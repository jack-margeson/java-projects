public class TriangleTest {
    public static void main(String[] args) {
        Point p1 = new Point(4, 5);
        System.out.println(p1.getString() + "\n");
        Lineseg l1 = new Lineseg(p1, p1);
        System.out.println(l1.getString() + "\n");
        Triangle t1 = new Triangle(l1, l1, l1);
        System.out.println(t1.getString());
    }
}
