package com.indra87g.plugin;

import cn.nukkit.plugin.PluginBase;
import com.indra87g.plugin.command.CommandHandler;
import com.indra87g.plugin.command.impl.SetBlockCommand;
import com.indra87g.plugin.listener.MyListener;

public class Main extends PluginBase {

    private static Main instance;
    private CommandHandler commandHandler;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        commandHandler = new CommandHandler(this);
        commandHandler.registerCommand(new SetBlockCommand());
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        getLogger().info("Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled!");
    }

    public static Main getInstance() {
        return instance;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }
}
