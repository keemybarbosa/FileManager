package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.models.MFile;
import br.com.keemy.filemanager.utils.InputService;

import java.util.Scanner;

public class CmdSaveImg extends Command {

    public CmdSaveImg(String  arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        String[] myArguments = getArguments().split(" ");
        //boolean retorno = true;
        String fileName = myArguments[0];
        String urlImage = myArguments[1];

        MFile mFile = new MFile();
        mFile.setFileName(fileName);
        mFile.setPath(Global.currentDir);
        mFile.setContent(urlImage);

        Global.handlerFile.salvarImagemComDiretorio(mFile);
    }

    @Override
    public String helpMenu() {
        return "saveimg: save a image file from a url.\n" +
                "     Syntax: savetxt [fileName] [url]\n";
    }

}
