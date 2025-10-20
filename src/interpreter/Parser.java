package interpreter;

import creatures.*;
import database.Database;

public class Parser {

    public static boolean runQuery(String query) {

        if (query.equals(Key.EMPTY_QUERY.getKey()))
            return true;

        String[] splitedQuery = query.split(Key.COMMAND_DELIMITER.getKey());

        if (splitedQuery.length != 4)
            return false;

        String commandType = splitedQuery[0];
        String creatureType = splitedQuery[1];
        String[] position = splitedQuery[2].split(Key.LIST_DELIMITER.getKey());
        String id = splitedQuery[3];


        Key creatureT = null;
        for (Key key : Key.values())
            if (key.getKey().equals(creatureType))
                creatureT = key;

        if (creatureT == null)
            return false;


        int x;
        int y;
        int hashCode;
        try {
            x = Integer.parseInt(position[0]);
            y = Integer.parseInt(position[1]);
            hashCode = Integer.parseInt(id);
        }catch (Exception e) {
            return false;
        }



        if (commandType.equals(Key.ADD.getKey())) {

           switch (creatureT) {
               case PLANT_ORDINARY_SHOOTER:
                   OrdinaryShooterPlant ordinaryShooterPlant = new OrdinaryShooterPlant(x,y);
                   ordinaryShooterPlant.setId(hashCode);
                   Database.addPlant(ordinaryShooterPlant);
                   break;
               case PLANT_ANGRY_SHOOTER:
                   AngryShooterPlant angryShooterPlant = new AngryShooterPlant(x,y);
                   angryShooterPlant.setId(hashCode);
                   Database.addPlant(angryShooterPlant);
                   break;
               case PLANT_POTATO:
                   Potato potato = new Potato(x,y);
                   potato.setId(hashCode);
                   Database.addPlant(potato);
                   break;
               case PLANT_SUNFLOWER:
                   SunFlower sunFlower = new SunFlower(x,y);
                   sunFlower.setId(hashCode);
                   Database.addPlant(sunFlower);
                   break;
               case ZOMBIE_ORDINARY:
                   OrdinaryZombie ordinaryZombie = new OrdinaryZombie(x,y);
                   ordinaryZombie.setId(hashCode);
                   Database.addZombie(ordinaryZombie);
                   ordinaryZombie.run();
                   break;

           }

        } else if (commandType.equals(Key.REMOVE.getKey())) {


            switch (creatureT) {

                case PLANT_ORDINARY_SHOOTER:
                    break;
                case PLANT_ANGRY_SHOOTER:
                    break;
                case PLANT_POTATO:
                    break;
                case PLANT_SUNFLOWER:
                    break;
                case ZOMBIE_ORDINARY:
                    break;

            }

        } else
            return false;


        return true;
    }

}
