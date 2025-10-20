package creatures;

public abstract class Plant implements Drawable {

    private int power = 100;
    private int id = hashCode();
    private boolean aliveState = true;

    public void setPower(int power) {
        this.power = power;
    }


    public int getPower() {
        return this.power;
    }

    public void setAliveState(boolean aliveState) {
        this.aliveState = aliveState;
    }


    public boolean getAliveState() {
        return this.aliveState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
