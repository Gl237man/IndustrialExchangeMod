package com.gl237.Iexchange;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class SFLEGeneratorMachieGui extends GuiContainer{

	private static SFLEGeneratorMachieTileEntity DisInventory;
	
	public SFLEGeneratorMachieGui(InventoryPlayer inventory, SFLEGeneratorMachieTileEntity tileEntity)
	{
		super (new SFLEGeneratorMachieContainer(inventory, tileEntity));
        this.DisInventory = tileEntity;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
            String s = this.DisInventory.isInvNameLocalized() ? this.DisInventory.getInventoryName() : StatCollector.translateToLocal(this.DisInventory.getInventoryName());
            this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
            this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		 this.mc.getTextureManager().bindTexture(new ResourceLocation("IexchangeMod", "textures/gui/SFgenGui.png"));
         int k = (this.width - this.xSize) / 2;
         int l = (this.height - this.ySize) / 2;
         this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
         int i1;

         if (true)
         {
                 //i1 = this.testInventory.getBurnTimeRemainingScaled(12);
        	     i1=12;
                 this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
         }

         //i1 = this.testInventory.getCookProgressScaled(24);
         i1 = 24;
         this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}

}
