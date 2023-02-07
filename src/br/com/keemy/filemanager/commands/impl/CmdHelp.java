package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.commands.Command;
import br.com.keemy.filemanager.utils.InputService;
import br.com.keemy.filemanager.utils.StringUtils;

public class CmdHelp extends Command {

    public CmdHelp(String  arguments) {
        super(arguments);
    }

    @Override
    public void execute() {

        String text = this.helpMenu();
        String output[] = text.split(";end;");
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
            if(i % 3 == 0){
                InputService.pause("..............Type ENTER to continue..............");
            }
        }
    }

    @Override
    public String helpMenu() {
        return "# " + StringUtils.formatBlue("HELP") + ":\tlist of commands(this menu)\n" +
                new CmdExit("").helpMenu() +
                new CmdCd("").helpMenu() +
                new CmdDir("").helpMenu() +
                new CmdSaveTxt("").helpMenu() +
                new CmdSaveImg("").helpMenu() +
                new CmdRemoveTxt("").helpMenu() +
                new CmdRemoveImg("").helpMenu();
    }
}
