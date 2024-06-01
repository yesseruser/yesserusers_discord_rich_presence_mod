package cz.yesseruser.discordrpc.neoforge;

import net.neoforged.fml.common.Mod;

import cz.yesseruser.discordrpc.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
