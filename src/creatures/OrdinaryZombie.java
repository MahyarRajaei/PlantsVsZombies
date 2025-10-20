package creatures;

import gui.AnimationContainer;
import database.AnimationDatabase;

public class OrdinaryZombie extends Zombie implements Drawable {


    private static int POWER = 100;
    private static final int DAMAGE_POWER = 35;
    private static final int DAMAGE_SPEED = 1;
    private static final int MOVE_SPEED = 10;

    private AnimationContainer animationContainer;
    private int x;
    private int y;

    public OrdinaryZombie(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void initRunningAnimationContainer() {

        animationContainer = new AnimationContainer(AnimationDatabase.getZombieRunning()) {
            @Override
            public void doInFrame(int frameIndex) {

                x = getX() - getMoveSpeed();
                y = getY();

                animationContainer.setX(x);
//                animationContainer.setX(x);

            }
        };
        animationContainer.setX(x);
        animationContainer.setY(y);
    }


    private void initDeathAnimationContainer() {

        animationContainer = new AnimationContainer(AnimationDatabase.getZombieDeath()) {
            @Override
            public void doInFrame(int frameIndex) {
                x = getX();
                y = getY();
//                animationContainer.setX(x);
            }
        };
        animationContainer.setX(x);
        animationContainer.setY(y);
    }


    private void initHittingAnimationContainer() {

        animationContainer = new AnimationContainer(AnimationDatabase.getZombieHitting()) {
            @Override
            public void doInFrame(int frameIndex) {
                x = getX();
//                animationContainer.setX(x);
                y = getY();
//                setX(x);
//                if (frameIndex == 12/*AnimationDatabase.getZombieHitting().getFrames().length*/) {
//                    initRunningAnimationContainer();
//                    animationContainer.start();
                if (frameIndex == AnimationDatabase.getZombieHitting().getFrames().length - 1)
                   stop();

//                }

            }
        };
        animationContainer.setX(x);
        animationContainer.setY(y);
    }


    @Override
    public int getDamagePower() {
        return DAMAGE_POWER;
    }

    @Override
    public int getDamageSpeed() {
        return DAMAGE_SPEED;
    }

    @Override
    public AnimationContainer getAnimationContainer() {
        return animationContainer;
    }

    @Override
    public void run() {
        initRunningAnimationContainer();
        animationContainer.start();
    }

    @Override
    public void stop() {
        animationContainer.stop();
    }

    //pixel move per frame
    @Override
    public int getMoveSpeed() {
        int PIXEL_MOVE = 6;
        return PIXEL_MOVE;
    }

    @Override
    public void death() {
        initDeathAnimationContainer();
        animationContainer.start();
    }

    private boolean allowToHit = true;

    @Override
    public void hit(Plant plant) {

        if (allowToHit) {
//            initHittingAnimationContainer();
//            animationContainer.start();
            plant.setPower(plant.getPower() - getDamagePower());
            allowToHit = false;
        } else
            return;

        new Thread(() -> {

            try {
                Thread.sleep(getDamageSpeed() * 1000);
                allowToHit = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}