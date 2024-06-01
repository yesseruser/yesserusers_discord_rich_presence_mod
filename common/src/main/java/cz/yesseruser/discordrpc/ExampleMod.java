package cz.yesseruser.discordrpc;

import com.mojang.logging.LogUtils;
import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.CreateParams;
import dev.architectury.event.events.client.ClientTickEvent;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;

public final class ExampleMod {
    public static final String MOD_ID = "yesserusers_discord_rich_presence_mod";
    public static final Logger LOGGER = LogUtils.getLogger();

    // L is not part of the ID, it states the number is of type long.
    public static final long DISCORD_CLIENT_ID = 1246435446838399037L;

    public static void init() {
        LOGGER.info("Creating params");
        /*try (*/CreateParams discordParams = new CreateParams();//) {
            LOGGER.info("Setting client ID");
            discordParams.setClientID(DISCORD_CLIENT_ID);
            LOGGER.info("Client ID set");
            discordParams.setFlags(CreateParams.getDefaultFlags());
            LOGGER.info("Flags set.");

            try (Core core = new Core(discordParams)) {

            }
        //}

        discordParams.close();


        // Write common init code here.
        ClientTickEvent.CLIENT_POST.register((MinecraftClient client) -> {
            LOGGER.info("Tick");
        });
    }
}
