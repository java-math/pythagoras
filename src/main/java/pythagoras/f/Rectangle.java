//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package pythagoras.f;

import java.io.Serializable;

/**
 * Represents an area in two dimensions.
 */
public class Rectangle extends AbstractRectangle implements Serializable
{
    /** The x-coordinate of the rectangle's upper left corner. */
    public float x;

    /** The y-coordinate of the rectangle's upper left corner. */
    public float y;

    /** The width of the rectangle. */
    public float width;

    /** The height of the rectangle. */
    public float height;

    /**
     * Constructs a rectangle at (0,0) and with dimensions (0,0).
     */
    public Rectangle () {
        setBounds(0, 0, 0, 0);
    }

    /**
     * Constructs a rectangle with the supplied upper-left corner and dimensions (0,0).
     */
    public Rectangle (IPoint p) {
        setBounds(p.getX(), p.getY(), 0, 0);
    }

    /**
     * Constructs a rectangle with upper-left corner at (0,) and the supplied dimensions.
     */
    public Rectangle (IDimension d) {
        setBounds(0, 0, d.getWidth(), d.getHeight());
    }

    /**
     * Constructs a rectangle with upper-left corner at the supplied point and with the supplied
     * dimensions.
     */
    public Rectangle (IPoint p, IDimension d) {
        setBounds(p.getX(), p.getY(), d.getWidth(), d.getHeight());
    }

    /**
     * Constructs a rectangle with the specified upper-left corner and dimensions.
     */
    public Rectangle (float x, float y, float width, float height) {
        setBounds(x, y, width, height);
    }

    /**
     * Constructs a rectangle with bounds equal to the supplied rectangle.
     */
    public Rectangle (IRectangle r) {
        setBounds(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    /**
     * Sets the upper-left corner of this rectangle to the specified point.
     */
    public void setLocation (float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the upper-left corner of this rectangle to the supplied point.
     */
    public void setLocation (IPoint p) {
        setLocation(p.getX(), p.getY());
    }

    /**
     * Sets the size of this rectangle to the specified dimensions.
     */
    public void setSize (float width, float height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Sets the size of this rectangle to the supplied dimensions.
     */
    public void setSize (Dimension d) {
        setSize(d.width, d.height);
    }

    /**
     * Sets the bounds of this rectangle to the specified bounds.
     */
    public void setBounds (float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * Sets the bounds of this rectangle to those of the supplied rectangle.
     */
    public void setBounds (IRectangle r) {
        setBounds(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    /**
     * Grows the bounds of this rectangle by the specified amount (i.e. the upper-left corner moves
     * by the specified amount in the negative x and y direction and the width and height grow by
     * twice the specified amount).
     */
    public void grow (float dx, float dy) {
        x -= dx;
        y -= dy;
        width += dx + dx;
        height += dy + dy;
    }

    /**
     * Translates the upper-left corner of this rectangle by the specified amount.
     */
    public void translate (float mx, float my) {
        x += mx;
        y += my;
    }

    /**
     * Expands the bounds of this rectangle to contain the specified point.
     */
    public void add (float px, float py) {
        float x1 = Math.min(x, px);
        float x2 = Math.max(x + width, px);
        float y1 = Math.min(y, py);
        float y2 = Math.max(y + height, py);
        setBounds(x1, y1, x2 - x1, y2 - y1);
    }

    /**
     * Expands the bounds of this rectangle to contain the supplied point.
     */
    public void add (IPoint p) {
        add(p.getX(), p.getY());
    }

    /**
     * Expands the bounds of this rectangle to contain the supplied rectangle.
     */
    public void add (IRectangle r) {
        float x1 = Math.min(x, r.getX());
        float x2 = Math.max(x + width, r.getX() + r.getWidth());
        float y1 = Math.min(y, r.getY());
        float y2 = Math.max(y + height, r.getY() + r.getHeight());
        setBounds(x1, y1, x2 - x1, y2 - y1);
    }

    @Override // from interface IRectangularShape
    public float getX () {
        return x;
    }

    @Override // from interface IRectangularShape
    public float getY () {
        return y;
    }

    @Override // from interface IRectangularShape
    public float getWidth () {
        return width;
    }

    @Override // from interface IRectangularShape
    public float getHeight () {
        return height;
    }

    @Override // from RectangularShape
    public void setFrame (float x, float y, float w, float h) {
        setBounds(x, y, w, h);
    }
}