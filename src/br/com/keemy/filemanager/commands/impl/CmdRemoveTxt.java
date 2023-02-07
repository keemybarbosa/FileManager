package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.models.MFile;
import br.com.keemy.filemanager.utils.InputService;

import java.util.Scanner;

public class CmdRemoveTxt extends Command {

    public CmdRemoveTxt(String  arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        String[] myArguments = getArguments().split(" ");
        //boolean retorno = true;
        String fileType = myArguments[0].toUpperCase();
        String fileName = myArguments[1];

        if(fileType.equals("/R")){
            removeFile(MFileAnnotationType.REMINDER, fileName);
        } else if(fileType.equals("/I")){
            removeFile(MFileAnnotationType.IMPORTANT, fileName);
        }else if(fileType.equals("/S")){
            removeFile(MFileAnnotationType.SIMPLE, fileName);
        }

    }

    @Override
    public String helpMenu() {
        return "removetxt: remove a text file\n" +
                "     Syntax: removetxt [argument] [fileName]\n" +
                "     Argument Options:\n" +
                "     /R - Reminder\n" +
                "     /I - Important\n" +
                "     /S - Simple\n";
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
