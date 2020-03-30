package com.template.game.resources;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.Map;

/**
 * Manages game resources: textures, sounds, maps...
 */
public interface ResourceManagerInterface {

    /**
     * Gets a loaded texture atlas from the resource manager
     *
     * @param name file name of the atlas
     * @return loaded texture atlas
     */
    TextureAtlas atlas(String name);

    /**
     * Gets rid of all loaded resources
     */
    void clear();

    /**
     * Disposes of the resource manager
     */
    void dispose();

    /**
     * Forces to load all queued resources. Blocks calling thread
     */
    void finishLoading();

    /**
     * Gets a loaded bitmap font from the resource manager
     *
     * @param name file name of the font
     * @return loaded bitmap font
     */
    BitmapFont font(String name);

    /**
     * Returns a number between 0 and 1 indicating loading percentage
     *
     * @return progress
     */
    float getProgress();

    /**
     * Loads all specified resources
     *
     * @param resources map containing resource file names and types
     */
    void load(Map<String, Class> resources);

    /**
     * Loads a single resource
     *
     * @param name file name of the resource
     * @param type class type of the resource
     */
    void load(String name, Class type);

    /**
     * Loads specified tiled maps
     *
     * @param maps maps to load
     */
    void loadMaps(String... maps);

    /**
     * Loads a tiled map
     *
     * @param name file name of the map
     */
    void loadMap(String name);

    /**
     * Gets a loaded tiled map from the resource manager
     *
     * @param name file name of the map
     * @return
     */
    TiledMap map(String name);

    /**
     * Gets a loaded music instance from the resource manager
     *
     * @param name file name of the music instance
     * @return loaded music instance
     */
    Music music(String name);

    /**
     * Gets a loaded skin from the resource manager
     *
     * @param name file name of the skin
     * @return loaded skin
     */
    Skin skin(String name);

    /**
     * Gets a loaded sound instance from the resource manager
     *
     * @param name file name of the sound instance
     * @return loaded sound instance
     */
    Sound sound(String name);

    /**
     * Gets a loaded texture from the resource manager
     *
     * @param name file name of the texture
     * @return loaded texture
     */
    Texture texture(String name);

    /**
     * Unloads all specified resources
     *
     * @param resources resources to unload
     * @param classes   class types of the same index resources
     */
    void unload(String[] resources, Class[] classes);

    /**
     * Unloads a single resource
     *
     * @param name  file name of the resource
     * @param clazz class type of the resource
     */
    void unload(String name, Class clazz);

    /**
     * Updates the resource manager. Must be called inside game loop to load resources
     *
     * @return true if finished loading, false otherwise
     */
    boolean update();
}
