package dei.vlab.communication.client.widgets.tools;

import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class CircuitPalette extends ListGrid {

	public CircuitPalette() {
		this.setWidth(300);
		this.setHeight100();
		this.setCanExpandRecords(true);
		this.setExpansionMode(ExpansionMode.DETAIL_FIELD);
		this.setDetailField("desc");
		this.setCanSort(false);
		this.setCanGroupBy(false);
		this.setCanAutoFitFields(false);
		this.setFixedFieldWidths(false);
		this.setFixedRecordHeights(false);
		this.setCanDrag(true);
		ListGridField nameField = new ListGridField("name", "Palette");
		this.setFields(nameField);

		this.setData(getNewRecords());

	}

	public class CircuitRecord extends ListGridRecord {

		public CircuitRecord() {
		}

		public CircuitRecord(String name) {
			setName(name);
		}

		public CircuitRecord(String name, String desc) {
			setName(name);
			setDesc(desc);
		}

		public void setName(String name) {
			setAttribute("name", name);
		}

		public String getName() {
			return getAttributeAsString("name");
		}

		public void setDesc(String desc) {
			setAttribute("desc", desc);
		}

		public String getDesc() {
			return getAttributeAsString("desc");
		}

	}

		private CircuitRecord[] getNewRecords() {
			return new CircuitRecord[] {
					new CircuitRecord("Function Generator", "No description avalaible"),
					new CircuitRecord("De-Modulator", "Demodulation is the act of extracting the original information-bearing signal from a modulated carrier wave. A demodulator is an electronic circuit (or computer program in a software-defined radio) that is used to recover the information content from the modulated carrier wave.[1] These terms are traditionally used in connection with radio receivers, but many other systems use many kinds of demodulators. Another common one is in a modem, which is a contraction of the terms modulator/demodulator."),
					new CircuitRecord("Detector", "No description avalaible"),
					new CircuitRecord("Amplifier/Mixer", "No description avalaible"),
					new CircuitRecord("Amplitude Limiter", "No description avalaible"),
					new CircuitRecord("Low Pass Filter", "No description avalaible")
			};

		}
	
}