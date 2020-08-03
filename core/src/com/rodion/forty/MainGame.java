package com.rodion.forty;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rodion.forty.screens.game.GameScreen;

public class MainGame extends Game {
    public GameScreen gameScreen;
    @Override
    public void create() {
        gameScreen = new GameScreen(this);
        setScreen(gameScreen);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
