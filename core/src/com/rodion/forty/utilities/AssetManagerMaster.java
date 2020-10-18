package com.rodion.forty.utilities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetManagerMaster {
    public final static AssetManager game = new AssetManager();
    public final static AssetManager loading = new AssetManager();
    public final static AssetManager title = new AssetManager();

    public static void loadGame() {
        load(game, "deck/themes/default");
        load(game, "icons");
        game.finishLoading();
    }

    public static void loadLoading() {
        load(loading, "loading");
        loading.finishLoading();
    }

    public static void loadTitle(){
        load(title, "title");
        title.finishLoading();
    }

    private static void load(AssetManager assetManager, String path) {
        assetManager.load(path + "/0.5x/pack.atlas", TextureAtlas.class);
        assetManager.load(path + "/0.75x/pack.atlas", TextureAtlas.class);
        assetManager.load(path + "/1x/pack.atlas", TextureAtlas.class);
        assetManager.load(path + "/1.5x/pack.atlas", TextureAtlas.class);
        assetManager.load(path + "/2x/pack.atlas", TextureAtlas.class);
        assetManager.load(path + "/3x/pack.atlas", TextureAtlas.class);
        assetManager.load(path + "/4x/pack.atlas", TextureAtlas.class);
    }

    public static void dispose() {
        game.dispose();
        loading.dispose();
        title.dispose();
    }
}