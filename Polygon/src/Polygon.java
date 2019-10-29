/* Polygon.java
Polygon class for Polygon project.
Jack Margeson, 10/22/2019 */

public class Polygon {
    // Private data.
    private Lineseg[] my_linesegs; // Array of line segments.

    // Constructors.
    // Default constructor.
    public Polygon() {
        this.my_linesegs = new Lineseg[0];
    }
    // Fill constructor.
    public Polygon(Lineseg[] my_linesegs) {
        this.my_linesegs = my_linesegs;
    }
    // Copy constructor.
    public Polygon(Polygon p1) {
        this.my_linesegs = p1.my_linesegs;
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

    // Member functions.
    // getPerimeter();
    // Gets the perimeter of the polygon.
    double getPerimeter() {
        double perimeter = 0.0;
        for(Lineseg lineseg:my_linesegs) {
            perimeter = perimeter + lineseg.distance();
        }
        return perimeter;
    }
    // getArea();
    // Gets the area of the polygon using the shoelace method.
    public double getArea() {
        double o1 = 0, o2 = 0;
        for (int i = 0; i < my_linesegs.length; i++) {
            if ((i + 1) >= my_linesegs.length) {
                o1 = o1 + (my_linesegs[i].getMy_bp().getMy_x() * my_linesegs[0].getMy_bp().getMy_y());
                o2 = o2 + (my_linesegs[0].getMy_bp().getMy_x() * my_linesegs[i].getMy_bp().getMy_y());
            } else {
                o1 = o1 + (my_linesegs[i].getMy_bp().getMy_x() * my_linesegs[i + 1].getMy_bp().getMy_y());
                o2 = o2 + (my_linesegs[i + 1].getMy_bp().getMy_x() * my_linesegs[i].getMy_bp().getMy_y());
            }
        }
        return (.5 * Math.abs(o1 - o2));
    }
    // isIntersecting()
    // Checks if the linesegs in the polygon are intersecting.
    boolean isIntersecting() {
        // I couldn't get this to work properly so I figured I'd omit it from the GitHub repo.
    }
    // isPolygon();
    // Verifies that the linesegs are actually a Polygon.
    // Checks the area of the polygon, if all of the points connect, and the shape does not intersect itself (bow tie).
    public boolean isPolygon() {
        if(getArea() != 0 && !isIntersecting()) {
            return true;
        } else {
            return false;
        }
    }
    public String getType() {
        if(my_linesegs.length == 5) {
            return ("Pentagon");
        } else if (my_linesegs.length == 4) {
            return("Quad");
        } else if (my_linesegs.length == 6) {
            return("hexagon");
        } else {
            return("Pentagon");
        }
    }
    // toString();
    // An override for the toString() function. Returns a string of info about the polygon.
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Lineseg lineseg:my_linesegs) {
            s.append(lineseg.toString()).append("\n");
        }
        s.append("Perimeter: ").append(getPerimeter()).append("\n");
        s.append("Area: ").append(getArea()).append("\n");
        s.append("Is it a polygon? (true/false): ").append(isPolygon()).append("\n");
        return s.toString();
    }
    // toHTML();
    // A function that returns an HTML string for use in JLabel.
    public String toHTML() {
        StringBuilder s = new StringBuilder();
        s.append("<html>");
        for (Lineseg lineseg:my_linesegs) {
            s.append(lineseg.toString()).append("<br>");
        }
        s.append("Perimeter: ").append(getPerimeter()).append("<br>");
        s.append("Area: ").append(getArea()).append("<br>");
        s.append("Is it a polygon? (true/false): ").append(isPolygon()).append("<br>");
        s.append("Type: ").append(getType()).append("<br>");
        s.append("</html>");
        return s.toString();
    }
}