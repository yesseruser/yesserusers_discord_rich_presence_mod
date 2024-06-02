package cz.yesseruser.discordrpc;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import com.mojang.logging.LogUtils;
import dev.architectury.event.events.client.ClientTickEvent;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;

public final class ExampleMod {
    public static final String MOD_ID = "yesserusers_discord_rich_presence_mod";
    public static final Logger LOGGER = LogUtils.getLogger();

    // L is not part of the ID, it states the number is of type long.
    public static final String DISCORD_CLIENT_ID = "1246435446838399037";

    public static final DiscordRPC RPC_LIB = DiscordRPC.INSTANCE;
    public static final long START_TIMESTAMP = System.currentTimeMillis() / 1000;

    public static void init() {
        RPC_LIB.Discord_Initialize(DISCORD_CLIENT_ID, new DiscordEventHandlers(), true, "");

        // Write common init code here.
        ClientTickEvent.CLIENT_POST.register((MinecraftClient client) -> {
            LOGGER.info("Tick");

            DiscordRichPresence presence = new DiscordRichPresence();
            presence.startTimestamp = START_TIMESTAMP;

            presence.details = "Testing...";
            // TODO: Add presence logic here...

            RPC_LIB.Discord_UpdatePresence(presence);
            RPC_LIB.Discord_RunCallbacks();
        });
    }
}
