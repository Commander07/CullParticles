package me.commander.cullparticles.mixin;

import com.mojang.blaze3d.vertex.VertexConsumer;
import me.commander.cullparticles.MixinHooks;
import net.minecraft.client.Camera;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ParticleEngine.class)
public class MixinParticleEngine {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/particle/Particle;render(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lnet/minecraft/client/Camera;F)V"))
    public void cullParticles(Particle instance, VertexConsumer vertexConsumer, Camera camera, float v) {
        MixinHooks.cullParticles(instance,vertexConsumer,camera,v);
    }
}
