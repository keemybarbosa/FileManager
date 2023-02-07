package br.com.keemy.filemanager.interfaces;

import br.com.keemy.filemanager.enums.MFileAnnotationType;

public interface FileDatabase {
    void saveFile(String directory, String content, MFileAnnotationType type, String nameFile);
    void recoveryFile(String directory, String nameFile);
    boolean removeFile(String directory, String nameFile, MFileAnnotationType type);
    void listAllFiles(String directory);
}
