//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package pythagoras.i;

/**
 * Provides read-only access to a {@link Rectangle}.
 */
public interface IRectangle extends IShape, Cloneable
{
    /** The bitmask that indicates that a point lies to the left of this rectangle. See
     * {@link #outcode}. */
    int OUT_LEFT = 1;

    /** The bitmask that indicates that a point lies above this rectangle. See {@link #outcode}. */
    int OUT_TOP = 2;

    /** The bitmask that indicates that a point lies to the right of this rectangle. See
     * {@link #outcode}. */
    int OUT_RIGHT = 4;

    /** The bitmask that indicates that a point lies below this rectangle. See {@link #outcode}. */
    int OUT_BOTTOM = 8;

    /** Returns the x-coordinate of the upper-left corner of the framing rectangle. */
    int getX ();

    /** Returns the y-coordinate of the upper-left corner of the framing rectangle. */
    int getY ();

    /** Returns the width of the framing rectangle. */
    int getWidth ();

    /** Returns the height of the framing rectangle. */
    int getHeight ();

    /** Returns the minimum x-coordinate of the framing rectangle. */
    int getMinX ();

    /** Returns the minimum y-coordinate of the framing rectangle. */
    int getMinY ();

    /** Returns the maximum x-coordinate of the framing rectangle. <em>Note:</em> this method
     * differs from its inting-point counterparts in that it considers {@code (x + width - 1)} to
     * be a rectangle's maximum x-coordinate. */
    int getMaxX ();

    /** Returns the maximum y-coordinate of the framing rectangle. <em>Note:</em> this method
     * differs from its inting-point counterparts in that it considers {@code (y + height - 1)}
     * to be a rectangle's maximum x-coordinate. */
    int getMaxY ();

    /** Returns a copy of this rectangle's upper-left corner. */
    Point getLocation ();

    /** Initializes the supplied point with this rectangle's upper-left corner.
     * @return the supplied point. */
    Point getLocation (Point target);

    /** Returns a copy of this rectangle's size. */
    Dimension getSize ();

    /** Initializes the supplied dimension with this rectangle's size.
     * @return the supplied dimension. */
    Dimension getSize (Dimension target);

    /** Returns the intersection of the specified rectangle and this rectangle (i.e. the largest
     * rectangle contained in both this and the specified rectangle). */
    Rectangle intersection (int rx, int ry, int rw, int rh);

    /** Returns the intersection of the supplied rectangle and this rectangle (i.e. the largest
     * rectangle contained in both this and the supplied rectangle). */
    Rectangle intersection (IRectangle r);

    /** Returns the union of the supplied rectangle and this rectangle (i.e. the smallest rectangle
     * that contains both this and the supplied rectangle). */
    Rectangle union (IRectangle r);

    /** Returns a set of flags indicating where the specified point lies in relation to the bounds
     * of this rectangle. See {@link #OUT_LEFT}, etc. */
    int outcode (int px, int py);

    /** Returns a set of flags indicating where the supplied point lies in relation to the bounds of
     * this rectangle. See {@link #OUT_LEFT}, etc. */
    int outcode (IPoint point);

    /** Returns a mutable copy of this rectangle. */
    Rectangle clone ();
}