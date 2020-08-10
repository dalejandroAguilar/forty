package com.rodion.forty;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.rodion.forty.screens.game.GameScreen;
import com.rodion.forty.screens.game.GameStage;

public class MainGame extends Game {
    static public Color green;
    static public TextureRegionDrawable greenBg;

    public GameScreen gameScreen;
    public AssetManager assetManagerGame;
    @Override
    public void create() {
        assetManagerGame = new AssetManager();
        loadGameAssets();
        loadColors();
        gameScreen = new GameScreen(this);
        setScreen(gameScreen);
    }

    @Override
    public void dispose() {
        assetManagerGame.dispose();
        super.dispose();
    }

    public void loadGameAssets() {
        assetManagerGame.load("deck/themes/default/0.5x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("deck/themes/default/0.75x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("deck/themes/default/1x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("deck/themes/default/1.5x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("deck/themes/default/2x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("deck/themes/default/3x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("deck/themes/default/4x/pack.atlas", TextureAtlas.class);

        assetManagerGame.load("icons/0.5x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("icons/0.75x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("icons/1x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("icons/1.5x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("icons/2x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("icons/3x/pack.atlas", TextureAtlas.class);
        assetManagerGame.load("icons/4x/pack.atlas", TextureAtlas.class);

        assetManagerGame.finishLoading();
    }

    public void loadColors(){
        green = new Color(118/255f,150/255f,86/255f,1);

        Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
        bgPixmap.setColor(green);
        bgPixmap.fill();
        greenBg  = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
    }

}

