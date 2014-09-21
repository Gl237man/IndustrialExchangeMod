package com.gl237.Iexchange;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opengl.GL11;

/**
 * Created by gl237 on 21.09.2014.
 */
public class MatterGeneratorMachineGui  extends GuiContainer {

    private static MatterGeneratorMachineTileEntity machieTileEntity;//Обявляем ентити инвентаря

    public MatterGeneratorMachineGui(InventoryPlayer inventory, MatterGeneratorMachineTileEntity tileEntity) {
        super(new MatterGeneratorMachineContainer(inventory, tileEntity));
        machieTileEntity = tileEntity;//загружаем ентити инвентаря
    }

    //Отрисовка переднего слоя
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String s = machieTileEntity.isInvNameLocalized() ? machieTileEntity.getInventoryName() : StatCollector.translateToLocal(machieTileEntity.getInventoryName());// Получаем имя инвентаря
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);//Отрисовываем имя
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);//отрисовываем имя инвентаря пользователя
    }

    //Отрисовка фона
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //Биндем текстуру инвентаря
        this.mc.getTextureManager().bindTexture(new ResourceLocation("iexchangemod", "textures/gui/MtgenGui.png"));
        //Рсчитываем наяальные точки для отрисовки инвентаря
        int startX = (this.width - this.xSize) / 2;
        int startY = (this.height - this.ySize) / 2;
        //Отрисовываем бекграунд
        this.drawTexturedModalRect(startX, startY, 0, 0, this.xSize, this.ySize);
        //int i1;

        /*
        //Сдесь будем отрисововать Прогресс работы машины
        if (true)
        {
        //i1 = this.testInventory.getBurnTimeRemainingScaled(12);
                i1=12;
                this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        //i1 = this.testInventory.getCookProgressScaled(24);
        i1 = 24;
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
        */

        //Отрисовываем жидкость
        drawFluid(machieTileEntity.getFluid(), startX + 106, startY + 19, 16, 58, machieTileEntity.getCapacity());
        //Перерисовываем шкалу
        this.mc.getTextureManager().bindTexture(new ResourceLocation("iexchangemod", "textures/gui/SFgenGui.png"));
        this.drawTexturedModalRect(startX + 106, startY + 19, 176, 0, 16, 58);
        //Отрисовываем стрелочку
        float ost = 24.0f / (float) machieTileEntity.ProgressMax * (float) machieTileEntity.Progress;
        this.drawTexturedModalRect(startX + 75, startY + 39, 192, 0, (int) ost, 58);
    }

    public void drawFluid(FluidStack fluid, int x, int y, int width, int height, int maxCapacity) {
        if (fluid == null || fluid.getFluid() == null) {
            return;
        }
        IIcon icon = fluid.getFluid().getIcon(fluid);
        mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
        setGLColorFromInt(fluid.getFluid().getColor(fluid));
        int fullX = width / 16;
        int fullY = height / 16;
        int lastX = width - fullX * 16;
        int lastY = height - fullY * 16;
        int level = fluid.amount * height / maxCapacity;
        int fullLvl = (height - level) / 16;
        int lastLvl = (height - level) - fullLvl * 16;
        for (int i = 0; i < fullX; i++) {
            for (int j = 0; j < fullY; j++) {
                if (j >= fullLvl) {
                    drawCutIcon(icon, x + i * 16, y + j * 16, 16, 16, j == fullLvl ? lastLvl : 0);
                }
            }
        }
        for (int i = 0; i < fullX; i++) {
            drawCutIcon(icon, x + i * 16, y + fullY * 16, 16, lastY, fullLvl == fullY ? lastLvl : 0);
        }
        for (int i = 0; i < fullY; i++) {
            if (i >= fullLvl) {
                drawCutIcon(icon, x + fullX * 16, y + i * 16, lastX, 16, i == fullLvl ? lastLvl : 0);
            }
        }
        drawCutIcon(icon, x + fullX * 16, y + fullY * 16, lastX, lastY, fullLvl == fullY ? lastLvl : 0);
    }

    //Хитрая функция отрисовки обрезанной иконки
    //The magic is here
    private void drawCutIcon(IIcon icon, int x, int y, int width, int height, int cut) {
        Tessellator tess = Tessellator.instance;
        tess.startDrawingQuads();
        tess.addVertexWithUV(x, y + height, zLevel, icon.getMinU(), icon.getInterpolatedV(height));
        tess.addVertexWithUV(x + width, y + height, zLevel, icon.getInterpolatedU(width), icon.getInterpolatedV(height));
        tess.addVertexWithUV(x + width, y + cut, zLevel, icon.getInterpolatedU(width), icon.getInterpolatedV(cut));
        tess.addVertexWithUV(x, y + cut, zLevel, icon.getMinU(), icon.getInterpolatedV(cut));
        tess.draw();
    }

    private static void setGLColorFromInt(int color) {
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;
        GL11.glColor4f(red, green, blue, 1.0F);
    }

}
