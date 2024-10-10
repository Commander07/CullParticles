package me.commander.cullparticles;

import net.minecraft.client.renderer.culling.Frustum;

public interface Capture {
    Frustum capturedFrustum();
}