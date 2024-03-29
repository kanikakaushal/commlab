package dei.vlab.communication.client.contoller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.allen_sauer.gwt.dnd.client.DragController;
import com.allen_sauer.gwt.dnd.client.DragEndEvent;
import com.allen_sauer.gwt.dnd.client.DragHandlerAdapter;
import com.allen_sauer.gwt.dnd.client.DragStartEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.canvas.BackgroundCanvas;
import dei.vlab.communication.client.canvas.DiagramCanvas;
import dei.vlab.communication.client.canvas.ImageBackgroundCanvas;
import dei.vlab.communication.client.canvas.MultiBrowserDiagramCanvas;
import dei.vlab.communication.client.connection.Connection;
import dei.vlab.communication.client.connection.ConnectionFactory;
import dei.vlab.communication.client.event.ChangeOnDiagramEvent;
import dei.vlab.communication.client.event.ChangeOnDiagramEvent.HasChangeOnDiagramHandlers;
import dei.vlab.communication.client.event.ChangeOnDiagramHandler;
import dei.vlab.communication.client.event.NewFunctionEvent;
import dei.vlab.communication.client.event.NewFunctionEvent.HasNewFunctionHandlers;
import dei.vlab.communication.client.event.NewFunctionHandler;
import dei.vlab.communication.client.event.TieLinkEvent;
import dei.vlab.communication.client.event.TieLinkEvent.HasTieLinkHandlers;
import dei.vlab.communication.client.event.TieLinkHandler;
import dei.vlab.communication.client.event.UntieLinkEvent;
import dei.vlab.communication.client.event.UntieLinkEvent.HasUntieLinkHandlers;
import dei.vlab.communication.client.event.UntieLinkHandler;
import dei.vlab.communication.client.menu.ContextMenu;
import dei.vlab.communication.client.menu.HasContextMenu;
import dei.vlab.communication.client.save.DiagramModel;
import dei.vlab.communication.client.save.DiagramSerializationService;
import dei.vlab.communication.client.save.DiagramWidgetFactory;
import dei.vlab.communication.client.save.FunctionModel;
import dei.vlab.communication.client.save.LinkModel;
import dei.vlab.communication.client.shapes.DecorationShape;
import dei.vlab.communication.client.shapes.DrawableSet;
import dei.vlab.communication.client.shapes.FunctionShape;
import dei.vlab.communication.client.shapes.MouseShape;
import dei.vlab.communication.client.shapes.Point;
import dei.vlab.communication.client.shapes.Shape;
import dei.vlab.communication.client.utils.LinksClientBundle;
import dei.vlab.communication.client.utils.MovablePoint;
import dei.vlab.communication.client.widgets.link.CNode;

/**
 * Controller which manage all the diagram logic
 * 
 * @author Pierre Renaudin (pierre.renaudin.fr@gmail.com)
 * @author David Durham (david.durham.jr@gmail.com)
 * 
 */
public class DiagramController implements HasNewFunctionHandlers,HasTieLinkHandlers, HasUntieLinkHandlers, HasChangeOnDiagramHandlers, HasContextMenu {

	/**
	 * If the distance between the mouse and segment is under this number in pixels, then,
	 * the mouse is considered over the segment
	 */
	public static int minDistanceToSegment = 10;

	/**
	 * Timer refresh duration, in milliseconds. It defers if the application is running in development mode
	 * or in the web mode
	 */
	public static int refreshRate = GWT.isScript() ? 25 : 50;
	
	private boolean allowingUserInteractions = true;
	
	protected DiagramCanvas topCanvas;
	protected DragController dragController;
	protected BackgroundCanvas backgroundCanvas;
	protected ImageBackgroundCanvas imgBackgroundCanvas;
	protected AbsolutePanel widgetPanel;
	protected ScrollPanel scrollPanel;
	protected HandlerManager handlerManager;
	protected boolean showGrid;
	protected String imagepath;

	protected ContextMenu canvasMenu;

	protected DrawableSet<Connection> connections = new DrawableSet<Connection>();
	protected DrawableSet<FunctionShape> shapes = new DrawableSet<FunctionShape>();
	protected Map<Widget,FunctionShape> widgetShapeMap = new HashMap<Widget, FunctionShape>();
	protected Map<Widget,Map<Widget,Connection>> functionsMap = new HashMap<Widget, Map<Widget, Connection>>();

