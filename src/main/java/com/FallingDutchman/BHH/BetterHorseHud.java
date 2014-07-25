package com.FallingDutchman.BHH;

import com.FallingDutchman.BHH.References.Reference;
import com.FallingDutchman.BHH.proxy.IProxy;
import com.FallingDutchman.BHH.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BetterHorseHud
{
    @Mod.Instance
    public static BetterHorseHud instance;

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        LogHelper.info("Init");
    }
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS)
    public static IProxy proxy;

}
