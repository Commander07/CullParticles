package me.commander.cullparticles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.MultiBufferSource;

public class MixinHooks {
    public static final Minecraft mc = Minecraft.getInstance();
    public static void cullParticles(Particle particle, VertexConsumer consumer, Camera camera, float deltaTime) {
        if (((Capture)mc.levelRenderer).cullParticles$capturedFrustum().isVisible(particle.getBoundingBox()))
            particle.render(consumer,camera,deltaTime);
    }

    public static void cullParticles(Particle particle, PoseStack poseStack, MultiBufferSource bufferSource, Camera camera, float partialTick) {
        if (((Capture)mc.levelRenderer).cullParticles$capturedFrustum().isVisible(particle.getBoundingBox()))
            particle.renderCustom(poseStack, bufferSource, camera, partialTick);
    }
}