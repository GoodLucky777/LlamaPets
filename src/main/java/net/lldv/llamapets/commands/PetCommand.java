package net.lldv.llamapets.commands;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import net.lldv.llamapets.LlamaPets;
import net.lldv.llamapets.components.language.Language;

public class PetCommand extends PluginCommand<LlamaPets> {

    public PetCommand(LlamaPets owner) {
        super(owner.getConfig().getString("Commands.Pet.Name"), owner);
        this.setDescription(owner.getConfig().getString("Commands.Pet.Description"));
        this.setPermission(owner.getConfig().getString("Commands.Pet.Permission"));
        this.setAliases(owner.getConfig().getStringList("Commands.Pet.Aliases").toArray(new String[]{}));
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(this.getPermission())) {
                LlamaPets.getApi().getFormWindows().openPetMenu(player);
            } else player.sendMessage(Language.get("permission.insufficient"));
        }
        return true;
    }

}
