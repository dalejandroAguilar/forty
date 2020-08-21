package com.rodion.forty.screens.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rodion.forty.basics.BasicScreen;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.ImageButtonEntity;
import com.rodion.forty.basics.Layout;
import com.rodion.forty.basics.Pip;
import com.rodion.forty.basics.Suit;
import com.rodion.forty.entities.CardEntity;
import com.rodion.forty.entities.DeckEntity;
import com.rodion.forty.screens.game.layouts.ActionLayout;
import com.rodion.forty.screens.game.layouts.BoardLayout;
import com.rodion.forty.screens.game.layouts.StatusLayout;

public class GameStage extends BasicStage {
    private DeckEntity deckEntity;
    private BoardLayout boardLayout;
    private HorizontalGroup player1DeckLayout;
    private HorizontalGroup player2DeckLayout;
    private StatusLayout statusPlayer1Layout;
    private StatusLayout statusPlayer2Layout;
    private ImageButtonEntity settingsButton;
    private ImageButtonEntity backButton;
    private ActionLayout actionLayout;
//    pr


    public GameStage(Viewport viewport, BasicScreen basicScreen) {
        super(viewport, basicScreen);
        deckEntity = new DeckEntity(this);
        player1DeckLayout = new HorizontalGroup();
        player2DeckLayout = new HorizontalGroup();
        player1DeckLayout.addActor(deckEntity.getCard(Suit.Clubs, Pip.Jack));
        player1DeckLayout.addActor(deckEntity.getCard(Suit.Clubs, Pip.Ace));
        player1DeckLayout.addActor(deckEntity.getCard(Suit.Spades, Pip.Ace));
        player1DeckLayout.addActor(deckEntity.getCard(Suit.Hearts, Pip.Ace));
        player1DeckLayout.addActor(deckEntity.getCard(Suit.Hearts, Pip.Seven));

        player2DeckLayout.addActor(deckEntity.getCard(Suit.Clubs, Pip.Two));
        player2DeckLayout.addActor(deckEntity.getCard(Suit.Clubs, Pip.Two));
        player2DeckLayout.addActor(deckEntity.getCard(Suit.Spades, Pip.Two));
        player2DeckLayout.addActor(deckEntity.getCard(Suit.Hearts, Pip.Two));
        player2DeckLayout.addActor(deckEntity.getCard(Suit.Hearts, Pip.Two));

        actionLayout = new ActionLayout(this);

        Layout layout = new Layout(this);
        boardLayout = new BoardLayout(this);
        boardLayout.setTouchable(Touchable.enabled);
        statusPlayer1Layout = new StatusLayout(this);
        statusPlayer2Layout = new StatusLayout(this);

        settingsButton = new ImageButtonEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentScreen().getMainGame().assetManagerGame);
                assetPath = "icons";
                assetName = "settings";
            }
        };
        settingsButton.prepareAssets();

        backButton = new ImageButtonEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentScreen().getMainGame().assetManagerGame);
                assetPath = "icons";
                assetName = "back";
            }
        };
        backButton.prepareAssets();



        Table topMenu = new Table();
        topMenu.setBackground(getParentScreen().getMainGame().grayBg);
        topMenu.add(backButton).left();
        Table bottomMenu = new Table();
        bottomMenu.setBackground(getParentScreen().getMainGame().grayBg);
        bottomMenu.add(settingsButton);



        final DragAndDrop dnd = new DragAndDrop();
        dnd.setDragActorPosition(-deckEntity.getCard(Suit.Clubs, Pip.Jack).getWidth(), 0);

        for (Suit suit : Suit.values()) {
            for (Pip pip : Pip.values()) {
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

                        if (target == null) {
                            player1DeckLayout.addActor(getActor());
                        }
                    }
                });
            }
        }

        dnd.addTarget(new DragAndDrop.Target(boardLayout) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
//                getActor().addAction(Actions.color(Color.FIREBRICK, 0.5f));
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                boardLayout.addActorGroup(source.getActor());
//                player1DeckLayout.removeActor(source.getActor());
                player1DeckLayout.pack();
//                player1DeckLayout.getCells().removeValue(player1DeckLayout.getCell(source.getActor()),true);
            }
        });
        dnd.addTarget(new DragAndDrop.Target(player1DeckLayout) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
//                getActor().addAction(Actions.color(Color.FIREBRICK, 0.5f));
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                player1DeckLayout.addActor(source.getActor());
                player1DeckLayout.pack();
            }
        });

        dnd.addTarget(new DragAndDrop.Target(player2DeckLayout) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
//                getActor().addAction(Actions.color(Color.FIREBRICK, 0.5f));
                return true;
            }


            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                player2DeckLayout.addActor(source.getActor());
            }
        });

        player1DeckLayout.wrap().align(Align.center).wrapSpace(10).space(10);
        player2DeckLayout.wrap().align(Align.center).wrapSpace(10).space(10);

        player1DeckLayout.setFillParent(false);
        player1DeckLayout.setTouchable(Touchable.enabled);
        player2DeckLayout.setTouchable(Touchable.enabled);
        layout.add(topMenu).top().expandX().fillX().row();
        layout.add(statusPlayer2Layout).top().expandX().fillX().align(Align.left).padTop(Value.percentHeight(.1f)).row();
        layout.add(player2DeckLayout).expandX().fillX().height(Value.percentHeight(1.1f,deckEntity.getCard(Suit.Clubs,Pip.Jack))).top().row();
        layout.add(boardLayout).fill().expand().row();
        layout.add(player1DeckLayout).expandX().fillX().height(Value.percentHeight(1.1f,deckEntity.getCard(Suit.Clubs,Pip.Jack))).bottom().row();
        layout.add(statusPlayer1Layout).bottom().expandX().align(Align.left).fillX().padTop(Value.percentHeight(.1f)).row();
        layout.add(bottomMenu).bottom().expandX().fill();
        addActor(layout);

        addActor(actionLayout);


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
        deckEntity.resize(width, height);
        statusPlayer1Layout.resize(width, height);
        statusPlayer2Layout.resize(width, height);
        settingsButton.resize(width, height);
        backButton.resize(width, height);
        actionLayout.resize(width, height);
    }
}
