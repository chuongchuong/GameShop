/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packet;

/**
 *
 * @author Hoang Minh
 */
public class ThongKeHoanTraDATA {
    private String ID;
    private String Game;
    private float price;

    public ThongKeHoanTraDATA() {
    }

    public ThongKeHoanTraDATA(String ID, String Game, float price) {
        this.ID = ID;
        this.Game = Game;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGame() {
        return Game;
    }

    public void setGame(String Game) {
        this.Game = Game;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
