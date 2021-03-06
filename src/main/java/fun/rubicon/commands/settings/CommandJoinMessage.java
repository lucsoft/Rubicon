/*
 * Copyright (c) 2017 Rubicon Bot Development Team
 *
 * Licensed under the MIT license. The full license text is available in the LICENSE file provided with this project.
 */

package fun.rubicon.commands.settings;

import fun.rubicon.RubiconBot;
import fun.rubicon.command.CommandCategory;
import fun.rubicon.command.CommandHandler;
import fun.rubicon.command.CommandManager;
import fun.rubicon.data.PermissionLevel;
import fun.rubicon.data.PermissionRequirements;
import fun.rubicon.data.UserPermissions;
import fun.rubicon.util.EmbedUtil;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;

public class CommandJoinMessage extends CommandHandler {
    public CommandJoinMessage() {
        super(new String[]{"joinmsg", "joinmessage", "joinnachricht"}, CommandCategory.SETTINGS,
                new PermissionRequirements(PermissionLevel.WITH_PERMISSION, "command.joinmsg"),
                "Set the server's join message!", "<Message(%user% for username, %guild% for guildname)>");
    }

    @Override
    protected Message execute(CommandManager.ParsedCommandInvocation parsedCommandInvocation, UserPermissions userPermissions) {
        if (parsedCommandInvocation.getArgs().length <= 1)
            return createHelpMessage();
        String temp = "";
        for (int i = 0; i < parsedCommandInvocation.getArgs().length; i++) {
            temp += " " + parsedCommandInvocation.getArgs()[i];
        }
        if (temp.equals("disable")) {
            RubiconBot.getMySQL().updateGuildValue(parsedCommandInvocation.getMessage().getGuild(), "leavemsg", "0");
            return new MessageBuilder().setEmbed(EmbedUtil.success("Disabled", "Succesfully disabled joinmessages").build()).build();
        }
        RubiconBot.getMySQL().updateGuildValue(parsedCommandInvocation.getMessage().getGuild(), "joinmsg", temp.replaceFirst("null ", ""));
        String up = RubiconBot.getMySQL().getGuildValue(parsedCommandInvocation.getMessage().getGuild(), "joinmsg");
        return new MessageBuilder().setEmbed(new EmbedBuilder().setDescription(":white_check_mark:  Successfully set joinmessage to `" + up + "`!").build()).build();
    }
}