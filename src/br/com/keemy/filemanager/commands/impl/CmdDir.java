package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;

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
        return "dir: List files and directories!\n";
    }
}
