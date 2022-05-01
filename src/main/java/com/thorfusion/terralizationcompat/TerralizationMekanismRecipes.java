package com.thorfusion.terralizationcompat;

import mekanism.api.ItemRetriever;
import mekanism.api.infuse.InfuseObject;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.recipe.RecipeHelper;
import mekanism.api.util.StackUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;


public class TerralizationMekanismRecipes {
    public static void init() {
        for (ItemStack ore : OreDictionary.getOres("dustQuartz")) {
            RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size(ore, 1), new ItemStack(Items.quartz));
        }
        /*
        if(TitanpowerConfig.EnableBluArmor) {
            GameRegistry.addRecipe(new ItemStack(TitanpowerArmour.Bluchest), new Object[]{"oxo", "ooo", "ooo", 'o', TitanpowerItems.bluplate});
            GameRegistry.addRecipe(new ItemStack(TitanpowerArmour.Bluhat), new Object[]{"ooo", "oxo", "xxx", 'o', TitanpowerItems.bluplate});
            GameRegistry.addRecipe(new ItemStack(TitanpowerArmour.Bluleggings), new Object[]{"ooo", "oxo", "oxo", 'o', TitanpowerItems.bluplate});
            GameRegistry.addRecipe(new ItemStack(TitanpowerArmour.Bluboots), new Object[]{"xxx", "oxo", "oxo", 'o', TitanpowerItems.bluplate});
        }
        */
    }

    public static void postinit() {
        ItemStack CompressedDiamond = ItemRetriever.getItem("CompressedDiamond");
        // RecipeHelper.addMetallurgicInfuserRecipe(InfuseRegistry.get("OBSIDIAN"), 10, new ItemStack(TitanpowerItems.bludust), new ItemStack(TitanpowerItems.bluplate, 1));
        {
            for (ItemStack ore : OreDictionary.getOres("gemDiamond")) {
                InfuseRegistry.registerInfuseObject(ore, new InfuseObject(InfuseRegistry.get("DIAMOND"), 10));
                RecipeHelper.addEnrichmentChamberRecipe(StackUtils.size(ore, 1), new ItemStack(CompressedDiamond));
            }
        }
    }
}

