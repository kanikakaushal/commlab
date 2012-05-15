package dei.vlab.communication.client.canvas;


public class ImageBackgroundCanvas extends MultiBrowserDiagramCanvas{


	public ImageBackgroundCanvas(int width, int height) {
		super(width, height);
		getElement().getStyle().setZIndex(0);
	}

	public void setImageBackground(String path) {
		super.setImageBackground(path);
		
	}

}

