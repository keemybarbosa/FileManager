package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.utils.StringUtils;

public class CmdRecoveryImg extends Command {

    public CmdRecoveryImg(String arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        String fileName = getArguments();

        Global.handlerFile.abrirImagem(fileName);
    }

    @Override
    public String helpMenu() {
        return "# "  + StringUtils.formatBlue("RECOVERYIMG") + ": show a image file with default image program. \n" +
                StringUtils.formatYellow("     Syntax: RECOVERYIMG [fileName] \n") +
                ";end;";
    }
}
