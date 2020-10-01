package com.rodion.forty.screens.title;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.rodion.forty.MainGame;
import com.rodion.forty.basics.BasicScreen;

public class TitleScreen extends BasicScreen {
        private TitleStage stage;
    public TitleScreen(MainGame mainGame) {
        super(mainGame);
        stage = new TitleStage(new ScreenViewport(), this);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(31.f/255, 31.f/255, 31.f/255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
}

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
