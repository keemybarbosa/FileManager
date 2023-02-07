package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.utils.StringUtils;

public class CmdMkDir extends Command {

    public CmdMkDir(String  arguments) {
        super(arguments);
    }

    @Override
    public void execute() {

        String dir = getArguments();
        String fullPath = Global.currentDir + dir;

        if (Global.handlerFile.criarDiretorio(fullPath)){
            System.out.printf("Directory %s created successfully!%n", dir);
        }
    }

    @Override
    public String helpMenu() {
        return "# "  + StringUtils.formatBlue("MKDIR") + ": create a directory.\n" +
                StringUtils.formatYellow("     Syntax: MKDIR [directory]\n") +
                ";end;";
    }
}
