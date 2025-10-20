package main;

import creatures.*;
import database.Database;
import gui.MainFrameV2;
import interpreter.Composer;
import interpreter.Key;
import interpreter.Parser;
import network.QueryReceiver;
import network.QuerySender;

import javax.swing.*;
import java.io.BufferedWriter;
import java.util.Random;

public class GameHandler {

    private static boolean isOnline;

    private GameHandler() {

    }


    private static int FPS = 30;
    private static int zombieAddingInterval = 6;
    private static int zombieAddingTime = 5;
    private static int ordinaryZombieCount = 7;

    private static int timeToGetSun = 5000;
    private static int sunInStart = 50;
    private static int sunCount = 25;

    private static int timeTogetDollar= 10000;
    private static int dollarInStart = 100;
    private static int dollarCount = 25;


    public static int getZombieCount(){
        return ordinaryZombieCount;
    }
    public static void setZombieCount(int count){
        ordinaryZombieCount = count;
    }

    public static int getDollarInStart(){
        return dollarInStart;
    }
    public static void setDollarInStart(int dollar){
        dollarInStart = dollar;
    }

    public static int getSunInStart(){
        return sunInStart;
    }
    public static void setSunInStart(int sun){
        sunInStart = sun;
    }


    static {

    }

    public static boolean isIsOnline() {
        return isOnline;
    }


    public static void calc(){
        Database.setStars(sunInStart);
        Database.setDollar(dollarInStart);

        //sun
        new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(timeToGetSun);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Database.setStars(Database.getStars() + sunCount);
            }

        }).start();

        // dollar
        new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(timeTogetDollar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Database.setDollar(Database.getDollar() + dollarCount);
            }

        }).start();
    }

    public static void startOfflineGame() {
        calc();
        new Thread(() -> {
        isOnline = false;
        MainFrameV2 mainFrameV2 = new MainFrameV2(FPS, false);
        mainFrameV2.setVisible(true);


        try {
            Thread.sleep(zombieAddingTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < ordinaryZombieCount; i++) {

            int randomRow = new Random().nextInt(5);
//            System.out.println(randomRow);
            int y = 0;
            if (randomRow == 0)
                y = mainFrameV2.getRow1Coordinate();
            else if (randomRow == 1)
                y = mainFrameV2.getRow2Coordinate();
            else if (randomRow == 2)
                y = mainFrameV2.getRow3Coordinate();
            else if (randomRow == 3)
                y = mainFrameV2.getRow4Coordinate();
            else if (randomRow == 4)
                y = mainFrameV2.getRow5Coordinate();

            try {
                Thread.sleep(zombieAddingInterval * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Zombie zombie = new OrdinaryZombie(mainFrameV2.getWidth(), y - 15);
            zombie.run();
            System.out.println("add new zombie");
            Database.addZombie(zombie);
        }


        boolean winState = false;
        while (true) {
            System.out.println();
            if (Database.getZombies().size() == 0) {
                winState = true;
                break;
            }
        }

        if (winState) {
            mainFrameV2.setVisible(false);
            mainFrameV2.dispose();
            JOptionPane.showMessageDialog(null, "YOU WIN!");
            System.exit(0);
        }

        }).start();
    }


    public static void startClientOnline() {

        calc();
        isOnline = true;

        MainFrameV2 mainFrameV2 = new MainFrameV2(FPS, true);

        mainFrameV2.setVisible(true);
        new Thread(() -> {

            while (true) {

                if (Database.getNewZombies().size() != 0) {
                    for (Zombie zombie : Database.getNewZombies())
                        QuerySender.send(Composer.getAddOrdinaryZombieQuery(zombie.getAnimationContainer().getX(), zombie.getAnimationContainer().getY(), zombie.getId()));

                    Database.clearNewZombieList();
                } else {

                    QuerySender.send(Key.EMPTY_QUERY.getKey());
                }

                try {
                    Thread.sleep(1000 / FPS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }


    public static void startServerOnline() {

        calc();
        isOnline = true;

//        mainFrameV2.setVisible(true);
        MainFrameV2 frameV2 = new MainFrameV2(FPS, false);


        frameV2.setVisible(true);
        QueryReceiver queryReceiver = new QueryReceiver() {
            @Override
            public void query(String query) {

//                System.out.println(query);
                Parser.runQuery(query);
            }

//            @Override
            public void response(BufferedWriter writer) {
                if (Database.getNewPlants().size() != 0) {
                    for (Plant plant : Database.getNewPlants())
                        if (plant instanceof OrdinaryShooterPlant)
                            QuerySender.send(Composer.getAddOrdinaryPlantShooterQuery(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.getId()));
                        else if (plant instanceof AngryShooterPlant)
                            QuerySender.send(Composer.getAddAngryPlantShooterQuery(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.getId()));
                        else if (plant instanceof SunFlower)
                            QuerySender.send(Composer.getAddPlantSunFlower(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.getId()));
                        else if (plant instanceof Potato)
                            QuerySender.send(Composer.getAddPlantPotatoQuery(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.getId()));
                    Database.clearNewZombieList();
                } else {
                    QuerySender.send(Key.EMPTY_QUERY.getKey());
                }
            }
        };
    }


}