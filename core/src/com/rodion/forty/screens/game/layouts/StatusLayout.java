package com.rodion.forty.screens.game.layouts;

import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.ImageEntity;
import com.rodion.forty.basics.Layout;

public class StatusLayout extends Layout {
    private ImageEntity scoreImage;
    private ImageEntity cardNumberImage;

    public StatusLayout(final BasicStage basicStage) {
        super(basicStage);
        System.out.println("assetName");
        setFillParent(false);
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
        add(scoreImage);
        add(cardNumberImage);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        scoreImage.resize(width, height);
        cardNumberImage.resize(width, height);
    }
}
