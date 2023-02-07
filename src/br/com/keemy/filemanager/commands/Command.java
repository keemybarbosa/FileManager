package br.com.keemy.filemanager.commands;

public abstract class Command {

    String arguments;

    public Command(String arguments) {
        this.arguments = arguments;
    }

    public abstract void execute();

    public abstract String helpMenu();

    public String getArguments() {
        return arguments;
    }

}
