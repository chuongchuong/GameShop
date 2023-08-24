package snakegame;

import Streamer.PlayerSnake;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import static snakegame.Game.dimension;
import static snakegame.Game.heigh;
import static snakegame.Game.with;

/**
 *
 * @author kieu anh văn
 */
public class Game extends javax.swing.JFrame implements KeyListener {

    private Snake snake;
    private Food food;
    private Graphics g;
    public static int with = 30;
    public static int heigh = 30;
    public static int dimension = 20;
    public String statusOfSnake;
    private PlayerSnake player;
    public String newOutfit;
    sound sound1;

    public Game() {
        initComponents();
        settingSpeed();
        this.setLayout(null);
        this.setSize(1000, 650);
        snake = new Snake();
        food = new Food(snake);
        g = new Graphics(this);
        panelGame.setLayout(new BorderLayout());
        panelGame.setBorder(new LineBorder(Color.BLACK, 3));
        this.setTitle("Game Snake");
        panelGame.add(g);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sound1 = new sound();
        newOutfit = null;
        setFocusComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGame = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlControlGame = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        scoreLb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboSpeed = new javax.swing.JComboBox<>();
        btnNewGame = new javax.swing.JButton();
        btnChangeSnake = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnItems = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout panelGameLayout = new javax.swing.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/snakeGam1).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlControlGame.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Score :");

        jLabel3.setText("Mức chơi : ");

        btnNewGame.setText("New Game");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        btnChangeSnake.setText("ChangeSnake");
        btnChangeSnake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeSnakeActionPerformed(evt);
            }
        });

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnItems.setText("items");
        btnItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControlGameLayout = new javax.swing.GroupLayout(pnlControlGame);
        pnlControlGame.setLayout(pnlControlGameLayout);
        pnlControlGameLayout.setHorizontalGroup(
            pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlGameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlControlGameLayout.createSequentialGroup()
                        .addGroup(pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addGroup(pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlControlGameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlControlGameLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(scoreLb, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlGameLayout.createSequentialGroup()
                        .addGroup(pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPause, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnChangeSnake, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(btnItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlControlGameLayout.setVerticalGroup(
            pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlGameLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(scoreLb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPause)
                    .addComponent(btnItems))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlControlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewGame)
                    .addComponent(btnChangeSnake))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(pnlControlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlControlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        g.state = "newgame";
        snake.defaultSnakes();
        snake.setMove("NOTHING");
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void btnChangeSnakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeSnakeActionPerformed
        bodySnake changeSnake = new bodySnake(this, rootPaneCheckingEnabled);
        statusOfSnake = snake.getMove();
         snake.setMove("NOTHING");
        changeSnake.setVisible(true);
    }//GEN-LAST:event_btnChangeSnakeActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
          if (btnPause.getText().compareTo("Pause") == 0) {
            btnPause.setText("Continue");
              System.out.println("co chay");
              statusOfSnake = snake.getMove();
              snake.setMove("NOTHING");
        }else{
               btnPause.setText("Pause");
               snake.setMove(statusOfSnake);
          }
    }//GEN-LAST:event_btnPauseActionPerformed

    public JPanel getPnlControlGame() {
        return pnlControlGame;
    }

    public void setPnlControlGame(JPanel pnlControlGame) {
        this.pnlControlGame = pnlControlGame;
    }
    
    private void btnItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemsActionPerformed
       itemsIngame items = new itemsIngame(this, rootPaneCheckingEnabled);
       items.setVisible(true);
    }//GEN-LAST:event_btnItemsActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    public void start() {
        g.state = "RUNNING";
    }

    public void update() {
        if (g.state == "RUNNING") {
            if (check_Eat_Food()) {
                snake.growSnake();
                food.randomFoodLocal(snake);
            } else if (checkTongTuong() || die_CanMinh()) {
                if (JOptionPane.showConfirmDialog(panelGame, "Bạn có muốn chơi tiếp không ?") == JOptionPane.OK_OPTION) {
                    g.state = "Start";
                    snake.defaultSnakes();
                    snake.setMove("NOTHING");
                } else {
                    g.state = "StopGame";
                }
            } else {
                snake.move();
            }
            g.bodySnake = (newOutfit == null) ? g.bodySnake : newOutfit;
            
        }
       
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (g.state == "RUNNING") {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_W) {
                sound1.setFile("src\\images\\mixkit-arcade-game-jump-coin-216.wav");
                sound1.play();
                snake.up();
            } else if (keyCode == KeyEvent.VK_S) {
                sound1.setFile("src\\images\\mixkit-arcade-game-jump-coin-216.wav");
                sound1.play();
                snake.down();
            } else if (keyCode == KeyEvent.VK_A) {
                sound1.setFile("src\\images\\mixkit-arcade-game-jump-coin-216.wav");
                sound1.play();
                snake.left();
            } else {
                sound1.setFile("src\\images\\mixkit-arcade-game-jump-coin-216.wav");
                sound1.play();
                snake.right();
            }
        } else {
            this.start();
        }
         btnPause.setText("Pause");
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public JFrame getWindow() {
        return Game.this;
    }

    public JTextField getScoreLb() {
        return scoreLb;
    }

    public void setScoreLb(JTextField scoreLb) {
        this.scoreLb = scoreLb;
    }

    public JComboBox<String> getComboSpeed() {
        return comboSpeed;
    }
    
    public boolean checkTongTuong() {
        if (snake.getX() < 0 || snake.getX() >= with * dimension
                || snake.getY() < 0 || snake.getY() >= heigh * dimension) {
            System.out.println(snake.getX() + "  =  " + snake.getY());
            return true;
        }
        return false;
    }

    public boolean check_Eat_Food() {
        if (snake.getX() == food.getX() * dimension && snake.getY() == food.getY() * dimension) {
            return true;
        }
        return false;
    }

    public boolean die_CanMinh() {
        for (int i = 1; i < snake.getBodySnake().size(); i++) {
            if (snake.getX() == snake.getBodySnake().get(i).x
                    && snake.getY() == snake.getBodySnake().get(i).y) {
                return true;
            }
        }
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeSnake;
    private javax.swing.JButton btnItems;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnPause;
    private javax.swing.JComboBox<String> comboSpeed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelGame;
    private javax.swing.JPanel pnlControlGame;
    private javax.swing.JTextField scoreLb;
    // End of variables declaration//GEN-END:variables

    private void settingSpeed() {
        comboSpeed.addItem("100");
        comboSpeed.addItem("50");
        comboSpeed.addItem("200");
        comboSpeed.addItem("300");
        comboSpeed.addItem("400");
    }

    private void setFocusComponents() {
        btnNewGame.setFocusPainted(false);
        comboSpeed.setFocusable(false);
        btnChangeSnake.setFocusable(false);
        btnPause.setFocusable(false);
        btnItems.setFocusPainted(false);
    }

   
}
