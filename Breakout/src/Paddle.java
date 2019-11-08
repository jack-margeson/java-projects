/* Paddle.java
Paddle class for breakout game.
Jack Margeson 11/07/2019 */

import java.awt.*;

public class Paddle  {
    // Private data.
    private int my_x, my_y, my_length;
    private Color my_color;

    // Gets and sets.
    public int getMy_x() {
        return my_x;
    }
    public void setMy_x(int my_x) {
        this.my_x = my_x;
    }
    public int getMy_y() {
        return my_y;
    }
    public void setMy_y(int my_y) {
        this.my_y = my_y;
    }
    public int getMy_length() {
        return my_length;
    }
    public void setMy_length(int my_length) {
        this.my_length = my_length;
    }
    public Color getMy_color() {
        return my_color;
    }
    public void setMy_color(Color my_color) {
        this.my_color = my_color;
    }

    // Constructors.
    // Default constructor.
    public Paddle() {
        this.my_x = 300;
        this.my_y = 350;
        this.my_length = 50;
        this.my_color = new Color(255, 255, 255);
    }
    // Fill constructor.
    public Paddle(int x, int y, int length, Color color) {
        this.my_x = x;
        this.my_y = y;
        this.my_length = length;
        this.my_color = color;
    }

    // Member functions.
    // draw();
    // Draws the ball on the screen.
    public void draw(Graphics2D g2){
        Color oldColor = g2.getColor();
        Stroke oldStroke = g2.getStroke();
        g2.setColor(my_color);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(my_x, my_y, my_x + my_length, my_y);
        g2.setColor(oldColor);
        g2.setStroke(oldStroke);
    }

    // moveTo();
    // Moves the ball to a specific X point.
    public void moveTo(int x) {
        my_x = (x - (my_length/2));
    }
}
