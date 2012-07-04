package dei.vlab.communication.client.canvas;

import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.DomEvent.Type;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.widgetideas.graphics.client.Color;
import com.google.gwt.widgetideas.graphics.client.GWTCanvas;
import com.smartgwt.client.widgets.Canvas;

public class MultiBrowserDiagramCanvas implements DiagramCanvas{

	protected int width;
	protected int height;
	private GWTCanvas canvas;
	
	public MultiBrowserDiagramCanvas(int width, int height){
		this.width = width;
		this.height = height;
		this.canvas = new GWTCanvas();
		setBackground();
		getElement().getStyle().setPosition(Position.RELATIVE);
		getElement().getStyle().setWidth(width, Unit.PX);
		getElement().getStyle().setHeight(height, Unit.PX);
		canvas.setCoordSize(width, height);
		canvas.setLineWidth(3);
	}
	
	
	public void setForeground() {
		this.getElement().getStyle().setZIndex(5);
	}

	
	public void setBackground() {
		this.getElement().getStyle().setZIndex(2);
	}


	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	public void setStrokeStyle(CssColor color) {
		setStrokeStyle(color.toString());
	}

	
	public void setFillStyle(CssColor color) {
		setFillStyle(color.toString());
	}
	
	
	public Widget asWidget(){
		return canvas;
	}

	
	public void setStrokeStyle(String color) {
		canvas.setStrokeStyle(new Color(color));
	}

	
	public void setFillStyle(String color) {
		canvas.setFillStyle(new Color(color));
	}


	
	public void clear() {
		canvas.clear();
	}

	
	public <H extends EventHandler> HandlerRegistration addDomHandler(
			H handler, Type<H> type) {
		return canvas.addDomHandler(handler, type);
	}

	
	public Element getElement() {
		return canvas.getElement();
	}

	
	public void beginPath() {
		canvas.beginPath();
	}

	
	public void closePath() {
		canvas.closePath();
	}

	
	public void lineTo(double x, double y) {
		canvas.lineTo(x, y);
	}

	
	public void moveTo(double x, double y) {
		canvas.moveTo(x, y);
	}

	
	public void fillRect(double x, double y, double w, double h) {
		canvas.fillRect(x, y, w, h);
	}

	
	public void stroke() {
		canvas.stroke();
	}

	
	public void arc(double x, double y, double radius, double startAngle,
			double endAngle, boolean anticlockwise) {
		canvas.arc(x, y, radius, startAngle, endAngle, anticlockwise);
	}

	
	public void fill() {
		canvas.fill();
	}

	
	public void bezierCurveTo(double cpx, double cpy, double x, double y) {
		canvas.cubicCurveTo(cpx, cpy, cpx, cpy, x, y);
	}

	
    public void setGlobalAlpha(double alpha) {
        canvas.setGlobalAlpha(alpha);
    }

	
	public void setImageBackground(String path) {
		Image image=new Image(path);
		canvas.drawImage(ImageElement.as(image.getElement()), 0, 0);
		
	}

	
}
