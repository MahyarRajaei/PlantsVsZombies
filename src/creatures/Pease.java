package creatures;

import database.AnimationDatabase;
import gui.AnimationContainer;

public class Pease extends Plant implements  Shootable, Damaging {

    private AnimationContainer animationContainer;
    private int damagePower = 25;

    public Pease(int x, int y){

        animationContainer = new AnimationContainer(AnimationDatabase.getPease()) {
            @Override
            public void doInFrame(int frameIndex) {
                setX(getX() + 10);
            }
        };
        animationContainer.setX(x);
        animationContainer.setY(y);

    }


    @Override
    public void run() {
        animationContainer.start();
    }

    @Override
    public void stop() {

        animationContainer.stop();
    }

    @Override
    public int getMoveSpeed() {
        return 0;
    }

    @Override
    public int getDamagePower() {
        return damagePower;
    }

    @Override
    public int getDamageSpeed() {
        return 0;
    }

    @Override
    public AnimationContainer getAnimationContainer() {
        return animationContainer;
    }
}
