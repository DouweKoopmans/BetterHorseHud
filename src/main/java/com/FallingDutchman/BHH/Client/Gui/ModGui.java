package com.FallingDutchman.BHH.Client.Gui;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;


//
// GuiBuffBar implements a simple status bar at the top of the screen which
// shows the current buffs/debuffs applied to the character.
//
public class ModGui extends Gui
{
    private Minecraft mc;

    public ModGui(Minecraft mc)
    {
        super();

        this.mc = mc;
    }

    //
    // This event is called by GuiIngameForge during each frame by
    // GuiIngameForge.pre() and GuiIngameForce.post().
    //
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderMountHealth(RenderGameOverlayEvent event)
    {
        if(this.mc.thePlayer.ridingEntity != null)
        {
            GuiIngameForge.renderFood = true;
        }
    }
}
