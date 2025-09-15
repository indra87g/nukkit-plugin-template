package com.indra87g.plugin.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Player;

public abstract class BaseCommand extends Command {

    private final Scope scope;

    public BaseCommand(String name, String description, String usageMessage, String permission, Scope scope) {
        this(name, description, usageMessage, permission, scope, new String[0]);
    }

    public BaseCommand(String name, String description, String usageMessage, String permission, Scope scope, String[] aliases) {
        super(name, description, usageMessage, aliases);
        this.setPermission(permission);
        this.scope = scope;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (scope == Scope.PLAYER && !(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return false;
        }

        if (scope == Scope.CONSOLE && sender instanceof Player) {
            sender.sendMessage("This command can only be used by the console.");
            return false;
        }

        return onExecute(sender, commandLabel, args);
    }

    public abstract boolean onExecute(CommandSender sender, String commandLabel, String[] args);
}