	protected Point mousePoint = new Point(0, 0);
	protected Point mouseOffsetPoint = new Point(0, 0);

	// Drag Edition status
	public boolean inEditionDragMovablePoint = false;
	public boolean inEditionSelectableShapeToDrawConnection = false;
	public boolean inDragBuildArrow = false;
	public boolean inDragMovablePoint = false;
	public boolean inDragWidget = false;

	protected Point highlightPoint;
	protected Connection highlightConnection;
	protected MovablePoint movablePoint;
	protected FunctionShape highlightFunctionShape;

	protected Widget startFunctionWidget;
	protected Connection buildConnection;

	protected long nFrame = 0;
	protected long previousNFrame = 0;
	protected long previousTime = 0;
	protected long fps = 0;

	protected int canvasWidth;
	protected int canvasHeight;

	/**
	 * Initialize the controller diagram. Use this constructor to start your diagram. A code sample is : <br/>
	 * <br/>
	 * <code>
	 * 		DiagramController controller = new DiagramController(400,400);<br/>
	 * 		RootPanel.get().add(controller.getView());
	 * </code> <br/>
	 * 
	 * @param canvas
	 *            the implementation of the canvas where connections and widgets will be drawn
	 */
	public DiagramController(int canvasWidth, int canvasHeight) {
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		this.topCanvas = new MultiBrowserDiagramCanvas(canvasWidth, canvasHeight);
		this.backgroundCanvas = new BackgroundCanvas(canvasWidth, canvasHeight);
		this.imgBackgroundCanvas = new ImageBackgroundCanvas(canvasWidth, canvasHeight);

		handlerManager = new HandlerManager(topCanvas);
		LinksClientBundle.INSTANCE.css().ensureInjected();

		initWidgetPanel(topCanvas);
		initMouseHandlers(topCanvas);
		initMenu();

		timer.scheduleRepeating(refreshRate);
		frameTimer.scheduleRepeating(1000);

		ContextMenu.disableBrowserContextMenu(widgetPanel.asWidget().getElement());
		ContextMenu.disableBrowserContextMenu(topCanvas.asWidget().getElement());
	}
	
	public DiagramController(int canvasWidth, int canvasHeight, int frameWidth, int frameHeight){
		this(canvasWidth, canvasHeight);
		scrollPanel = new ScrollPanel(getView());
		scrollPanel.setWidth(frameWidth + "px");
		scrollPanel.setHeight(frameHeight + "px");
	}

	protected void initMouseHandlers(final DiagramCanvas canvas) {
		canvas.addDomHandler(new MouseMoveHandler() {
			
			public void onMouseMove(MouseMoveEvent event) {
				DiagramController.this.onMouseMove(event);
			}
		}, MouseMoveEvent.getType());

		canvas.addDomHandler(new MouseDownHandler() {
			
			public void onMouseDown(MouseDownEvent event) {
				DiagramController.this.onMouseDown(event);
			}
		}, MouseDownEvent.getType());

		canvas.addDomHandler(new MouseUpHandler() {
			
			public void onMouseUp(MouseUpEvent event) {
				DiagramController.this.onMouseUp(event);
			}
		}, MouseUpEvent.getType());
	}

	protected void initWidgetPanel(final DiagramCanvas canvas) {
		widgetPanel = new AbsolutePanel();
		widgetPanel.getElement().getStyle().setWidth(canvas.getWidth(), Unit.PX);
		widgetPanel.getElement().getStyle().setHeight(canvas.getHeight(), Unit.PX);
		widgetPanel.add(canvas.asWidget());
	}

	protected void initMenu() {
	}

	
	public ContextMenu getContextMenu() {
		return canvasMenu;
	}

	public void pauseRefresh() {
		timer.cancel();
	}

	public void runRefresh() {
		timer.scheduleRepeating(refreshRate);
	}

	/**
	 * Clear the diagram (connections and widgets)
	 */
	public void clearDiagram() {
		connections.clear();
		widgetShapeMap.clear();
		functionsMap.clear();
		shapes.clear();
		startFunctionWidget = null;
		buildConnection = null;

		// Restart widgetPane
		if(scrollPanel != null)
			scrollPanel.clear();
		widgetPanel.clear();
		widgetPanel.add(topCanvas.asWidget());
		topCanvas.getElement().getStyle().setPosition(Position.ABSOLUTE);
		showGrid(showGrid);
	}
	
