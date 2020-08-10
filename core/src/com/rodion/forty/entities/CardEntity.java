package com.rodion.forty.entities;

import com.rodion.forty.basics.ImageEntity;
import com.rodion.forty.basics.Layout;
import com.rodion.forty.basics.Pip;
import com.rodion.forty.basics.Suit;

public class CardEntity extends ImageEntity {
    Pip pip;
    Suit suit;
    public CardEntity(Pip pip, Suit suit) {
        super();
        this.pip = pip;
        this.suit = suit;
        prepareAssets();
    }

    @Override
    public void setAssetAddress() {
        super.setAssetAddress();
        assetPath = "deck/themes/default";
        assetName = suit.name+String.format("%02d", pip.value);
        System.out.println(assetPath);
        System.out.println(assetName);
    }
}

