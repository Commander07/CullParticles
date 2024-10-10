package me.commander.cullparticles;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;

public class MixinHooks {
    public static final Minecraft mc = Minecraft.getInstance();
    public static void cullParticles(Particle particle, VertexConsumer consumer, Camera camera, float deltaTime) {
        if (((Capture)mc.levelRenderer).capturedFrustum().isVisible(particle.getBoundingBox()))
            particle.render(consumer,camera,deltaTime);
    }
}