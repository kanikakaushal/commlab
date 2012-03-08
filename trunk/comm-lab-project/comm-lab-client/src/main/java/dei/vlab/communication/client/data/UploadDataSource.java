package dei.vlab.communication.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.fields.DataSourceBinaryField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.form.fields.UploadItem;

public class UploadDataSource extends DataSource {
	private static UploadDataSource instance = null;

	public static UploadDataSource getInstance() {
		if (instance == null) {
			instance = new UploadDataSource("uploadDS");
			instance.setDataURL("app/imageUploadRest");
			OperationBinding opBind = new OperationBinding();
			opBind.setOperationType(DSOperationType.ADD);
			opBind.setDataProtocol(DSProtocol.POSTPARAMS);
			instance.setOperationBindings(opBind);
		}

		return instance;
	}

	private UploadDataSource(String id) {
		super(id);
	}

	protected void init() {
		
		DataSourceBinaryField imageField = new DataSourceBinaryField("image","Image");
	
		UploadItem fileItem = new UploadItem("image");
		imageField.setEditorType(fileItem);
		setFields(imageField);

	}

	
}
