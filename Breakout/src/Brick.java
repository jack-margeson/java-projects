/* Brick.java
Brick class for breakout game.
Jack Margeson 11/07/2019 */

import java.awt.*;

public class Brick {
    // Private data.
    private int my_x, my_y;
    private int my_width, my_height;
    private Color my_color;
    boolean my_status;

    // Constructors.
    // Default constructor.
    public Brick() {
        this.my_x = 0;
        this.my_y = 0;
        this.my_width = 0;
        this.my_height = 0;
        this.my_color = Color.white;
        this.my_status = false;
    }
    // Fill constructor.
    public Brick(int my_x, int my_y, int my_width, int my_height, Color my_color) {
        this.my_x = my_x;
        this.my_y = my_y;
        this.my_width = my_width;
        this.my_height = my_height;
        this.my_color = my_color;
        this.my_status = false;
    }

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
    public int getMy_width() {
        return my_width;
    }
    public void setMy_width(int my_width) {
        this.my_width = my_width;
    }
    public int getMy_height() {
        return my_height;
    }
    public void setMy_height(int my_height) {
        this.my_height = my_height;
    }
    public Color getMy_color() {
        return my_color;
    }
    public void setMy_color(Color my_color) {
        this.my_color = my_color;
    }
    public boolean isMy_status() {
        return my_status;
    }
    public void setMy_status(boolean my_status) {
        this.my_status = my_status;
    }

    // Member functions.
    // draw();
    // Draws the rectangle.
    public void draw(Graphics2D g2){
        Color oldColor = g2.getColor();
        g2.setColor(my_color);
        // Creates a 3D rectangle.
        g2.fill3DRect(this.my_x, this.my_y, this.my_width, this.my_height, true);
        g2.setColor(oldColor);
    }
    // isColliding();
    // Used to check ball collision.
    public boolean isColliding(Ball ball) {
        if ((ball.getMy_centerY() + ball.getMy_radius()) <= (my_y + my_height) &&
                (ball.getMy_centerY() + ball.getMy_radius() >= (my_y)) &&
                (ball.getMy_centerX() - ball.getMy_radius()) >= (my_x) &&
                (ball.getMy_centerX() - ball.getMy_radius()) <= (my_x + my_width) &&
                (!this.my_status)) {
            this.my_status = true;
            return true;
        }
        return false;
    }
}
