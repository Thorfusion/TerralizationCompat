package com.thorfusion.terralizationcompat;

import mekanism.api.recipe.RecipeHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import blusunrize.immersiveengineering.common.IEContent;



public class TerralizationMekanismImmersiveRecipes {
    public static void init() {
        RecipeHelper.addEnrichmentChamberRecipe(new ItemStack(IEContent.itemMetal,1,18), new ItemStack(Items.quartz));
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
        // RecipeHelper.addMetallurgicInfuserRecipe(InfuseRegistry.get("OBSIDIAN"), 10, new ItemStack(TitanpowerItems.bludust), new ItemStack(TitanpowerItems.bluplate, 1));
    }
}

