/* Level.java
Level class for breakout game.
Jack Margeson, 11/07/2019 */

import java.awt.*;
import java.util.ArrayList;

public class Level {
    // Private data
    ArrayList<Brick> my_bricks = new ArrayList<Brick>();

    // Constructors
    // Default constructor.
    public Level() {
        int i = 0;
        my_bricks.add(i, new Brick(10, 20, 50, 20, Color.white));
        for (i = 1; i <= 5; i++) {
            my_bricks.add(i, new Brick(my_bricks.get(i - 1).getMy_x() + 55, 20, 50, 20, Color.white));
        }
        my_bricks.add(i, new Brick(10, 50, 50, 20, Color.white));
        for (i = 7; i <= 11; i++) {
            my_bricks.add(i, new Brick(my_bricks.get(i - 1).getMy_x() + 55, 50, 50, 20, Color.white));
        }
        my_bricks.add(i, new Brick(10, 80, 50, 20, Color.white));
        for (i = 13; i <= 17; i++) {
            my_bricks.add(i, new Brick(my_bricks.get(i - 1).getMy_x() + 55, 80, 50, 20, Color.white));
        }
        my_bricks.add(i, new Brick(10, 80, 50, 20, Color.white));
        for (i = 19; i <= 23; i++) {
            my_bricks.add(i, new Brick(my_bricks.get(i - 1).getMy_x() + 55, 80, 50, 20, Color.white));
        }
    }

    // Gets and sets.
    public ArrayList<Brick> getMy_bricks() {
        return my_bricks;
    }
    public void setMy_bricks(ArrayList<Brick> my_bricks) {
        this.my_bricks = my_bricks;
    }

    // Member functions.
    // Checks if the game has been won.
    public boolean checkCleared() {
        for (Brick my_brick : my_bricks) {
            if (!my_brick.isMy_status()) {
                return false;
            }
        }
        return true;
    }
}
