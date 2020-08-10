package com.rodion.forty.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.rodion.forty.MainGame;
import com.rodion.forty.basics.BasicScreen;
import com.rodion.forty.basics.Layout;
import com.rodion.forty.entities.CardEntity;

public class GameScreen extends BasicScreen {
    private GameStage gameStage;

    public GameScreen(MainGame mainGame) {
        super(mainGame);
        gameStage = new GameStage(new ScreenViewport(), this);
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(31.f / 255, 31.f / 255, 31.f / 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        gameStage.act(delta);
        gameStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        gameStage.resize(width, height);
    }
}
