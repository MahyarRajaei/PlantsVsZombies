package creatures;

public abstract class Zombie implements Movable, Damaging, Drawable {

    private int power = 100;
    private int id = hashCode();



    public void setPower(int power) {
        this.power = power;
    }


    public int getPower() {
        return this.power;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public abstract void death();

    public abstract void hit(Plant plant);
}
