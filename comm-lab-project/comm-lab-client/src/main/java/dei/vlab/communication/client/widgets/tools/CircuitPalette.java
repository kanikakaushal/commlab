package dei.vlab.communication.client.widgets.tools;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import dei.vlab.communication.client.data.CircuitDataSource;
import dei.vlab.communication.client.handler.AddCircuitHander;

public class CircuitPalette extends HLayout {
	private AddCircuitHander addCircuitHander;

	public void setAddCircuitHander(AddCircuitHander addCircuitHander) {
		this.addCircuitHander = addCircuitHander;
	}

	private ListGrid _listGrid = new ListGrid() {
		protected Canvas getExpansionComponent(final ListGridRecord record) {

			VLayout recordCanvas = new VLayout(3);
			recordCanvas.setHeight(16);
			recordCanvas.setAlign(Alignment.CENTER);
			Button addCircuitBtn = new Button();
			addCircuitBtn.setShowDown(false);
			addCircuitBtn.setShowRollOver(false);
			addCircuitBtn.setLayoutAlign(Alignment.CENTER);
			addCircuitBtn.setPrompt("Add this circuit");
			addCircuitBtn.setTitle("Add this circuit");
			addCircuitBtn.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					addCircuitHander.onClick(record.getAttribute("image"),record.getAttribute("nodeData"));
				}

			});

			HTMLFlow descL = new HTMLFlow();
			descL.setContents(record.getAttribute("description"));
			recordCanvas.addMember(descL);

			HTMLFlow levelL = new HTMLFlow();
			levelL.setContents("Level : " + record.getAttribute("type"));
			recordCanvas.addMember(levelL);

			Img img = new Img("resources/" + record.getAttribute("image"), 250,
					100);
			recordCanvas.addMember(img);

			recordCanvas.addMember(addCircuitBtn);
			return recordCanvas;

		};
	};

	public CircuitPalette() {
		this.setWidth(300);
		this.setHeight100();
		_listGrid.setCanExpandRecords(true);
		_listGrid.setExpansionMode(ExpansionMode.DETAIL_FIELD);
		_listGrid.setDetailField("description");
		_listGrid.setCanSort(false);
		_listGrid.setCanGroupBy(false);
		_listGrid.setCanAutoFitFields(false);
		_listGrid.setFixedFieldWidths(false);
		_listGrid.setFixedRecordHeights(false);
		_listGrid.setCanDrag(true);
		_listGrid.setDataSource(CircuitDataSource.getInstance());
		_listGrid.setWidth100();
		_listGrid.setHeight100();

		ListGridField imageField = new ListGridField("image", "Image");
		imageField.setType(ListGridFieldType.IMAGE);
		imageField.setImageURLPrefix("resources/");

		ListGridField nameField = new ListGridField("name", "Palette");
		ListGridField typeField = new ListGridField("type", "Level");
		ListGridField descField = new ListGridField("description",
				"Description");
		ListGridField actionField = new ListGridField("actions", "Actions");
		ListGridField nodeDataField = new ListGridField("nodeData", "NodeData");
		_listGrid.setFields(nameField, descField, typeField, imageField);

		_listGrid.hideField("nodeData");
		_listGrid.hideField("description");
		_listGrid.hideField("type");
		_listGrid.hideField("image");

		_listGrid.setAutoFetchData(true);
		_listGrid.setShowRecordComponents(true);
		_listGrid.setShowRecordComponentsByCell(true);
		_listGrid.setCanRemoveRecords(false);
		_listGrid.setShowAllRecords(true);
		_listGrid.fetchData();
		addMember(_listGrid);

	}
}