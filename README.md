# Fleecifer (Quilt)
Fleecifer is a Minecraft mod developed for the [Quilt Loader](https://quiltmc.org/). This mod replaces sheep behaviour, turning them hostile towards the player.

## Mod Requirements
- [Quilt Loader](https://quiltmc.org/)  
- [QSL](https://modrinth.com/mod/qsl)  

## FAQ
- **I've got another mod that changes sheep behavior, is this compatible?**
    - Fleecifer has not been tested with other mods that change sheep behavior, you may experience issues under this circumstance.
- **Is this compatible with Fabric Loader?**
    - No, updated versions are made for [Quilt Loader](https://quiltmc.org/).
        - There is some older versions that are compatible with Fabric Loader, and are tagged with Fabric on the versions page, but they will not be updated.
    - I would recommend trying out [Quilt Loader](https://quiltmc.org/), as it's mostly a drop-in replacement for Fabric Loader - even mods that are only tagged as Fabric most likely will work with Quilt with [QFAPI (bundled with QSL)](https://modrinth.com/mod/qsl) replacing Fabric API.
- **Why is this Quilt Loader exclusive?**
    - This helps me streamline the development process, making testing easier and no longer having to test multiple mod loaders, this will allow me to focus more on making higher-quality mods for the modloader I actually use.
- **Is this compatible with Forge?**
    - No. However, other developers are free to port this mod, as long as they adhere to the conditions of the LGPL-3.0-or-later license.
- **Can I use this in a modpack or video?**
    - Yes, you can use this mod in modpacks or videos.
- **Will you port this mod to 1.x.x?**
    - I am unlikely to port to specific versions, as this mod was made for fun. However, other developers are free to port this mod, as long as they adhere to the conditions of the LGPL-3.0-or-later license.
- **Can I remove the re-texturing of the sheep?**
    - The eyes are a separate texture located at `fleecifer:textures/entity/sheep/sheep_eyes.png`, which you could replace with a blank texture using a resource pack.