	/**
	 * Remove the drag controller
	 */
	public void removeDragController(){
		dragController = null;
	}

	/**
	 * Draw a straight connection with an arrow between two GWT widgets.
	 * The arrow is pointing to the second widget
	 * 
	 * @param startWidget
	 *            Start widget
	 * @param endWidget
	 *            End Widget
	 * @return the created new connection between the two widgets
	 */
	public Connection drawStraightArrowConnection(Widget startWidget, Widget endWidget) {
		Connection c = drawConnection(ConnectionFactory.ARROW, startWidget, endWidget);
		functionsMap.get(startWidget).put(endWidget, c);
		return c;
	}

	protected <C extends Connection> C drawConnection(ConnectionFactory<C> cf, Widget start, Widget end) {
		FunctionShape startShape = widgetShapeMap.get(start);
		FunctionShape endShape = widgetShapeMap.get(end);
		return drawConnection(cf, startShape, endShape);
	}

	protected <C extends Connection> C drawConnection(ConnectionFactory<C> cf, Shape start, Shape end) {
		// Create Connection and Store it in the controller
		C c = cf.create(this,start, end);
		c.setController(this);

		connections.add(c);

		start.addConnection(c);
		end.addConnection(c);
		return c;
	}

	/**
	 * Draw a straight connection between two GWT widgets. The arrow is pointing to the second widget
	 * 
	 * @param startWidget
	 *            Start widget
	 * @param endWidget
	 *            End Widget
	 * @return the created new connection between the two widgets
	 */
	public Connection drawStraightConnection(Widget startWidget, Widget endWidget) {
		Connection c = drawConnection(ConnectionFactory.STRAIGHT, startWidget, endWidget);
		functionsMap.get(startWidget).put(endWidget, c);
		return c;
	}

	/**
	 * Add a widget on the diagram
	 * 
	 * @param w
	 *            the widget to add
	 * @param left
	 *            left margin with the absolute panel
	 * @param top
	 *            top margin with the absolute panel
	 */
	public FunctionShape addWidget(final Widget w, int left, int top) {
		
		w.getElement().getStyle().setZIndex(3);
		final FunctionShape shape = new FunctionShape(this, w);

		shapes.add(shape);
		widgetShapeMap.put(w, shape);
		functionsMap.put(w, new HashMap<Widget, Connection>());

		if (w instanceof HasContextMenu) {
			w.addDomHandler(new MouseUpHandler() {
				public void onMouseUp(MouseUpEvent event) {
					if (event.getNativeButton() == NativeEvent.BUTTON_RIGHT) {
						showMenu((HasContextMenu) w, event.getClientX(), event.getClientY());
					}
				}
			}, MouseUpEvent.getType());
		}
		widgetPanel.add(w, left, top);

		// Register the drag handler
		if(dragController != null){
			registerDragHandler(shape);
		}

		// If the is mouse is over the widget, clear the topCanvas
		w.addDomHandler(new MouseOverHandler() {
			public void onMouseOver(com.google.gwt.event.dom.client.MouseOverEvent arg0) {
				topCanvas.clear();
				mousePoint.setLeft(-30);
				mousePoint.setTop(-30);
			}
		}, com.google.gwt.event.dom.client.MouseOverEvent.getType());
		shape.draw();
		
		// Send event
		handlerManager.fireEvent(new NewFunctionEvent(w));
        return shape;
	}

	public FunctionShape addWidgetAtMousePoint(final Widget w) {
		return addWidget(w, mousePoint.getLeft(), mousePoint.getTop());
	}

	public FunctionShape addWidgetAtMousePoint(final Widget w,int l, int t) {
			return addWidget(w, l,t);
	}
	/**
	 * Add a widget as a decoration on a connection
	 * 
	 * @param decoration
	 *            widget that will be in the middle of the connection
	 * @param decoratedConnection
	 *            the connection where the decoration will be put
	 */
	public void addDecoration(Widget decoration, Connection decoratedConnection) {
		decoration.getElement().getStyle().setZIndex(10);
		decoration.getElement().getStyle().setPosition(Position.ABSOLUTE);
		widgetPanel.add(decoration);
		decoratedConnection.setDecoration(new DecorationShape(this, decoration));
		decoratedConnection.setSynchronized(false);
	}

