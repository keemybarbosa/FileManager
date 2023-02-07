package br.com.keemy.filemanager.application;

import br.com.keemy.filemanager.commands.impl.CmdDefaultDir;
import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.handlers.HandlerCommand;
import br.com.keemy.filemanager.models.MFile;
import br.com.keemy.filemanager.utils.InputService;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        new CmdDefaultDir().execute();

        System.out.println("use the help command to know the other options ");
        do{

            System.out.printf("%s>",Global.currentDir);
            HandlerCommand.getInstance().createAndExecuteCommand(InputService.getMeAString().trim());

        } while(true);


    }




}