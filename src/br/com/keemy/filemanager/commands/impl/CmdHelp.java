package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.commands.Command;

public class CmdHelp extends Command {

    public CmdHelp(String  arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        System.out.println(this.helpMenu());
    }

    @Override
    public String helpMenu() {
        return "help:\tlist of commands(this menu)\n" +
                new CmdExit("").helpMenu() +
                new CmdCd("").helpMenu() +
                new CmdDir("").helpMenu() +
                new CmdSaveTxt("").helpMenu();
    }
}
