package com.rodion.forty.basics;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ImageEntity extends Image {
    protected TextureRegionDrawable texture75, texture100, texture150, texture200, texture300;
    protected Layout layout;
    private String assetPath;
    private String assetName;
    private AssetManager assetManager;

    public ImageEntity(Layout layout) {
        this.layout = layout;
        prepareAssets();
    }

    public ImageEntity(AssetManager assetManager, String assetPath, String assetName, Layout layout) {
        this.assetPath = assetPath;
        this.assetName = assetName;
        this.layout = layout;
        this.assetManager = assetManager;
        prepareAssets();
    }

    protected void prepareAssets() {
        TextureAtlas atlas = assetManager.get(assetPath+"/0.75x/pack.atlas",
                TextureAtlas.class);
        texture75 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath+"/1x/pack.atlas", TextureAtlas.class);
        texture100 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath+"/1.5x/pack.atlas", TextureAtlas.class);
        texture150 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath+"/2x/pack.atlas", TextureAtlas.class);
        texture200 = new TextureRegionDrawable(atlas.findRegion(assetName));
        atlas = assetManager.get(assetPath+"/3x/pack.atlas", TextureAtlas.class);
        texture300 = new TextureRegionDrawable(atlas.findRegion(assetName));
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

    }

    public void resize(int width, int height) {
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

}
