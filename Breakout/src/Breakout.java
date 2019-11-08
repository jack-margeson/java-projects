/* Breakout.java
A breakout game, made in Java for the APCS "Pong" project.
Jack Margeson, 11/07/2019 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Breakout {
    // Declarations and init.
    // GUI and misc. variables.
    private static JFrame gui = new JFrame(); // JFrame from JFrame.
    private static ColorPanel pane = new ColorPanel(new Color(0, 0, 0)); // New ColorPanel from ColorPanel.
    private static Timer timer = new Timer(); // Used for animation
    // Game variables.
    private static Ball ball = new Ball(); // Ball that moves around the screen.
    private static Paddle paddle = new Paddle(); // Paddle controllable with the mouse cursor.
    private static Level level = new Level(); // ArrayList of breakable bricks.
    private static int lives = 3;

    // Main program.
    public static void main(String[] args) {
        // JFrame properties.
        gui.setSize(350,400);
        // Pane properties.
        pane.setSize(350, 400);
        pane.setLocation(0,0);

        // Add pane.
        gui.add(pane);
        // Show GUI.
        gui.setVisible(true);

        // Start the game.
        startGame();
    }

    // Main game function.
    private static void startGame() {
        // Init ball speed and direction.
        ball.setMy_speed(3);
        ball.setMy_direction(45);
        // Output starting lives to console.
        System.out.println("Lives remaining: " + lives);

        pane.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                paddle.moveTo(e.getX());
            }
        });

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Moves the ball according to it's velocity and direction.
                ball.move();

                // Collision checks.
                // Vertical walls.
                if (ball.getMy_centerX() - ball.getMy_radius() <= 0 || ball.getMy_centerX() + ball.getMy_radius() >= pane.getWidth())
                    ball.turn(45);
                // Horizontal walls.
                if (ball.getMy_centerY() - ball.getMy_radius() <= 0 || ball.getMy_centerY() + ball.getMy_radius() >= pane.getHeight())
                    ball.turn(45);
                // Paddle.
                if ((ball.getMy_centerX() - ball.getMy_radius()) >= paddle.getMy_x()
                        && (ball.getMy_centerX() - ball.getMy_radius()) <= (paddle.getMy_x() + paddle.getMy_length())
                        && (ball.getMy_centerY() + ball.getMy_radius()) >= paddle.getMy_y()
                        && (ball.getMy_centerY() + ball.getMy_radius()) <= (paddle.getMy_y() + 10))
                    ball.turn(45);

                // Lives counter/checker.
                if ((ball.getMy_centerY() + ball.getMy_radius()) >= (pane.getHeight() - 1)) {
                    lives--;
                    if (lives == 0) {
                        gameOver(0);
                    } else {
                        System.out.println("Lives remaining: " + lives);
                    }
                    ball.setMy_direction(45);
                    ball.setMy_centerX(175);
                    ball.setMy_centerY(200);
                }

                // Brick collision checker.
                for (int i = 0; i < level.getMy_bricks().size(); i++){
                    if (level.getMy_bricks().get(i).isColliding(ball)) {
                        ball.turn(90);
                    }
                }

                // Re-draw graphics.
                pane.repaint();

                // Check if all of the bricks have been cleared.
                if (level.checkCleared()) {
                    gameOver(1);
                }
            }
        }, 200, 17);
    }

    // Game over function.
    private static void gameOver(int condition) {
        System.out.println("Game over!");
        // Stop timer.
        timer.cancel();
        timer.purge();
        switch (condition) {
            case 0: // Game loss
                System.out.println("You lose.");
                break;

            case 1: // Game win
                System.out.println("You win!");
                break;
        }
    }

    // ColorPanel class
    static class ColorPanel extends JPanel {
        // Fill constructor.
        ColorPanel(Color color) {
            setBackground(color);
        }

        public void paintComponent(Graphics g) {
            // Create paint component.
            super.paintComponent(g);
            // Create Graphics2D component.
            Graphics2D g2 = (Graphics2D) g;

            // Draw background image.
            BufferedImage background = null;
            try {
                background = ImageIO.read(new File("clay.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g2.drawImage(background, (getWidth()/2)-128, (getHeight()/2)-128, this);

            // Draw ball.
            ball.draw(g2);

            // Draw paddle.
            paddle.draw(g2);

            // Draw bricks.
            for (int i = 0; i < level.getMy_bricks().size(); i++) {
                if (!level.getMy_bricks().get(i).isMy_status()) {
                    level.getMy_bricks().get(i).draw(g2);
                }
            }

            // Refresh graphics buffer.
            Toolkit.getDefaultToolkit().sync();
        }
    }
}
