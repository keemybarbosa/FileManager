package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.utils.InputService;
import br.com.keemy.filemanager.utils.StringUtils;

public class CmdRemoveDir extends Command {

    public CmdRemoveDir(String  arguments) {
        super(arguments);
    }

    @Override
    public void execute() {

        String dir = getArguments();
        String fullPath = Global.currentDir + dir;

        if (Global.handlerFile.removerDiretorio(fullPath)){
            System.out.printf("Directory %s removed successfully!%n", dir);
        }
    }

    @Override
    public String helpMenu() {
        return "# "  + StringUtils.formatBlue("REMOVEDIR") + ": remove a directory.\n" +
                StringUtils.formatYellow("     Syntax: REMOVEDIR [directory]\n") +
                ";end;";
    }
}
