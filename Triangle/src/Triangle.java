public class Triangle {
    // Private data.
    private Lineseg[] my_linesegs = new Lineseg[3];

    // Constructors.
    // Default constructor.
    Triangle() {
        my_linesegs[0] = new Lineseg(new Point(0, 0), new Point(0, 0));
        my_linesegs[1] = new Lineseg(new Point(0, 0), new Point(0, 0));
        my_linesegs[2] = new Lineseg(new Point(0, 0), new Point(0, 0));
    }
    // Lineseg fill constructor.
    Triangle(Lineseg l1, Lineseg l2, Lineseg l3) {
        my_linesegs[0] = l1;
        my_linesegs[1] = l2;
        my_linesegs[2] = l3;
    }
    // Point fill constructor.
    Triangle(Point p1, Point p2, Point p3) {
        my_linesegs[0] = new Lineseg(p1, p2);
        my_linesegs[1] = new Lineseg(p2, p3);
        my_linesegs[2] = new Lineseg(p3, p1);
    }
    // Copy constructor.
    Triangle(Triangle t) {
        my_linesegs = t.my_linesegs;
    }

    // Gets and sets.
    // Gets.
    public Lineseg[] getMy_linesegs() {
        return my_linesegs;
    }
    // Sets.
    public void setMy_linesegs(Lineseg[] my_linesegs) {
        this.my_linesegs = my_linesegs;
    }

    // Triangle member functions.
    // isTri
    // Returns if the drawn shape is a triangle.
    public boolean isTri() {
        return(true);
    }
    // kind
    // Returns the type of triangle in string format.
    public String kind() {
        return("Right");
    }
    // area
    // Returns the area of the triangle.
    public double area() {
        double p = this.perimeter()/2;
        return(Math.sqrt(p * (p - my_linesegs[0].distance()) * (p - my_linesegs[1].distance()) * (p - my_linesegs[2].distance())));
    }
    // perimeter
    // Returns the perimeter of the triangle.
    public double perimeter() {
        return(my_linesegs[1].distance() + my_linesegs[2].distance() + my_linesegs[3].distance());
    }

    // getString.
    @Override
    public String toString() {
        return(my_linesegs[0].toString() + "\n" +
                my_linesegs[1].toString() + "\n" +
                my_linesegs[2].toString());
    }
}
