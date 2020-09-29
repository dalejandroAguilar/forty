package com.rodion.forty.screens.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.rodion.forty.MainGame;
import com.rodion.forty.basics.BasicScreen;

public class LoadingScreen extends BasicScreen {

    private LoadingStage stage;

    public LoadingScreen(MainGame mainGame) {
        super(mainGame);
        stage = new LoadingStage(new ScreenViewport(), this);
//        mainGame.loadingTitleAssets();
//        System.out.println("" + mainGame.assetManagerDefault.getProgress());
//        mainGame.loadingDefaultAssets();
//        mainGame.loadingLevelsAssets();
//
//        System.out.println("" + mainGame.assetManagerTitle.getProgress());

    }


    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

//        System.out.println("hola" + mainGame.assetManagerTitle.isFinished());
        stage.act(delta);
        stage.draw();
//        mainGame.assetManagerTitle.update();
//        mainGame.assetManagerDefault.update();
////
//        if (mainGame.assetManagerTitle.isFinished() && mainGame.assetManagerDefault.isFinished() &&
//        mainGame.assetManagerLevels.isFinished()) {
//            mainGame.titleScreenScreen = new TitleScreen(mainGame);
//            mainGame.setScreen(mainGame.titleScreenScreen);
//            hide();
//        }

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }
}
