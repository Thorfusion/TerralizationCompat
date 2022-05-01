package com.thorfusion.terralizationcompat;


import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import com.jadarstudios.developercapes.DevCapes;


@Mod(modid = TerralizationCompat.MODID, name = TerralizationCompat.NAME, version = TerralizationCompat.VERSION)

public class TerralizationCompat{
    public static final String NAME = "TerralizationCompat";
    public static final String MODID = "terralizationcompat";
    public static final String VERSION = "GRADLE_MODVERSION";

    public static boolean isMekanismLoaded;
    public static boolean isImmersiveLoaded;
    public static boolean isThorfusionLoaded;
    /*
    //Adds creative tab
    public static CreativeTabs tabTitanpower = new CreativeTabs("tabTitanpower") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(TitanpowerItems.TerralizationCreative).getItem();
        }
    };
    */

    @Mod.Instance
    public static TerralizationCompat instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        isMekanismLoaded = Loader.isModLoaded("Mekanism");
        isImmersiveLoaded = Loader.isModLoaded("ImmersiveEngineering");
        isImmersiveLoaded = Loader.isModLoaded("thorfusion");
        TerralizationConfig.init();
        if (isMekanismLoaded & isImmersiveLoaded) {
            System.out.println("Initialization of Mekanism and Immersive engineering compat");
            TerralizationMekanismImmersiveRecipes.init();
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if (TerralizationConfig.EnableCapes & !isThorfusionLoaded) {
            //proxy, tilentity
            if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
                try {
                    DevCapes.getInstance().registerConfig("https://raw.githubusercontent.com/maggi373/files/main/capes/cape.json");
                } catch (Exception e)
                {
                    System.out.print("Failed to load capes\n"+e);
                }
            }
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if(isMekanismLoaded) {
            TerralizationMekanismImmersiveRecipes.postinit();
        }

    }
}
