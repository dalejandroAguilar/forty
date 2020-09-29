package com.rodion.forty.basics;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class LabelEntity extends Label {
    Layout layout;
    public LabelEntity(CharSequence text, Layout layout) {
        super(text, layout.getParentStage().getParentScreen().getMainGame().labelStyle100x);
        this.layout = layout;
        resize(Constants.WIDTH1x, Constants.HEIGHT1x);
        System.out.println("label");
    }

    public void resize(int width, int height) {
         System.out.println("resize");
        if (width <= Constants.WIDTH50x || height <= Constants.HEIGHT50x) {
            resize50();
            return;
        }

        if (width <= Constants.WIDTH75x || height <= Constants.HEIGHT75x) {
            resize75();
            return;
        }

        if (width <= Constants.WIDTH1x || height <= Constants.HEIGHT1x) {
            resize100();
            return;

        }
        if (width <= Constants.WIDTH150x || height <= Constants.HEIGHT150x) {
            resize150();
            return;
        }
        if (width <= Constants.WIDTH2x || height <= Constants.HEIGHT2x) {
            resize200();
            return;
        }
        if (width <= Constants.WIDTH3x || height <= Constants.HEIGHT3x) {
            resize300();
            return;
        }
        if (width <= Constants.WIDTH4x || height <= Constants.HEIGHT4x) {
            resize400();
            return;
        }
    }

    public void resize50() {
        setStyle(layout.getParentStage().basicScreen.getMainGame().labelStyle50x);
    }

    public void resize75() {
        setStyle(layout.getParentStage().basicScreen.getMainGame().labelStyle75x);
    }

    public void resize100() {
        setStyle(layout.getParentStage().basicScreen.getMainGame().labelStyle100x);

    }

    public void resize150() {
        setStyle(layout.getParentStage().basicScreen.getMainGame().labelStyle150x);

    }

    public void resize200() {
        setStyle(layout.getParentStage().basicScreen.getMainGame().labelStyle200x);

    }

    public void resize300() {
        setStyle(layout.getParentStage().basicScreen.getMainGame().labelStyle300x);
    }

    public void resize400() {
        setStyle(layout.getParentStage().basicScreen.getMainGame().labelStyle400x);
    }
}