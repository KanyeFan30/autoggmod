package com.github.kanyefan30.autoggmod;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.Objects;

public class AutoGGCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "autogg";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Current autogg message is set to §3" + AutoGGConfig.getMessage()));
        } else if (args.length == 1) {
            if (Objects.equals(args[0], "reset")) {
                AutoGGConfig.resetMessage();
            } else {
                AutoGGConfig.setMessage(args[0]);
            }
        } else {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Usage:"));
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Change message: §r/autogg §3<message>"));
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Reset message: §r/autogg §3reset"));
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Get current message: §r/autogg"));
        }
    }
}
