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
    // Fill constructor.
    Triangle(Lineseg l1, Lineseg l2, Lineseg l3) {
        my_linesegs[0] = l1;
        my_linesegs[1] = l2;
        my_linesegs[2] = l3;
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

    // getString.
    public String getString() {
        return(my_linesegs[0].getString() + "\n" +
                my_linesegs[1].getString() + "\n" +
                my_linesegs[2].getString());
    }
}
