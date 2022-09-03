package com.thorfusion.terralizationcompat;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class TerralizationConfig {
    public static boolean EnableQuartzCompat;
    public static boolean EnableDiamondCompat;
    public static boolean EnableCapes;
    public static boolean EnablePoorOresCompat;

    public static void init() {
        Configuration config;
        //this line either creates the file if it doesn't exist or opens it if it already exists.
        config = new Configuration(new File("config/Terralization.cfg"));
        config.load();//reads the contents of the file into the Configuration object.

        //General
        EnableCapes = config.get("General", "Capes", true).getBoolean();
        EnableQuartzCompat = config.get("General", "QuartzCompat", true).getBoolean();
        EnableDiamondCompat = config.get("General", "DiamondCompat", true).getBoolean();
        EnablePoorOresCompat = config.get("General", "PoorOresCompat", true).getBoolean();
        try {
            config.save();//saves the Configuration content into the file.
        } catch (Exception e) {
            System.out.print("Could't save changes to the config file\n" + e);
        }
    }
}
