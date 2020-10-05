package com.rodion.forty.screens.game.layouts;

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.Layout;
import com.rodion.forty.entities.DeckEntity;
import com.rodion.forty.kernel.Card;
import com.rodion.forty.kernel.Player;

public class PlayerHandLayout extends HorizontalGroup {
    Player player;
    DeckEntity deckEntity;
    public PlayerHandLayout(Player player, DeckEntity deckEntity) {
        setFillParent(false);
         expand();
        this.player = player;
        this.deckEntity = deckEntity;
    }

    public void setUp(){
        for (Card card : player.getHand().getDeck()) {
            addActor(deckEntity.getCard(card));
        }
    }

    public void resize(int width, int height) {

    }


}
