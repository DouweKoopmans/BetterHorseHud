package com.FallingDutchman.BHH.Client.Gui;

import com.FallingDutchman.BHH.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.input.Keyboard;


public class ModGui extends Gui
{
    private Minecraft mc;
    public Entity ridingEntity;
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
        if(this.mc.thePlayer.ridingEntity instanceof EntityHorse)
        {
            if (!Keyboard.isKeyDown(Keyboard.KEY_SPACE) && event.type == ElementType.JUMPBAR )
            {
                LogHelper.info("spacebar not held down and element type = jumpbar");
                event.setCanceled(true);
                GuiIngameForge.renderJumpBar = false;
                GuiIngameForge.renderExperiance = true;
            } else if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
            {
                LogHelper.info("Spacebar is held down");
                if (event.type == ElementType.JUMPBAR)
                {
                    GuiIngameForge.renderJumpBar = true;
                    LogHelper.info("JumpBar is rendered");
                }
            }
            if (event.type == ElementType.EXPERIENCE)
            {
                event.setCanceled(false);
                GuiIngameForge.renderExperiance = true;
            }
        }
    }
}
