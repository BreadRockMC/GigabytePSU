package io.github.breadrockmc.gigabyte.gigabytepsu;

import io.github.breadrockmc.gigabyte.gigabytepsu.blocks.PSU;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricModLoader implements ModInitializer {
    public static final PSU psu = new PSU(FabricBlockSettings.of(Material.METAL).strength(6).ticksRandomly());

    @Override
    public void onInitialize() {
        Identifier psuID = new Identifier("gigabyte", "psu");
        Registry.register(Registry.BLOCK, psuID, psu);
        Registry.register(Registry.ITEM, psuID, new BlockItem(psu, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    }
}
