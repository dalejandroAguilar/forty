package com.rodion.forty.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.Pip;
import com.rodion.forty.basics.Suit;

import javax.smartcardio.Card;

public class DeckEntity {
    private final CardEntity[][] cards;
    public DeckEntity(final BasicStage basicStage) {
        cards = new CardEntity[Suit.values().length][];
        for (Suit suit : Suit.values()) {
            cards[suit.index] = new CardEntity[Pip.values().length];
            for (Pip pip : Pip.values()) {
                cards[suit.index][pip.index] = new CardEntity(pip, suit) {
                    @Override
                    public void setAssetAddress() {
                        setAssetManager(basicStage.getParentScreen().getMainGame().assetManagerGame);
                        super.setAssetAddress();
                    }
                };
            }
        }
    }

    public CardEntity getCard(Suit suit, Pip pip) {
        return cards[suit.index][pip.index];
    }

    public void resize(int width, int height){
        for (Suit suit : Suit.values()) {
            for (Pip pip : Pip.values()) {
                cards[suit.index][pip.index].resize(width, height);
            }
        }
    }
}
