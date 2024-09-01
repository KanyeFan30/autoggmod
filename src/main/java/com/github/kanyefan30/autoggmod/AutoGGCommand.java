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
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Current autogg message is set to §3" + AutoGGConfig.getMessage()));
        } else {
            if (Objects.equals(args[0], "reset")) {
                AutoGGConfig.resetMessage();
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Autogg message set to §3gg"));
            } else if (Objects.equals(args[0], "help")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Usage:"));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Change message: §r/autogg §3<message>"));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Reset message: §r/autogg §3reset"));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Get current message: §r/autogg"));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Display this message: §r/autogg §3help"));
            } else {
                StringBuilder newMessage = new StringBuilder();
                for (String arg : args) {
                    newMessage.append(arg);
                    newMessage.append(" ");
                }
                AutoGGConfig.setMessage(String.valueOf(newMessage));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Autogg message set to §3" + AutoGGConfig.getMessage()));
            }
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
