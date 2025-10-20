package creatures;

import database.AnimationDatabase;
import database.Database;
import gui.AnimationContainer;

public class OrdinaryShooterPlant extends ShooterPlant {


    private final AnimationContainer animationContainer;
    private static final int SHOOTS_INTERVAL = 1500;

    public OrdinaryShooterPlant(int x, int y) {
        super(SHOOTS_INTERVAL);
        animationContainer = new AnimationContainer(AnimationDatabase.getAttackerPlant()) {
            @Override
            public void doInFrame(int frameIndex) {

                if (getAliveState()) {
                    shoot();
                } else
                    stop();
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
    public void shootTime() {
        Pease pease = new Pease(animationContainer.getX() + 50, animationContainer.getY());
        Database.addPlant(pease);
        pease.run();
    }
}
