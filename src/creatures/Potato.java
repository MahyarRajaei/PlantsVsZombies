package creatures;

import database.AnimationDatabase;
import gui.AnimationContainer;

public class Potato extends Plant implements Damaging{

    private AnimationContainer animationContainer;
    private final static int DAMAGE_POWER = Integer.MAX_VALUE;
    private final static int DAMAGE_SPEED = 0;


    public Potato(int x, int y){
        animationContainer = new AnimationContainer(AnimationDatabase.getPotato()) {
            @Override
            public void doInFrame(int frameIndex) {

            }
        };
        animationContainer.setX(x);
        animationContainer.setY(y);
        animationContainer.start();
    }



    @Override
    public int getDamagePower() {
        return DAMAGE_POWER;
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
