package com.rodion.forty.screens.game.layouts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.Layout;
import com.rodion.forty.entities.CardEntity;

import java.util.ArrayList;

public class RemainerDeckLayout extends Layout {
    //    private ArrayList<CardEntity> deck;
    private Stack deck;

    public RemainerDeckLayout(BasicStage basicStage) {
        super(basicStage);
        setFillParent(true);
//        deck = new ArrayList<>();
        deck = new Stack();
        add(deck).center();
    }

    public void addCard(CardEntity... cards) {
        for (CardEntity card : cards) {
            deck.addActor(card);
            pack();
        }
    }

    public SequenceAction enterAnimation() {
        SequenceAction sequence = new SequenceAction();
        final float delta = Gdx.graphics.getWidth();
        sequence.addAction(
                Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        moveBy(delta, 0);
                        addAction(
                                Actions.parallel(
                                        Actions.moveBy(-delta, 0, .5f)
//                                        Actions.rotateBy(90, .5f)
                                )
                        );
                    }
                })
        );
        sequence.addAction(
                Actions.delay(.5f)
        );
        return sequence;
    }
}
