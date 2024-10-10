package me.commander.cullparticles;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class CullParticles {

    public CullParticles(IEventBus eventBus) {
        CommonClass.init();

    }
}