package com.github.kanyefan30.autoggmod;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;

import java.util.Collection;

public class ScoreboardReader {
    private static final String emojiRegex = "[\\uD83D\\uDD2B\\uD83C\\uDF6B\\uD83D\\uDCA3\\uD83D\\uDC7D\\uD83D\\uDD2E\\uD83D\\uDC0D\\uD83D\\uDC7E\\uD83C\\uDF20\\uD83C\\uDF6D\\u26BD\\uD83C\\uDFC0\\uD83D\\uDC79\\uD83C\\uDF81\\uD83C\\uDF89\\uD83C\\uDF82]+";
    private static final String colorRegex = "(\\u00A7.)+";

    public static String getScoreboard() {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.theWorld == null || mc.thePlayer == null) return null;

        Scoreboard scoreboard = mc.theWorld.getScoreboard();
        if (scoreboard == null) return null;

        ScoreObjective objective = scoreboard.getObjectiveInDisplaySlot(1);
        if (objective == null) return null;

        StringBuilder contents = new StringBuilder(objective.getDisplayName()
                .replaceAll(emojiRegex, "")
                .replaceAll(colorRegex, "")
        );

        Collection<Score> scores = scoreboard.getSortedScores(objective);
        for (Score score : scores) {
            ScorePlayerTeam team = scoreboard.getPlayersTeam(score.getPlayerName());
            String scoreboardLine = ScorePlayerTeam.formatPlayerName(team, score.getPlayerName()).trim();
            contents.append(scoreboardLine
                    .replaceAll(emojiRegex, "")
                    .replaceAll(colorRegex, "")
            ).append(' ');
        }

        return contents.toString();
    }
}
