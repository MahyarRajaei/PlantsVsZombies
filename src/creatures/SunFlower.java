package creatures;

import database.AnimationDatabase;
import database.Database;
import gui.AnimationContainer;

public class SunFlower extends ShooterPlant {


    private AnimationContainer animationContainer;
    private static final int SHOOTS_INTERVAL = 5000;

    public SunFlower(int x, int y) {
        super(SHOOTS_INTERVAL);
        animationContainer = new AnimationContainer(AnimationDatabase.getSunFlower()) {
            @Override
            public void doInFrame(int frameIndex) {

                if (getAliveState()) {
                    shoot();
                } else {
                    animationContainer.stop();
                }
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

//    private boolean isAllowToShoot = true;
//
//    @Override
//    public void generateShootableObj() {
//
//        if (isAllowToShoot) {
//            Sun sun = new Sun(animationContainer.getX(), animationContainer.getY());
//            Database.setStars(Database.getStars() + 50);
//            Database.addPlant(sun);
//            isAllowToShoot = false;
//        } else
//            return;
//
//        new Thread(() -> {
//
//            try {
//                // shootsInterval defined in mls
//                Thread.sleep(shootsInterval);
//                isAllowToShoot = true;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//    }

    @Override
    public void shootTime() {
        Sun sun = new Sun(animationContainer.getX(), animationContainer.getY());
        Database.setStars(Database.getStars() + 50);
        Database.addPlant(sun);
        sun.run();
    }
}