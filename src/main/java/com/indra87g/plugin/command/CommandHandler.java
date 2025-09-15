package com.indra87g.plugin.command;

import com.indra87g.plugin.Main;
import java.util.Collections;

public class CommandHandler {

    private final Main plugin;

    public CommandHandler(Main plugin) {
        this.plugin = plugin;
    }

    public void registerCommand(BaseCommand command) {
        plugin.getServer().getCommandMap().register(command.getName(), command);
    }
}
