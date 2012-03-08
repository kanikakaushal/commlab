package dei.vlab.communication.client.event;

import com.google.gwt.event.shared.GwtEvent;

import dei.vlab.communication.client.handler.EditorEventHandler;
import dei.vlab.communication.client.widgets.tab.AbstractTab;

public class EditorEvent  extends GwtEvent<EditorEventHandler> {
	 private static final Type<EditorEventHandler> TYPE = new Type<EditorEventHandler>();
	 
	 private final AbstractTab abstractTab;
	 
	 public EditorEvent(AbstractTab abstractTab) {
	  this.abstractTab = abstractTab;
	 }
	 
	 public static Type<EditorEventHandler> getType() {
	  return TYPE;
	 }
	 
	 public AbstractTab getTab() {
	  return abstractTab;
	 }
	 
	 @Override
	 protected void dispatch(EditorEventHandler handler) {
	  handler.openTab(this);
	 }

	 @Override
	 public Type<EditorEventHandler> getAssociatedType() {
	  return TYPE;
	 }
	}