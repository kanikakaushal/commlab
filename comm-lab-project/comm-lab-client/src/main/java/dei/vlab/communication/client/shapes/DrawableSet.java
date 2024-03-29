package dei.vlab.communication.client.shapes;

import java.util.Collection;
import java.util.HashSet;

/**
 * Drawable composite
 */
@SuppressWarnings("serial")
public class DrawableSet<D extends Drawable> extends HashSet<D> implements Drawable {

    public DrawableSet() {
        super();
    }

    public DrawableSet(Collection<D> c) {
        super(c);
    }

    public DrawableSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public DrawableSet(int initialCapacity) {
        super(initialCapacity);
    }

   
    public void setSynchronized(boolean sync) {
        for (Drawable drawable : this) {
            drawable.setSynchronized(sync);
        }
    }

   
    public boolean isSynchronized() {
        for (Drawable drawable : this) {
            if (!drawable.isSynchronized()) {
                return false;
            }
        }
        return true;
    }

   
    public void draw() {
        for (Drawable drawable : this) {
            drawable.draw();
        }
    }

   
    public void drawHighlight() {
        for (Drawable drawable : this) {
            drawable.drawHighlight();
        }
    }

   
    public void setAllowSynchronized(boolean allowSynchronized) {
        for (Drawable drawable : this) {
            drawable.setAllowSynchronized(allowSynchronized);
        }
    }
    
   
    public boolean allowSynchronized(){
    	 for (Drawable drawable : this) {
             if (!drawable.allowSynchronized()) {
                 return false;
             }
         }
         return true;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public DrawableSet<D> getUnsynchronizedDrawables(){
		DrawableSet unsynchronizedSet = new DrawableSet<Drawable>();
    	for (Drawable drawable : this) {
            if(!drawable.isSynchronized())
            	unsynchronizedSet.add(drawable);
        }
    	return unsynchronizedSet;
    }
    

}
