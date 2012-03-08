package dei.vlab.communication.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class PopupView extends PopupPanel {

    @UiTemplate("PopupView.ui.xml") 
    interface Binder extends UiBinder<Widget, PopupView> { } 
    private static final Binder binder = GWT.create(Binder.class); 
    public PopupView() { 
       super(true); 
      add(binder.createAndBindUi(this)); 
    } 

}
