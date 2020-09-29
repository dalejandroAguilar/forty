package com.rodion.forty.basics;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class AnimatedEntity extends Image {
    protected TextureRegionDrawable[] frames;
    protected TextureRegionDrawable[] frames50, frames75, frames100, frames150, frames200, frames300,
            frames400;
    protected Animation animation;
    protected String assetPath;
    protected String assetName;
    protected AssetManager assetManager;
    protected int nframes;
    protected float elapsedTime;

    public AnimatedEntity(int nframes) {
        this.nframes = nframes;
        frames = new TextureRegionDrawable[this.nframes];
        animation = new Animation(0.125f, frames);
        elapsedTime=0;
    }

    public void prepareAssets() {
        setAssetAddress();

        frames50  = new TextureRegionDrawable[nframes];
        frames75  = new TextureRegionDrawable[nframes];
        frames100 = new TextureRegionDrawable[nframes];
        frames150 = new TextureRegionDrawable[nframes];
        frames200 = new TextureRegionDrawable[nframes];
        frames300 = new TextureRegionDrawable[nframes];
        frames400  = new TextureRegionDrawable[nframes];

        TextureAtlas atlas = assetManager.get(assetPath + "/0.5x/pack.atlas",
                TextureAtlas.class);

        for (int i = 0; i < nframes; i++) {
            frames50[i] = new TextureRegionDrawable(atlas.findRegion(assetName +
                    String.format("%02d", i+1)));
        }

        atlas = assetManager.get(assetPath + "/0.75x/pack.atlas", TextureAtlas.class);
        for (int i = 0; i < nframes; i++) {
            frames75[i] = new TextureRegionDrawable(atlas.findRegion(assetName +
                    String.format("%02d", i+1)));
        }

        atlas = assetManager.get(assetPath + "/1x/pack.atlas", TextureAtlas.class);
        for (int i = 0; i < nframes; i++) {
            frames100[i] = new TextureRegionDrawable(atlas.findRegion(assetName +
                    String.format("%02d", i+1)));
        }

        atlas = assetManager.get(assetPath + "/1.5x/pack.atlas", TextureAtlas.class);
        for (int i = 0; i < nframes; i++) {
            frames150[i] = new TextureRegionDrawable(atlas.findRegion(assetName +
                    String.format("%02d", i+1)));
        }

        atlas = assetManager.get(assetPath + "/2x/pack.atlas", TextureAtlas.class);
        for (int i = 0; i < nframes; i++) {
            frames200[i] = new TextureRegionDrawable(atlas.findRegion(assetName +
                    String.format("%02d", i+1)));
        }

        atlas = assetManager.get(assetPath + "/3x/pack.atlas", TextureAtlas.class);
        for (int i = 0; i < nframes; i++) {
            frames300[i] = new TextureRegionDrawable(atlas.findRegion(assetName +
                    String.format("%02d", i+1)));
        }

        atlas = assetManager.get(assetPath + "/4x/pack.atlas", TextureAtlas.class);
        for (int i = 0; i < nframes; i++) {
            frames400[i] = new TextureRegionDrawable(atlas.findRegion(assetName +
                    String.format("%02d", i+1)));
        }
    }

    public void setAssetAddress() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime += delta;
        setDrawable((Drawable) animation.getKeyFrame(elapsedTime, true));

    }



    public void resize(int width, int height) {
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
        for(int i =0; i<nframes;i++)
            frames[i] = frames50[i];
    }

    public void resize75() {
       for(int i =0; i<nframes;i++)
            frames[i] = frames75[i];

    }

    public void resize100() {
        for(int i =0; i<nframes;i++)
            frames[i] = frames100[i];

    }

    public void resize150() {
       for(int i =0; i<nframes;i++)
            frames[i] = frames150[i];
    }

    public void resize200() {
        for(int i =0; i<nframes;i++)
            frames[i] = frames200[i];
    }

    public void resize300() {
        for(int i =0; i<nframes;i++)
            frames[i] = frames300[i];
    }

    public void resize400() {
        for(int i =0; i<nframes;i++)
            frames[i] = frames400[i];
    }

    public AssetManager getAssetManager() {
        return assetManager;

    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

}
