/* Polygon.java
Polygon class for Polygon homework.
Jack Margeson, 10/10/2019 */

public class Polygon {
    // Private data.
    private Point[] my_points;

    // Constructors.
    // Default constructor.
    public Polygon() {
        this.my_points = new Point[0];
    }
    // Fill constructor.
    public Polygon(Point[] my_points) {
        this.my_points = my_points;
    }
    // Copy constructor.
    public Polygon(Polygon p1) {
        this.my_points = p1.my_points;
    }

    // Sets and gets.
    // Gets.
    public Point[] getMy_points() {
        return my_points;
    }
    // Sets.
    public void setMy_points(Point[] my_points) {
        this.my_points = my_points;
    }

    // Member functions.
    // Gets the area of the polygon using the Shoelace method.
    public double getArea() {
        double o1 = 0, o2 = 0;
        for (int i = 0; i < my_points.length; i++) {
            if ((i + 1) >= my_points.length) {
                o1 = o1 + (my_points[i].getMy_x() * my_points[0].getMy_y());
                o2 = o2 + (my_points[0].getMy_x() * my_points[i].getMy_y());
            } else {
                o1 = o1 + (my_points[i].getMy_x() * my_points[i + 1].getMy_y());
                o2 = o2 + (my_points[i + 1].getMy_x() * my_points[i].getMy_y());
            }
        }
        return (.5 * Math.abs(o1 - o2));
    }
}
