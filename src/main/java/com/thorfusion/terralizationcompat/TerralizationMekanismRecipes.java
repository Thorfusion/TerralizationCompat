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
        /*
        for (ItemStack ore : OreDictionary.getOres("dustQuartz")) {
            RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size(ore, 1), new ItemStack(Items.quartz));
        }

        if(TitanpowerConfig.EnableBluArmor) {
            GameRegistry.addRecipe(new ItemStack(TitanpowerArmour.Bluchest), new Object[]{"oxo", "ooo", "ooo", 'o', TitanpowerItems.bluplate});
            GameRegistry.addRecipe(new ItemStack(TitanpowerArmour.Bluhat), new Object[]{"ooo", "oxo", "xxx", 'o', TitanpowerItems.bluplate});
            GameRegistry.addRecipe(new ItemStack(TitanpowerArmour.Bluleggings), new Object[]{"ooo", "oxo", "oxo", 'o', TitanpowerItems.bluplate});
            GameRegistry.addRecipe(new ItemStack(TitanpowerArmour.Bluboots), new Object[]{"xxx", "oxo", "oxo", 'o', TitanpowerItems.bluplate});
        }
        */
    }

    public static void postinit() {
        /*
        // RecipeHelper.addMetallurgicInfuserRecipe(InfuseRegistry.get("OBSIDIAN"), 10, new ItemStack(TitanpowerItems.bludust), new ItemStack(TitanpowerItems.bluplate, 1));
        {
            for (ItemStack ore : OreDictionary.getOres("gemDiamond")) {
                InfuseRegistry.registerInfuseObject(ore, new InfuseObject(InfuseRegistry.get("DIAMOND"), 10));
                RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size(ore, 1), ItemRetriever.getItem("CompressedDiamond"));
            }
        }
        */
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
            // Enrich quartz ore into 2 quartz dust'
            for (ItemStack ore : OreDictionary.getOres("dustQuartz")) {
                RecipeHelper.addEnrichmentChamberRecipe(new ItemStack(Blocks.quartz_ore), StackUtils.size(ore, 2));
            }
            for (ItemStack ore : OreDictionary.getOres("dustNetherQuartz")) {
                RecipeHelper.addEnrichmentChamberRecipe(new ItemStack(Blocks.quartz_ore), StackUtils.size(ore, 2));
            }
        }


            /*
            RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size((new ItemStack(Blocks.quartz_ore), 1), new (ItemStack ore : OreDictionary.getOres("dustQuartz"));
            for (ItemStack ore : OreDictionary.getOres("dustDirtyQuartz") & (ItemStack or2 : OreDictionary.getOres("dustDirtyQuartz")) {
                RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size(ore, 1), or2);
            } Applied-Energistics-2-Unofficial/src/main/java/appeng/items/materials/ItemMultiMaterial.java
            */
        // Add gemdiamond oredict for compressed diamond
        if (TerralizationConfig.EnableDiamondCompat) {
            for (ItemStack ore : OreDictionary.getOres("gemDiamond")) {
                InfuseRegistry.registerInfuseObject(ore, new InfuseObject(InfuseRegistry.get("DIAMOND"), 10));
                RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size(ore, 1), ItemRetriever.getItem("CompressedDiamond"));
            }
        }

    }
}

