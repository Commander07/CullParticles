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
    @Unique private Frustum cullParticles$frustum;

    @ModifyVariable(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/LevelRenderer;setupRender(Lnet/minecraft/client/Camera;Lnet/minecraft/client/renderer/culling/Frustum;ZZ)V"))
    private Frustum captureFrustum(Frustum frustum2) {
        return cullParticles$frustum = frustum2;
    }

    @Unique
    public Frustum cullParticles$capturedFrustum() {
        return cullParticles$frustum;
    }
}
