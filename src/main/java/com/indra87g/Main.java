import cn.nukkit.block.Block;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Player;

public class Main extends PluginBase {

    @Override
    public void onEnable() {
        getLogger().info("Plugin aktif!");
        this.getServer().getCommandMap().register("setblock", new Command("setblock") {
            @Override
            public boolean execute(CommandSender sender, String label, String[] args) {
                if (!(sender instanceof Player)) return false;

                Player player = (Player) sender;
                Level level = player.getLevel();

                // Contoh koordinat dan jenis block
                Vector3 pos = new Vector3(100, 65, 100); // X, Y, Z
                Block block = Block.get(Block.STONE); // Ganti dengan jenis block lain jika perlu

                level.setBlock(pos, block);
                player.sendMessage("Block berhasil ditempatkan di " + pos.toString());
                return true;
}
});
}
            }
