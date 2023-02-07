package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.utils.StringUtils;

public class CmdDir extends Command {

    public CmdDir(String arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        Global.handlerFile.listarArquivos(Global.currentDir);
    }

    @Override
    public String helpMenu() {
        return "# " + StringUtils.formatBlue("DIR") + ": List files and directories!\n;end;";
    }
}
