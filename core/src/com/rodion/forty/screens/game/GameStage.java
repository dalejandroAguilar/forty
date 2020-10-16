package com.rodion.forty.screens.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rodion.forty.MainGame;
import com.rodion.forty.basics.BasicScreen;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.ImageButtonEntity;
import com.rodion.forty.basics.Layout;
import com.rodion.forty.entities.CardEntity;
import com.rodion.forty.entities.DeckEntity;
import com.rodion.forty.kernel.Card;
import com.rodion.forty.kernel.Game;
import com.rodion.forty.kernel.Pip;
import com.rodion.forty.kernel.Player;
import com.rodion.forty.kernel.Suit;
import com.rodion.forty.kernel.Team;
import com.rodion.forty.screens.game.layouts.ActionLayout;
import com.rodion.forty.screens.game.layouts.BoardLayout;
import com.rodion.forty.screens.game.layouts.PlayerHandLayout;
import com.rodion.forty.screens.game.layouts.RemainerDeckLayout;
import com.rodion.forty.screens.game.layouts.StatusLayout;

public class GameStage extends BasicStage {
    private DeckEntity deckEntity;
    private BoardLayout boardLayout;
    private PlayerHandLayout player1DeckLayout;
    private PlayerHandLayout player2DeckLayout;
    private StatusLayout statusPlayer1Layout;
    private StatusLayout statusPlayer2Layout;
    private ImageButtonEntity settingsButton;
    private ImageButtonEntity backButton;
    private ActionLayout actionLayout;
    private RemainerDeckLayout remainerDeckLayout;
    private Game game;
    private Team team1;
    private Team team2;
    private Player player1;
    private Player player2;
    private SequenceAction mainActionSequence;

    public GameStage(Viewport viewport, BasicScreen basicScreen) throws Exception {
        super(viewport, basicScreen);
        deckEntity = new DeckEntity(this){
            @Override
            public void cardAction(CardEntity cardEntity) {
                super.cardAction(cardEntity);
                player1DeckLayout.selectCard(cardEntity);
            }
        };
        mainActionSequence = new SequenceAction();

        player1 = new Player();
        player2 = new Player();

        team1 = new Team(player1);
        team2 = new Team(player2);

        game = new Game(team1, team2);
        player1DeckLayout = new PlayerHandLayout(player1, deckEntity){
            @Override
            public void selectCard(CardEntity cardSelect) {
                super.selectCard(cardSelect);
                System.out.println("SELECT");
            }

            @Override
            public void onBoardAction() {
                super.onBoardAction();
                System.out.println("onBoard");
                player1DeckLayout.setTouchable(Touchable.disabled);
                actionLayout.showPass();
            }
        };
        player2DeckLayout = new PlayerHandLayout(player2, deckEntity);
//        player1DeckLayout.toFront();

        remainerDeckLayout = new RemainerDeckLayout(this);
        for (int i = 4; i >= 0; i--) {
            CardEntity card2 = deckEntity.getCard(player2.getHand().getDeck().get(i));
            card2.setBack(2);
            remainerDeckLayout.addCard(card2);
            CardEntity card1 = deckEntity.getCard(player1.getHand().getDeck().get(i));
            card1.setBack(1);
            remainerDeckLayout.addCard(card1);
        }
//        remainerDeckLayout.addCard(deckEntity.getCard(Suit.Clubs, Pip.Jack));

        actionLayout = new ActionLayout(this) {
            @Override
            public void onConfirm() {
                super.onConfirm();
                addAction(
                        Actions.run(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        player1DeckLayout.flipUp();
                                        player1DeckLayout.enabled();
                                        actionLayout.exitConfirm();
                                        player1DeckLayout.updateDnD(boardLayout);
                                    }
                                }
                        )
                );
            }

