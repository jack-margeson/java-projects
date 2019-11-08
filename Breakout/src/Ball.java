/* Ball.java
Ball class for breakout game.
Jack Margeson 11/07/2019 */

import java.awt.*;

public class Ball  {
    // Private data.
    private int my_centerX, my_centerY, my_radius;
    private Color my_color;
    private int my_direction, my_speed;

    // Constructors.
    // Default constructor.
    public Ball() {
        this.my_centerX = 175;
        this.my_centerY = 200;
        this.my_radius = 5;
        this.my_color = new Color(255, 255, 255);
    }
    // Fill constructor.
    public Ball(int my_centerX, int my_centerY, int my_radius, Color my_color) {
        this.my_centerX = my_centerX;
        this.my_centerY = my_centerY;
        this.my_radius = my_radius;
        this.my_color = my_color;
    }

    // Gets and sets.
    public int getMy_centerX() {
        return my_centerX;
    }
    public void setMy_centerX(int my_centerX) {
        this.my_centerX = my_centerX;
    }
    public int getMy_centerY() {
        return my_centerY;
    }
    public void setMy_centerY(int my_centerY) {
        this.my_centerY = my_centerY;
    }
    public int getMy_radius() {
        return my_radius;
    }
    public void setMy_radius(int my_radius) {
        this.my_radius = my_radius;
    }
    public Color getMy_color() {
        return my_color;
    }
    public void setMy_color(Color my_color) {
        this.my_color = my_color;
    }
    public int getMy_direction() {
        return my_direction;
    }
    public void setMy_direction(int my_direction) {
        this.my_direction = my_direction;
    }
    public int getMy_speed() {
        return my_speed;
    }
    public void setMy_speed(int my_speed) {
        this.my_speed = my_speed;
    }

    // Member functions.
    // draw();
    // Draws the ball on the screen.
    public void draw(Graphics2D g2){
        Color oldColor = g2.getColor();
        g2.setColor(my_color);
        // Translates circle's center to rectangle's origin for drawing.
        g2.fillOval(my_centerX - my_radius, my_centerY - my_radius,
                my_radius * 2, my_radius * 2);
        g2.setColor(oldColor);
    }
    // containsPoint();
    // Used for collision testing.
    public boolean containsPoint(int x, int y){
        int xSquared = (x - my_centerX) * (x - my_centerX);
        int ySquared = (y - my_centerY) * (y - my_centerY);
        int radiusSquared = my_radius * my_radius;
        return xSquared + ySquared - radiusSquared <= 0;
    }
    // turn();
    // Turns the ball by x degrees.
    public void turn(int degrees){
        my_direction = (my_direction + degrees) % 360;
    }
    // move();
    // Moves the ball by x and y amounts.
    public void move(int xAmount, int yAmount){
        my_centerX = my_centerX + xAmount;
        my_centerY = my_centerY + yAmount;
    }
    // move();
    // Uses the previous move function to move the ball by a vector of it's speed and direction.
    public void move() {
        move((int) (my_speed * Math.cos(Math.toRadians(my_direction))),
                (int) (my_speed * Math.sin(Math.toRadians(my_direction))));
    }
    // moveTo();
    // Moves the ball to a specific X point.
    public void moveTo(int x) {
        my_centerX = x;
    }
}
