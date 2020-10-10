package com.rodion.forty.screens.game.layouts;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.rodion.forty.entities.CardEntity;
import com.rodion.forty.entities.DeckEntity;
import com.rodion.forty.kernel.Card;
import com.rodion.forty.kernel.Player;

public class PlayerHandLayout extends HorizontalGroup {
    Player player;
    DeckEntity deckEntity;
    DragAndDrop dnd;
    CardEntity cardSelect;

    public PlayerHandLayout(Player player, DeckEntity deckEntity) {
        setFillParent(false);
        expand();
        this.player = player;
        this.deckEntity = deckEntity;
        dnd = new DragAndDrop();
        disabled();
        cardSelect = null;
    }

    public void setUp() {
        for (Card card : player.getHand().getDeck()) {
            addActor(deckEntity.getCard(card));
        }
    }

    public void flipUp() {
        for (Card card : player.getHand().getDeck()) {
            deckEntity.getCard(card).flipUp();
        }
    }

     public void flipDown() {
     for (Card card : player.getHand().getDeck()) {
         deckEntity.getCard(card).flipDown();
     }
 }

    public void disabled() {
        for (Card card : player.getHand().getDeck()) {
            deckEntity.getCard(card).setTouchable(Touchable.disabled);
        }
    }

    public void enabled() {
        for (Card card : player.getHand().getDeck()) {
            deckEntity.getCard(card).setTouchable(Touchable.enabled);
        }
    }

    public void updateDnD(final BoardLayout bl) {
        dnd.clear();
        for (final Card card : player.getHand().getDeck()) {
            final CardEntity cardEntity = deckEntity.getCard(card);
            cardEntity.catchBeforePosition();
            System.out.println(cardEntity.getXbefore() + "+," + cardEntity.getYbefore());
        }


        for (final Card card : player.getHand().getDeck()) {

            final CardEntity cardEntity = deckEntity.getCard(card);

//            deckEntity.getCard(card).setTouchable(Touchable.enabled);
            dnd.addSource(new DragAndDrop.Source(cardEntity) {
                final DragAndDrop.Payload payload = new DragAndDrop.Payload();

                @Override
                public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                    payload.setDragActor(getActor());
                    selectCard(cardEntity);
                    invalidate();
                    pack();
                    getActor().addAction(Actions.color(Color.YELLOW, 0.5f));
                    dnd.setDragActorPosition(-x + getActor().getWidth(), -y);


//                    for (Card card2 : player.getHand().getDeck()) {
//                        final CardEntity cardEntity2 = deckEntity.getCard(card2);
//                        if (card.getSuit() != card2.getSuit() && card.getPip() != card2.getPip()) {
//                        cardEntity2.addAction(
//                                Actions.sequence(
//                                                Actions.run(
//                                                new Runnable() {
//                                                    @Override
//                                                    public void run() {
//                                                        cardEntity2.setVisible(false);
//
//                                                    }
//                                                }
//                                        ),
//
//                                        Actions.run(
//                                                new Runnable() {
//                                                    @Override
//                                                    public void run() {
//                                                        cardEntity2.setVisible(true);
//                                                        cardEntity2.catchAfterPosition();
//                                                        cardEntity2.restoreMove();
//                                                        cardEntity2.moveAction();
//                                                        System.out.println("before" + cardEntity2.getXbefore() + "+," + cardEntity2.getYbefore());
//                                                        System.out.println("after" + cardEntity2.getXafter() + "+," + cardEntity2.getYafter());
//                                                    }
//                                                }
//                                        ),
//                                        Actions.run(
//                                                new Runnable() {
//                                                    @Override
//                                                    public void run() {
//
//
//
//
//                                                    }
//                                                }
//                                        )
////                                            Actions.run(
////                                                    new Runnable() {
////                                                        @Override
////                                                        public void run() {
////                                                        }
////                                                    }
////                                            )
//
//
//                                )
//                        );
//                        }
//                    }
                    return payload;
                }

                @Override
                public void dragStop(InputEvent event, float x, float y, int pointer, DragAndDrop.Payload payload, DragAndDrop.Target target) {
                    super.dragStop(event, x, y, pointer, payload, target);
                    getActor().addAction(Actions.color(Color.WHITE, 0.5f));
                    if (target == null) {
                        addActor(getActor());
                        for (Card card2 : player.getHand().getDeck()) {
                            final CardEntity cardEntity2 = deckEntity.getCard(card2);
//                            for (final Card card : player.getHand().getDeck()) {

                            cardEntity2.catchBeforePosition();

//                            }


//                            if (card.getSuit() != card2.getSuit() && card.getPip() != card2.getPip()) {
//                                cardEntity2.addAction(
//                                        Actions.sequence(
//                                                Actions.run(
//                                                        new Runnable() {
//                                                            @Override
//                                                            public void run() {
//                                                                cardEntity2.catchAfterPosition();
//                                                            }
//                                                        }
//                                                )
//                                                ,
//                                                Actions.run(
//                                                        new Runnable() {
//                                                            @Override
//                                                            public void run() {
//                                                                cardEntity2.restoreMove();
//
//                                                            }
//                                                        }
//                                                )
//                                                ,
//                                                Actions.run(
//                                                        new Runnable() {
//                                                            @Override
//                                                            public void run() {
//
//                                                                cardEntity2.moveAction();
//                                                            }
//                                                        }
//                                                )
//                                        )
//                                );
//                            }

                        }
                    }
                }
            });
        }
        dnd.addTarget(new DragAndDrop.Target(bl) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x,
                                float y, int pointer) {
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y,
                             int pointer) {
                bl.addActorGroup(source.getActor());
                bl.pack();
                onBoardAction();
            }
        });
    }

    public void selectCard(CardEntity cardSelect) {
        this.cardSelect = cardSelect;
        for (final Card card : player.getHand().getDeck()) {
            final CardEntity cardEntity = deckEntity.getCard(card);
            if (cardSelect.getPip() != card.getPip() || cardSelect.getSuit() != card.getSuit()) {
                cardEntity.addAction(Actions.color(Color.LIGHT_GRAY, .2f));
            }
        }
        cardSelect.addAction(Actions.color(Color.WHITE, .2f));
    }

    public CardEntity getCardSelect() {
        return cardSelect;
    }

    public void onBoardAction(){

    }

}
