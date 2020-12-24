package com.template.game.resources;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.Map;

public interface ResourceManagerInterface {

    TextureAtlas atlas(String name);

    void clear();

    void dispose();

    void finishLoading();

    BitmapFont font(String name);

    float getProgress();

    void load(Map<String, Class> resources);

    void load(String name, Class type);

    void loadMaps(String... maps);

    void loadMap(String name);

    TiledMap map(String name);

    Music music(String name);

    Skin skin(String name);

    Sound sound(String name);

    Texture texture(String name);

    void unload(String[] resources);

    void unload(String name);

    boolean update();
}
