package dei.vlab.communication.client.shapes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.connection.Connection;
import dei.vlab.communication.client.contoller.DiagramController;
import dei.vlab.communication.client.utils.ClassnameContainerFinder;
import dei.vlab.communication.client.utils.IContainerFinder;



public abstract class AbstractShape implements Shape {

    protected Widget widget;
    protected DiagramController controller;

    private int containerOffsetLeft = -1;
    private int containerOffsetTop = -1;
    private int offsetWidth = -1;
    private int offsetHeight = -1;
    private boolean sync;
    protected boolean allowSync = true;

    protected DrawableSet<Connection> connections = new DrawableSet<Connection>();
    
    protected IContainerFinder containerFinder = new ClassnameContainerFinder();

    public AbstractShape(DiagramController controller, Widget widget) {
        this.widget = widget;
        this.controller = controller;
    }

    public boolean isSynchronized() {
        return sync;
    }

    public void setSynchronized(boolean sync) {
        if (allowSync) {
            this.sync = sync;
        }
    }
    
    public boolean allowSynchronized(){
    	return allowSync;
    }

    public int getLeft() {
        return widget.getAbsoluteLeft() - getContainerOffsetLeft();
    }

    protected int getContainerOffsetLeft() {
        if (containerOffsetLeft < 0 || !sync) {
        	int scrollLeft = 0;
            Element parent = DOM.getParent(widget.getElement());
            while (parent != null) {
            	if(getScrollLeft(parent) > 0){
            		scrollLeft += getScrollLeft(parent);
            		GWT.log("Scroll left detected : " + scrollLeft);
            	}
            	if (containerFinder.isContainer(parent)) {
                    containerOffsetLeft = DOM.getAbsoluteLeft(parent) - scrollLeft;
                }
                parent = DOM.getParent(parent);
            }
        }
        return containerOffsetLeft;
    }

   
    public int getTop() {
        return widget.getAbsoluteTop() - getContainerOffsetTop();
    }

    protected int getContainerOffsetTop() {
        if (containerOffsetTop < 0 || !sync) {
        	int scrollTop = 0;
            Element parent = DOM.getParent(widget.getElement());
            while (parent != null) {
            	if(getScrollTop(parent) > 0){
            		scrollTop += getScrollTop(parent);
            		GWT.log("Scroll Top detected : " + scrollTop);
            	}
            	if (containerFinder.isContainer(parent)) {
                    containerOffsetTop = DOM.getAbsoluteTop(parent) - scrollTop;
                }
                parent = DOM.getParent(parent);
            }
        }
        return containerOffsetTop;
    }
    
    private native int getScrollLeft(Element element)/*-{
		return element.scrollLeft;
	}-*/;

    private native int getScrollTop(Element element)/*-{
		return element.scrollTop;
	}-*/;


    public int getWidth() {
        if (offsetWidth < 0 || !sync) {
            offsetWidth = widget.getOffsetWidth();
        }
        return offsetWidth;
    }

    public int getHeight() {
        if (offsetHeight < 0 || !sync) {
            offsetHeight = widget.getOffsetHeight();
        }
        return offsetHeight;
    }

    public boolean addConnection(Connection connection) {
        return connections.add(connection);
    }

    public boolean removeConnection(Connection connection) {
        return connections.remove(connection);
    }

    public Widget asWidget() {
        return widget;
    }

   
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((widget == null) ? 0 : widget.hashCode());
        return result;
    }

   
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractShape other = (AbstractShape) obj;
        if (widget == null) {
            if (other.widget != null)
                return false;
        } else if (!widget.equals(other.widget))
            return false;
        return true;
    }

    public DrawableSet<Connection> getConnections() {
        return connections;
    }

   
    public void setAllowSynchronized(boolean allowSynchronized) {
        this.allowSync = allowSynchronized;
    }
    
    

}
