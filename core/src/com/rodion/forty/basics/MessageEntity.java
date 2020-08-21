package com.rodion.forty.basics;

import com.badlogic.gdx.graphics.g2d.Batch;

public class MessageEntity extends Layout {
    public MessageEntity(BasicStage basicStage) {
        super(basicStage);
        setFillParent(false);
        setBackground(basicStage
                .getParentScreen()
                .getMainGame()
                .grayBg);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, 0.75f);
    }
}
