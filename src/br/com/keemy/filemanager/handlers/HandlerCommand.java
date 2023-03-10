package br.com.keemy.filemanager.handlers;

import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.commands.impl.*;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

public class HandlerCommand {

    private static HandlerCommand instance;

    private HandlerCommand() {
    }

    public static synchronized HandlerCommand getInstance() {
        if (instance == null)
            instance = new HandlerCommand();

        return instance;
    }

    public void createAndExecuteCommand(String prompt){

        String commandLine = prompt.trim();
        String arguments = "";

        int firstIndex = commandLine.indexOf(" ");

        String command = commandLine.substring(0,(firstIndex != -1 ? firstIndex : commandLine.length())).toUpperCase();
        if (firstIndex != -1){
            arguments = commandLine.substring(firstIndex, commandLine.length()).trim();
        }

        if (command.equals("EXIT")){
            getInstance().executeCommand(new CmdExit(arguments));
        } else if (command.equals("HELP")){
            getInstance().executeCommand(new CmdHelp(arguments));
        } else if (command.equals("CD")) {
            getInstance().executeCommand(new CmdCd(arguments));
        } else if (command.equals("DIR")) {
            getInstance().executeCommand(new CmdDir(arguments));
        } else if (command.equals("SAVETXT")) {
            getInstance().executeCommand(new CmdSaveTxt(arguments));
        } else if (command.equals("SAVEIMG")) {
            getInstance().executeCommand(new CmdSaveImg(arguments));
        } else if (command.equals("REMOVETXT")) {
            getInstance().executeCommand(new CmdRemoveTxt(arguments));
        } else if (command.equals("REMOVEIMG")) {
            getInstance().executeCommand(new CmdRemoveImg(arguments));
        } else if (command.equals("REMOVEDIR")) {
            getInstance().executeCommand(new CmdRemoveDir(arguments));
        } else if(command.equals("MKDIR")) {
            getInstance().executeCommand(new CmdMkDir(arguments));
        } else if (command.equals("LISTIMG")){
            getInstance().executeCommand(new CmdListImg(arguments));
        } else if (command.equals("RECOVERYIMG")){
            getInstance().executeCommand(new CmdRecoveryImg(arguments));
        } else{
            System.out.println("Command not found!!\nUse help for more options!");
        }

    }

    public void executeCommand(Command command){
        command.execute();
    }
}
