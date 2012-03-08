package dei.vlab.communication.client.widgets.navigation;

import com.google.gwt.user.client.Timer;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.DateChooser;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

import dei.vlab.communication.client.data.ToDoDataSource;

public class TodoNavigator extends Window {
	public static final String TITLE = "Todo Actvivity";

	private VLayout innerLayout;
	private ListGrid todoListGrid;
	
	private Timer refresher = new Timer() {

		@Override
		public void run()
		{
			try{
			refresh();
			}catch (Exception e) {
			SC.say("error "+e.getLocalizedMessage());
			}
		}
	};;

	

	public TodoNavigator() {
		this.innerLayout = new VLayout();
		this.innerLayout.setWidth100();
		this.innerLayout.setHeight100();
		this.innerLayout.setMargin(0);
		this.innerLayout.setBackgroundColor("#FFFFCC");
		this.setTitle(TITLE);
		this.setWidth(295);
		this.setHeight100();
		this.setEdgeSize(5);
		this.setCanDragReposition(false);
		this.setCanDragResize(false);
		this.setShowMinimizeButton(false);
		this.setShowMaximizeButton(false);
		this.setShowCloseButton(false);
		this.addItem(innerLayout);
		initCalander();
		initToDoGrid();
		}

	private void initToDoGrid() {
		todoListGrid= new ListGrid();
		todoListGrid.setWidth(285);
		todoListGrid.setHeight100();
		todoListGrid.setCanExpandRecords(false);
		todoListGrid.setCanSort(true);
		todoListGrid.setCanGroupBy(false);
		todoListGrid.setCanAutoFitFields(false);
		todoListGrid.setFixedFieldWidths(false);
		todoListGrid.setFixedRecordHeights(false);
		todoListGrid.setCanDrag(true);
		todoListGrid.setHeaderHeight(0);
		todoListGrid.setMargin(5);
		todoListGrid.setBorder("none");
	//	ListGridField id = new ListGridField("id");
		ListGridField task = new ListGridField("task");
		todoListGrid.setFields(task);
		todoListGrid.setAutoFetchData(true);
		todoListGrid.setDataSource(ToDoDataSource.getInstance());
		todoListGrid.setBodyBackgroundColor("#FFFFCC");
		todoListGrid.setRowNumberStart(1);
		this.innerLayout.addMember(todoListGrid);
	
		// Every 5 seconds.

		refresher.scheduleRepeating(15000);
	}
	
	public void refresh(){
		todoListGrid.fetchData();
	}
	

	private void initCalander() {
		final DateChooser dateChooser = new DateChooser();
		dateChooser.setWidth(285);
		dateChooser.setShowEdges(false);
		dateChooser.setShowTodayButton(false);
		dateChooser.setMargin(5);
		dateChooser.setBackgroundColor("#FFFFCC");
		this.innerLayout.addMember(dateChooser);
	}
	
	

}
