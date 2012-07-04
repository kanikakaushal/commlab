package dei.vlab.communication.client.widgets.tools;

import java.util.List;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.types.FormMethod;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import dei.vlab.communication.client.contoller.CircuitMapperContoller;
import dei.vlab.communication.client.data.CircuitNodeRecord;
import dei.vlab.communication.client.image.utils.ImageLoadEvent;
import dei.vlab.communication.client.image.utils.ImageLoadHandler;
import dei.vlab.communication.client.image.utils.ImagePreloader;
import dei.vlab.communication.client.widgets.link.CNodeData;
import dei.vlab.communication.client.widgets.link.CircuitWidget;

public class CircuitPanel {

	private int width = 500;
	private int height = 300;
	private String image;
	protected CircuitMapperContoller controller;
	private Window _circuitWin = new Window();
	private VLayout drwPanelLayout = new VLayout();
	private HLayout dataLayout = new HLayout();
	private HLayout ctrlLayout = new HLayout();
	private VerticalPanel drwLayout = new VerticalPanel();
	private Widget cw;
    private DynamicForm xyDataForm = new DynamicForm();
    private HiddenItem nameItem = new HiddenItem("name");
    private HiddenItem dataItem = new HiddenItem("data");
	private final ListGrid nodeDataGrid = new ListGrid();
	
	public CircuitPanel() {

		try {

			_circuitWin = new Window();
			_circuitWin.setTitle("Circuit Coorinate Mapping");
			_circuitWin.setWidth(920);
			_circuitWin.setHeight(450);
			_circuitWin.setIsModal(true);
			_circuitWin.setShowModalMask(true);
			_circuitWin.centerInPage();
			_circuitWin.setMargin(20);
			dataLayout.addMember(drwLayout);
			dataLayout.addMember(ctrlLayout);
			drwPanelLayout.addMember(dataLayout);
			
			addDataForm();

			addButtons();
			addDataButtons();
			_circuitWin.addItem(drwPanelLayout);

		} catch (Exception e) {
			SC.say(e.getLocalizedMessage());
		}

	}
	
	public void  addDataForm(){
		
		xyDataForm.setMethod(FormMethod.POST);
		xyDataForm.setAction("app/circuitXY");
		xyDataForm.setTarget("hidden_frame");
		xyDataForm.setItems(nameItem, dataItem);		
	  }

	private void initDiamension() {
		ImagePreloader.load(image, new ImageLoadHandler() {
			public void imageLoaded(ImageLoadEvent event) {
				if (event.isLoadFailed())
					SC.say("Image " + event.getImageUrl() + " failed to load.");
				else
					width = event.getDimensions().getWidth();
				height = event.getDimensions().getHeight();
			}
		});
	}

	public void draw() {
		PickupDragController dragController = new PickupDragController(
				controller.getView(), true);
		CircuitWidget lcWidget = new CircuitWidget(controller, dragController,
				this.image);
		controller.addWidgetToBackgoundStatic(lcWidget, 0, 0);

		controller.registerDragController(dragController);

	}

	public Widget asWidget() {
		Widget w = controller.getView();

		w.getElement().getStyle().setMargin(10, Unit.PX);
		w.getElement().getStyle().setProperty("border", "1px solid #cccccc");
		w.setWidth("500");
		w.setHeight("300");

		return w;
	}

	public void showWin(String image,String name,String nodeData) {
		this.nameItem.setDefaultValue(name);
	   
		initPanel(image);
		if (cw == null) {
			cw = asWidget();
		} else {
			drwLayout.remove(cw);
		}
		drwLayout.add(cw);
		draw();
		_circuitWin.setTitle("Circuit Coorinate Mapping - {"+name+"}");
		_circuitWin.show();
		_circuitWin.redraw();
		if(nodeData!=null && !nodeData.isEmpty()){
			nodeDataGrid.selectAllRecords();
			nodeDataGrid.removeSelectedData();
			controller.setNodeData(nodeData);
			List<CNodeData> datas =controller.getSavableData();
			if(datas!=null && !datas.isEmpty()){
				for(CNodeData  cNodeData :datas){
					nodeDataGrid.addData(new CircuitNodeRecord(cNodeData.getName(),cNodeData.getDescription(),""+cNodeData.getTop(),""+cNodeData.getLeft()));
				}
			}

		}
	}

