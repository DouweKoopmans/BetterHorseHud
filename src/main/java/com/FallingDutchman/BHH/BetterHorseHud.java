package com.FallingDutchman.BHH;

import com.FallingDutchman.BHH.Client.Gui.ModGui;
import com.FallingDutchman.BHH.References.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BetterHorseHud
{
    @Mod.Instance
    public static BetterHorseHud instance;

    @EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ModGui(Minecraft.getMinecraft()));
    }
}
