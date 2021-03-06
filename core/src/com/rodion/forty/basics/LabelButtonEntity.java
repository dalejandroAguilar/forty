package com.rodion.forty.basics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class LabelButtonEntity extends Layout {
    private TextureRegionDrawable enableColor;
    private LabelEntity label;

    public LabelButtonEntity(String text, TextureRegionDrawable enableColor, BasicStage basicStage) {
        super(basicStage);
        this.enableColor = enableColor;
        setFillParent(false);
        label = new LabelEntity(text, this);
        setTouchable(Touchable.enabled);
        setBackground(enableColor);

        add(label).pad(Value.percentHeight(0.2f, label));

        addListener(new ClickListener() {
                        boolean isPressed;
                        boolean isClicked;

                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            try {
                                action();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
        );

        addListener(new ClickListener() {
                        boolean isPressed;
                        boolean isClicked;

                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            if (button == 0) {
                                isPressed = true;
                                isClicked = false;
                                addAction(Actions.color(Color.GRAY, .2f));
                            }
                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            if (button == 0) {
                                super.touchUp(event, x, y, pointer, button);
                                addAction(Actions.color(Color.WHITE, .2f));
//                            if (isPressed) {
//
//                            }
                            }
                        }

                        @Override
                        public void touchDragged(InputEvent event, float x, float y, int pointer) {
                            super.touchDragged(event, x, y, pointer);
                            if (!isOver() && isPressed) {
                                addAction(Actions.color(Color.WHITE, .2f));
                                isPressed = false;
                            }
                        }
                    }
        );
    }

    public void action() throws Exception {
    }

    public void setText(String st) {
        label.setText(st);
    }


    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        label.resize(width, height);
    }
}
