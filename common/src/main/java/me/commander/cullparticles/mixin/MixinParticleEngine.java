package me.commander.cullparticles.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.commander.cullparticles.MixinHooks;
import net.minecraft.client.Camera;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.MultiBufferSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ParticleEngine.class)
public class MixinParticleEngine {
    @Redirect(method = "renderParticleType", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/particle/Particle;render(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lnet/minecraft/client/Camera;F)V"))
    private static void cullParticles(Particle instance, VertexConsumer vertexConsumer, Camera camera, float v) {
        MixinHooks.cullParticles(instance, vertexConsumer, camera, v);
    }

    @Redirect(method = "renderCustomParticles", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/particle/Particle;renderCustom(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/Camera;F)V"))
    private static void cullParticles(Particle instance, PoseStack poseStack, MultiBufferSource bufferSource, Camera camera, float partialTick) {
        MixinHooks.cullParticles(instance, poseStack, bufferSource, camera, partialTick);
    }
}
