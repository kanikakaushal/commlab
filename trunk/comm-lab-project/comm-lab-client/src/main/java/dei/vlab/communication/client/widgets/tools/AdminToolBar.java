package dei.vlab.communication.client.widgets.tools;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.RecordClickHandler;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

import dei.vlab.communication.client.event.EditorEvent;
import dei.vlab.communication.client.handler.CalandarToolClickHandler;
import dei.vlab.communication.client.handler.EditorEventHandler;
import dei.vlab.communication.client.widgets.arc.ToolRecord;
import dei.vlab.communication.client.widgets.tab.CalendarTab;
import dei.vlab.communication.client.widgets.tab.CircuitTab;
import dei.vlab.communication.client.widgets.tab.MessageTab;
import dei.vlab.communication.client.widgets.tab.UserWFTab;

public class AdminToolBar extends TileGrid  {
	
	private HandlerManager handlerManager;

	public AdminToolBar() {
		handlerManager = new HandlerManager(this);
		this.setTileWidth(100);
		this.setTileHeight(75);
		this.setHeight(110);
		this.setWidth100();
		this.setCanReorderTiles(false);
		this.setShowAllRecords(true);
		this.setMargin(5);
		this.setData(getTools());
		setFieldItems();

		this.addRecordClickHandler(new RecordClickHandler() {

			@Override
			public void onRecordClick(
					com.smartgwt.client.widgets.tile.events.RecordClickEvent event) {
				String msg = event.getRecord().getAttribute("name");
				if (msg.equalsIgnoreCase("User Mangement")) {
					handlerManager.fireEvent(new EditorEvent(new UserWFTab()));
				} else if (msg.equalsIgnoreCase("Circuit Mangement")) {
					handlerManager.fireEvent(new EditorEvent(new CircuitTab()));
				} else if (msg.equalsIgnoreCase("Calandar")) {
					handlerManager.fireEvent(new EditorEvent(new CalendarTab()));
				} else if (msg.equalsIgnoreCase("Send Message")) {
					handlerManager.fireEvent(new EditorEvent(new MessageTab()));
				}

			}
		});
	}

	private void setFieldItems() {
		DetailViewerField pictureField = new DetailViewerField("picture");
		pictureField.setType("image");
		pictureField.setImageURLPrefix("tools/");
		pictureField.setImageWidth(32);
		pictureField.setImageHeight(32);
		DetailViewerField nameField = new DetailViewerField("name");
		this.setFields(pictureField, nameField);
	}

	private ToolRecord[] getTools() {
		return new ToolRecord[] {
				new ToolRecord("User Mangement", "users.png"),
				new ToolRecord("Circuit Mangement", "circuit.png"),
				new ToolRecord("Calandar", "calandar.png"),
				new ToolRecord("Send Message", "message.png") };

	}


		public HandlerRegistration addEditorEventHandler(
			EditorEventHandler handler) {
		return handlerManager.addHandler(EditorEvent.getType(), handler);
	}

}
