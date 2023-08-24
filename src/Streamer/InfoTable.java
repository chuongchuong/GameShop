
package Streamer;

import java.io.Serializable;

/**
 *
 * @author kieu anh văn
 */
public class InfoTable implements Serializable{
    private String id;
    private PlayerCaro players1;
    private PlayerCaro players2;
    private int number_played;
    private int time_playing;

    public InfoTable() {
    }

    public InfoTable(String id, PlayerCaro players1, PlayerCaro players2, int number_played, int time_playing) {
        this.id = id;
        this.players1 = players1;
        this.players2 = players2;
        this.number_played = number_played;
        this.time_playing = time_playing;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PlayerCaro getPlayers1() {
        return players1;
    }

    public void setPlayers1(PlayerCaro players1) {
        this.players1 = players1;
    }

    public PlayerCaro getPlayers2() {
        return players2;
    }

    public void setPlayers2(PlayerCaro players2) {
        this.players2 = players2;
    }

    public int getNumber_played() {
        return number_played;
    }

    public void setNumber_played(int number_played) {
        this.number_played = number_played;
    }

    public int getTime_playing() {
        return time_playing;
    }

    public void setTime_playing(int time_playing) {
        this.time_playing = time_playing;
    }
    
}