	/**
	 * Remove a decoration from the diagram
	 * 
	 * @param decoratedConnection
	 *            connection where the decoration will be deleted
	 */
	public void removeDecoration(Connection decoratedConnection) {
		DecorationShape decoShape = decoratedConnection.getDecoration();
		if (decoShape != null) {
			widgetPanel.remove(decoShape.asWidget());
			decoratedConnection.removeDecoration();
		}
	}

	/**
	 * Add an segment on a path by adding a point on the connection
	 * 
	 * @param c
	 *            the connection where the point will be added
	 * @param left
	 *            Left margin in pixels
	 * @param top
	 *            Top margin in pixels
	 */
	public void addPointOnConnection(Connection c, int left, int top) {
		c.addMovablePoint(new Point(left, top));
	}

	/**
	 * Change the background of the canvas by displaying or not a gray grid.
	 * 
	 * @param showGrid
	 *            if true, show a grid, else don't
	 */
	public void showGrid(boolean showGrid) {
		this.showGrid = showGrid;
		backgroundCanvas.initGrid();
		if (this.showGrid) {
			widgetPanel.add(backgroundCanvas.asWidget());
		} else {
			widgetPanel.remove(backgroundCanvas.asWidget());
		}
	}
	
	public void showImage(String path) {
		this.imagepath = path;
		imgBackgroundCanvas.setImageBackground(path);
		if (this.imagepath!=null) {
			widgetPanel.add(imgBackgroundCanvas.asWidget());
		} else {
			widgetPanel.remove(imgBackgroundCanvas.asWidget());
		}
	}


	/**
	 * Get the diagram canvas
	 * 
	 * @return the diagram canvas
	 */
	public DiagramCanvas getDiagramCanvas() {
		return topCanvas;
	}

	/**
	 * 
	 * @return the view where the widgets are displayed
	 */
	public AbsolutePanel getView() {
		return widgetPanel;
	}
	
	public void setFrameSize(int width, int height){
		if(scrollPanel == null){
			scrollPanel = new ScrollPanel(widgetPanel);
		}
		scrollPanel.setWidth(width + "px");
		scrollPanel.setHeight(height + "px");
	}
	
	public ScrollPanel getViewAsScrollPanel(){
		scrollPanel.addScrollHandler(new ScrollHandler() {
			
			public void onScroll(ScrollEvent event) {
				unsynchronizedShapes();
			}
		});
		return scrollPanel;
	}

	/**
	 * Register a drag controller to control the refresh rate
	 * 
	 * @param dragController
	 *            The DragController used to handle the drags on widgets
	 */
	public void registerDragController(DragController dragController) {
		this.dragController = dragController;
		for(FunctionShape shape : shapes){
			registerDragHandler(shape);
		}
	}

	protected void registerDragHandler(final FunctionShape shape){
		this.dragController.addDragHandler(new DragHandlerAdapter() {

			
			public void onPreviewDragEnd(DragEndEvent event){
				shape.getConnections().draw();
			}

			
			public void onDragEnd(DragEndEvent event) {
				inDragWidget = false;
				Widget widget = event.getContext().draggable;
				Shape s = widgetShapeMap.get(widget);
				if(shape.equals(s)){
					shape.setSynchronized(true);
					shape.getConnections().setAllowSynchronized(true);
					shape.getConnections().setSynchronized(true);
				}
			}

			
			public void onDragStart(DragStartEvent event) {
				inDragWidget = true;
				Widget widget = event.getContext().draggable;
				Shape s = widgetShapeMap.get(widget);
				if(shape.equals(s)){
					shape.setSynchronized(false);
					shape.getConnections().setSynchronized(false);
					shape.getConnections().setAllowSynchronized(false);
				}
			}
		});
	}
	
	public void unsynchronizedShapes(){
		for(FunctionShape shape : shapes){
			shape.setSynchronized(false);
			shape.getConnections().setSynchronized(false);
		}
	}
	
