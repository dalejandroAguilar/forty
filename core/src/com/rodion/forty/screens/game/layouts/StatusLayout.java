package com.rodion.forty.screens.game.layouts;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.ImageEntity;
import com.rodion.forty.basics.LabelEntity;
import com.rodion.forty.basics.Layout;

public class StatusLayout extends Layout {
    private ImageEntity scoreImage;
    private ImageEntity cardNumberImage;
    private ImageEntity userImage;
    private LabelEntity scoreLabel;


    public StatusLayout(final BasicStage basicStage) {
        super(basicStage);
        setFillParent(false);
        userImage  = new ImageEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(basicStage.getParentScreen().getMainGame().assetManagerGame);
                assetPath = "icons";
                assetName = "player";
            }
        };
        userImage.prepareAssets();
        scoreImage = new ImageEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(basicStage.getParentScreen().getMainGame().assetManagerGame);
                assetPath = "icons";
                assetName = "dog";
            }
        };
        scoreImage.prepareAssets();
        cardNumberImage = new ImageEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(basicStage.getParentScreen().getMainGame().assetManagerGame);
                assetPath = "icons";
                assetName = "card";
            }
        };
        cardNumberImage.prepareAssets();

        scoreLabel = new LabelEntity("12",this);
        add(userImage);
        add(scoreImage);
        add(scoreLabel);
        add(cardNumberImage);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        scoreLabel.draw(batch,parentAlpha);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        userImage.resize(width, height);
        scoreImage.resize(width, height);
        cardNumberImage.resize(width, height);
        scoreLabel.resize(width, height);
    }
}
