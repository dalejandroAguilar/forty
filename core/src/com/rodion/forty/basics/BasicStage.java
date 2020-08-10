package com.rodion.forty.basics;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;


public class BasicStage extends Stage {
    protected BasicScreen basicScreen;

    public BasicStage(Viewport viewport, BasicScreen basicScreen) {
        super(viewport);
        this.basicScreen = basicScreen;
    }

    public BasicStage(Viewport viewport, Batch batch, BasicScreen basicScreen) {
        super(viewport, batch);
        this.basicScreen = basicScreen;
    }

    public BasicScreen getParentScreen() {
        return basicScreen;
    }

    public void setParentScreen(BasicScreen basicScreen) {
        this.basicScreen = basicScreen;
    }



    public void resize(int width, int height){
        getViewport().update(width, height,true);
    }


}