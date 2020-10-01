package com.rodion.forty.screens.launch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rodion.forty.basics.BasicScreen;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.Layout;

public class LaunchStage extends BasicStage {
    private Texture logoTexture;
    private Texture poweredTexture;
    private Texture engineTexture;

    public LaunchStage(Viewport viewport, BasicScreen basicScreen) {
        super(viewport, basicScreen);
        Layout layout = new Layout(this);
//        layout.debug();
        logoTexture = new Texture(Gdx.files.internal("logo.png"));
        Image logoImage = new Image(logoTexture);
        poweredTexture = new Texture(Gdx.files.internal("powered-by-text.png"));
        Image poweredImage = new Image(poweredTexture);
        engineTexture = new Texture(Gdx.files.internal("engine.png"));
        Image engineImage = new Image(engineTexture);
        layout.add(logoImage).expandY().row();
        layout.add(poweredImage).bottom().padBottom(25).row();
        layout.add(engineImage).bottom().padBottom(50);
        addActor(layout);
    }

    @Override
    public void dispose() {
        super.dispose();
        logoTexture.dispose();
        poweredTexture.dispose();
        engineTexture.dispose();
    }
}
