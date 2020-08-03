package com.rodion.forty.basics;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;

public class Layout extends Table implements Disposable {
    protected BasicStage basicStage;
    public Layout(BasicStage basicStage){
        this.basicStage = basicStage;
        setFillParent(true);
    }

    @Override
    public void dispose() {

    }

    public void resize(int width, int height){

    }

    public BasicStage getParentStage() {
        return basicStage;
    }

    public void setParentStage(BasicStage basicStage) {
        this.basicStage = basicStage;
    }
}
