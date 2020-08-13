package com.rodion.forty.screens.game.layouts;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.utils.Align;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.Layout;

public class BoardLayout extends Layout {
    private HorizontalGroup horizontalGroup;
    public BoardLayout(BasicStage basicStage) {
        super(basicStage);
        setFillParent(false);
        horizontalGroup = new HorizontalGroup();
        horizontalGroup
                .wrapSpace(10)
                .wrap()
                .expand()
                .align(Align.center)
                .space(10);
        setBackground(getParentStage().getParentScreen().getMainGame().greenBg);
//        horizontalGroup.debug();
        super.add(horizontalGroup).expandX().fillX();
    }


    public void addActorGroup(Actor actor) {
            horizontalGroup.addActor(actor);
    }
}
