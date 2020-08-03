package com.rodion.forty.basics;
import com.badlogic.gdx.Screen;
import com.rodion.forty.MainGame;

public class BasicScreen implements Screen {
    protected MainGame mainGame;

    public BasicScreen(MainGame mainGame) {
        this.mainGame = mainGame;
    }

    public MainGame getMainGame() {
        return mainGame;
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
