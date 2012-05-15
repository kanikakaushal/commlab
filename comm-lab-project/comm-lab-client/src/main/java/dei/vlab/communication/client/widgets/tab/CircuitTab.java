package dei.vlab.communication.client.widgets.tab;

import dei.vlab.communication.client.widgets.form.CircuitGridWindow;

public class CircuitTab extends AbstractTab {
	public static String CIRCUIT_TAB_ID = "CIRCUIT_TAB_ID";
	public static String CIRCUIT_TITLE = "Circut Management&nbsp;&nbsp;";
	public static String CIRCUIT_ICON = "tools/welcome.jpg";


	private CircuitGridWindow circuitForm;

	public CircuitTab() {
		super(CIRCUIT_TAB_ID);
		setTabTitle(CIRCUIT_TITLE);
		setIcon(CIRCUIT_ICON, 16);
		setTabHeight100();
		setTabWidth100();
		this.circuitForm = new CircuitGridWindow();
		addTabMember(circuitForm);
	}

	public CircuitGridWindow getCircuitForm() {
		return circuitForm;
	}
}
