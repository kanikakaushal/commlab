package dei.vlab.communication.client.widgets.link;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuItem;

import dei.vlab.communication.client.menu.ContextMenu;
import dei.vlab.communication.client.menu.HasContextMenu;

public class LabelWithMenu extends BoxLabel implements HasContextMenu {
    
    ContextMenu customMenu;
    
    public LabelWithMenu(String text) {
        super(text);
        customMenu = new ContextMenu();
        for (final String name : new String[] { "Custom 1", "Custom 2", "Custom 3" }) {
            customMenu.addItem(new MenuItem(name, new Command() {
                
                public void execute() {
                    Window.alert(name + " clicked");
                }
            }));
        }
    }

    
    public ContextMenu getContextMenu() {
        return customMenu;
    }
}