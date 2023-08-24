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
public class StoreUserData {
    private String IDGame;
    private String Game;
    private String NPH;
    private float price;
    private String theLoai;
    private String gamePic;
    private String thongTin;

    public StoreUserData() {
    }

    public StoreUserData(String IDGame, String Game, String NPH, float price, String theLoai, String gamePic, String thongTin) {
        this.IDGame = IDGame;
        this.Game = Game;
        this.NPH = NPH;
        this.price = price;
        this.theLoai = theLoai;
        this.gamePic = gamePic;
        this.thongTin = thongTin;
    }

    public String getIDGame() {
        return IDGame;
    }

    public void setIDGame(String IDGame) {
        this.IDGame = IDGame;
    }

    public String getGame() {
        return Game;
    }

    public void setGame(String Game) {
        this.Game = Game;
    }

    public String getNPH() {
        return NPH;
    }

    public void setNPH(String NPH) {
        this.NPH = NPH;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getGamePic() {
        return gamePic;
    }

    public void setGamePic(String gamePic) {
        this.gamePic = gamePic;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }
@Override
    public boolean equals(Object obj) {
        StoreUserData pro_other = (StoreUserData) obj;
        return pro_other.getTheLoai().equals(this.getTheLoai());
    }

    @Override
    public String toString() {
        return this.theLoai;
    }
    
}

