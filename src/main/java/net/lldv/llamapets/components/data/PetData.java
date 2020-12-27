package net.lldv.llamapets.components.data;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.utils.DyeColor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.lldv.llamapets.components.data.entities.Pet;
import net.lldv.llamapets.components.data.entities.passive.SheepPet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class PetData {

    public static final HashMap<String, Pet> currentPet = new HashMap<>();
    public static final HashMap<String, PetData> playerPetData = new HashMap<>();
    public static final LinkedHashMap<String, Double> cachedPetList = new LinkedHashMap<>();

    private final String player;
    private final List<String> ownedPets;
    private final String pet;
    private final List<String> petData;

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Meta {

        private final String entity;
        private String name;
        private boolean baby;
        private DyeColor color;

        public void create(final Player player) {
            final Pet entity = (Pet) Entity.createEntity(this.entity, player);

            entity.follow(player);
            entity.setNameTag(this.name);
            entity.spawnToAll();

            if (entity instanceof SheepPet) {
                SheepPet pet = (SheepPet) entity;
                pet.setColor(this.color.getWoolData());
            }

            PetData.currentPet.put(player.getName(), entity);
        }

    }

    public static class Type {

        /*
         * Passive pets
         */
        public static final String
                BEE_PET = "bee_pet",
                CAT_PET = "cat_pet",
                CHICKEN_PET = "chicken_pet",
                COW_PET = "cow_pet",
                DOLPHIN_PET = "dolphin_pet",
                DONKEY_PET = "donkey_pet",
                FOX_PET = "fox_pet",
                HORSE_PET = "horse_pet",
                LLAMA_PET = "llama_pet",
                MOOSHROOM_PET = "mooshroom_pet",
                MULE_PET = "mule_pet",
                OCELOT_PET = "ocelot_pet",
                PANDA_PET = "panda_pet",
                PIG_PET = "pig_pet",
                POLARBEAR_PET = "polarbear_pet",
                RABBIT_PET = "rabbit_pet",
                SHEEP_PET = "sheep_pet",
                SNOWGOLEM_PET = "snowgolem_pet",
                STRIDER_PET = "strider_pet",
                TURTLE_PET = "turtle_pet",
                VILLAGER_PET = "villager_pet",
                WOLF_PET = "wolf_pet";

        /*
         * Hostile pets
         */
        public static final String
                BLAZE_PET = "blaze_pet",
                CAVESPIDER_PET = "cavespider_pet",
                CREEPER_PET = "creeper_pet",
                DROWNED_PET = "drowned_pet",
                ELDERGUARDIAN_PET = "elderguardian_pet",
                ENDERMAN_PET = "enderman_pet",
                ENDERMITE_PET = "endermite_pet",
                EVOKER_PET = "evoker_pet",
                GHAST_PET = "ghast_pet",
                GUARDIAN_PET = "guardian_pet",
                HOGLIN_PET = "hoglin_pet",
                HUSK_PET = "husk_pet",
                PHANTOM_PET = "phantom_pet",
                PIGLIN_PET = "piglin_pet",
                PILLAGER_PET = "pillager_pet",
                RAVAGER_PET = "ravager_pet",
                SILVERFISH_PET = "silverfish_pet",
                SKELETON_PET = "skeleton_pet",
                SPIDER_PET = "spider_pet",
                STRAY_PET = "stray_pet",
                VEX_PET = "vex_pet",
                VINDICATOR_PET = "vindicator_pet",
                WITCH_PET = "witch_pet",
                WITHERSKELETON_PET = "witherskeleton_pet",
                ZOGLIN_PET = "zoglin_pet",
                ZOMBIE_PET = "zombie_pet",
                ZOMBIEPIGMAN_PET = "zombiepigman_pet",
                ZOMBIEVILLAGER_PET = "zombievillager_pet";

        /*
         * Data keys
         */
        public static final String
                NAME_KEY = "name",
                BABY_KEY = "baby",
                COLOR_KEY = "color";

    }

}
