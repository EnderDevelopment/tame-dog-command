# Minecraft Fabric Mod: Tamed Dog Command

Tamed Dog Command is a Minecraft 1.21.1 Fabric mod that adds a configurable dog spawning command. Use `/dog` to spawn a tamed, sitting wolf owned by you, or use `/dog <amount>` to choose how many dogs to spawn at once.

## Install

Requirements:

- Minecraft Java Edition 1.21.1
- Fabric Loader 0.16.5 or newer
- Fabric API for Minecraft 1.21.1
- Java 21 or newer

1. Install Fabric Loader for Minecraft 1.21.1.
2. Install the matching Fabric API version.
3. Build the mod with `./gradlew build`, or obtain the compiled mod JAR.
4. Place the Dog Command JAR in the Minecraft `mods` folder.
5. Start Minecraft with the Fabric profile.

To build the mod from source, run:

```text
./gradlew build
```

The compiled JAR will be created in `build/libs`.

## Use

1. Join a Minecraft world while using Fabric.
2. Run `/dog` to spawn one tamed, sitting dog.
3. Run `/dog <amount>` to spawn between 1 and 100 dogs. For example:

```text
/dog 5
```

Each dog spawns near the player who used the command, is tamed by that player, and starts sitting. The command can only be used by a player.

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/7d6e71bb-257f-40b0-b89f-2ca4e6df973e?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=7d6e71bb-257f-40b0-b89f-2ca4e6df973e
