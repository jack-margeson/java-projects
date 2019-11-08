/* HighScore.java
High score class for Breakout game.
Jack Margeson, 11/08/2019 */

import java.io.*;
import java.util.Scanner;

public class HighScore {
    // Private data.
    private String my_name;
    private int my_score;

    // Constructors.
    public HighScore() {
        try {
            Scanner scanner = new Scanner(new File("score.txt"));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                my_name = s.split(",")[0];
                my_score = Integer.parseInt(s.split(",")[1]);
            }
        } catch (FileNotFoundException err) {
            err.printStackTrace();
        }
        System.out.println("High score: " + this.my_name + ", " + this.my_score);
    }

    // Member functions
    // save();
    // Saves a new high score to the file.
    public void save(int score) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        this.my_name = scanner.nextLine();
        if (score >= my_score) {
            this.my_score = score;
            System.out.println("Congrats! You have the new high score.");
            try {
                Writer writer = new FileWriter(new File("score.txt"));
                writer.write(this.my_name + "," + this.my_score);
                writer.flush();
                writer.close();
            } catch (IOException err) {
                err.printStackTrace();
            }
        } else {
            System.out.println("Your score does not qualify for a high score.");
        }
    }
}