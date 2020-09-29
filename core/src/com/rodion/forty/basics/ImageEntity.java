package com.rodion.forty.basics;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ImageEntity extends Image {
    protected TextureRegionDrawable texture50, texture75, texture100, texture150, texture200,
            texture300, texture400;
    protected String assetPath;
    protected String assetName;
    protected AssetManager assetManager;

    public ImageEntity() {
    }

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

    public void setAssetAddress() {

    }


    public void resize(int width, int height) {
        setSize(getImageWidth(),getImageHeight());
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
        setDrawable(texture50);
    }

    public void resize75() {
        setDrawable(texture75);

    }

    public void resize100() {
        setDrawable(texture100);

    }

    public void resize150() {
        setDrawable(texture150);

    }

    public void resize200() {
        setDrawable(texture200);

    }

    public void resize300() {
        setDrawable(texture300);

    }

    public void resize400() {
        setDrawable(texture400);


    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
}