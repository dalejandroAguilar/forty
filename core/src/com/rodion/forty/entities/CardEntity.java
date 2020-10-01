package com.rodion.forty.entities;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.rodion.forty.basics.SwitchImageEntity;
import com.rodion.forty.kernel.Card;
import com.rodion.forty.kernel.Pip;
import com.rodion.forty.kernel.Suit;

public class CardEntity extends SwitchImageEntity {
    private Card card;
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
        assetNameOn = suit.name + String.format("%02d", pip.getValue());
        assetNameOff = "back1";
        System.out.println(assetPath);
    }

    public void action() {
        if (status == 1)
            status = 0;
        else
            status = 1;
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