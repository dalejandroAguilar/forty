package com.rodion.forty.entities;

import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.kernel.Card;
import com.rodion.forty.kernel.Pip;
import com.rodion.forty.kernel.Suit;

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
                        setAssetManager(basicStage.getParentScreen().getMainGame().amGame);
                        super.setAssetAddress();
                    }

                    @Override
                    public void action(CardEntity cardEntity) {
                        super.action(cardEntity);
                        cardAction(cardEntity);
                    }
                };
            }
        }
    }

    public CardEntity getCard(Suit suit, Pip pip) {
        return cards[suit.index][pip.index];
    }

    public CardEntity getCard(Card card){
        return cards[card.getSuit().index][card.getPip().index];
    }

    public void resize(int width, int height){
        for (Suit suit : Suit.values()) {
            for (Pip pip : Pip.values()) {
                cards[suit.index][pip.index].resize(width, height);
            }
        }
    }
    public void cardAction(CardEntity cardEntity){

    }
}
