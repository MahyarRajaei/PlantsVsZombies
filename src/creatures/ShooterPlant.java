package creatures;

public abstract class ShooterPlant extends Plant implements Shooter{

    private int shootsInterval;

    public ShooterPlant(int shootsInterval){
        this.shootsInterval = shootsInterval;
    }

    @Override
    public int getShootsInterval() {
        return shootsInterval;
    }

    boolean isAllowToShoot = true;
    @Override
    public boolean shoot() {
        if (isAllowToShoot) {
            shootTime();
            isAllowToShoot = false;
        } else
            return false;

        new Thread(() -> {

            try {
                // shootsInterval defined in mls
                Thread.sleep(getShootsInterval());
                isAllowToShoot = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return true;
    }
}
