package snakegame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author kieu anh văn
 */
public class Graphics extends JPanel implements ActionListener {

    private Timer t;
    public String state;
    private Snake s;
    private Food food;
    private Game game;
    private String[] pathImageSnake;
    private String pahtImageHead;
    public String bodySnake;

    public Graphics(Game game) {
        state = "Start";
        this.game = game;
        this.s = game.getSnake();
        this.food = game.getFood();
        t = new Timer(Integer.valueOf(this.game.getComboSpeed().getSelectedItem().toString()), this);
        t.start();
        this.addKeyListener(game);
        this.setFocusable(true);// truyền dữ liệu đến   bảng điều khiển 
        this.setFocusTraversalKeysEnabled(false);// có cho tap hay ko
        pathImageSnake = new String[]{"lionButtom.png", "lionLeft.png",
            "lionRight.png", "lionTop.png"};
        bodySnake = "src\\images\\bodySnake\\sun30.png";
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, Game.with * Game.dimension, Game.heigh * Game.dimension);
        Image img1;
        if (state == "Start") {
            g2d.setColor(Color.WHITE);
            g2d.drawString("PRESS ANY Key", Game.with / 2 * Game.dimension - 40,
                    Game.heigh / 2 * Game.dimension - 20);
        } else if (state == "RUNNING" || state == "pause") {

            img1 = Toolkit.getDefaultToolkit().getImage("src\\images\\icons8-apple-30.png");
//            g2d.setColor(Color.red);
//            g2d.fillRect(food.getX() * Game.dimension, food.getY() * Game.dimension, Game.dimension, Game.dimension);
            g2d.drawImage(img1, food.getX() * Game.dimension, food.getY() * Game.dimension, this);

//            g2d.setColor(Color.GREEN);
            for (int i = 0; i < s.getBodySnake().size(); i++) {
                if (i == 0) {
                    img1 = Toolkit.getDefaultToolkit().getImage("src\\images\\" + pahtImageHead);
                    g2d.drawImage(img1, s.getBodySnake().get(i).x - 5, s.getBodySnake().get(i).y
                            - (Game.dimension / 2), this);
                    continue;
                }
                img1 = Toolkit.getDefaultToolkit().getImage(bodySnake);
                g2d.drawImage(img1, s.getBodySnake().get(i).x, s.getBodySnake().get(i).y, this);
            }
        } else {
            if (state != "pause") {
                g2d.setColor(Color.WHITE);
                g2d.drawString("YOUR SCORE :" + (s.getBodySnake().size() * 3), Game.with / 2 * Game.dimension - 40,
                        Game.heigh / 2 * Game.dimension - 20);
            }

        }
        if (state == "StopGame") {
            state = "END";
        }
        if (state == "newgame") {
            state = "Start";
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        pahtImageHead = (s.getMove() == "UP") ? pathImageSnake[3]
                : (s.getMove() == "DOWN") ? pathImageSnake[0]
                : (s.getMove() == "LEFT") ? pathImageSnake[1]
                : pathImageSnake[2];
        game.update();
        t.setDelay(Integer.valueOf(this.game.getComboSpeed().getSelectedItem().toString()));

        game.getScoreLb().setText(String.valueOf((s.getBodySnake().size() - 3) * 100));
    }

}
