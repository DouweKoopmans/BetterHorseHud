package com.FallingDutchman.BHH.Client.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;


public class ModGui extends Gui
{
    private Minecraft mc;
    private boolean YesOrNo = false;

    public ModGui(Minecraft mc)
    {
        super();

        this.mc = mc;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderMountHealth(RenderGameOverlayEvent event)
    {
        if (event.type == ElementType.EXPERIENCE || event.type == ElementType.FOOD || event.type == ElementType.JUMPBAR )
        {
            YesOrNo = true;
        }

        if (!event.isCancelable() || !YesOrNo)return;

        if(this.mc.thePlayer.ridingEntity != null)
        {
            GuiIngameForge.renderFood = true;
        }

        if(GuiIngameForge.renderExperiance)
        {
            if(this.mc.thePlayer.ridingEntity instanceof EntityHorse)
            {
                GuiIngameForge.renderJumpBar = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
            }
        }
    }
}
