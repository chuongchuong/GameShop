package snakegame;

import java.awt.Rectangle;

/**
 *
 * @author kieu anh văn
 */
public class Food {

    private int x;
    private int y;

    public Food(Snake snake) {
        randomFoodLocal(snake);
    }

    public void randomFoodLocal(Snake snake) {
        boolean foodOnSnake = false;
        do {            
             x = (int) (Math.random() * Game.with);
            y = (int) (Math.random() * Game.heigh);
            for (Rectangle item : snake.getBodySnake()) {
                if (item.x == x && item.y == y) {
                    foodOnSnake = true;
                }
            }
        } while (foodOnSnake);
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
