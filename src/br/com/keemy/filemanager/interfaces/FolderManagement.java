package br.com.keemy.filemanager.interfaces;

import br.com.keemy.filemanager.enums.MFileAnnotationType;

public interface FolderManagement {
    void createAFolder(String path, MFileAnnotationType fileType);
    boolean removeAFolder(String path);
    void listAllFoldersCreated();
}