	private void initPanel(String image) {
		this.image = image;
		initDiamension();
		if (controller != null) {
			controller.setCount(0);
			controller.clearDiagram();
		} else {
			controller = new CircuitMapperContoller(200, 300);
		}

	}

	public void hideWin() {
		// drwLayout.removeMember(asWidget());

	}

	private void addButtons() {
		HLayout buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setMargin(10);
		IButton saveButton = new IButton("Save");
		saveButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				String data=controller.getSavableDatainString();
				SC.say("data ==>" +controller.getSavableData().toString());
				dataItem.setDefaultValue(data);
				 xyDataForm.submitForm();
			
				_circuitWin.hide();
			}
		});
		IButton cancelButton = new IButton("Cancel");
		cancelButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				_circuitWin.hide();
			}
		});

		buttonLayout.addMember(cancelButton);
		buttonLayout.addMember(saveButton);
		drwPanelLayout.addMember(buttonLayout);
	}

	protected TextItem nodeNameItem = new TextItem("name");
	protected TextAreaItem descriptionItem = new TextAreaItem("description");

	private void addDataButtons() {
		VLayout layout = new VLayout();
		layout.setMargin(15);
		nodeDataGrid.setWidth(280);
		nodeDataGrid.setHeight(100);
		nodeDataGrid.setTop(280);
		//nodeDataGrid.setDataSource(CircuitNodeDS.getInstance());
		ListGridField nameField = new ListGridField("name", "Node Name");
		ListGridField descField = new ListGridField("description", "Description");
		ListGridField topField = new ListGridField("top", "Top");
		ListGridField leftField = new ListGridField("left", "left");
		nodeDataGrid.setFields(nameField, descField,topField,leftField);
		nodeDataGrid.setShowAllRecords(true);
		nodeDataGrid.setAutoFetchData(true);
		nodeDataGrid.setDataPageSize(5);
		//nodeDataGrid.SHOWA
	
		layout.addMember(nodeDataGrid);

		final DynamicForm form = new DynamicForm();
		
		nodeNameItem.setTitle("Node Name");
		nodeNameItem.setRequired(true);
		nodeNameItem.setWidth(150);
		nodeNameItem.setRequired(true);
		nodeNameItem.setRequiredMessage("Name is required.");

		descriptionItem.setTitle("Description");
		descriptionItem.setRequired(true);
		descriptionItem.setWidth(150);
		descriptionItem.setRequired(true);
		descriptionItem.setRequiredMessage("Should provide description.");

		form.setMargin(20);
		form.setFields(new FormItem[] { nodeNameItem, descriptionItem });
		layout.addMember(form);
		

		IButton addButton = new IButton("Add New node");
		addButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if(form.validate()){
					nodeDataGrid.addData(new CircuitNodeRecord(nodeNameItem.getDisplayValue(),descriptionItem.getDisplayValue(),"",""));
					//nodeDataGrid.getDataSource().addData(new CircuitNodeRecord(nodeNameItem.getDisplayValue(),descriptionItem.getDisplayValue()));
					controller.addNode(nodeNameItem.getDisplayValue(),descriptionItem.getDisplayValue());
					//nodeDataGrid.getDataSource().fetchData();
					form.setValue("name","");
					form.setValue("description","");
					controller.runRefresh();
					
				}
			}
		});
		IButton deleteButton = new IButton("Delete Node");
		deleteButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				
				if(nodeDataGrid.getSelectedRecord()!=null && nodeDataGrid.getSelectedRecord().getAttribute("name")!=null){
					 controller.removeNode(nodeDataGrid.getSelectedRecord().getAttribute("name"));  
					 nodeDataGrid.removeData(nodeDataGrid.getSelectedRecord());
				}else{
					SC.say("No row selected.");
				}
			}
		});
		HLayout blayout= new HLayout();
		blayout.addMember(deleteButton);
		blayout.addMember(addButton);
		layout.addMember(blayout);
		ctrlLayout.addMember(layout);
		blayout.addMember(xyDataForm);
		
		

	}

}
