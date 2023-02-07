package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.commands.Command;

public class CmdExit extends Command {

    public CmdExit(String arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        System.out.println("Thank You!");
        System.exit(0);
    }

    @Override
    public String helpMenu() {
        return "exit: exit program!\n";
    }
}
