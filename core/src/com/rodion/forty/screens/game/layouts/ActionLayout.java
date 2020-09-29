package com.rodion.forty.screens.game.layouts;

import com.badlogic.gdx.utils.Align;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.ImageButtonEntity;
import com.rodion.forty.basics.ImageLabelButtonEntity;
import com.rodion.forty.basics.LabelButtonEntity;
import com.rodion.forty.basics.LabelEntity;
import com.rodion.forty.basics.Layout;
import com.rodion.forty.basics.MessageEntity;

public class ActionLayout extends Layout {
    ImageLabelButtonEntity takeButton;
    ImageLabelButtonEntity passButton;
    MessageEntity messageEntity;
    LabelEntity messageLabel;
    LabelButtonEntity button;
    public ActionLayout(BasicStage basicStage) {
        super(basicStage);
        messageEntity = new MessageEntity(basicStage);
        messageLabel = new LabelEntity("Comenzar turno",this);
        button = new LabelButtonEntity("Listo",basicStage.getParentScreen().getMainGame().greenBg,basicStage);
        messageEntity.add(messageLabel).pad(10).row();
        messageEntity.add(button).pad(10);
        takeButton = new ImageLabelButtonEntity(Align.left,getParentStage().getParentScreen()
                .getMainGame()
        .grayBg,getParentStage(),
                "Take","card") {
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentStage(). getParentScreen().getMainGame().assetManagerGame);
                assetPath = "icons";
                assetName = "take";
            }
        };
        takeButton.prepareAssets();

        passButton = new ImageLabelButtonEntity( Align.right,getParentStage().getParentScreen()
                .getMainGame()
        .grayBg,getParentStage()
        ,"Pass","turn") {
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentStage(). getParentScreen().getMainGame().assetManagerGame);
                assetPath = "icons";
                assetName = "pass";
            }
        };
        passButton.prepareAssets();
//        passButton.setVisible(false);

        add(takeButton).left();
        add().expandX().fillX();
        add(messageEntity);
        add().expandX().fillX();
        add(passButton).right();

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        takeButton.resize(width, height);
        passButton.resize(width, height);
        messageLabel.resize(width, height);
        button.resize(width, height);
    }
}
