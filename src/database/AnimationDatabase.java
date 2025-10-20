package database;

import creatures.Grass;
import creatures.Pease;
import gui.Animation;

import java.io.File;

public class AnimationDatabase {

    private final static int FPS = 15;

    private final static Animation ZOMBIE_RUNNING;
    private final static Animation ZOMBIE_HITTING;
    private final static Animation ZOMBIE_DEATH;
    private final static Animation ATTACKER_PLANT;
    private final static Animation SUN_FLOWER;
    private final static Animation SUN;
    private final static Animation GRASS;
    private final static Animation PEASE;
    private final static Animation POTATO;

    private static final File[] ZOMBIE_RUNNING_FRAMES = {

            new File("./res/Zombie1/18.png"),
            new File("./res/Zombie1/19.png"),
            new File("./res/Zombie1/20.png"),
            new File("./res/Zombie1/21.png"),
            new File("./res/Zombie1/22.png"),
            new File("./res/Zombie1/23.png"),
            new File("./res/Zombie1/24.png"),
            new File("./res/Zombie1/25.png"),
    };

    private static final File[] ZOMBIE_HIT_FRAMES = {
            new File("./res/Zombie1/1.png"),
            new File("./res/Zombie1/2.png"),
            new File("./res/Zombie1/3.png"),
            new File("./res/Zombie1/4.png"),
            new File("./res/Zombie1/5.png"),
            new File("./res/Zombie1/6.png"),
            new File("./res/Zombie1/7.png"),
            new File("./res/Zombie1/8.png"),
            new File("./res/Zombie1/9.png"),
            new File("./res/Zombie1/10.png"),
            new File("./res/Zombie1/11.png"),
            new File("./res/Zombie1/12.png"),
            new File("./res/Zombie1/13.png"),
            new File("./res/Zombie1/14.png"),
            new File("./res/Zombie1/15.png"),
            new File("./res/Zombie1/16.png"),
            new File("./res/Zombie1/17.png")
    };


    private static final File[] ZOMBIE_DEATH_FRAMES = {

            new File("./res/Zombie1Death/1.png"),
            new File("./res/Zombie1Death/2.png"),
            new File("./res/Zombie1Death/3.png"),
            new File("./res/Zombie1Death/4.png"),
            new File("./res/Zombie1Death/5.png"),
            new File("./res/Zombie1Death/6.png"),
            new File("./res/Zombie1Death/7.png"),
            new File("./res/Zombie1Death/8.png"),
            new File("./res/Zombie1Death/9.png"),
            new File("./res/Zombie1Death/10.png"),
            new File("./res/Zombie1Death/11.png"),
            new File("./res/Zombie1Death/12.png"),
            new File("./res/Zombie1Death/13.png"),
            new File("./res/Zombie1Death/14.png"),
            new File("./res/Zombie1Death/15.png"),
            new File("./res/Zombie1Death/16.png"),
            new File("./res/Zombie1Death/17.png"),
            new File("./res/Zombie1Death/18.png"),
            new File("./res/Zombie1Death/19.png"),
            new File("./res/Zombie1Death/20.png"),
            new File("./res/Zombie1Death/21.png"),
            new File("./res/Zombie1Death/22.png"),
            new File("./res/Zombie1Death/23.png"),
            new File("./res/Zombie1Death/24.png"),
            new File("./res/Zombie1Death/26.png"),
            new File("./res/Zombie1Death/27.png"),
            new File("./res/Zombie1Death/28.png"),
            new File("./res/Zombie1Death/29.png"),
            new File("./res/Zombie1Death/30.png"),
            new File("./res/Zombie1Death/31.png"),
            new File("./res/Zombie1Death/32.png"),
            new File("./res/Zombie1Death/33.png"),
            new File("./res/Zombie1Death/34.png"),
            new File("./res/Zombie1Death/35.png"),
            new File("./res/Zombie1Death/36.png")
    };

