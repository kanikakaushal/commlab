package dei.vlab.communication.client.shapes;

import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.canvas.DiagramCanvas;
import dei.vlab.communication.client.contoller.DiagramController;
import dei.vlab.communication.client.utils.Couple;
import dei.vlab.communication.client.utils.Direction;
import dei.vlab.communication.client.utils.LinksClientBundle;

public class FunctionShape extends AbstractShape {

	private int selectableAreaRadius = 8;
	private CssColor highlightSelectableAreaColor = CssColor.make("#DDDDDD");

	Point centerW;	
	Point centerN;
	Point centerS;
	Point centerE;
	
    public FunctionShape(DiagramController controller, Widget widget) {
        super(controller, widget);
    }

   
    public void setSynchronized(boolean sync) {
        if (allowSync && !sync) {
            centerW = null;
            centerN = null;
            centerS = null;
            centerE = null;
        }
        super.setSynchronized(sync);
    }

    public boolean isMouseNearSelectableArea(Point mousePoint) {
        return getSelectableArea(mousePoint) != null;
    }

    public void highlightSelectableArea(Point mousePoint) {
        // Mouse Point
        Couple<Direction, Point> couple = getSelectableArea(mousePoint);
        Direction direction = couple.getFirstArg();
        Point closestSelectablePoint = couple.getSecondArg();
        if (closestSelectablePoint != null) {
            DiagramCanvas canvas = controller.getDiagramCanvas();
            canvas.beginPath();
            canvas.arc(closestSelectablePoint.getLeft(), closestSelectablePoint.getTop(), selectableAreaRadius, direction.getAngle()
                    - Math.PI / 2, direction.getAngle() + Math.PI / 2, true);
            canvas.setStrokeStyle(highlightSelectableAreaColor);
            canvas.stroke();
            canvas.setFillStyle(highlightSelectableAreaColor);
            canvas.fill();
            canvas.closePath();
        }
    }

    public Couple<Direction, Point> getSelectableArea(Point p) {
        // Center of the selectable areas
        if (centerW == null || !isSynchronized()) {
            centerW = new Point(getLeft(), getTop() + getHeight() / 2);
            centerN = new Point(getLeft() + getWidth() / 2, getTop());
            centerS = new Point(getLeft() + getWidth() / 2, getTop() + getHeight() - 1);
            centerE = new Point(getLeft() + getWidth() - 1, getTop() + getHeight() / 2);
            setSynchronized(true);
        }

        if (p.distance(centerW) <= selectableAreaRadius) {
            return new Couple<Direction, Point>(Direction.W, centerW);
        } else if (p.distance(centerN) <= selectableAreaRadius) {
            return new Couple<Direction, Point>(Direction.N, centerN);
        } else if (p.distance(centerS) <= selectableAreaRadius) {
            return new Couple<Direction, Point>(Direction.S, centerS);
        } else if (p.distance(centerE) <= selectableAreaRadius) {
            return new Couple<Direction, Point>(Direction.E, centerE);
        }
        return null;
    }

   
    public void drawHighlight() {
        widget.addStyleName(LinksClientBundle.INSTANCE.css().translucide());        
        setSynchronized(true);
    }

   
    public void draw() {
        widget.removeStyleName(LinksClientBundle.INSTANCE.css().translucide());
        setSynchronized(true);
    }

}
