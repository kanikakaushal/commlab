package dei.vlab.communication.client.widgets.form;

import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Window;

import dei.vlab.communication.client.widgets.tools.CircuitImage;

public class CoorinateMapperForm  extends Window  {
	//private DiagramController currentController;

	private String imageName;
	public CoorinateMapperForm() {
		//super(dataSource);
		//setUseAllDataSourceFields(false);
		this.setTitle("Circuit Node Coordinate Mapper");
		this.setWidth(500);
		this.setHeight(500);
		this.setIsModal(true);
		this.setShowModalMask(true);
		this.centerInPage();
	}
	
	public void showImage(){
		try{
		String imgPath="resources/"+imageName;
		CircuitImage img = new CircuitImage(imgPath);
		//currentController = new DiagramController(img.getImgWidth(),img.getImgHeight());
		//img.setDiagramController(currentController);
		Widget w = asWidget();
	    addItem(w);
		img.draw();
		}
		catch (Exception e) {
			SC.say(e.getMessage());
		}
 	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
