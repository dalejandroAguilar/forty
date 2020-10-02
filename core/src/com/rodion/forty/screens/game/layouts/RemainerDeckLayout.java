package com.rodion.forty.screens.game.layouts;

import com.badlogic.gdx.scenes.scene2d.Group;
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

    //    @Override
//    public void resize(int width, int height) {
//        super.resize(width, height);
//        for(CardEntity obj : deck)
//            obj.resize(width, height);
//    }
}
