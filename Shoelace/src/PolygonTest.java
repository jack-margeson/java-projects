/* PolygonTest.java
Polygon class tester for Polygon homework.
Jack Margeson, 10/10/2019 */

public class PolygonTest {
    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(2, 4), new Point(3, -6), new Point(7, 8)};
        Polygon p = new Polygon(points);
        System.out.println(p.getArea());
    }
}
