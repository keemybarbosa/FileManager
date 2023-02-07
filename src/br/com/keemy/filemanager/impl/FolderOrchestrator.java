package br.com.keemy.filemanager.impl;

import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.interfaces.FolderManagement;

import java.io.File;

public class FolderOrchestrator implements FolderManagement {
    @Override
    public void createAFolder(String path, MFileAnnotationType fileType) {
        String dir = "";
        switch (fileType) {
            case REMINDER -> dir = "reminders";
            case IMPORTANT -> dir = "importants";
            case IMAGE -> dir = "images";
            default -> dir = "";
        }
        try {
            boolean file = new File(path+"\\"+dir).exists();
            if (file) {
                System.out.println("diretorio ja existe");
            } else {
                boolean result = new File(path).mkdir();
                if (result) {
                    System.out.println(" DIRETORIO CRIADO COM SUCESSO ");
                }

            }

        } catch (Exception e) {
            System.out.println(" ERROR AO CRIAR DIRETORIO ");
        }
    }

    @Override
    public void removeAFolder(String path) {
        System.out.println("TODO: FolderOrchestrator.removeAFolder");
        //TODO: não implementado
    }

    @Override
    public void listAllFoldersCreated() {
        System.out.println("TODO: FolderOrchestrator.listAllFoldersCreated");
        //TODO: não implementado

    }
}
