package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.models.MFile;
import br.com.keemy.filemanager.utils.StringUtils;

public class CmdRemoveImg extends Command {

    public CmdRemoveImg(String  arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        String fileName = getArguments();

        removeFile(MFileAnnotationType.IMAGE, fileName);
    }

    @Override
    public String helpMenu() {
        return "# "  + StringUtils.formatBlue("REMOVEIMG") + ": remove a image.\n" +
                StringUtils.formatYellow("     Syntax: REMOVEIMG [fileName]\n") +
                ";end;";
    }

    private void removeFile(MFileAnnotationType fileType, String fileName) {

        System.out.println("File type:" + fileType.name());

        MFile mFile = new MFile();
        mFile.setType(fileType);
        mFile.setPath(Global.currentDir);
        mFile.setFileName(fileName);

        if (Global.handlerFile.removerArquivo(mFile))
            System.out.println("File removed Successful!");

    }

}