    private static final File[] ATTACKER_PLANT_FRAMES = {

            new File("./res/flowerAttacker/1.png"),
            new File("./res/flowerAttacker/2.png"),
            new File("./res/flowerAttacker/3.png"),
            new File("./res/flowerAttacker/4.png"),
            new File("./res/flowerAttacker/5.png"),
            new File("./res/flowerAttacker/6.png"),
            new File("./res/flowerAttacker/7.png"),
            new File("./res/flowerAttacker/8.png"),
            new File("./res/flowerAttacker/9.png"),
            new File("./res/flowerAttacker/10.png"),
            new File("./res/flowerAttacker/11.png"),
            new File("./res/flowerAttacker/12.png")
    };


    private static final File[] SUNFLOWER_FRAME = {

            new File("./res/sunFlower/1.png"),
            new File("./res/sunFlower/2.png"),
            new File("./res/sunFlower/3.png"),
            new File("./res/sunFlower/4.png"),
            new File("./res/sunFlower/5.png"),
            new File("./res/sunFlower/6.png"),
            new File("./res/sunFlower/7.png"),
            new File("./res/sunFlower/8.png"),
            new File("./res/sunFlower/9.png"),
            new File("./res/sunFlower/10.png")
    };

    private static final File[] SUN_FRAMES = {

//            new File("./res/sun/1.png"),
//            new File("./res/sun/2.png"),
//            new File("./res/sun/3.png"),
//            new File("./res/sun/4.png"),
//            new File("./res/sun/5.png"),
//            new File("./res/sun/6.png"),
//            new File("./res/sun/7.png"),
//            new File("./res/sun/8.png"),
//            new File("./res/sun/9.png"),
            new File("./res/sun/10.png"),
            new File("./res/sun/11.png"),
            new File("./res/sun/12.png"),
            new File("./res/sun/13.png"),
            new File("./res/sun/14.png"),
            new File("./res/sun/15.png"),
            new File("./res/sun/15.png"),
            new File("./res/sun/14.png"),
            new File("./res/sun/13.png"),
            new File("./res/sun/12.png"),
            new File("./res/sun/11.png"),
            new File("./res/sun/10.png"),
    };


    private static final File[] GRASS_FRAMES = {
            new File("./res/grass.jpg")
    };

    private static final File[] PEASE_FRAMES = {
            new File("./res/pease.png")
    };


    private static final File[] POTATO_FRAMES = {
            new File("./res/potato.png")
    };



    static {
        ZOMBIE_RUNNING = new Animation(ZOMBIE_RUNNING_FRAMES, FPS);
        ZOMBIE_HITTING = new Animation(ZOMBIE_HIT_FRAMES, FPS);
        ZOMBIE_DEATH = new Animation(ZOMBIE_DEATH_FRAMES, FPS);
        ATTACKER_PLANT = new Animation(ATTACKER_PLANT_FRAMES, FPS);
        SUN_FLOWER = new Animation(SUNFLOWER_FRAME, FPS);
        SUN = new Animation(SUN_FRAMES, FPS);
        GRASS = new Animation(GRASS_FRAMES, FPS);
        PEASE = new Animation(PEASE_FRAMES, FPS);
        POTATO = new Animation(POTATO_FRAMES, FPS);
    }

    private AnimationDatabase() {
    }


    public static Animation getZombieRunning() {
        return ZOMBIE_RUNNING;
    }


    public static Animation getZombieDeath() {
        return ZOMBIE_DEATH;
    }

    public static Animation getAttackerPlant() {
        return ATTACKER_PLANT;
    }


    public static Animation getZombieHitting() {
        return ZOMBIE_HITTING;
    }

    public static Animation getSunFlower() {
        return SUN_FLOWER;
    }

    public static Animation getSun() {
        return SUN;
    }


    public static Animation getGrass() {
        return GRASS;
    }


    public static Animation getPease() {
        return PEASE;
    }



    public static Animation getPotato(){
        return POTATO;
    }

}
