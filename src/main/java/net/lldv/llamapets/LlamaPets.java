package net.lldv.llamapets;

import cn.nukkit.entity.Entity;
import cn.nukkit.plugin.PluginBase;
import lombok.Getter;
import net.lldv.llamapets.commands.PetCommand;
import net.lldv.llamapets.components.api.API;
import net.lldv.llamapets.components.data.PetData;
import net.lldv.llamapets.components.data.entities.hostile.*;
import net.lldv.llamapets.components.data.entities.passive.*;
import net.lldv.llamapets.components.forms.FormListener;
import net.lldv.llamapets.components.forms.FormWindows;
import net.lldv.llamapets.components.language.Language;
import net.lldv.llamapets.components.provider.Provider;
import net.lldv.llamapets.components.provider.UniversalClient;
import net.lldv.llamapets.components.provider.data.clientdetails.MongoDbDetails;
import net.lldv.llamapets.components.provider.data.clientdetails.MySqlDetails;
import net.lldv.llamapets.components.provider.data.clientdetails.YamlDetails;
import net.lldv.llamapets.listeners.EventListener;

public class LlamaPets extends PluginBase {

    @Getter
    private static API api;

    @Getter
    public Provider provider;

    @Override
    public void onEnable() {
        try {
            this.saveDefaultConfig();
            UniversalClient client = null;
            switch (this.getConfig().getString("Provider").toLowerCase()) {
                case "mysql":
                    client = new UniversalClient(
                            UniversalClient.Type.MySql,
                            new MySqlDetails(
                                    this.getConfig().getString("MySql.Host"),
                                    this.getConfig().getString("MySql.Port"),
                                    this.getConfig().getString("MySql.User"),
                                    this.getConfig().getString("MySql.Password"),
                                    this.getConfig().getString("MySql.Database")
                            )
                    );
                    break;
                case "mongodb":
                    client = new UniversalClient(
                            UniversalClient.Type.MongoDB,
                            new MongoDbDetails(
                                    this.getConfig().getString("MongoDB.Uri"),
                                    this.getConfig().getString("MongoDB.Database")
                            )
                    );
                    break;
                case "yaml":
                    client = new UniversalClient(
                            UniversalClient.Type.Yaml,
                            new YamlDetails(
                                    this.getDataFolder().toString() + "/data"
                            )
                    );
                    break;
                default:
                    this.getLogger().error("§4Please specify a valid provider: Yaml, MySql, MongoDB");
                    break;
            }
            this.provider = new Provider(client);
            this.provider.init();
            this.getLogger().info("§aSuccessfully loaded provider.");
            api = new API(this.provider, new FormWindows(this.provider));
            Language.init(this);
            this.loadPlugin();
            this.getLogger().info("§aLlamaPets successfully started.");
        } catch (Exception e) {
            e.printStackTrace();
            this.getLogger().error("§4Failed to load LlamaPets.");
        }
    }

