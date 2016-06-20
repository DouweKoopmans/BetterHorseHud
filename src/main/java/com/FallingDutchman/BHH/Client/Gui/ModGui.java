package com.FallingDutchman.BHH.Client.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
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

    @SubscribeEvent()
    public void onRenderMountHealth(RenderGameOverlayEvent event)
    {
        if (event.getType() == ElementType.EXPERIENCE || event.getType() == ElementType.FOOD
                || event.getType() == ElementType.JUMPBAR )
        {
            YesOrNo = true;
        }

        if (!event.isCancelable() || !YesOrNo)return;

        if(this.mc.thePlayer.isRiding())
        {
            GuiIngameForge.renderFood = true;
        }

        if(GuiIngameForge.renderExperiance)
        {
            if(this.mc.thePlayer.isRidingHorse())
            {
                GuiIngameForge.renderJumpBar = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
            }
        }
    }
}
