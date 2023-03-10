package br.com.keemy.filemanager.application;

import br.com.keemy.filemanager.commands.impl.CmdDefaultDir;
import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.handlers.HandlerCommand;
import br.com.keemy.filemanager.models.MFile;
import br.com.keemy.filemanager.utils.InputService;
import br.com.keemy.filemanager.utils.StringUtils;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        new CmdDefaultDir().execute();

        System.out.println("\n####### Welcome to File Manager System #######\n");
        System.out.println("use the " + StringUtils.formatBlue("HELP") + " command to know the other options ");
        do{

            System.out.printf(StringUtils.formatYellow( "%s>"),Global.currentDir);
            HandlerCommand.getInstance().createAndExecuteCommand(InputService.getMeAString(false).trim());

        } while(true);


    }




}