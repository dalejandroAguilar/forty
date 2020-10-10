package com.rodion.forty.basics;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class TriphaseImageEntity extends Image {
    protected TextureRegionDrawable[] texture50, texture75, texture100, texture150, texture200,
            texture300, texture400;
    protected String assetPath;
    protected String assetName1;
    protected String assetName2;
    protected String assetName3;
    protected AssetManager assetManager;
    protected int status;
    private int size;

    public TriphaseImageEntity() {
        status = 1;
        size = 100;
    }

    public void prepareAssets() {
        setAssetAddress();
        texture50  = new TextureRegionDrawable[3];
        texture75  = new TextureRegionDrawable[3];
        texture100 = new TextureRegionDrawable[3];
        texture150 = new TextureRegionDrawable[3];
        texture200 = new TextureRegionDrawable[3];
        texture300 = new TextureRegionDrawable[3];
        texture400 = new TextureRegionDrawable[3];

        TextureAtlas atlas = assetManager.get(assetPath + "/0.5x/pack.atlas",
                TextureAtlas.class);
        texture50[0] = new TextureRegionDrawable(atlas.findRegion(assetName1));
        texture50[1] = new TextureRegionDrawable(atlas.findRegion(assetName2));
        texture50[2] = new TextureRegionDrawable(atlas.findRegion(assetName3));
        atlas = assetManager.get(assetPath + "/0.75x/pack.atlas", TextureAtlas.class);
        texture75[0] = new TextureRegionDrawable(atlas.findRegion(assetName1));
        texture75[1] = new TextureRegionDrawable(atlas.findRegion(assetName2));
        texture75[2] = new TextureRegionDrawable(atlas.findRegion(assetName3));
        atlas = assetManager.get(assetPath + "/1x/pack.atlas", TextureAtlas.class);
        texture100[0] = new TextureRegionDrawable(atlas.findRegion(assetName1));
        texture100[1] = new TextureRegionDrawable(atlas.findRegion(assetName2));
        texture100[2] = new TextureRegionDrawable(atlas.findRegion(assetName3));

        atlas = assetManager.get(assetPath + "/1.5x/pack.atlas", TextureAtlas.class);
        texture150[0] = new TextureRegionDrawable(atlas.findRegion(assetName1));
        texture150[1] = new TextureRegionDrawable(atlas.findRegion(assetName2));
        texture150[2] = new TextureRegionDrawable(atlas.findRegion(assetName3));

        atlas = assetManager.get(assetPath + "/2x/pack.atlas", TextureAtlas.class);
        texture200[0] = new TextureRegionDrawable(atlas.findRegion(assetName1));
        texture200[1] = new TextureRegionDrawable(atlas.findRegion(assetName2));
        texture200[2] = new TextureRegionDrawable(atlas.findRegion(assetName3));

        atlas = assetManager.get(assetPath + "/3x/pack.atlas", TextureAtlas.class);
        texture300[0] = new TextureRegionDrawable(atlas.findRegion(assetName1));
        texture300[1] = new TextureRegionDrawable(atlas.findRegion(assetName2));
        texture300[2] = new TextureRegionDrawable(atlas.findRegion(assetName3));


        atlas = assetManager.get(assetPath + "/4x/pack.atlas", TextureAtlas.class);
        texture400[0] = new TextureRegionDrawable(atlas.findRegion(assetName1));
        texture400[1] = new TextureRegionDrawable(atlas.findRegion(assetName2));
        texture400[2] = new TextureRegionDrawable(atlas.findRegion(assetName3));

    }

    public void setAssetAddress() {

    }


    public void resize(int width, int height) {
        if (width <= Constants.WIDTH50x || height <= Constants.HEIGHT50x) {
            resize50();
            size = 50;
            return;
        }
        if (width <= Constants.WIDTH75x || height <= Constants.HEIGHT75x) {
            resize75();
            size = 75;
            return;
        }
        if (width <= Constants.WIDTH1x || height <= Constants.HEIGHT1x) {
            resize100();
            size = 100;
            return;
        }
        if (width <= Constants.WIDTH150x || height <= Constants.HEIGHT150x) {
            resize150();
            size = 150;
            return;
        }
        if (width <= Constants.WIDTH2x || height <= Constants.HEIGHT2x) {
            resize200();
            size = 200;
            return;
        }
        if (width <= Constants.WIDTH3x || height <= Constants.HEIGHT3x) {
            resize300();
            size = 300;
            return;
        }
        if (width <= Constants.WIDTH4x || height <= Constants.HEIGHT4x) {
            resize400();
            size = 400;
            return;
        }
    }

    public void update(){
        switch (size){
            case 50:
                resize50();
                break;
            case 75:
                resize75();
                break;
            case 100:
                resize100();
                break;
            case 150:
                resize150();
                break;
            case 200:
                resize200();
                break;
            case 300:
                resize300();
                break;
            case 400:
                resize400();
                break;
        }
    }

    public void resize50() {
        setDrawable(texture50[status]);
    }

    public void resize75() {
        setDrawable(texture75[status]);
    }

    public void resize100() {
        setDrawable(texture100[status]);
    }

    public void resize150() {
        setDrawable(texture150[status]);
    }

    public void resize200() {
        setDrawable(texture200[status]);
    }

    public void resize300() {
        setDrawable(texture300[status]);
    }

    public void resize400() {
        setDrawable(texture400[status]);
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        update();
    }
}