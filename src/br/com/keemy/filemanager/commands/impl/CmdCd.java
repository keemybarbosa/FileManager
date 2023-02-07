package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;

import java.io.File;

public class CmdCd extends Command {

    public CmdCd(String arguments) {
        super(arguments);
    }

    @Override
    public void execute() {

        String arguments = getArguments();

        if(arguments.equals("..")){
            if((Global.currentDir.lastIndexOf("\\") > 0) && (Global.currentDir.length() > 3)) {
                String temp = Global.currentDir.substring(0, Global.currentDir.length() - 1);
                Global.currentDir = temp.substring(0, temp.lastIndexOf("\\") + 1);
            }
        } else if (arguments.equals("\\")){
            Global.currentDir = Global.currentDir.substring(0,2) + "\\";
        }
        else {
            //Check if client put full path
            String newPath = "";
            if (arguments.lastIndexOf(":") != -1){
                newPath = arguments;
            } else {
                newPath = Global.currentDir + arguments;
            }

            if (!newPath.substring(newPath.length() - 1).equals("\\")){
                newPath += "\\";
            }

            if (new File(newPath).exists()){
                Global.currentDir = newPath;
            }
        }
    }

    @Override
    public String helpMenu() {
        return "cd: change directory\n" +
                "    Syntax: cd [argument]\n" +
                "         Argument Options: \n" +
                "         [..] - Back to previous folder;\n" +
                "         [folder Path] - Change folder;\n" +
                "         [\\] - Back to root[NOT IMPLEMENTED]\n";
    }
}