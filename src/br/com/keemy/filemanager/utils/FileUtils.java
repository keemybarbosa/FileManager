package br.com.keemy.filemanager.utils;

public final class FileUtils {

    public static String getFileNameWithExtension(String fileName, String extension){
        int len = fileName.length();

        if (len > 4){
            if (!fileName.substring(len-4,len).equals("."+extension)){
                return fileName + "." + extension;
            }
        } else {
            return fileName + "." + extension; //4 or less
        }

        return fileName;
    }
}
