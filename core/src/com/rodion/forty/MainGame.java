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
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.rodion.forty.screens.game.GameScreen;
import com.rodion.forty.screens.game.GameStage;
import com.rodion.forty.screens.loading.LoadingScreen;
import com.rodion.forty.screens.presentation.LaunchScreen;

public class MainGame extends Game {
    static public Color green, gray, grayTrans;
    static public TextureRegionDrawable greenBg, grayBg, grayTransBg;
    static private BitmapFont bitmapFont50x, bitmapFont75x, bitmapFont100x, bitmapFont150x, bitmapFont200x, bitmapFont300x, bitmapFont400x;
    static public Label.LabelStyle labelStyle50x, labelStyle75x, labelStyle100x, labelStyle150x, labelStyle200x,
            labelStyle300x, labelStyle400x;

    public GameScreen gameScreen;
    public LaunchScreen launchScreen;
    public AssetManager assetManagerGame;
    public AssetManager assetManagerLoading;
    public LoadingScreen loadingScreen;

    @Override
    public void create() {
        loadColors();
        loadFonts();

        assetManagerGame = new AssetManager();
        assetManagerLoading = new AssetManager();
        loadLoadingAssets();
        loadingScreen = new LoadingScreen(this);
//        assetManagerLoading.is
//        loadGameAssets();
//        gameScreen = new GameScreen(this);
        launchScreen = new LaunchScreen(this);
        setScreen(loadingScreen);
    }

    @Override
    public void dispose() {
        super.dispose();
        assetManagerGame.dispose();
        assetManagerLoading.dispose();
        bitmapFont50x.dispose();
        bitmapFont75x.dispose();
        bitmapFont100x.dispose();
        bitmapFont150x.dispose();
        bitmapFont200x.dispose();
        bitmapFont300x.dispose();
        bitmapFont400x.dispose();
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

    public void loadLoadingAssets(){
        assetManagerLoading.load("loading/0.5x/pack.atlas", TextureAtlas.class);
        assetManagerLoading.load("loading/0.75x/pack.atlas", TextureAtlas.class);
        assetManagerLoading.load("loading/1x/pack.atlas", TextureAtlas.class);
        assetManagerLoading.load("loading/1.5x/pack.atlas", TextureAtlas.class);
        assetManagerLoading.load("loading/2x/pack.atlas", TextureAtlas.class);
        assetManagerLoading.load("loading/3x/pack.atlas", TextureAtlas.class);
        assetManagerLoading.load("loading/4x/pack.atlas", TextureAtlas.class);
        assetManagerLoading.finishLoading();

    }

    public void loadColors() {
        green = new Color(118 / 255f, 150 / 255f, 86 / 255f, 1);

        Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
        bgPixmap.setColor(green);
        bgPixmap.fill();
        greenBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));

        gray = new Color(0.16f, 37 / 255f, 34 / 255f, 1);
        bgPixmap.setColor(gray);
        bgPixmap.fill();
        grayBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));

        grayTrans = new Color(0.16f, 37 / 255f, 34 / 255f, 0.75f);
        bgPixmap.setColor(grayTrans);
        bgPixmap.fill();
        grayTransBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
    }

     public void loadFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Helvetica.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "1234567890abcdefghijklmnopqrstuvwxyzáéíóúABCDEFGHIJKLMNOPQRSTUVWXYZ.";
        bitmapFont50x = new BitmapFont();
        parameter.size = 15;
        bitmapFont50x = generator.generateFont(parameter);
        bitmapFont50x = generator.generateFont(parameter);

        bitmapFont75x = new BitmapFont();
        parameter.size = 22;
        bitmapFont75x = generator.generateFont(parameter);

        bitmapFont100x = new BitmapFont();
        parameter.size = 30;
        bitmapFont100x = generator.generateFont(parameter);

        bitmapFont150x = new BitmapFont();
        parameter.size = 75;
        bitmapFont150x = generator.generateFont(parameter);

        bitmapFont200x = new BitmapFont();
        parameter.size = 100;
        bitmapFont200x = generator.generateFont(parameter);

        bitmapFont300x = new BitmapFont();
        parameter.size = 150;
        bitmapFont300x = generator.generateFont(parameter);

        bitmapFont400x = new BitmapFont();
        parameter.size = 200;
        bitmapFont400x = generator.generateFont(parameter);

        labelStyle50x = new Label.LabelStyle(bitmapFont50x, Color.WHITE);
        labelStyle75x = new Label.LabelStyle(bitmapFont75x, Color.WHITE);
        labelStyle100x = new Label.LabelStyle(bitmapFont100x, Color.WHITE);
        labelStyle150x = new Label.LabelStyle(bitmapFont150x, Color.WHITE);
        labelStyle200x = new Label.LabelStyle(bitmapFont200x, Color.WHITE);
        labelStyle300x = new Label.LabelStyle(bitmapFont300x, Color.WHITE);
        labelStyle400x = new Label.LabelStyle(bitmapFont400x, Color.WHITE);

    }

}

