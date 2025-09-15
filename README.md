# ContohPlugin

This is a sample Nukkit plugin that demonstrates a variety of features, including a command handler, EconomyAPI integration, and more.

## Building the Plugin

To build the plugin, you will need to have [Maven](https://maven.apache.org/) installed. Then, you can run the following command in the root directory of the project:

```
mvn clean package
```

This will create a `ContohPlugin-1.1.0.jar` file in the `target` directory.

## Creating a New Command

To create a new command, you will need to create a new class that extends `com.indra87g.plugin.command.BaseCommand`. Here is an example:

```java
package com.indra87g.plugin.command.impl;

import cn.nukkit.command.CommandSender;
import com.indra87g.plugin.command.BaseCommand;
import com.indra87g.plugin.command.Scope;

public class MyCommand extends BaseCommand {

    public MyCommand() {
        super("mycommand", "This is my command", "/mycommand", "contohplugin.command.mycommand", Scope.BOTH, new String[]{"mycmd", "mc"});
    }

    @Override
    public boolean onExecute(CommandSender sender, String commandLabel, String[] args) {
        sender.sendMessage("Hello, world!");
        return true;
    }
}
```

Then, you will need to register the command in the `onEnable` method of the `ContohPlugin` class:

```java
commandHandler.registerCommand(new MyCommand());
```

## Creating a New Event Listener

To create a new event listener, you will need to create a new class that implements `cn.nukkit.event.Listener`. Here is an example:

```java
package com.indra87g.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class MyListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome to the server!");
    }
}
```

Then, you will need to register the listener in the `onEnable` method of the `ContohPlugin` class:

```java
getServer().getPluginManager().registerEvents(new MyListener(), this);
```

## Using the EconomyAPI

To use the EconomyAPI, you will need to get an instance of the `com.indra87g.plugin.api.Economy` class. Here is an example:

```java
Economy economy = new Economy();
double money = economy.getMoney(player);
economy.addMoney(player, 100);
```

## Configuring pom.xml

To add a new dependency to the plugin, you will need to add it to the `<dependencies>` section of the `pom.xml` file. Here is an example:

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>example-api</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
```

You may also need to add a new repository to the `<repositories>` section of the `pom.xml` file. Here is an example:

```xml
<repository>
    <id>example-repo</id>
    <url>https://example.com/repo</url>
</repository>
```
