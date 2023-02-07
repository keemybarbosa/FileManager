package br.com.keemy.filemanager.utils;

import br.com.keemy.filemanager.application.Global;

public final class StringUtils {

    public static String formatBlue(String text){
        return Global.ANSI_BLUE + text + Global.ANSI_RESET;
    }

    public static String formatYellow(String text){
        return Global.ANSI_YELLOW + text + Global.ANSI_RESET;
    }

}
