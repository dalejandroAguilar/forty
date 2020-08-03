package com.rodion.forty.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.rodion.forty.MainGame;
import com.rodion.forty.basics.BasicScreen;

public class GameScreen extends BasicScreen {
    public GameScreen(MainGame mainGame) {
        super(mainGame);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(31.f/255, 31.f/255, 31.f/255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }
}
