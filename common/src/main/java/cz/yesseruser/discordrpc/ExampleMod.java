package cz.yesseruser.discordrpc;

import com.mojang.logging.LogUtils;
import de.jcm.discordgamesdk.CreateParams;
import dev.architectury.event.events.client.ClientGuiEvent;
import dev.architectury.event.events.common.TickEvent;
import dev.architectury.hooks.client.screen.ScreenAccess;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import org.slf4j.Logger;

public final class ExampleMod {
    public static final String MOD_ID = "yesserusers_discord_rich_presence_mod";
    public static final Logger LOGGER = LogUtils.getLogger();

    // L is not part of the ID, it states the number is of type long.
    public static final long DISCORD_CLIENT_ID = 1246435446838399037L;

    public static void init() {
        try (CreateParams discordParams = new CreateParams()) {
            discordParams.setClientID(DISCORD_CLIENT_ID);
        }


        // Write common init code here.
        TickEvent.PLAYER_POST.register((PlayerEntity player) -> {
            LOGGER.info("Tick");
        });

        ClientGuiEvent.INIT_POST.register((Screen screen, ScreenAccess access) -> {

        });
    }
}
