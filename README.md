# LibGDX_Project_Template_2
More advanced prototype of a LibGDX project, utilizes ObjectManagerInterface from https://github.com/Giedrius-Kristinaitis/DI_Container for dependency injection. Separate rendering and updating thread support (optional, specified in a config file), built-in config file reading, refactored resource management, refactored screen handling logic, and more... Built with state updating and rendering separation in mind. Built for 2D games, but can be easily refactored to work with 3D games too.

Features that may be added in the future:

1) more flexible frame animations

## How to use
All boilerplate logic is already written, all you need to do is clone the repository, rename packages if needed, and start the damn project. The entry point for customization is the com.template.game.logic package. It has 3 sub-packages:

1) main - contains all game specifig logic, initialize everything inside Game class, which contains methods initialize() and dispose() where you initialize and destroy all game specific mechanics. Game class also has a reference to the game state object, which contains all game objects, game object renderers and other classes that implement updatable interface, which need to be added to the queue and removed manually, thus, allowing to create your own update and render queue and render only these objects that actually need to be rendered (check game state interface for all available methods)
2) renderer - contains RendererRegistry class, in which you register renderers for your game objects, place created renderers in this package or it's sub-packages too (not mandatory), every renderer must implement RendererInterface<T>, where T is the class of rendered object
3) screen - contains all screens and their related stuff, loading screen is already written, it has it's own config inside assets/config/application.config file, there's also a game screen, in which all you need to do is set up user interface in the setupUI method and return map with assets that the screen will need inside getAssetsToLoad method. If you need any extra initialization inside game screen, do it inside show() method (this applies for all screens which extend abstract screen). You can pass an input processor in the super constructor call of the game class to handle user input


Old project template version: https://github.com/Giedrius-Kristinaitis/LibGDX_Project_Template
