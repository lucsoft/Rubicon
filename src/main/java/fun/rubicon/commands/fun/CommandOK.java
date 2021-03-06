package fun.rubicon.commands.fun;

import fun.rubicon.command.CommandCategory;
import fun.rubicon.command.CommandHandler;
import fun.rubicon.command.CommandManager;
import fun.rubicon.data.PermissionLevel;
import fun.rubicon.data.PermissionRequirements;
import fun.rubicon.data.UserPermissions;
import net.dv8tion.jda.core.entities.Message;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Yannick Seeger / ForYaSee
 */
public class CommandOK extends CommandHandler {

    public CommandOK() {
        super(new String[]{"ok", "okay", "k", "mkay"}, CommandCategory.FUN, new PermissionRequirements(PermissionLevel.EVERYONE, "command.ok"), "OK", "This command makes no sense :(");
    }

    @Override
    protected Message execute(CommandManager.ParsedCommandInvocation parsedCommandInvocation, UserPermissions userPermissions) {
        String[] urls = new String[]{"http://gph.is/1skTTcz", "https://media.giphy.com/media/dykJfX4dbM0Vy/giphy.gif", "https://media.giphy.com/media/3ov9k01Y5IKizNmC7S/giphy.gif", "https://media.giphy.com/media/ylyUQm2pCWo5yLfFEQ/giphy.gif", "https://media.giphy.com/media/GCvktC0KFy9l6/giphy.gif", "https://media.giphy.com/media/lgRNj0m1oORfW/giphy.gif", "https://media.giphy.com/media/l3fQf1OEAq0iri9RC/giphy.gif"};
        int rand = ThreadLocalRandom.current().nextInt(0, urls.length );
        parsedCommandInvocation.getMessage().getTextChannel().sendMessage(urls[rand]).queue();
        return null;
    }
}
