package com.rodion.forty.basics;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.addAction;

public class ImageLabelButtonEntity extends Layout {
    private TextureRegionDrawable enableColor;
    private ArrayList<LabelEntity> labels;
    private TextureRegionDrawable texture50, texture75, texture100, texture150, texture200,
            texture300, texture400;
    protected String assetPath;
    protected String assetName;
    protected AssetManager assetManager;
    int align;

//    public ImageLabelButtonEntity(String text, TextureRegionDrawable enableColor, BasicStage basicStage) {
    public ImageLabelButtonEntity(int  align, TextureRegionDrawable enableColor, BasicStage basicStage, String ... texts) {
        super(basicStage);
        this.enableColor = enableColor;
        this.align = align;
        labels = new ArrayList<>();
        setFillParent(false);
        setTouchable(Touchable.enabled);
        setBackground(enableColor);
//        debug();
        for(String text : texts) {
            labels.add(new LabelEntity(text, this));
            labels.get(labels.size() - 1).setAlignment(align);
            add(labels.get(labels.size() - 1)).expandX().fillX().row();
        }
//        label = new LabelEntity(text, this);

        addListener(new ClickListener() {
                        boolean isPressed;
                        boolean isClicked;

                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            isPressed = true;
                            isClicked = false;
                            addAction(Actions.color(Color.GRAY, .2f));
                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            super.touchUp(event, x, y, pointer, button);
                            addAction(Actions.color(Color.WHITE, .2f));
                            if (isPressed) {
                                action();
                            }
                        }

                        @Override
                        public void touchDragged(InputEvent event, float x, float y, int pointer) {
                            super.touchDragged(event, x, y, pointer);
                            if (!isOver() && isPressed) {
                                addAction(Actions.color(Color.WHITE, .2f));
                                isPressed = false;
                            }
                        }
                    }
        );
    }

    public void action(){}


    public void prepareAssets() {
        setAssetAddress();
        System.out.println(assetPath + "/0.5x/pack.atlas");
        TextureAtlas atlas = assetManager.get(assetPath + "/0.5x/pack.atlas",
                TextureAtlas.class);
        texture50 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath + "/0.75x/pack.atlas", TextureAtlas.class);
        texture75 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath + "/1x/pack.atlas", TextureAtlas.class);
        texture100 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath + "/1.5x/pack.atlas", TextureAtlas.class);
        texture150 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath + "/2x/pack.atlas", TextureAtlas.class);
        texture200 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath + "/3x/pack.atlas", TextureAtlas.class);
        texture300 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath + "/4x/pack.atlas", TextureAtlas.class);
        texture400 = new TextureRegionDrawable(atlas.findRegion(assetName));
    }

    public void setAssetAddress(){

    }


    public void resize(int width, int height) {
        for (LabelEntity label: labels)
            label.resize(width, height);
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
        setBackground(texture50);
    }

    public void resize75() {
        setBackground(texture75);
    }

    public void resize100() {
        setBackground(texture100);
    }

    public void resize150() {
        setBackground(texture150);
    }

    public void resize200() {
        setBackground(texture200);
    }

    public void resize300() {
        setBackground(texture300);
    }

    public void resize400() {
        setBackground(texture400);
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
}