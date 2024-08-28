package com.github.kanyefan30.autoggmod;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Collection;

public class AutoGGMod {
    private final Minecraft mc = Minecraft.getMinecraft();
    private boolean gameEnded = false;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (mc.theWorld != null && mc.thePlayer != null) {
            Scoreboard scoreboard = mc.theWorld.getScoreboard();
            ScoreObjective objective = scoreboard.getObjectiveInDisplaySlot(1);

            if (objective != null) {
                Collection<Score> scores = scoreboard.getScores();
                for (Score score : scores) {
                    String lineText = score.getPlayerName();
                    if (lineText.equals("Game ended!") && !gameEnded) {
                        mc.thePlayer.sendChatMessage("/achat gg");
                        gameEnded = true;
                        break;
                    } else if (!lineText.equals("Game ended!")) {
                        gameEnded = false;
                    }
                }
            }
        }
    }
}
