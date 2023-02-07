package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.models.MFile;
import br.com.keemy.filemanager.utils.InputService;

import java.util.Scanner;

public class CmdSaveTxt extends Command {

    public CmdSaveTxt(String  arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        String[] myArguments = getArguments().split(" ");
        //boolean retorno = true;
        String fileType = myArguments[0].toUpperCase();
        String fileName = myArguments[1];

        if(fileType.equals("/R")){
            createFile(MFileAnnotationType.REMINDER, fileName);
        } else if(fileType.equals("/I")){
            createFile(MFileAnnotationType.IMPORTANT, fileName);
        }else if(fileType.equals("/S")){
            createFile(MFileAnnotationType.SIMPLE, fileName);
        }
    }

    @Override
    public String helpMenu() {
        return "savetxt: save a text file\n" +
                "     Syntax: savetxt [argument] [fileName]\n" +
                "     Argument Options:\n" +
                "     /R - Reminder\n" +
                "     /I - Important\n" +
                "     /S - Simple\n";
    }

    private void createFile(MFileAnnotationType fileType, String fileName) {
        Scanner sc = new Scanner(System.in);

        System.out.println("File type:" + fileType.name());
        System.out.print("Type content of file: \n");
        String contentArq = InputService.getMeAString();


        MFile mFile = new MFile();
        mFile.setType(fileType);
        mFile.setPath(Global.currentDir);
        mFile.setContent(contentArq);
        mFile.setFileName(fileName);

        Global.handlerFile.salvarComDiretorio(mFile);

        System.out.println("File saved Successful!");

    }

}
