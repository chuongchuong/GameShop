//package snakegame;
//
//import Streamer.PlayerSnake;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.GridLayout;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.LineBorder;
//
///**
// *
// * @author kieu anh văn
// */
//public class Game implements KeyListener {
//
//    private Snake snake;
//    private Food food;
//    private JFrame window;
//    private Graphics g;
//    public static int with = 30;
//    public static int heigh = 30;
//    public static int dimension = 20;
//    private PlayerSnake player;
//
//    public Game() {
//        window = new JFrame();
//        window.setLayout(null);
//        window.setSize(1000, 1000);
//        snake = new Snake();
//        food = new Food(snake);
//        g = new Graphics(this);
//        JPanel pgame = new JPanel();
//        pgame.setLayout(new BorderLayout());
//        pgame.setBounds(0, 0, with * dimension + 5, heigh * dimension + 5);
//        pgame.setBorder(new LineBorder(Color.BLACK, 3));
//        window.setTitle("Game Snake");
//        pgame.add(g);
//        window.add(pgame);
//        window.setVisible(true);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
////    public void getPlayer(PlayerSnake player) {
////        this.player = player;
////    }
//
//    public void start() {
//        g.state = "RUNNING";
//    }
//
//    public void update() {
//        if (g.state == "RUNNING") {
//            if (check_Eat_Food()) {
//                snake.growSnake();
//                food.randomFoodLocal(snake);
//            } else if (checkTongTuong() || die_CanMinh()) {
//                g.state = "END";
//            } else {
//                snake.move();
//            }
//        }
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        if (g.state == "RUNNING") {
//            int keyCode = e.getKeyCode();
//            if (keyCode == KeyEvent.VK_W) {
//                snake.up();
//            } else if (keyCode == KeyEvent.VK_S) {
//                snake.down();
//            } else if (keyCode == KeyEvent.VK_A) {
//                snake.left();
//            } else {
//                snake.right();
//            }
//        } else {
//            this.start();
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//    }
//
//    public Snake getSnake() {
//        return snake;
//    }
//
//    public void setSnake(Snake snake) {
//        this.snake = snake;
//    }
//
//    public Food getFood() {
//        return food;
//    }
//
//    public void setFood(Food food) {
//        this.food = food;
//    }
//
//    public JFrame getWindow() {
//        return window;
//    }
//
//    public void setWindow(JFrame window) {
//        this.window = window;
//    }
//
//    public boolean checkTongTuong() {
//        if (snake.getX() < 0 || snake.getX() >= with * dimension
//                || snake.getY() < 0 || snake.getY() >= heigh * dimension) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean check_Eat_Food() {
//        if (snake.getX() == food.getX() * dimension && snake.getY() == food.getY() * dimension) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean die_CanMinh() {
//        for (int i = 1; i < snake.getBodySnake().size(); i++) {
//            if (snake.getX() == snake.getBodySnake().get(i).x
//                    && snake.getY() == snake.getBodySnake().get(i).y) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
