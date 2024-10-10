package me.commander.cullparticles.mixin;

import me.commander.cullparticles.Capture;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LevelRenderer.class)
public class MixinLevelRenderer implements Capture {
    @Unique private Frustum frustum;

    @ModifyVariable(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/FogRenderer;setupColor(Lnet/minecraft/client/Camera;FLnet/minecraft/client/multiplayer/ClientLevel;IF)V"))
    private Frustum captureFrustum(Frustum frustum2) {
        return frustum = frustum2;
    }

    @Override
    public Frustum capturedFrustum() {
        return frustum;
    }
}
