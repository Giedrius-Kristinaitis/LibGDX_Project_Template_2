package com.template.game.resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.Map;

public class ResourceManager implements ResourceManagerInterface {

    private AssetManager assetManager;
    private boolean finishedLoading = false;

    public ResourceManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    @Override
    public boolean update() {
        if (finishedLoading) {
            return true;
        }

        if (!assetManager.update()) {
            return false;
        }

        finishedLoading = true;

        return true;
    }

    @Override
    public void finishLoading() {
        assetManager.finishLoading();
    }

    @Override
    public float getProgress() {
        return assetManager.getProgress();
    }

    @Override
    public void load(Map<String, Class> assets) {
        for (Map.Entry<String, Class> asset : assets.entrySet()) {
            load(asset.getKey(), asset.getValue());
        }
    }

    @Override
    public void load(String name, Class type) {
        assetManager.load(name, type);
    }

    @Override
    public void loadMaps(String... maps) {
        for (String map : maps) {
            loadMap(map);
        }
    }

    @Override
    public void loadMap(String name) {
        assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        assetManager.load(name, TiledMap.class);
    }

    @Override
    public TiledMap map(String name) {
        if (!assetManager.isLoaded(name)) {
            throw new NotLoadedException("Map '" + name + "' is not loaded");
        }

        return assetManager.get(name, TiledMap.class);
    }

    @Override
    public Texture texture(String name) {
        if (!assetManager.isLoaded(name)) {
            throw new NotLoadedException("Texture '" + name + "' is not loaded");
        }

        return assetManager.get(name, Texture.class);
    }

    @Override
    public TextureAtlas atlas(String name) {
        if (!assetManager.isLoaded(name)) {
            throw new NotLoadedException("TextureAtlas '" + name + "' is not loaded");
        }

        return assetManager.get(name, TextureAtlas.class);
    }

    @Override
    public BitmapFont font(String name) {
        if (!assetManager.isLoaded(name)) {
            throw new NotLoadedException("Font '" + name + "' is not loaded");
        }

        return assetManager.get(name, BitmapFont.class);
    }

    @Override
    public Music music(String name) {
        if (!assetManager.isLoaded(name)) {
            throw new NotLoadedException("Music '" + name + "' is not loaded");
        }

        return assetManager.get(name, Music.class);
    }

    @Override
    public Sound sound(String name) {
        if (!assetManager.isLoaded(name)) {
            throw new NotLoadedException("Sound '" + name + "' is not loaded");
        }

        return assetManager.get(name, Sound.class);
    }

    @Override
    public Skin skin(String name) {
        if (!assetManager.isLoaded(name)) {
            throw new NotLoadedException("Skin '" + name + "' is not loaded");
        }

        return assetManager.get(name, Skin.class);
    }

    @Override
    public void unload(String[] assets) {
        for (String asset : assets) {
            unload(asset);
        }
    }

    @Override
    public void unload(String name) {
        assetManager.unload(name);
    }

    @Override
    public void clear() {
        assetManager.clear();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
