package com.rodion.forty.screens.game.layouts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Align;
import com.rodion.forty.basics.BasicStage;
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
        messageLabel = new LabelEntity("Comenzar turno", this);
        button = new LabelButtonEntity("Listo", basicStage.getParentScreen().getMainGame().greenBg, basicStage) {
            @Override
            public void action() throws Exception {
                super.action();
                onConfirm();
            }
        };
        messageEntity.add(messageLabel).pad(10).row();
        messageEntity.add(button).pad(10).expandX().fillX();
        takeButton = new ImageLabelButtonEntity(Align.left, getParentStage().getParentScreen()
                .getMainGame()
                .grayBg, getParentStage(),
                "Take", "card") {
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentStage().getParentScreen().getMainGame().amGame);
                assetPath = "icons";
                assetName = "take";
            }
        };
        takeButton.prepareAssets();

        passButton = new ImageLabelButtonEntity(Align.right, getParentStage().getParentScreen()
                .getMainGame()
                .grayBg, getParentStage()
                , "Pass", "turn") {
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentStage().getParentScreen().getMainGame().amGame);
                assetPath = "icons";
                assetName = "pass";
            }

            @Override
            public void action() {
                super.action();
                onPass();
            }
        };
        passButton.prepareAssets();
//        passButton.setVisible(false);

        add(takeButton).left();
        add().expandX().fillX();
        add(messageEntity);
        add().expandX().fillX();
        add(passButton).right();
        takeButton.setVisible(false);
        passButton.setVisible(false);
        messageEntity.setVisible(false);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        takeButton.resize(width, height);
        passButton.resize(width, height);
        messageLabel.resize(width, height);
        button.resize(width, height);
    }

    public void confirmP1() {
        messageLabel.setText("Jugador 1 ¿Estás listo?");
        messageEntity.setVisible(true);
        messageEntity.moveBy(0, -100);
        messageEntity.getColor().a = 0f;
        messageEntity.addAction(Actions.parallel(
//                Actions.fadeOut(0),
                Actions.fadeIn(.25f),
                Actions.moveBy(0, 0, .25f)
        ));
    }

    public void exitConfirm() {
        messageEntity.addAction(
                Actions.parallel(
                        Actions.fadeOut(.25f),
                        Actions.moveBy(0, -100, .25f)
                )
        );

    }

//    public void

    public void onConfirm() {
    }

    public void showPass() {
        float delta = passButton.getWidth();
        passButton.moveBy(delta, 0);
        passButton.setVisible(true);
        passButton.addAction(Actions.moveBy(-delta, 0, 0.25f));
    }

    public void onPass() {

    }

}
