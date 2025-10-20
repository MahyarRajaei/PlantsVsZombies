package creatures;

import database.AnimationDatabase;
import gui.AnimationContainer;

public class Grass extends Plant{


    private AnimationContainer animationContainer;

    public Grass(){
        animationContainer = new AnimationContainer(AnimationDatabase.getGrass()) {
            @Override
            public void doInFrame(int frameIndex) {

            }
        };
        animationContainer.start();
    }


    @Override
    public AnimationContainer getAnimationContainer() {
        return animationContainer;
    }

}