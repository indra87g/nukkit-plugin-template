package com.indra87g.plugin.command.impl;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;
import com.indra87g.plugin.command.BaseCommand;

public class SetBlockCommand extends BaseCommand {

    public SetBlockCommand() {
        super("setblock", "Sets a block at a specific location", "/setblock <x> <y> <z> <id>", "contohplugin.command.setblock", Scope.PLAYER, new String[]{"sb"});
    }

    @Override
    public boolean onExecute(CommandSender sender, String commandLabel, String[] args) {
        if (args.length != 4) {
            sender.sendMessage("Usage: " + getUsage());
            return false;
        }

        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int z = Integer.parseInt(args[2]);
            int blockId = Integer.parseInt(args[3]);

            Player player = (Player) sender;
            Level level = player.getLevel();
            Block block = Block.get(blockId);

            level.setBlock(new Vector3(x, y, z), block);
            sender.sendMessage("Block placed successfully.");
        } catch (NumberFormatException e) {
            sender.sendMessage("Invalid coordinates or block ID.");
        }

        return true;
    }
}
