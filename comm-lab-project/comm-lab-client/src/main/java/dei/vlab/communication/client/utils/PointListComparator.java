package dei.vlab.communication.client.utils;

import java.util.Comparator;

import dei.vlab.communication.client.shapes.Point;

public class PointListComparator implements Comparator<Point>{

	public int compare(Point startPoint, Point otherPoint) {
		return new Double(startPoint.distance(otherPoint)).intValue();
	}

}
