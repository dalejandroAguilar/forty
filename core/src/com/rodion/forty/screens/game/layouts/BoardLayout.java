package com.rodion.forty.screens.game.layouts;

import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.Layout;

public class BoardLayout extends Layout {
    public BoardLayout(BasicStage basicStage) {
        super(basicStage);
        setFillParent(false);
        setBackground(getParentStage().getParentScreen().getMainGame().greenBg);
    }
}
