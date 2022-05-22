package com.thorfusion.terralizationcompat;

import com.jadarstudios.developercapes.DevCapes;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = TerralizationCompat.MODID, name = TerralizationCompat.NAME, version = TerralizationCompat.VERSION, dependencies = "before:aobd;after:MineTweaker3;after:Mekanism;after:appliedenergistics2")

public class TerralizationCompat {
    public static final String NAME = "TerralizationCompat";
    public static final String MODID = "terralizationcompat";
    public static final String VERSION = "GRADLE_MODVERSION";

    public static boolean isMekanismLoaded;
    public static boolean isThorfusionLoaded;

    //Adds creative tab
    /*
    public static CreativeTabs tabTerralization = new CreativeTabs("tabTerralization") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(TerralizationItems.quartzdust ).getItem();
        }
    };
*/

    @Mod.Instance
    public static TerralizationCompat instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        isMekanismLoaded = Loader.isModLoaded("Mekanism");
        isThorfusionLoaded = Loader.isModLoaded("thorfusion");
        TerralizationConfig.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if (TerralizationConfig.EnableCapes & !isThorfusionLoaded) {
            //proxy, tilentity
            if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
                try {
                    DevCapes.getInstance().registerConfig("https://raw.githubusercontent.com/maggi373/files/main/capes/cape.json");
                } catch (Exception e) {
                    System.out.print("Failed to load capes\n" + e);
                }
            }
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        /*
        if(isMekanismLoaded) {
            TerralizationMekanismRecipes.postinit();
        }
        */
    }

    @Mod.EventHandler
    public void onServerAboutToStart(FMLServerAboutToStartEvent event) {
        if (isMekanismLoaded) {
            TerralizationMekanismRecipes.onServerAboutToStart();
        }
    }
}
