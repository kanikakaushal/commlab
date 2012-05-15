package dei.vlab.communication.client.widgets.form;

import java.util.LinkedHashMap;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FileItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.ViewFileItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import dei.vlab.communication.client.contoller.CircuitMapperContoller;
import dei.vlab.communication.client.data.CircuitImageMapData;
import dei.vlab.communication.client.widgets.tools.CircuitPanel;

public class CoorinateMapperForm extends Window {
	private CircuitImageMapData circuitImageMapData;
	private VLayout formLayout = new VLayout();
	private HorizontalPanel mapperLayout = new HorizontalPanel();
	private VerticalPanel mainPanel = new VerticalPanel();		
	private CircuitPanel circuitPanel;
	private CircuitMapperContoller currentController;


	public CoorinateMapperForm() {
		this.setTitle("Circuit");
		this.setWidth(500);
		this.setHeight(550);
		this.setIsModal(true);
		this.setShowModalMask(true);
		this.centerInPage();
		this.setMargin(20);
		formLayout.setHeight100();
		formLayout.setWidth100();
		formLayout.setVisible(true);
		mainPanel.setVisible(false);
		addItem(formLayout);
		addItem(mainPanel);
		addForm();
		addButtons();
	}

	public CircuitImageMapData getCircuitImageMapData() {
		return circuitImageMapData;
	}

	public void setCircuitImageMapData(CircuitImageMapData circuitImageMapData) {
		this.circuitImageMapData = circuitImageMapData;
	}

	public void setWindowTitle(String title) {
		this.setTitle(title);
	}

	private void addForm() {
		final DynamicForm form = new DynamicForm();
		form.setWidth(250);

		TextItem circuitNameItem = new TextItem();
		circuitNameItem.setTitle("Name");
		circuitNameItem.setRequired(true);
		circuitNameItem.setWidth(260);

		LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
		valueMap.put("Beginner", "Beginner");
		valueMap.put("Moderate ", "Moderate ");
		valueMap.put("Expert", "Expert");

		SelectItem levelItem = new SelectItem();
		levelItem.setTitle("Level");
		levelItem.setRequired(true);
		levelItem.setValueMap(valueMap);
		levelItem.setWidth(260);

		TextAreaItem descriptionItem = new TextAreaItem();
		descriptionItem.setTitle("Description");
		descriptionItem.setRequired(true);
		descriptionItem.setWidth(260);

		FileItem imageItem = new FileItem("cimage");
		imageItem.setTitle("Image");
		imageItem.setRequired(true);
		imageItem.setWidth(260);
	
		FileItem configItem = new FileItem("Configuration");
		imageItem.setTitle("Configuration");
		imageItem.setRequired(true);
		imageItem.setWidth(260);

		form.setMargin(20);
		form.setFields(new FormItem[] { circuitNameItem, levelItem,
				descriptionItem, imageItem, configItem });
		formLayout.addMember(form);

	}

	private void addButtons() {
		HLayout buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setMargin(50);
		IButton saveButton = new IButton("Next");
		saveButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (validate()) {
					hideForm();
					//TODO: need to get the uploaded file name
						// after uploaded on server to display image 
						// for coordinate mapping
					initCiruitMapper("images/circuit3.png");
				} else {
					showError();
				}
			}
		});
		IButton cancelButton = new IButton("Cancel");
		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}

		});

		buttonLayout.addMember(cancelButton);
		buttonLayout.addMember(saveButton);
		formLayout.addMember(buttonLayout);
	}

	public void hideForm() {
		formLayout.setVisible(false);
		
	}
	public void showForm() {
		formLayout.setVisible(true);
		
	}


	private boolean validate() {
		return true;
	}

	private void showError() {
		// TODO Auto-generated method stub

	}

	private void initCiruitMapper(String image) {
		this.setWidth(700);
		this.setHeight(550);
		mapperLayout = new HorizontalPanel();
		mainPanel.add(mapperLayout);
		circuitPanel = new CircuitPanel();
		if (currentController != null) {
			currentController.clearDiagram();
		} else {
			// Create the drawing zone
			currentController = new CircuitMapperContoller(150,350);
		}
		currentController.showImage(image);
		circuitPanel.setDiagramController(currentController);
		Widget w = circuitPanel.asWidget();
		w.getElement().getStyle().setMargin(10, Unit.PX);
		w.getElement().getStyle().setProperty("border", "1px solid #cccccc");
		mapperLayout.insert(w, 0);
		mainPanel.setVisible(true);
	}
}
