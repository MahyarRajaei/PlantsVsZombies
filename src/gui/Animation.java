package gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Animation {

    private BufferedImage[] frames;
    private int FPS;

    public Animation(File[] frames, int FPS) {

        try {
            this.frames = new BufferedImage[frames.length];
            for (int i = 0; i < frames.length; i++)
                this.frames[i] = ImageIO.read(frames[i]);

            this.FPS = FPS;
        } catch (IOException ex) {
            Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public BufferedImage[] getFrames() {
        return this.frames;
    }

    public int getFPS() {
        return this.FPS;
    }
}
