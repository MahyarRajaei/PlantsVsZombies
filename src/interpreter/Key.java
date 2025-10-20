package interpreter;

public enum Key {

    ADD("add"),
    REMOVE("remove"),
    ZOMBIE_ORDINARY("Zo"),
    PLANT_POTATO("PPotato"),
    PLANT_ORDINARY_SHOOTER("POrdinaryShoot"),
    PLANT_ANGRY_SHOOTER("PAngryShoot"),
    PLANT_SUNFLOWER("PlantSunF"),
    EMPTY_QUERY("%"),
    COMMAND_DELIMITER(" "),
    LIST_DELIMITER(",");

    String key;
    Key(String key){
        this.key = key;
    }


    public String getKey(){
        return key;
    }


}
