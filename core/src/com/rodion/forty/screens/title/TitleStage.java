package com.rodion.forty.screens.title;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rodion.forty.basics.BasicScreen;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.ImageEntity;
import com.rodion.forty.basics.LabelButtonEntity;
import com.rodion.forty.basics.Layout;
import com.rodion.forty.screens.game.GameScreen;


public class TitleStage extends BasicStage {
    private ImageEntity title;
    private LabelButtonEntity button;
    public TitleStage(Viewport viewport, final BasicScreen basicScreen) {
        super(viewport, basicScreen);
        Layout layout = new Layout(this);
        title  = new ImageEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentScreen().getMainGame().assetManagerTitle);
                assetPath = "title";
                assetName = "logo";
            }
        };
        title.prepareAssets();


        button = new LabelButtonEntity("Jugar", getParentScreen().getMainGame().greenBg,this){
            @Override
            public void action() {
                basicScreen.hide();
                basicScreen.getMainGame().gameScreen = new GameScreen(basicScreen.getMainGame());
                basicScreen.getMainGame().setScreen(basicScreen.getMainGame().gameScreen);
            }
        };
        layout.add(title).top().row();
        layout.add(button).expandX().expandY().fillX().center();
        addActor(layout);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        title.resize(width,height);
        button.resize(width, height);
    }
}