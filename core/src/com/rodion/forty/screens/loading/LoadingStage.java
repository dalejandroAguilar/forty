package com.rodion.forty.screens.loading;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.rodion.forty.basics.AnimatedEntity;
import com.rodion.forty.basics.BasicScreen;
import com.rodion.forty.basics.BasicStage;
import com.rodion.forty.basics.Constants;
import com.rodion.forty.basics.ImageEntity;
import com.rodion.forty.basics.LabelEntity;
import com.rodion.forty.basics.Layout;

public class LoadingStage extends BasicStage {
    private Layout layout;
    private LabelEntity label;

//    private Image image;
    private AnimatedEntity loadingIconEntity;
    public LoadingStage(Viewport viewport, BasicScreen basicScreen) {
        super(viewport, basicScreen);
//        label.setStyle();

        layout = new Layout(this);
        label = new LabelEntity("Loading...",layout);
        loadingIconEntity = new AnimatedEntity(4){
            @Override
            public void setAssetAddress() {
                setAssetManager(getParentScreen().getMainGame().assetManagerLoading);
                assetPath = "loading";
                assetName = "loading";
            }
        };
        loadingIconEntity.prepareAssets();

        layout.add(loadingIconEntity).expand().row();
        layout.add(label).top().expand();
        addActor(layout);


    }

    @Override
    public void act(float delta) {
        super.act(delta);
//        loadingIconEntity.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        loadingIconEntity.resize(width,height);
        label.resize(width, height);
    }
}
