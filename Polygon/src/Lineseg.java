/* Lineseg.java
Lineseg class for Polygon project.
Jack Margeson, 10/22/2019 */

public class Lineseg {
    // Private data.
    private Point my_bp; // Beginning point.
    private Point my_ep; // Ending point.

    // Constructors.
    // Default constructor.
    Lineseg() {
        my_bp = new Point(0,0);
        my_ep = new Point(0, 0);
    }
    // Fill constructor.
    Lineseg(Point a, Point b) {
        my_bp = a;
        my_ep = b;
    }
    // Copy constructor.
    Lineseg(Lineseg l) {
        my_bp = l.my_bp;
        my_ep = l.my_ep;
    }

    // Gets and sets.
    // Gets.
    public Point getMy_bp() {
        return my_bp;
    }
    public Point getMy_ep() {
        return my_ep;
    }
    // Sets.
    public void setMy_bp(Point my_bp) {
        this.my_bp = my_bp;
    }
    public void setMy_ep(Point my_ep) {
        this.my_ep = my_ep;
    }

    // Lineseg member functions.
    // slope
    // Returns the slope of the lineseg using slope formula.
    public double slope() {
        return((my_ep.getMy_y() - my_bp.getMy_y())/(my_ep.getMy_x()-my_bp.getMy_x()));
    }
    // distance
    // Returns the distance of the lineseg.
    public double distance() {
        return(Math.sqrt(Math.pow(my_ep.getMy_x() - my_bp.getMy_x(), 2) + Math.pow(my_ep.getMy_y() - my_ep.getMy_y(), 2)));
    }

    @Override
    public String toString() {
        return("(" + this.getMy_bp().toString() + ", " + this.getMy_ep().toString() + ")");
    }
}