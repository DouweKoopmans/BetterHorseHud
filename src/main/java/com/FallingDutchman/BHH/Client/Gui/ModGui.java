package com.FallingDutchman.BHH.Client.Gui;

import java.util.Collection;
import java.util.Iterator;

import com.FallingDutchman.BHH.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.FoodStats;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.opengl.GL11;

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
        Entity entity = this.mc.thePlayer.ridingEntity;
        if (entity != null && event.type == ElementType.HEALTHMOUNT)
        {
            event.setCanceled(true);
            GuiIngameForge.renderFood = true;
        }
        if(this.mc.thePlayer.ridingEntity != null)
        {
            GuiIngameForge.renderFood = true;
        }
        //
        // We draw after the ExperienceBar has drawn.  The event raised by GuiIngameForge.pre()
        // will return true from isCancelable.  If you call event.setCanceled(true) in
        // that case, the portion of rendering which this event represents will be canceled.
        // We want to draw *after* the experience bar is drawn, so we make sure isCancelable() returns
        // false and that the eventType represents the ExperienceBar event.
        if(entity == null || event.type != ElementType.HEALTHMOUNT)
        {
            return;
        }

        int FoodHeight = 20;
        int FoodWidth = screenWidth/2 - 10;
        int icon = 16;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.mc.getTextureManager().bindTexture(icons);

        if(entity != null)
            this.drawTexturedModalRect(FoodWidth, FoodHeight, icon + 54, BUFF_ICON_BASE_V_OFFSET, BUFF_ICON_SIZE, BUFF_ICON_SIZE);
    }
}
