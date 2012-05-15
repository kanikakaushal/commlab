package dei.vlab.communication.client.utils;

import dei.vlab.communication.client.shapes.Point;

public class MovablePoint extends Point{

	private Point point;
	
	public MovablePoint(double left, double top) {
		super(left, top);
	}
	
	public MovablePoint(Point p) {
		super(p.getLeft(), p.getTop());
	}

	
	public int getLeft(){
		return point == null ? super.left : point.getLeft();
	}
	
	
	public int getTop(){
		return point == null ? super.top : point.getTop();
	}
	
	public void setTrackPoint(Point p){
		this.point = p;
	}
	
	public void setFixed(boolean fixed){
		left = getLeft();
		top = getTop();
		if(fixed && point != null){
			point = null;
		}
	}
	
}
