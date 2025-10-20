package interpreter;

public class Composer {


    public static String getAddOrdinaryZombieQuery(int x, int y, int id) {
        return generateAddQuery(x, y, id, Key.ZOMBIE_ORDINARY.getKey());
    }

    public static String getAddOrdinaryPlantShooterQuery(int x, int y, int id) {
        return generateAddQuery(x, y, id, Key.PLANT_ORDINARY_SHOOTER.getKey());
    }

    public static String getAddAngryPlantShooterQuery(int x, int y, int id) {
        return generateAddQuery(x, y, id, Key.PLANT_ANGRY_SHOOTER.getKey());

    }

    public static String getAddPlantPotatoQuery(int x, int y, int id) {
        return generateAddQuery(x, y, id, Key.PLANT_POTATO.getKey());
    }


    public static String getAddPlantSunFlower(int x, int y, int id) {
        return generateAddQuery(x, y, id, Key.PLANT_SUNFLOWER.getKey());
    }


    private static String generateAddQuery(int x, int y, int id, String creatureType) {

        String query = "";
        query += Key.ADD.getKey();
        query += Key.COMMAND_DELIMITER.getKey();
        query += creatureType;
        query += Key.COMMAND_DELIMITER.getKey();
        query += x + Key.LIST_DELIMITER.getKey() + y;
        query += Key.COMMAND_DELIMITER.getKey();
        query += id;
        return query;
    }


}
