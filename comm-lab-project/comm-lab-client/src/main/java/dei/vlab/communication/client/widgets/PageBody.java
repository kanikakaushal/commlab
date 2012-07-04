package dei.vlab.communication.client.widgets;

import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

import dei.vlab.communication.client.widgets.tools.CircuitPalette;
import dei.vlab.communication.client.widgets.tools.Editor;

public class PageBody extends VLayout {

	private VLayout navigation;
	private VLayout editor;
	private Editor tabSet;
	private HLayout subLayout;

	public Editor getTabSet() {
		return tabSet;
	}

	public PageBody() {
		subLayout = new HLayout();
		this.addMember(subLayout);
		/* left panel (navaigation panel configuration */
		this.navigation = new VLayout();
		this.navigation.setHeight100();
		this.navigation.setWidth(285);
		this.navigation.setMargin(5);
		this.navigation.setShowResizeBar(true);

		/* right panel (editor panel) configuration */
		this.editor = new VLayout();
		this.editor.setMargin(5);
		this.editor.setWidth100();
		this.editor.setHeight100();
		this.tabSet = new Editor();
		Canvas canvas = new Canvas();
		canvas.setWidth100();
		canvas.setHeight100();
		canvas.addChild(this.tabSet);
		this.editor.addMember(canvas);
		subLayout.addMember(this.navigation);
		subLayout.addMember(this.editor);

	}

	/*
	 * Method to add widget to naviagation panel
	 */

	public void addNavigationWidget(Widget widget) {
		this.navigation.addMember(widget);
		if(widget instanceof CircuitPalette){
		this.tabSet.setCircuitPalette((CircuitPalette)widget);
		}
	}
	public void addMenu(ToolStrip menu) {
		this.addMember(menu,0);
	}
	
	


}
