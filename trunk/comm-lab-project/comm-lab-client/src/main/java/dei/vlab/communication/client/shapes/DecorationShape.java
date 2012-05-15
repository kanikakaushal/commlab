package dei.vlab.communication.client.shapes;

import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.contoller.DiagramController;


public class DecorationShape extends AbstractShape {

	private Widget widget;
	
    public DecorationShape(DiagramController controller, Widget widget) {
        super(controller, widget);
        this.widget = widget;
    }
    
    public Widget getWidget(){
    	return this.widget;
    }
    
   
    public void draw() {
    }

   
    public void drawHighlight() {
    }
    
}
