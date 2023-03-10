package br.com.keemy.filemanager.utils;

import java.util.Scanner;
import java.util.function.Function;

public final class InputService {

    static Scanner scanner = null;

    private static Scanner getScanner(){
        if (scanner == null){
            return new Scanner(System.in);
        } else {
            return scanner;
        }
    }

    public static Integer getAnInteger(){
        Integer returnValue = null;
        if (getScanner().hasNextInt()) {
            returnValue = getScanner().nextInt();
        }
        return returnValue;
    }

    public static String getMeAString(boolean returnEmpty){
        String returnValue = null;

        if (returnEmpty){
            returnValue = getScanner().nextLine();
        } else {
            returnValue = scanLine.apply(getScanner());
        }

        return returnValue;
    }

    public static Function<Scanner,String> scanLine = (scan -> {
        String s = scan.nextLine();
        return( s.length() == 0 ? scan.nextLine() : s );
    });

    public static String pause(String message) {
        System.out.print(message);
        return InputService.getMeAString(true);
    }
}
