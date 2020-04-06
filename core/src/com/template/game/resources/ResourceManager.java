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

import java.util.HashMap;
import java.util.Map;

public class ResourceManager implements ResourceManagerInterface {

    private AssetManager assetManager;
    private Map<String, TextureAtlas> textureAtlases = new HashMap<String, TextureAtlas>();
    private Map<String, Texture> textures = new HashMap<String, Texture>();
    private Map<String, BitmapFont> fonts = new HashMap<String, BitmapFont>();
    private Map<String, Music> music = new HashMap<String, Music>();
    private Map<String, Sound> sounds = new HashMap<String, Sound>();
    private Map<String, TiledMap> maps = new HashMap<String, TiledMap>();
    private Map<String, Skin> skins = new HashMap<String, Skin>();
    private boolean finishedLoading = false;

    public ResourceManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    @Override
    public boolean update() {
        if (finishedLoading) {
            return true;
        }

        finishedLoading = assetManager.update();

        if (finishedLoading) {
            fillTextureAtlasMap();
            fillTextureMap();
            fillFontMap();
            fillMusicMap();
            fillSoundMap();
            fillMapsMap();
            fillSkinsMap();
        }

        return finishedLoading;
    }

    @Override
    public void finishLoading() {
        assetManager.finishLoading();

        fillTextureAtlasMap();
        fillTextureMap();
        fillFontMap();
        fillMapsMap();
        fillMusicMap();
        fillSkinsMap();
        fillSoundMap();
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

        if (type == TextureAtlas.class) {
            textureAtlases.put(name, null);
        } else if (type == Texture.class) {
            textures.put(name, null);
        } else if (type == BitmapFont.class) {
            fonts.put(name, null);
        } else if (type == Music.class) {
            music.put(name, null);
        } else if (type == Sound.class) {
            sounds.put(name, null);
        } else if (type == Skin.class) {
            skins.put(name, null);
        }
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

        maps.put(name, null);
    }

    @Override
    public TiledMap map(String name) {
        if (!maps.containsKey(name)) {
            throw new NotLoadedException("Map '" + name + "' is not loaded");
        }

        return maps.get(name);
    }

    @Override
    public Texture texture(String name) {
        if (!textures.containsKey(name)) {
            throw new NotLoadedException("Texture '" + name + "' is not loaded");
        }

        return textures.get(name);
    }

    @Override
    public TextureAtlas atlas(String name) {
        if (!textureAtlases.containsKey(name)) {
            throw new NotLoadedException("TextureAtlas '" + name + "' is not loaded");
        }

        return textureAtlases.get(name);
    }

    @Override
    public BitmapFont font(String name) {
        if (!fonts.containsKey(name)) {
            throw new NotLoadedException("Font '" + name + "' is not loaded");
        }

        return fonts.get(name);
    }

    @Override
    public Music music(String name) {
        if (!music.containsKey(name)) {
            throw new NotLoadedException("Music '" + name + "' is not loaded");
        }

        return music.get(name);
    }

    @Override
    public Sound sound(String name) {
        if (!sounds.containsKey(name)) {
            throw new NotLoadedException("Sound '" + name + "' is not loaded");
        }

        return sounds.get(name);
    }

    @Override
    public Skin skin(String name) {
        if (!skins.containsKey(name)) {
            throw new NotLoadedException("Skin '" + name + "' is not loaded");
        }

        return skins.get(name);
    }

    @Override
    public void unload(String[] assets, Class[] classes) {
        for (int i = 0; i < assets.length; i++) {
            unload(assets[i], classes[i]);
        }
    }

    @Override
    public void unload(String name, Class clazz) {
        assetManager.unload(name);

        if (clazz == TextureAtlas.class) {
            textureAtlases.remove(name);
        } else if (clazz == Texture.class) {
            textures.remove(name);
        } else if (clazz == BitmapFont.class) {
            fonts.remove(name);
        } else if (clazz == Music.class) {
            music.remove(name);
        } else if (clazz == Sound.class) {
            sounds.remove(name);
        } else if (clazz == TiledMap.class) {
            maps.remove(name);
        } else if (clazz == Skin.class) {
            skins.remove(name);
        }
    }

    @Override
    public void clear() {
        assetManager.clear();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    private void fillMapsMap() {
        for (String map : maps.keySet()) {
            maps.put(map, assetManager.get(map, TiledMap.class));
        }
    }

    private void fillSkinsMap() {
        for (String skin : skins.keySet()) {
            skins.put(skin, assetManager.get(skin, Skin.class));
        }
    }

    private void fillFontMap() {
        for (String font : fonts.keySet()) {
            fonts.put(font, assetManager.get(font, BitmapFont.class));
        }
    }

    private void fillMusicMap() {
        for (String music : this.music.keySet()) {
            this.music.put(music, assetManager.get(music, Music.class));
        }
    }

    private void fillSoundMap() {
        for (String sound : sounds.keySet()) {
            sounds.put(sound, assetManager.get(sound, Sound.class));
        }
    }

    private void fillTextureAtlasMap() {
        for (String textureAtlas : textureAtlases.keySet()) {
            textureAtlases.put(textureAtlas, assetManager.get(textureAtlas, TextureAtlas.class));
        }
    }

    private void fillTextureMap() {
        for (String texture : textures.keySet()) {
            textures.put(texture, assetManager.get(texture, Texture.class));
        }
    }
}
