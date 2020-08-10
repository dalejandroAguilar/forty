package com.rodion.forty.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rodion.forty.basics.BasicScreen;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.Layout;
import com.rodion.forty.basics.Pip;
import com.rodion.forty.basics.Suit;
import com.rodion.forty.entities.CardEntity;
import com.rodion.forty.entities.DeckEntity;
import com.rodion.forty.screens.game.layouts.BoardLayout;
import com.rodion.forty.screens.game.layouts.PlayerDeckLayout;
import com.rodion.forty.screens.game.layouts.StatusLayout;

public class GameStage extends BasicStage {
    private CardEntity cardEntity;
    private BoardLayout boardLayout;
    private DeckEntity deckEntity;
    private PlayerDeckLayout player1DeckLayout;
    private PlayerDeckLayout player2DeckLayout;
    private StatusLayout statusLayout;

    public GameStage(Viewport viewport, BasicScreen basicScreen) {
        super(viewport, basicScreen);
        deckEntity = new DeckEntity(this);
        player1DeckLayout = new PlayerDeckLayout(this);
        player2DeckLayout = new PlayerDeckLayout(this);
        player1DeckLayout.add(deckEntity.getCard(Suit.Clubs, Pip.Jack)).expandX();
        player1DeckLayout.add(deckEntity.getCard(Suit.Clubs, Pip.Ace)).expandX();
        player1DeckLayout.add(deckEntity.getCard(Suit.Spades, Pip.Ace)).expandX();
        player1DeckLayout.add(deckEntity.getCard(Suit.Hearts, Pip.Ace)).expandX();
        player1DeckLayout.add(deckEntity.getCard(Suit.Hearts, Pip.Seven)).expandX();

        Layout layout = new Layout(this);
        boardLayout = new BoardLayout(this);
        boardLayout.setTouchable(Touchable.enabled);
        statusLayout = new StatusLayout(this);

        final DragAndDrop dnd = new DragAndDrop();
        dnd.setDragActorPosition(-deckEntity.getCard(Suit.Clubs, Pip.Jack).getWidth(), 0);

        for (Suit suit : Suit.values()) {
            for (Pip pip : Pip.values()) {
                ;

                dnd.addSource(new DragAndDrop.Source(deckEntity.getCard(suit, pip)) {
                    final DragAndDrop.Payload payload = new DragAndDrop.Payload();

                    @Override
                    public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                        payload.setDragActor(getActor());
//                player1DeckLayout.getCell(getActor()).clearActor();
                        player1DeckLayout.invalidate();
//                player1DeckLayout.removeActor(getActor());
//                        getCells().removeValue(player1DeckLayout.getCell(getActor()),true);
                        player1DeckLayout.pack();
                        getActor().addAction(Actions.color(Color.YELLOW, 0.5f));
                        dnd.setDragActorPosition(-x + getActor().getWidth(), -y);
                        return payload;
                    }

                    @Override
                    public void dragStop(InputEvent event, float x, float y, int pointer, DragAndDrop.Payload payload, DragAndDrop.Target target) {
                        super.dragStop(event, x, y, pointer, payload, target);
                        getActor().addAction(Actions.color(Color.WHITE, 0.5f));
                    }
                });
            }
        }

        dnd.addTarget(new DragAndDrop.Target(boardLayout) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                getActor().addAction(Actions.color(Color.FIREBRICK, 0.5f));

                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                        player1DeckLayout.getCells().removeValue(player1DeckLayout.getCell(source.getActor()),true);
                boardLayout.add(source.getActor());
            }
        });
        dnd.addTarget(new DragAndDrop.Target(player1DeckLayout) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                getActor().addAction(Actions.color(Color.FIREBRICK, 0.5f));
                return true;
            }


            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                player1DeckLayout.add(source.getActor()).expandX();

                player1DeckLayout.pack();
            }

        });


        layout.add(player2DeckLayout).top().row();
        layout.add(boardLayout).expand().fill().row();
        layout.add(player1DeckLayout).bottom().expandX().fillX().row();
        player1DeckLayout.setTouchable(Touchable.enabled);
        layout.add(statusLayout).bottom().expandX().fillX();
        player1DeckLayout.setDebug(true);
        layout.setDebug(true);
        addActor(layout);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void resize(int width, int height) {
        super.resize(width, height);
        player1DeckLayout.resize(width, height);
        player2DeckLayout.resize(width, height);
        deckEntity.resize(width, height);
        statusLayout.resize(width, height);
    }
}
