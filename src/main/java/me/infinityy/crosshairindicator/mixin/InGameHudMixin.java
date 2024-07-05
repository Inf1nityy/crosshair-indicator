package me.infinityy.crosshairindicator.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Final @Shadow private MinecraftClient client;
    @Unique Identifier textureLocation = new Identifier("crosshairindicator", "crosshair.png");
    @Unique int textureWidth = 9;
    @Unique int textureHeight = 9;

    @Inject(method = "renderCrosshair", at = @At("RETURN"))
    private void drawCrosshair(DrawContext context, float tickDelta, CallbackInfo ci) {
        assert this.client.player != null;
        if (!this.client.player.isSpectator() && this.client.targetedEntity instanceof PlayerEntity) {
            context.drawTexture(this.textureLocation, (client.getWindow().getScaledWidth() - 9) / 2, (client.getWindow().getScaledHeight() - 9) / 2, 0, 0, this.textureWidth, this.textureHeight);
        }

    }
}