	public void synchronizedShapes(){
		for(FunctionShape shape : shapes){
			shape.setSynchronized(true);
			shape.getConnections().setSynchronized(true);
		}
	}

	
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	
	public HandlerRegistration addUntieLinkHandler(UntieLinkHandler handler) {
		return handlerManager.addHandler(UntieLinkEvent.getType(), handler);
	}

	
	public HandlerRegistration addTieLinkHandler(TieLinkHandler handler) {
		return handlerManager.addHandler(TieLinkEvent.getType(), handler);
	}

	
	public HandlerRegistration addChangeOnDiagramHandler(ChangeOnDiagramHandler handler) {
		return handlerManager.addHandler(ChangeOnDiagramEvent.getType(), handler);
	}
	

	
	public HandlerRegistration addNewFunctionHandler(NewFunctionHandler handler) {
		return handlerManager.addHandler(NewFunctionEvent.getType(), handler);
	}

	/**
	 * 
	 * @return true if a grid is displayed in background
	 */
	public boolean isShowGrid() {
		return showGrid;
	}

	// setup timer
	protected final Timer timer = new Timer() {
		
		public void run() {
			nFrame++;
			update();
		}
	};

	protected final Timer frameTimer = new Timer() {
		
		public void run() {
			long now = new Date().getTime();
			fps = (now - previousTime) != 0 ? (nFrame - previousNFrame) * 1000 / (now - previousTime) : 0;
			previousNFrame = nFrame;
			previousTime = now;
		}
	};



	public void update() {
		redrawConnections();

		// If the user is dragging widgets, do nothing
		if(inDragWidget)
			return;

		topCanvas.clear();

		// Search for selectable area
		if (!inDragBuildArrow) {
			for (FunctionShape s : shapes) {
				if (s.isMouseNearSelectableArea(mousePoint)) {
					s.highlightSelectableArea(mousePoint);
					inEditionSelectableShapeToDrawConnection = true;
					startFunctionWidget = s.asWidget();
					RootPanel.getBodyElement().getStyle().setCursor(Cursor.POINTER);
					return;
				}
				inEditionSelectableShapeToDrawConnection = false;
			}
		} else {
			// Don't go deeper if in edition mode
			// If mouse over a widget, highlight it
			FunctionShape s = getShapeUnderMouse();
			if (s != null) {
				s.drawHighlight();
				highlightFunctionShape = s;
			}
			else if(highlightFunctionShape != null) {
				highlightFunctionShape.draw();
				highlightFunctionShape = null;
			}
			clearAnimationsOnCanvas();
		}

		// Test if in Drag Movable Point
		if (!inDragMovablePoint && !inDragBuildArrow) {
			for (Connection c : connections) {
				if (c.isMouseNearConnection(mousePoint)) {
					highlightPoint = c.highlightMovablePoint(mousePoint);
					highlightConnection = getConnectionNearMouse();
					inEditionDragMovablePoint = true;
					RootPanel.getBodyElement().getStyle().setCursor(Cursor.POINTER);
					return;
				}
				inEditionDragMovablePoint = false;
			}
		}

		clearAnimationsOnCanvas();
	}

	/**
	 * If any connections need to be redrawn, clear the canvas and redraw all lines.
	 */
	protected void redrawConnections() {
		connections.getUnsynchronizedDrawables().draw();
	}

	protected void clearAnimationsOnCanvas() {
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
	}

	protected void showContextualMenu() {
		final Connection c = getConnectionNearMouse();
		if (c != null) {
			showMenu(c);
			return;
		}

		showMenu(this);
	}

	protected void showMenu(final HasContextMenu c) {
		showMenu(c, mouseOffsetPoint.getLeft(), mouseOffsetPoint.getTop());
	}

	protected void showMenu(final HasContextMenu c, int left, int top) {
		ContextMenu menu = c.getContextMenu();
		if (menu != null) {
			menu.setPopupPosition(left, top);
			menu.show();
		}
	}

	protected void onMouseMove(MouseMoveEvent event) {
		if(!isAllowingUserInteractions()){
			return;
		}
		
		int mouseX = event.getRelativeX(topCanvas.getElement());
		int mouseY = event.getRelativeY(topCanvas.getElement());
		mousePoint.setLeft(mouseX);
		mousePoint.setTop(mouseY);

		int offsetMouseX = event.getClientX();
		int offsetMouseY = event.getClientY();
		mouseOffsetPoint.setLeft(offsetMouseX);
		mouseOffsetPoint.setTop(offsetMouseY);
	}

