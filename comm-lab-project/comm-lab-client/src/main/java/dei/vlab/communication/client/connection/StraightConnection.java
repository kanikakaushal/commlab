package dei.vlab.communication.client.connection;

import java.util.List;

import dei.vlab.communication.client.canvas.DiagramCanvas;
import dei.vlab.communication.client.contoller.DiagramController;
import dei.vlab.communication.client.exception.DiagramViewNotDisplayedException;
import dei.vlab.communication.client.shapes.Point;
import dei.vlab.communication.client.shapes.Shape;
import dei.vlab.communication.client.utils.Segment;

public class StraightConnection extends AbstractConnection {

    private int cubicMargin = 25;

    public StraightConnection(DiagramController controller, Shape startShape, Shape endShape) throws DiagramViewNotDisplayedException {
        super(controller, startShape, endShape);
    }

    @Override
    public void draw(Point p1, Point p2, boolean lastPoint) {
        DiagramCanvas canvas = controller.getDiagramCanvas();

        canvas.clear();
        
        canvas.beginPath();
        canvas.moveTo(p1.getLeft(), p1.getTop());
        canvas.lineTo(p2.getLeft(), p2.getTop());

        canvas.setStrokeStyle(connectionColor);
        canvas.stroke();
        canvas.closePath();
    }

    @Override
    protected void draw(List<Point> pointList) {
        Point p0 = pointList.get(0);
        Point p1 = pointList.get(1);
        Point p2;

        canvas.clear();
        
        canvas.beginPath();
        canvas.moveTo(p0.getLeft(), p0.getTop());

        // Curve only for intermediate point
        for (int i = 1; i < pointList.size() - 1; i++) {
            p0 = pointList.get(i - 1);
            p1 = pointList.get(i);
            p2 = pointList.get(i + 1);

            // source point
            Segment prevSegment = new Segment(p0, p1);
            double prevAngle = prevSegment.getAngleWithTop();
            double srcx = p1.getLeft() - cubicMargin * Math.cos(prevAngle);
            double srcy = p1.getTop() - cubicMargin * Math.sin(prevAngle);

            // control point
            double cpx = p1.getLeft();
            double cpy = p1.getTop();

            // destination point
            Segment nextSegment = new Segment(p1, p2);
            double nextAngle = nextSegment.getAngleWithTop();
            double x = p1.getLeft() + cubicMargin * Math.cos(nextAngle);
            double y = p1.getTop() + cubicMargin * Math.sin(nextAngle);

            canvas.lineTo(srcx, srcy);
            canvas.bezierCurveTo(cpx, cpy, x, y);
        }

        p0 = pointList.get(pointList.size() - 2);
        p1 = pointList.get(pointList.size() - 1);
        canvas.lineTo(p1.getLeft(), p1.getTop());

        canvas.setStrokeStyle(connectionColor);
        canvas.stroke();
        canvas.closePath();
    }

}
