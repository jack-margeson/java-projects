class Point {
    // Private data.
    private int my_x;
    private int my_y;

    // Constructors.
    // Default constructor.
    Point() {
        my_x = 0;
        my_y = 0;
    }
    // Fill constructor
    Point(int x, int y) {
        my_x = x;
        my_y = y;
    }
    // Copy constructor.
    Point(Point p) {
        my_x = p.my_x;
        my_y = p.my_y;
    }

    // Gets and sets.
    // Gets.
    public int getMy_x() {
        return my_x;
    }
    public int getMy_y() {
        return my_y;
    }
    // Sets.
    public void setMy_x(int my_x) {
        this.my_x = my_x;
    }
    public void setMy_y(int my_y) {
        this.my_y = my_y;
    }

    // getString.
    public String getString() {
        return("(" + this.getMy_x() + ", " + this.getMy_y() + ")");
    }
}
