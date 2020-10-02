package com.rodion.forty.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.rodion.forty.basics.SwitchImageEntity;
import com.rodion.forty.basics.TriphaseImageEntity;
import com.rodion.forty.kernel.Card;
import com.rodion.forty.kernel.Pip;
import com.rodion.forty.kernel.Suit;

public class CardEntity extends TriphaseImageEntity {
    Pip pip;
    Suit suit;
    private float xbefore, ybefore, xafter, yafter;

    public CardEntity(Pip pip, Suit suit) {
        super();
        this.pip = pip;
        this.suit = suit;
        prepareAssets();
        addListener(new ClickListener() {
                        boolean isPressed;
                        boolean isClicked;
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            action();
                        }
                    }
        );
        xbefore=0;
        ybefore=0;
        xafter =0;
        yafter=0;
    }


    @Override
    public void setAssetAddress() {
        super.setAssetAddress();
        assetPath = "deck/themes/default";
        assetName1 = suit.name + String.format("%02d", pip.getValue());
        assetName2 = "back1";
        assetName3 = "back2";
    }

    public void action() {
        status++;
        if (status == 3)
            status = 0;
        update();
    }

    public void setPositionBefore(float x, float y){
        xbefore = x;
        ybefore = y;
    }

    public void setPositionAfter(float x, float y){
        xafter = x;
        yafter = y;
    }

    public void catchBeforePosition(){
        xbefore = localToStageCoordinates(new Vector2(0, 0)).x;
        ybefore = localToStageCoordinates(new Vector2(0, 0)).y;
    }

    public void catchAfterPosition(){
        xafter = localToStageCoordinates(new Vector2(0, 0)).x;
        yafter = localToStageCoordinates(new Vector2(0, 0)).y;
    }

    public void moveAction(){
        float deltax = xafter-xbefore, deltay =  yafter-ybefore;

        moveBy(-deltax, -deltay);

        addAction(Actions.moveBy(deltax,deltay,0.5f));
    }

    public float getXbefore() {
        return xbefore;
    }

    public float getYbefore() {
        return ybefore;
    }

    public float getXafter() {
        return xafter;
    }

    public float getYafter() {
        return yafter;
    }
}