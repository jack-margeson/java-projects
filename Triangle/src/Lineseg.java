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

    // getString.
    public String getString() {
        return("(" + this.getMy_bp().getString() + ", " + this.getMy_ep().getString() + ")");
    }
}
