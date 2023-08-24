
package Streamer;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author kieu anh văn
 */
public class PlayerSnake implements Serializable, Comparable<PlayerSnake>{
    private String FullName;
    private String Password;
    private String Email;
    public PlayerSnake() {
    }

    public PlayerSnake(String FullName) {
        this.FullName = FullName;
    }
    
    public PlayerSnake(String FullName, String Password, String Email) {
        this.FullName = FullName;
        this.Password = Password;
        this.Email = Email;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.FullName);
        hash = 71 * hash + Objects.hashCode(this.Password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlayerSnake other = (PlayerSnake) obj;
        if (!Objects.equals(this.FullName, other.FullName)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(PlayerSnake o) {
        return o.FullName.compareTo(FullName);
    }
    
}