            @Override
            public void onPass() {
                super.onPass();
                player1DeckLayout.flipDown();
                player2DeckLayout.flipUp();
                player2DeckLayout.setTouchable(Touchable.enabled);

            }
        };


        Layout layout = new Layout(this);
        boardLayout = new BoardLayout(this){
            @Override
            public void action() {
                super.action();
                CardEntity card = player1DeckLayout.getCardSelect();
                if(card!=null)
                    boardLayout.addActorGroup(card);
            }
        };

        boardLayout.setTouchable(Touchable.enabled);

        statusPlayer1Layout = new StatusLayout(this);

        statusPlayer2Layout = new StatusLayout(this);

        settingsButton = new ImageButtonEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentScreen().getMainGame().amGame);
                assetPath = "icons";
                assetName = "settings";
            }
        };
        settingsButton.prepareAssets();

        backButton = new ImageButtonEntity() {
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentScreen().getMainGame().amGame);
                assetPath = "icons";
                assetName = "back";
            }

            @Override
            public void action() {
                super.action();
                MainGame mg = getParentScreen().getMainGame();
                getParentScreen().hide();
                mg.setScreen(mg.titleScreen);
//                getParentScreen()
            }
        };
        backButton.prepareAssets();

        Table topMenu = new Table();
        topMenu.setBackground(getParentScreen().getMainGame().grayBg);
        topMenu.add(backButton).left();

        Table bottomMenu = new Table();
        bottomMenu.setBackground(getParentScreen().getMainGame().grayBg);
        bottomMenu.add(settingsButton);

        player1DeckLayout.wrap().
                align(Align.center).
                wrapSpace(10).
                space(10);
        player2DeckLayout.wrap().
                align(Align.center).
                wrapSpace(10).
                space(10);

        player1DeckLayout.setFillParent(false);
        player1DeckLayout.setTouchable(Touchable.enabled);
        player2DeckLayout.setTouchable(Touchable.enabled);
        layout.add(topMenu).top().expandX().fillX().row();
        layout.add(statusPlayer2Layout).
                top().
                expandX().
                fillX().
                align(Align.left).
                padTop(Value.percentHeight(.1f)).
                row();
        layout.add(player2DeckLayout).
                expandX().
                fillX().
                height(Value.percentHeight(1.1f, deckEntity.getCard(Suit.Clubs, Pip.Jack))).
                top().
                row();
        layout.add(boardLayout).
                fill().
                expand().
                row();
        layout.add(player1DeckLayout).
                expandX().
                fillX().
                height(Value.percentHeight(1.1f, deckEntity.getCard(Suit.Clubs, Pip.Jack))).
                bottom().
                row();
        layout.add(statusPlayer1Layout).
                bottom().
                expandX().
                align(Align.left).
                fillX().
                padTop(Value.percentHeight(.1f)).
                row();
        layout.add(bottomMenu).
                bottom().
                expandX().
                fill();

        addActor(layout);

        addActor(actionLayout);

        addActor(remainerDeckLayout);
        boardLayout.toBack();
        mainActionSequence.addAction(remainerDeckLayout.enterAnimation());
        dealCards();
        mainActionSequence.addAction(
                Actions.run(
                        new Runnable() {
                            @Override
                            public void run() {
                                actionLayout.confirmP1();
                            }
                        }
                )
        );
        addAction(mainActionSequence);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        CardEntity card = deckEntity.getCard(Suit.Spades, Pip.Four);
        Vector2 v = card.localToStageCoordinates(new Vector2(10, 10));
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
        remainerDeckLayout.resize(width, height);
    }

    private void dealCards() {
        SequenceAction dealCardsAnimation = new SequenceAction();
        dealCardsAnimation.addAction(
                Actions.delay(0)
        );
        dealCardsAnimation.addAction(
                Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        for (final Card card : player1.getHand().getDeck())
                            deckEntity.getCard(card).catchBeforePosition();
                        for (final Card card : player2.getHand().getDeck())
                            deckEntity.getCard(card).catchBeforePosition();
                    }
                })
        );
        dealCardsAnimation.addAction(
                Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        player1DeckLayout.setUp();
                        player2DeckLayout.setUp();

                        for (final Card card : player1.getHand().getDeck())
                            deckEntity.getCard(card).setVisible(false);
                        for (final Card card : player2.getHand().getDeck())
                            deckEntity.getCard(card).setVisible(false);
                    }
                })
        );

        dealCardsAnimation.addAction(
                Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        for (final Card card : player1.getHand().getDeck()) {
                            deckEntity.getCard(card).catchAfterPosition();
                            deckEntity.getCard(card).restoreMove();
                            deckEntity.getCard(card).setVisible(true);
                        }
                        for (final Card card : player2.getHand().getDeck()) {
                            deckEntity.getCard(card).catchAfterPosition();
                            deckEntity.getCard(card).restoreMove();
                            deckEntity.getCard(card).setVisible(true);
                        }
                    }
                })
        );
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            dealCardsAnimation.addAction(
                    Actions.run(new Runnable() {
                        @Override
                        public void run() {
                            Card card1 = player1.getHand().getDeck().get(finalI);
                            deckEntity.getCard(card1).moveAction();
                        }
                    })
            );
            dealCardsAnimation.addAction(
                    Actions.delay(0.025f)
            );
            dealCardsAnimation.addAction(
                    Actions.run(new Runnable() {
                        @Override
                        public void run() {
                            Card card2 = player2.getHand().getDeck().get(finalI);
                            deckEntity.getCard(card2).moveAction();
                        }
                    })
            );
        }
        dealCardsAnimation.addAction(
                Actions.delay(0.025f)
        );
        mainActionSequence.addAction(dealCardsAnimation);
    }
}