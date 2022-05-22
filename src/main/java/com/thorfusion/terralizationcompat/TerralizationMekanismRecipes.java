package com.thorfusion.terralizationcompat;

import mekanism.api.ItemRetriever;
import mekanism.api.infuse.InfuseObject;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.recipe.RecipeHelper;
import mekanism.api.util.StackUtils;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;


public class TerralizationMekanismRecipes {
    public static void init() {
    }

    public static void postinit() {
    }

    public static void onServerAboutToStart() {
        if (TerralizationConfig.EnableQuartzCompat) {
            // Enrich quartz dust into quartz
            for (ItemStack ore : OreDictionary.getOres("dustQuartz")) {
                RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size(ore, 1), new ItemStack(Items.quartz));
            }
            for (ItemStack ore : OreDictionary.getOres("dustNetherQuartz")) {
                RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size(ore, 1), new ItemStack(Items.quartz));
            }
            // Enrich quartz ore into 2 quartz dust
            for (ItemStack ore : OreDictionary.getOres("dustQuartz")) {
                RecipeHelper.addEnrichmentChamberRecipe(new ItemStack(Blocks.quartz_ore), StackUtils.size(ore, 2));
            }
            for (ItemStack ore : OreDictionary.getOres("dustNetherQuartz")) {
                RecipeHelper.addEnrichmentChamberRecipe(new ItemStack(Blocks.quartz_ore), StackUtils.size(ore, 2));
            }
        }
        // Add gemdiamond oredict for compressed diamond
        if (TerralizationConfig.EnableDiamondCompat) {
            for (ItemStack ore : OreDictionary.getOres("gemDiamond")) {
                InfuseRegistry.registerInfuseObject(ore, new InfuseObject(InfuseRegistry.get("DIAMOND"), 10));
                RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size(ore, 1), ItemRetriever.getItem("CompressedDiamond"));
            }
        }
    }
}

