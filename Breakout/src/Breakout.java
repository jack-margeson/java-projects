/* Breakout.java
A breakout game, made in Java for the APCS "Pong" project.
Jack Margeson, 11/07/2019 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Breakout {
    // Declarations and init.
    private static Timer timer = new Timer();
    private static JFrame gui = new JFrame(); // JFrame from JFrame.
    private static ColorPanel pane = new ColorPanel(new Color(0, 0, 0)); // New ColorPanel from ColorPanel.
    private static Ball ball = new Ball();
    private static Paddle paddle = new Paddle();
    private static int lives = 3;

    // Main program.
    public static void main(String[] args) {
        // JFrame properties.
        gui.setSize(350,600);
        // Pane properties.
        pane.setSize(350, 600);
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
                ball.move();
                if (ball.getMy_centerX() - ball.getMy_radius() <= 0 || ball.getMy_centerX() + ball.getMy_radius() >= pane.getWidth())
                    ball.turn(45);
                if (ball.getMy_centerY() - ball.getMy_radius() <= 0 || ball.getMy_centerY() + ball.getMy_radius() >= pane.getHeight())
                    ball.turn(45);
                if ((ball.getMy_centerX() - ball.getMy_radius()) >= paddle.getMy_x()
                        && (ball.getMy_centerX() - ball.getMy_radius()) <= (paddle.getMy_x() + paddle.getMy_length())
                        && (ball.getMy_centerY() + ball.getMy_radius()) >= paddle.getMy_y()
                        && (ball.getMy_centerY() + ball.getMy_radius()) <= (paddle.getMy_y() + 5))
                    ball.turn(45);
                if ((ball.getMy_centerY() + ball.getMy_radius()) >= (pane.getHeight() - 1)) {
                    lives--;
                    if (lives == 0) {
                        gameOver();
                    } else {
                        System.out.println("Lives remaining: " + lives);
                    }
                    ball.setMy_centerX(175);
                    ball.setMy_centerY(300);
                }
                pane.repaint();
            }
        }, 50, 17);
    }

    // Game over function.
    private static void gameOver() {
        System.out.println("Game over...");
        // Stop timer.
        timer.cancel();
        timer.purge();
    }

    // ColorPanel class
    static class ColorPanel extends JPanel {
        // ColorPanel constructors.
        // Default constructor.
        ColorPanel() {
            setBackground(Color.white);
        }
        // Fill constructor.
        ColorPanel(Color color) {
            setBackground(color);
        }

        public void paintComponent(Graphics g) {
            // Create paint component.
            super.paintComponent(g);
            // Create Graphics2D component.
            Graphics2D g2 = (Graphics2D) g;

            // Draw ball test.
            ball.draw(g2);
            paddle.draw(g2);

            // Refresh graphics buffer.
            Toolkit.getDefaultToolkit().sync();
        }
    }
}
