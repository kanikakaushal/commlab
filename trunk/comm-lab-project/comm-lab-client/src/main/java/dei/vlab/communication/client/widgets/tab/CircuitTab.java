package dei.vlab.communication.client.widgets.tab;

import dei.vlab.communication.client.widgets.form.CircuitForm;

public class CircuitTab extends AbstractTab {
	public static String CIRCUIT_TAB_ID = "CIRCUIT_TAB_ID";
	public static String CIRCUIT_TITLE = "Circut Management&nbsp;&nbsp;";
	public static String CIRCUIT_ICON = "tools/welcome.jpg";


	private CircuitForm circuitForm;

	public CircuitTab() {
		super(CIRCUIT_TAB_ID);
		setTabTitle(CIRCUIT_TITLE);
		setIcon(CIRCUIT_ICON, 16);
		setTabHeight100();
		setTabWidth100();
		this.circuitForm = new CircuitForm();
		addTabMember(circuitForm);
	}

	public CircuitForm getCircuitForm() {
		return circuitForm;
	}
}
