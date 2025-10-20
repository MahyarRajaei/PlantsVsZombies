package gui;


import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AnimationContainer {


    private Animation animation;
    private BufferedImage currentFrame;
    private int x;
    private int y;


    public AnimationContainer(Animation animation) {

        if (animation == null)
            throw new NullPointerException();

        this.animation = animation;
        this.currentFrame = animation.getFrames()[0];
//            setBackground(Color.red);
    }

    public void setAnimation(Animation animation) {

        if (animation == null)
            throw new NullPointerException();
        currentFrame = null;
        this.animation = animation;
    }

   public Animation getAnimation(){
        return this.animation;
   }


    private boolean inRunning = false;

    public void start() {
        inRunning = true;
        render();
    }

    public void stop() {
        inRunning = false;
    }

    public void reStart() {
        stop();
        start();
    }

    private void render() {
        final BufferedImage[] frames = animation.getFrames();
        final int framesLength = frames.length;

        new Thread(() -> {
            int frameIndex = 0;
            while (inRunning) {
                this.currentFrame = frames[frameIndex];

                doInFrame(frameIndex);
                try {
                    Thread.currentThread().sleep(1000 / animation.getFPS());
                } catch (InterruptedException ex) {
                    Logger.getLogger(AnimationContainer.class.getName()).log(Level.SEVERE, null, ex);
                }
                frameIndex++;

                if (frameIndex >= framesLength)
                    frameIndex = 0;
            }
        }).start();
    }


    public BufferedImage getCurrentFrame() {
        return this.currentFrame;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void doInFrame(int frameIndex);


}