	protected void onMouseUp(MouseUpEvent event) {
		if(!isAllowingUserInteractions()){
			return;
		}
		
		// Test if Right Click
		if (event.getNativeButton() == NativeEvent.BUTTON_RIGHT) {
			event.stopPropagation();
			event.preventDefault();
			showContextualMenu();
			return;
		}

		if (inDragMovablePoint) {
			movablePoint.setFixed(true);
			topCanvas.setBackground();
			inDragMovablePoint = false;
			highlightConnection.setAllowSynchronized(true);
			return;
		}

		if (inDragBuildArrow) {
			FunctionShape functionUnderMouse = getShapeUnderMouse();
			if (functionUnderMouse != null) {
				Widget widgetSelected = functionUnderMouse.asWidget();
				if(startFunctionWidget != widgetSelected){
					Connection c = drawStraightArrowConnection(startFunctionWidget, widgetSelected);
					fireEvent(new TieLinkEvent(startFunctionWidget, widgetSelected, c));
				}
			}
			topCanvas.setBackground();
			deleteConnection(buildConnection);
			inDragBuildArrow = false;
			buildConnection = null;
			if(highlightFunctionShape != null){
				highlightFunctionShape.draw();
				highlightFunctionShape = null;
			}
			clearAnimationsOnCanvas();
		}

		if (inEditionDragMovablePoint) {
			inEditionDragMovablePoint = false;
			clearAnimationsOnCanvas();
		}
	}

	protected void onMouseDown(MouseDownEvent event) {
		if(!isAllowingUserInteractions()){
			return;
		}
		
		// Test if Right Click
		if (event.getNativeButton() == NativeEvent.BUTTON_RIGHT) {
			return;
		}

		if (inEditionSelectableShapeToDrawConnection) {
			inDragBuildArrow = true;
			inEditionSelectableShapeToDrawConnection = false;
			drawBuildArrow(startFunctionWidget, mousePoint);
			return;
		}

		if (inEditionDragMovablePoint) {
			inDragMovablePoint = true;
			inEditionDragMovablePoint = false;
			movablePoint = highlightConnection.addMovablePoint(highlightPoint);
			highlightConnection.setSynchronized(false);
			highlightConnection.setAllowSynchronized(false);
			movablePoint.setTrackPoint(mousePoint);
			// Set canvas foreground to avoid dragging over a widget
			topCanvas.setForeground();
			return;
		}
	}

	/*
	 * CONNECTION MANAGEMENT METHODS
	 */

	public void deleteConnection(Connection c) {
		connections.remove(c);
		for (Map<Widget,Connection> entry : functionsMap.values()) {
			for(Iterator<Connection> it = entry.values().iterator(); it.hasNext(); ){
				Connection connection = it.next();
				if (connection.equals(c)) {
					it.remove();
					break;
				}
			}
		}
		c.delete();
		removeDecoration(c);
	}
	
	public void deleteWidget(Widget widget) {
	    FunctionShape shape = widgetShapeMap.get(widget);
	    shapes.remove(shape);
		functionsMap.remove(widget);
	    for (Connection connection : shape.getConnections()) {
	        deleteConnection(connection);
	    }
	    widgetPanel.remove(widget);
	}

	protected Connection getConnectionNearMouse() {
		for (Connection c : connections) {
			if (c.isMouseNearConnection(mousePoint)) {
				return c;
			}
		}
		return null;
	}

	protected void drawBuildArrow(Widget startFunctionWidget, Point mousePoint) {
		topCanvas.setForeground();
		Shape startShape = new FunctionShape(this, startFunctionWidget);
		final MouseShape endShape = new MouseShape(mousePoint);
		buildConnection = drawConnection(ConnectionFactory.ARROW, startShape, endShape);
		buildConnection.setAllowSynchronized(false);
		buildConnection.setSynchronized(false);
		connections.add(buildConnection);
	}

	public Point getMousePoint() {
		return mousePoint;
	}

