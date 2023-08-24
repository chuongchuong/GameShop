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
public class UserLib {
    private String IDD;
    private String Game;
    private String NPH;
    private float price;
    private String theLoai;
    private String gamePic;
    private String thongTin;

    public UserLib() {
    }

    public String getIDD() {
        return IDD;
    }

    public void setIDD(String IDD) {
        this.IDD = IDD;
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

    public UserLib(String IDD, String Game, String NPH, float price, String theLoai, String gamePic, String thongTin) {
        this.IDD = IDD;
        this.Game = Game;
        this.NPH = NPH;
        this.price = price;
        this.theLoai = theLoai;
        this.gamePic = gamePic;
        this.thongTin = thongTin;
    }

    

    
    
}
