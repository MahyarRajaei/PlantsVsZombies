package creatures;

import database.AnimationDatabase;
import database.Database;
import gui.AnimationContainer;

public class Sun extends Plant implements Shootable, Drawable {

    private final int SunValue = 25;


    private AnimationContainer animationContainer;

    public Sun(int x, int y){
        animationContainer = new AnimationContainer(AnimationDatabase.getSun()) {
            @Override
            public void doInFrame(int frameIndex) {
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                setX(getX() - 25);
                setY(getY() - 25);
            }
        };
        animationContainer.setX(x);
        animationContainer.setY(y);
        animationContainer.start();
    }


    @Override
    public AnimationContainer getAnimationContainer() {
        return animationContainer;
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }

    @Override
    public int getMoveSpeed() {
        return 0;
    }
}
