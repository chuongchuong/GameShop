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
public class StoreAdminData {
    private String GID;
    private String Game;
    private String NPH;
    private float GiaGame;
    private String theLoai;
    private String gamePic;
    private String thongTin;


    public StoreAdminData() {
    }

    public StoreAdminData(String GID, String Game, String NPH, float GiaGame, String theLoai, String gamePic, String thongTin) {
        this.GID = GID;
        this.Game = Game;
        this.NPH = NPH;
        this.GiaGame = GiaGame;
        this.theLoai = theLoai;
        this.gamePic = gamePic;
        this.thongTin = thongTin;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
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

    public float getGiaGame() {
        return GiaGame;
    }

    public void setGiaGame(float GiaGame) {
        this.GiaGame = GiaGame;
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

    

    
}
