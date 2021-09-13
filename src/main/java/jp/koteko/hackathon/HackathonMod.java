package jp.koteko.hackathon;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HackathonMod.MOD_ID)
public class HackathonMod
{
    //MOD ID name
    public static final String MOD_ID = "hackathon";

    public HackathonMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Blocks.register(modEventBus);
        Items.register(modEventBus);
    }


    public static class Blocks {
        private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
        public static final RegistryObject<Block> DETHBOX_BLOCK = BLOCKS.register("dethbox_block", () -> new Block(AbstractBlock.Properties
                .create(Material.IRON)
                .setRequiresTool()
                .hardnessAndResistance(5.0F, 6.0F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(1)
        ));

        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }
    }

    public static class Items {
        private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
        public static final RegistryObject<Item> DETHBOX_BLOCK = ITEMS.register("dethbox_block", () -> new BlockItem(Blocks.DETHBOX_BLOCK.get(), new Item.Properties()
                .group(ItemGroup.BUILDING_BLOCKS)));

        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
    }
}