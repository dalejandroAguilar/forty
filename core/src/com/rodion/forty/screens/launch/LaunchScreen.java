package com.rodion.forty.screens.launch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.rodion.forty.MainGame;
import com.rodion.forty.basics.BasicScreen;
import com.rodion.forty.basics.BlackStage;
import com.rodion.forty.screens.loading.LoadingScreen;
import com.rodion.forty.utilities.AssetManagerMaster;

public class LaunchScreen extends BasicScreen {
    private LaunchStage stage;
    private BlackStage blackStage;

    public LaunchScreen(MainGame mainGame) {
        super(mainGame);
        stage = new LaunchStage(new ScreenViewport(), this);
        blackStage = new BlackStage(new ScreenViewport());
//        mainGame.loadLoadingAssets();
    }


    @Override
    public void show() {
        super.show();
        Gdx.gl.glClearColor(0.f, 0.f, 1.f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        blackStage.addAction(
                Actions.sequence(
                        Actions.fadeOut(0.2f),
                        Actions.delay(0.2f),
                        Actions.run(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        hide();
                                    }
                                }
                        )
                )
        );
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.f, 0.f, 0.f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        blackStage.act(delta);
        blackStage.draw();
    }

    @Override
    public void hide() {
        blackStage.addAction(
                Actions.sequence(
                        Actions.fadeIn(0.2f),
                        Actions.run(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        while (!AssetManagerMaster.loading.update()){
                                        };
                                        mainGame.loadingScreen = new LoadingScreen(mainGame);
                                        mainGame.setScreen(mainGame.loadingScreen);
                                    }
                                }
                        )
                )
        );
    }


    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void pause() {
        super.pause();
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
        blackStage.dispose();
    }
}