    private void loadPlugin() {
        this.getServer().getPluginManager().registerEvents(new FormListener(), this);
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

        this.getServer().getCommandMap().register("llamapets", new PetCommand(this));

        /*
         * Passive
         */
        Entity.registerEntity(PetData.Type.BEE_PET, BeePet.class);
        Entity.registerEntity(PetData.Type.CAT_PET, CatPet.class);
        Entity.registerEntity(PetData.Type.CHICKEN_PET, ChickenPet.class);
        Entity.registerEntity(PetData.Type.COW_PET, CowPet.class);
        Entity.registerEntity(PetData.Type.DOLPHIN_PET, DolphinPet.class);
        Entity.registerEntity(PetData.Type.DONKEY_PET, DonkeyPet.class);
        Entity.registerEntity(PetData.Type.FOX_PET, FoxPet.class);
        Entity.registerEntity(PetData.Type.HORSE_PET, HorsePet.class);
        Entity.registerEntity(PetData.Type.LLAMA_PET, LlamaPet.class);
        Entity.registerEntity(PetData.Type.MOOSHROOM_PET, MooshroomPet.class);
        Entity.registerEntity(PetData.Type.MULE_PET, MulePet.class);
        Entity.registerEntity(PetData.Type.OCELOT_PET, OcelotPet.class);
        Entity.registerEntity(PetData.Type.PANDA_PET, PandaPet.class);
        Entity.registerEntity(PetData.Type.PIG_PET, PigPet.class);
        Entity.registerEntity(PetData.Type.POLARBEAR_PET, PolarbearPet.class);
        Entity.registerEntity(PetData.Type.RABBIT_PET, RabbitPet.class);
        Entity.registerEntity(PetData.Type.SHEEP_PET, SheepPet.class);
        Entity.registerEntity(PetData.Type.SNOWGOLEM_PET, SnowgolemPet.class);
        Entity.registerEntity(PetData.Type.STRIDER_PET, StriderPet.class);
        Entity.registerEntity(PetData.Type.TURTLE_PET, TurtlePet.class);
        Entity.registerEntity(PetData.Type.VILLAGER_PET, VillagerPet.class);
        Entity.registerEntity(PetData.Type.WOLF_PET, WolfPet.class);

        /*
         * Hostile
         */
        Entity.registerEntity(PetData.Type.BLAZE_PET, BlazePet.class);
        Entity.registerEntity(PetData.Type.CAVESPIDER_PET, CaveSpiderPet.class);
        Entity.registerEntity(PetData.Type.CREEPER_PET, CreeperPet.class);
        Entity.registerEntity(PetData.Type.DROWNED_PET, DrownedPet.class);
        Entity.registerEntity(PetData.Type.ELDERGUARDIAN_PET, ElderGuardianPet.class);
        Entity.registerEntity(PetData.Type.ENDERMAN_PET, EndermanPet.class);
        Entity.registerEntity(PetData.Type.ENDERMITE_PET, EndermitePet.class);
        Entity.registerEntity(PetData.Type.EVOKER_PET, EvokerPet.class);
        Entity.registerEntity(PetData.Type.GHAST_PET, GhastPet.class);
        Entity.registerEntity(PetData.Type.GUARDIAN_PET, GuardianPet.class);
        Entity.registerEntity(PetData.Type.HOGLIN_PET, HoglinPet.class);
        Entity.registerEntity(PetData.Type.HUSK_PET, HuskPet.class);
        Entity.registerEntity(PetData.Type.PHANTOM_PET, PhantomPet.class);
        Entity.registerEntity(PetData.Type.PIGLIN_PET, PiglinPet.class);
        Entity.registerEntity(PetData.Type.PILLAGER_PET, PillagerPet.class);
        Entity.registerEntity(PetData.Type.RAVAGER_PET, RavagerPet.class);
        Entity.registerEntity(PetData.Type.SILVERFISH_PET, SilverfishPet.class);
        Entity.registerEntity(PetData.Type.SKELETON_PET, SkeletonPet.class);
        Entity.registerEntity(PetData.Type.SPIDER_PET, SpiderPet.class);
        Entity.registerEntity(PetData.Type.STRAY_PET, StrayPet.class);
        Entity.registerEntity(PetData.Type.VEX_PET, VexPet.class);
        Entity.registerEntity(PetData.Type.VINDICATOR_PET, VindicatorPet.class);
        Entity.registerEntity(PetData.Type.WITCH_PET, WitchPet.class);
        Entity.registerEntity(PetData.Type.WITHERSKELETON_PET, WitherSkeletonPet.class);
        Entity.registerEntity(PetData.Type.ZOGLIN_PET, ZoglinPet.class);
        Entity.registerEntity(PetData.Type.ZOMBIE_PET, ZombiePet.class);
        Entity.registerEntity(PetData.Type.ZOMBIEPIGMAN_PET, ZombiePigmanPet.class);
        Entity.registerEntity(PetData.Type.ZOMBIEVILLAGER_PET, ZombieVillagerPet.class);

        this.getConfig().getSection("PetSettings.Prices").getAll().getKeys(false).forEach(s -> {
            PetData.cachedPetList.put(s.toLowerCase(), this.getConfig().getDouble("PetSettings.Prices." + s));
        });
    }

    @Override
    public void onDisable() {
        this.provider.disconnect();
    }

}
