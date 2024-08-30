package com.github.kanyefan30.autoggmod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoGGHandler {
    private final Minecraft mc = Minecraft.getMinecraft();
    private boolean gameEnded = false;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (mc.theWorld == null || mc.thePlayer == null) return;
        String scoreboardText = ScoreboardReader.getScoreboard();
        if (scoreboardText != null && scoreboardText.contains("Game ended!") && !gameEnded) {
            mc.thePlayer.sendChatMessage("/achat gg");
            gameEnded = true;
        } else if (scoreboardText != null && !scoreboardText.contains("Game ended!")) {
            gameEnded = false;
        }
    }
}
