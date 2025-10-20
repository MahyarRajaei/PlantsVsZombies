package creatures;

import database.AnimationDatabase;
import database.Database;
import gui.AnimationContainer;

public class AngryShooterPlant extends ShooterPlant {

    private AnimationContainer animationContainer;
    private final static int POWER = 200;
    private final static int SHOOTS_INTERVAL = 1500;


    public AngryShooterPlant(int x, int y){
        super(SHOOTS_INTERVAL);

        setPower(POWER);

        animationContainer = new AnimationContainer(AnimationDatabase.getAttackerPlant()) {
            @Override
            public void doInFrame(int frameIndex) {
                shoot();
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

        Pease pease1 = new Pease(animationContainer.getX() + 80, animationContainer.getY());
        Pease pease2 = new Pease(animationContainer.getX() + 50, animationContainer.getY());
        Database.addPlant(pease1);
        Database.addPlant(pease2);
        pease1.run();
        pease2.run();


//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
}
