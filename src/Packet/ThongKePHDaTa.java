/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packet;


public class ThongKePHDaTa {
    private String IDS;
    private String Game;
    private String NPH;
    private float price;
    private String theLoai;
    private String danhGia;
    private Boolean likes;

    public ThongKePHDaTa() {
    }

    public ThongKePHDaTa(String IDS, String Game, String NPH, float price, String theLoai, String danhGia, Boolean likes) {
        this.IDS = IDS;
        this.Game = Game;
        this.NPH = NPH;
        this.price = price;
        this.theLoai = theLoai;
        this.danhGia = danhGia;
        this.likes = likes;
    }

    public String getIDS() {
        return IDS;
    }

    public void setIDS(String IDS) {
        this.IDS = IDS;
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

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public Boolean getLikes() {
        return likes;
    }

    public void setLikes(Boolean likes) {
        this.likes = likes;
    }
@Override
    public boolean equals(Object obj) {
        ThongKePHDaTa pro_other = (ThongKePHDaTa) obj;
        return pro_other.getTheLoai().equals(this.getTheLoai());
    }

    @Override
    public String toString() {
        return this.theLoai;
    }
    
    
}
