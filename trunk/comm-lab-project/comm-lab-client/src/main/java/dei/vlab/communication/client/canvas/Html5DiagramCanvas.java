package dei.vlab.communication.client.canvas;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.DomEvent.Type;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class Html5DiagramCanvas implements DiagramCanvas{

	private int width;
	private int height;
	private Canvas canvas;
	private Context2d context;
	final CssColor redrawColor = CssColor.make("rgba(255,255,255,1)");
	final CssColor backgroundColor = CssColor.make("rgba(255,255,255,0)");
	
	public Html5DiagramCanvas(int width, int height){
		this.canvas = Canvas.createIfSupported();
		this.context = canvas.getContext2d();
		this.width = width;
		this.height = height;
		setBackground();
		canvas.getElement().getStyle().setPosition(Position.ABSOLUTE);
		canvas.setHeight(this.height + "px");
		canvas.setWidth(this.width + "px");
		canvas.setCoordinateSpaceHeight(height);
		canvas.setCoordinateSpaceWidth(width);
	}

	
	public int getWidth() {
		return width;
	}

	
	public void setWidth(int width) {
		this.width = width;
	}

	
	public int getHeight() {
		return height;
	}

	
	public void setHeight(int height) {
		this.height = height;
	}

	
	public void clear(){
	    context.clearRect(0, 0, width, height);
	}

	
	public void setForeground(){
		canvas.getElement().getStyle().setZIndex(5);
	}

	
	public void setBackground(){
		canvas.getElement().getStyle().setZIndex(1);
	}

	
	public Widget asWidget(){
		return canvas;
	}

	
	public <H extends EventHandler> HandlerRegistration addDomHandler(
			H handler, Type<H> type) {
		return canvas.addDomHandler(handler, type);
	}

	
	public Element getElement() {
		return canvas.getElement();
	}

	
	public void beginPath() {
		context.beginPath();
	}

	
	public void closePath() {
		context.closePath();
	}

	
	public void lineTo(double x, double y) {
		context.lineTo(x, y);
	}

	
	public void moveTo(double x, double y) {
		context.moveTo(x, y);
	}

	
	public void setStrokeStyle(CssColor color) {
		context.setStrokeStyle(color);
	}

	
	public void setFillStyle(CssColor color) {
		context.setFillStyle(color);
	}

	
	public void fillRect(double x, double y, double w, double h) {
		context.fillRect(x, y, w, h);
	}

	
	public void stroke() {
		context.stroke();
	}

	
	public void setStrokeStyle(String color) {
		context.setStrokeStyle(color);
	}

	
	public void setFillStyle(String color) {
		context.setFillStyle(color);
	}

	
	public void arc(double x, double y, double radius, double startAngle,
			double endAngle, boolean anticlockwise) {
		context.arc(x, y, radius, startAngle, endAngle, anticlockwise);
	}

	
	public void fill() {
		context.fill();
	}

	
	public void bezierCurveTo(double cpx, double cpy, double x, double y) {
		context.bezierCurveTo(cpx, cpy, cpx, cpy, x, y);
	}

	
    public void setGlobalAlpha(double alpha) {
           context.setGlobalAlpha(alpha);
    }

}
