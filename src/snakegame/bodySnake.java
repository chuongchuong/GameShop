package snakegame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author kieu anh văn
 */
public class bodySnake extends javax.swing.JDialog {
     ArrayList<String> list;
    private int numberOfoutfit;
    private Game game;
    private Snake snake;
    ImageIcon[] icons;
    private JPanel[] pnls;
    private JPanel[] skinSnake;
    MouseListener listener;
    CardLayout controlLayout;
    
    public bodySnake(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.game = (Game) parent;
        this.snake = this.game.getSnake();
         list = getListFile("src\\images\\bodySnake");
        createIcons();
        pnls = new JPanel[numberOfoutfit];
        skinSnake = new JPanel[numberOfoutfit];
        settingChooseSnake();
        settingPanels();
        createListeners();
        addListeners();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPrevious = new javax.swing.JLabel();
        labelNext = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnlBoss = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previousIcon.png"))); // NOI18N

        labelNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nextIcon.png"))); // NOI18N

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pnlBoss.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlBossLayout = new javax.swing.GroupLayout(pnlBoss);
        pnlBoss.setLayout(pnlBossLayout);
        pnlBossLayout.setHorizontalGroup(
            pnlBossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBossLayout.setVerticalGroup(
            pnlBossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cửa hàng skins");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jButton1)
                .addContainerGap(283, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(labelPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBoss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNext, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(pnlBoss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton1)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelPrevious)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelNext)
                        .addGap(150, 150, 150))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JPanel pnlSelected = null;
        for (Component comp : pnlBoss.getComponents()) {
            if (comp instanceof JPanel) {
                if (comp.isVisible() == true) {
                    pnlSelected = (JPanel) ((JPanel) comp).getComponent(1);
                    break;
                }
            }
        }
        JLabel label= (JLabel) pnlSelected.getComponent(1);
        String path = label.getIcon().toString();
        game.newOutfit = path;
        snake.setMove(game.statusOfSnake);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                bodySnake dialog = new bodySnake(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelNext;
    private javax.swing.JLabel labelPrevious;
    private javax.swing.JPanel pnlBoss;
    // End of variables declaration//GEN-END:variables

    private void settingChooseSnake() {

    }

    private void settingPanels() {
        pnlBoss.setBorder(new LineBorder(Color.BLACK, 3));
        pnlBoss.setLayout(new CardLayout(5,5));
       
        for (int i = 0; i < numberOfoutfit; i++) {
            pnls[i] = new JPanel();
            pnls[i].setLayout(new GridLayout(2,1));
            JLabel labelTitle = new JLabel("Thân rắn" + i);
            labelTitle.setHorizontalAlignment(JLabel.CENTER);
            pnls[i].add(labelTitle);
            pnls[i].setBorder(new LineBorder(Color.PINK, 3));
            pnls[i].add(createPanel(i));
            pnlBoss.add(pnls[i]);
        }
        controlLayout = (CardLayout) pnlBoss.getLayout();
        
    }

    private void createListeners() {
        listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel label = (JLabel) e.getSource();
                if (label.equals(labelNext)) {
                   controlLayout.next(pnlBoss);
                }
                if (label.equals(labelPrevious)) {
                    controlLayout.previous(pnlBoss);
                }
            }
        };
    }

    private void addListeners() {
        labelNext.addMouseListener(listener);
        labelPrevious.addMouseListener(listener);
    }

    private JPanel createPanel(int i) {
        skinSnake[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, -5  , 0));
        skinSnake[i].setBorder(new LineBorder(Color.red ,3));
        JLabel bodyHead = new JLabel(new ImageIcon("src\\images\\lionLeft.png"));
        skinSnake[i].add(bodyHead);
        for (int j = 0; j < 7; j++) {
            JLabel body = new JLabel(icons[i]);
            skinSnake[i].add(body);
        }
        return skinSnake[i];
    }

    private void createIcons() {
        String defaultPath = "src\\images\\bodySnake\\";
        icons = new ImageIcon[list.size()];
        for (int i = 0; i < icons.length; i++) {
           icons[i] = new ImageIcon(defaultPath + list.get(i));
            System.out.println(defaultPath + list.get(i));
        }
        numberOfoutfit = icons.length;
        
    }
    
    public ArrayList<String> getListFile(String path){
        ArrayList<String> list = new ArrayList<>();
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                list.add(file.getName());
            }
        }
        return list;
    }
}
