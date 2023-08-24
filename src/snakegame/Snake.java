package snakegame;

import java.awt.Rectangle;
import java.util.ArrayList;

/*
 * @author kieu anh văn
 */
public class Snake {

    private ArrayList<Rectangle> bodySnake;
    private int w = Game.with;
    private int h = Game.heigh;
    private int d = Game.dimension;
    private String move;

    public Snake() {

        defaultSnakes();
        move = "NOTHING";
    }

    public ArrayList<Rectangle> getBodySnake() {
        return bodySnake;
    }

    public void setBodySnake(ArrayList<Rectangle> bodySnake) {
        this.bodySnake = bodySnake;
    }

    public void up() {
        if (move != "DOWN") {
            move = "UP";
        }
    }

    public void down() {
        if (move != "UP") {
            move = "DOWN";
        }
    }

    public void left() {
        if (move != "RIGHT") {
            move = "LEFT";
        }
    }

    public void right() {
        if (move != "LEFT") {
            move = "RIGHT";
        }
    }

    public void move() {
        if (move != "NOTHING") {
            Rectangle fist = bodySnake.get(0);
            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
            if (move == "UP") {
                temp.setLocation(fist.x, fist.y - Game.dimension);
            }
            if (move == "DOWN") {
                temp.setLocation(fist.x, fist.y + Game.dimension);
            }
            if (move == "LEFT") {
                temp.setLocation(fist.x - Game.dimension, fist.y);
            }
            if (move == "RIGHT") {
                temp.setLocation(fist.x + Game.dimension, fist.y);
            }
            bodySnake.add(0, temp);
            bodySnake.remove(bodySnake.size() - 1);
        }
    }

    public void growSnake() {
       
        
            Rectangle fist = bodySnake.get(0);
            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
            if (move == "UP") {
                temp.setLocation(fist.x, fist.y - Game.dimension);
            }
            if (move == "DOWN") {
                temp.setLocation(fist.x, fist.y + Game.dimension);
            }
            if (move == "LEFT") {
                temp.setLocation(fist.x - Game.dimension, fist.y);
            }
            if (move == "RIGHT") {
                temp.setLocation(fist.x + Game.dimension, fist.y);
            }
            bodySnake.add(0, temp);
        

    }

    public int getX() {
        return bodySnake.get(0).x;
    }

    public int getY() {
        return bodySnake.get(0).y;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public void defaultSnakes() {
        bodySnake = new ArrayList<>();
        Rectangle defaultSnakeBody = new Rectangle(d, d);
        defaultSnakeBody.setLocation(w / 2 * d, h / 2 * d);
        bodySnake.add(defaultSnakeBody);

        defaultSnakeBody = new Rectangle(d, d);
        defaultSnakeBody.setLocation(((w / 2) - 1) * d, ((h / 2)) * d);
        bodySnake.add(defaultSnakeBody);

        defaultSnakeBody = new Rectangle(d, d);
        defaultSnakeBody.setLocation(((w / 2) - 2) * d, ((h / 2)) * d);
        bodySnake.add(defaultSnakeBody);
    }

}
