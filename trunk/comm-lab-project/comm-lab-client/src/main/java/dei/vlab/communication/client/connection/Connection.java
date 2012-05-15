package dei.vlab.communication.client.connection;

import java.util.List;

import dei.vlab.communication.client.contoller.DiagramController;
import dei.vlab.communication.client.menu.HasContextMenu;
import dei.vlab.communication.client.shapes.DecorationShape;
import dei.vlab.communication.client.shapes.Drawable;
import dei.vlab.communication.client.shapes.Point;
import dei.vlab.communication.client.shapes.Shape;
import dei.vlab.communication.client.utils.MovablePoint;

public interface Connection extends Drawable, HasContextMenu {

	/**
	 * Add a fixed point on a connection called movable point
	 * @param p the point 
	 * @return
	 */
	MovablePoint addMovablePoint(Point p);
	
	/**
	 * Set a decoration a the connection
	 * @param s the shape of the decoration to add
	 */
	void setDecoration(DecorationShape s);
	
	/**
	 * 
	 * @return decoration of the connection 
	 */
	DecorationShape getDecoration();
	
	/**
	 * 
	 * @return list of the movable points
	 */
	List<Point> getMovablePoints();
	
	/**
	 * Remove the decoration on a connection
	 */
	void removeDecoration();
	
	/**
	 * Delete alle the movable point and then, the connection is straight
	 */
	void setStraight();
	
	/**
	 *  Return the start container
	 * @return starting shape of the start widget
	 */
	Shape getStartShape();
	
	/**
	 *  Return the end container
	 * @return ending shape of the end widget
	 */
	Shape getEndShape();
	
	/**
	 *  Highlight Point
	 * @param mousePoint the point near the movable point
	 * @return the highlighted point
	 */
	Point highlightMovablePoint(Point mousePoint);
	
	/**
	 * Test is the mouse is near a connection
	 * @param mousePoint the point where the mouse is
	 * @return true is the mouse is near the connection
	 */
	boolean isMouseNearConnection(Point mousePoint);
	
	/**
	 * Delete the connection from the absolutepanel
	 */
	public void delete();
	
	void setController(DiagramController controller);

}
