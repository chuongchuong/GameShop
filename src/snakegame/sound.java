
package snakegame;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author kieu anh văn
 */
public class sound {

        Clip clip;

        public void setFile(String path) {
            try {
                File file = new File(path);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            } catch (Exception e) {
                System.out.println("error");
            }
        }

        public void play() {
            clip.setFramePosition(0);
            clip.start();
        }
    }
