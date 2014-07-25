package com.FallingDutchman.BHH;

import com.FallingDutchman.BHH.References.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BetterHorseHud
{
    @Mod.Instance
    public static BetterHorseHud instance;

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {

    }

}