	protected FunctionShape getShapeUnderMouse() {
		for (FunctionShape s : shapes) {
			if (mousePoint.isInside(s)) {
				return s;
			}
		}
		return null;
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	/*
	 * Public methods to debug
	 */

	/**
	 * 
	 * @return the fps which are really displayed (frame per second)
	 */
	public long getFps() {
		return fps;
	}

	/**
	 * 
	 * @return unsynchronized connection
	 */
	public DrawableSet<Connection> getUnsynchronizedConnections(){
		return connections.getUnsynchronizedDrawables();
	}

	/**
	 * 
	 * 
	 */
	public DiagramModel getDiagramModel(){
		DiagramModel diagramRepresentation = new DiagramModel();
		diagramRepresentation.setDiagramProperties(this.canvasWidth,
				this.canvasHeight,this.showGrid);

		// Add function
		for(Widget startWidget : functionsMap.keySet()){
			diagramRepresentation.addFunction(startWidget);
		}

		// Add links
		for(Widget startWidget : functionsMap.keySet()){
			for(Widget endWidget : functionsMap.get(startWidget).keySet()){
				Connection c = functionsMap.get(startWidget).get(endWidget);
				int[][] pointList = new int[c.getMovablePoints().size()][2];
				int i = 0;
				for(Point p : c.getMovablePoints()){
					int[] point = {p.getLeft(), p.getTop()};
					pointList[i] = point;
					i++;
				}
				diagramRepresentation.addLink(startWidget, endWidget,pointList,c);
			}
		}
		return diagramRepresentation;
	}
	
	public String exportDiagram(){
		return DiagramSerializationService.exportDiagram(getDiagramModel());
	}
	
	public void importDiagram(String diagramXmlExport, DiagramWidgetFactory saveFactory){
		DiagramModel diagramRepresentation = DiagramSerializationService.importDiagram(diagramXmlExport);
		// Display the converted graphical representation
		clearDiagram();
		// Add Functions
		Map<String,Widget> idToWidgetMap = new HashMap<String,Widget>();
		for(FunctionModel function : diagramRepresentation.getFunctionRepresentationSet()){
			Widget w = saveFactory.getFunctionByType(function.identifier, function.content);
			addWidget(w, function.left, function.top);
			idToWidgetMap.put(function.id, w);
		}
		// Add links
		for(LinkModel link : diagramRepresentation.getLinkRepresentationSet()){
			Widget w1 = idToWidgetMap.get(link.startId);
			Widget w2 = idToWidgetMap.get(link.endId);
			Connection c;
			if(link.type != null && link.type.equals("straight")){
				c = drawStraightConnection(w1, w2);
			} else {
				c = drawStraightArrowConnection(w1, w2);
			}
			if(link.decoration != null){
				addDecoration(saveFactory.getDecorationByType(
						link.decoration.identifier , link.decoration.content ), c);
			} 
			
			// Add the movable points
			for(int[] p : link.pointList){
				c.addMovablePoint(new Point(p[0],p[1]));
			}
			
			// Fire TieEvent
			handlerManager.fireEvent(new TieLinkEvent(w1, w2, c));
		}
	}
	

	public boolean isAllowingUserInteractions() {
		return allowingUserInteractions;
	}

	public void setAllowingUserInteractions(boolean allowingUserInteractions) {
		this.allowingUserInteractions = allowingUserInteractions;
		if(!allowingUserInteractions){
			removeDragController();
		}
	}
	
	public String getBackgroundImage(){
		return this.imagepath;
	}

	public void addWidgetToBackgoundStatic(final Widget w, int left, int top){
		
	  widgetPanel.add(w,left,top);
	}
	
	public void addWidgetToBackgound(final Widget w, int left, int top){
		w.getElement().getStyle().setZIndex(3);
		final FunctionShape shape = new FunctionShape(this, w);

		shapes.add(shape);
		//widgetShapeMap.put(w, shape);
		functionsMap.put(w, new HashMap<Widget, Connection>());


		if (w instanceof HasContextMenu) {
			w.addDomHandler(new MouseUpHandler() {
				
				public void onMouseUp(MouseUpEvent event) {
					if (event.getNativeButton() == NativeEvent.BUTTON_RIGHT) {
						showMenu((HasContextMenu) w, event.getClientX(), event.getClientY());
					}
				}
			}, MouseUpEvent.getType());
		}
		  widgetPanel.add(w,left,top);
	
		 
	}
	public void registerWidget(final Widget w){
		w.getElement().getStyle().setZIndex(3);
		final FunctionShape shape = new FunctionShape(this, w);

		shapes.add(shape);
		widgetShapeMap.put(w, shape);
		functionsMap.put(w, new HashMap<Widget, Connection>());

	}
	public Widget getWidget(int index){
		return widgetPanel.getWidget(index);
	}
}
