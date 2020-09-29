package com.rodion.forty.screens.loading;


import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.rodion.forty.basics.AnimatedEntity;
import com.rodion.forty.basics.ImageEntity;


public class LoadingIconEntity extends AnimatedEntity {

    public LoadingIconEntity(int nframes) {
        super(nframes);
    }
}
