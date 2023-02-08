package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.utils.InputService;
import br.com.keemy.filemanager.utils.StringUtils;

public class CmdListImg extends Command {

    public CmdListImg(String  arguments) {
        super(arguments);
    }

    @Override
    public void execute() {

        Global.handlerFile.listarImagens(Global.currentDir);

    }

    @Override
    public String helpMenu() {
        return "# " + StringUtils.formatBlue("LISTIMG") + ":\tList of Images\n;end;";
    }
}
