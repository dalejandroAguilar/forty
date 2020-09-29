package com.rodion.forty.basics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.viewport.Viewport;

public class BlackStage extends Stage {
    Texture blackTexture;
    public BlackStage(Viewport viewport) {
        super(viewport);
        blackTexture = getTexture();
        final Image image=new Image(new TextureRegion(blackTexture));
        image.setSize(getWidth(),getHeight());
        image.setOrigin(getWidth()/2,getHeight()/2);
        image.setColor(Color.BLACK);
        addActor(image);
    }

    public static Texture getTexture() {

        Pixmap pixmap;
        try {
            pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        } catch (GdxRuntimeException e) {
            pixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
        }
        pixmap.setColor(Color.WHITE);
        pixmap.drawRectangle(0, 0, 1, 1);
        return new Texture(pixmap);
    }

    public void resize(int width, int height){
        getViewport().update(width, height,true);
    }

    @Override
    public void dispose() {
        super.dispose();
        blackTexture.dispose();
    }
}
