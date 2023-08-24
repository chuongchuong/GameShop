package Streamer;


import javax.swing.ImageIcon;


/**
 *
 * @author kieu anh văn
 */
public class PlayerCaro extends PlayerSnake{
    private String name;
    private ImageIcon icon;
    private int point;

    public PlayerCaro(String name, ImageIcon icon, int point) {
        this.name = name;
        this.icon = icon;
        this.point = point;
    }

    public PlayerCaro(String FullName,String name, ImageIcon icon, int point) {
        super(FullName);
        this.name = name;
        this.icon = icon;
        this.point = point;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    
}
