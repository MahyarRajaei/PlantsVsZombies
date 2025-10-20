package database;

import creatures.Plant;
import creatures.Zombie;
import main.GameHandler;

import java.util.ArrayList;

public class Database {

    private static final ArrayList<Zombie> zombies;
    private static final ArrayList<Plant> plants;
    private static int stars;
    private static int dollar;

    public static int getDollar() {
        return dollar;
    }

    public static void setDollar(int dollar) {
        Database.dollar = dollar;
    }


    private static final ArrayList<Zombie> newZombies;
    private static final ArrayList<Plant> newPlants;

    static {
        zombies = new ArrayList<>();
        plants = new ArrayList<>();

//        if (GameHandler.isIsOnline()){
            newZombies = new ArrayList<>();
            newPlants = new ArrayList<>();
//        }else {
//            newZombies = null;
//            newPlants = null;
//        }
    }


    public static void setStars(int s){
        stars = s;
    }
    public static int getStars(){
        return stars;
    }

    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }


    public static ArrayList<Zombie> getNewZombies(){
        return newZombies;
    }

    public static void clearNewZombieList(){
        newZombies.clear();

    }


    public static void addZombie(Zombie zombie) {
//        QuerySender.send(Composer.getAddOrdinaryZombieQuery(zombie.getAnimationContainer().getX(), zombie.getAnimationContainer().getY(), zombie.hashCode()));
        if (GameHandler.isIsOnline())
            newZombies.add(zombie);
        zombies.add(zombie);
    }

    public static boolean removeZombie(int id) {

        for (int i = 0; i < zombies.size(); i++)
            if (zombies.get(i).getId() == id) {
                zombies.remove(i);
                return true;
            }
        return false;
    }

    public static void addPlant(Plant plant) {
//        QuerySender.send(Composer.getAddOrdinaryPlantShooterQuery(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.hashCode()));
        if (GameHandler.isIsOnline())
            newPlants.add(plant);
        plants.add(plant);
    }


    public static boolean removePlant(int id) {
        for (int i = 0; i < plants.size(); i++)
            if (plants.get(i).getId() == id) {
                plants.get(i).setAliveState(false);
                plants.remove(i);
                return true;
            }

        return false;
    }

    public static ArrayList<Plant> getPlants() {
        return plants;
    }

    public static ArrayList<Plant> getNewPlants(){
        return newPlants;
    }


    public static void clearNewPlants(){
        newPlants.clear();
    }

}

