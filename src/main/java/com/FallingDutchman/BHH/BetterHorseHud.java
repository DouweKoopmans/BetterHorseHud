package com.FallingDutchman.BHH;

import com.FallingDutchman.BHH.Client.Gui.ModGui;
import com.FallingDutchman.BHH.References.Reference;
import com.FallingDutchman.BHH.proxy.CommonProxy;
import com.FallingDutchman.BHH.proxy.IProxy;
import com.FallingDutchman.BHH.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.GuiIngameForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BetterHorseHud
{
    @Mod.Instance
    public static BetterHorseHud instance;

    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ModGui(Minecraft.getMinecraft()));
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        LogHelper.info("Init");
        proxy.registerRenderers();
    }

    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("post init");
    }

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

}
