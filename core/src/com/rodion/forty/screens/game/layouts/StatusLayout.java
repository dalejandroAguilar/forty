package com.rodion.forty.screens.game.layouts;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.ImageEntity;
import com.rodion.forty.basics.LabelEntity;
import com.rodion.forty.basics.Layout;

public class StatusLayout extends Layout {
    private ImageEntity scoreImage;
    private ImageEntity cardNumberImage;
    private ImageEntity userImage;
    private LabelEntity scoreLabel;
    private LabelEntity cardsCountLabel;
    private LabelEntity playerNameLabel;

    public StatusLayout(final BasicStage basicStage) {
        super(basicStage);
        setFillParent(false);
        Table table = new Table();
        Table bottomTable = new Table();
        bottomTable.setFillParent(false);
        table.setFillParent(false);
        userImage = new ImageEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(basicStage.getParentScreen().getMainGame().amGame);
                assetPath = "icons";
                assetName = "player";
            }
        };
        userImage.prepareAssets();
        scoreImage = new ImageEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(basicStage.getParentScreen().getMainGame().amGame);
                assetPath = "icons";
                assetName = "dog";
            }
        };
        scoreImage.prepareAssets();
        cardNumberImage = new ImageEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(basicStage.getParentScreen().getMainGame().amGame);
                assetPath = "icons";
                assetName = "card";
            }
        };
        cardNumberImage.prepareAssets();


        scoreLabel = new LabelEntity("12", this);
        playerNameLabel = new LabelEntity("PLAYER 1 RED asdfasdfasdfasdf", this);
        cardsCountLabel = new LabelEntity("15", this);
//        table.debug();


        table.add(playerNameLabel).left().row();
        bottomTable.add(scoreImage).left();
        bottomTable.add(scoreLabel).left().width(100);
        bottomTable.add(cardNumberImage).left();
        bottomTable.add(cardsCountLabel).left().width(100);
        table.add(bottomTable).left();
        add(userImage).left();

        add(table).left();
        add().expand();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        userImage.resize(width, height);
        scoreImage.resize(width, height);
        cardNumberImage.resize(width, height);
        scoreLabel.resize(width, height);
        cardsCountLabel.resize(width, height);
        playerNameLabel.resize(width, height);
    }
}
