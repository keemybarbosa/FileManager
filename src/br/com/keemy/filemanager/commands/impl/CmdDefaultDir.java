package br.com.keemy.filemanager.commands.impl;

import br.com.keemy.filemanager.application.Global;
import br.com.keemy.filemanager.commands.Command;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CmdDefaultDir extends Command {

    public CmdDefaultDir() {
        super("");
    }

    @Override
    public void execute() {
        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        Global.currentDir = directoryName.trim();
        if (!Global.currentDir.substring(Global.currentDir.length()).equals("\\")){
            Global.currentDir += "\\";
        }
    }

    @Override
    public String helpMenu() {
        return "defaultDir\n;end;";
    }
}