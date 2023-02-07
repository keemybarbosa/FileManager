package br.com.keemy.filemanager.impl;

import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.interfaces.FolderManagement;

import java.io.File;

public class FolderOrchestrator implements FolderManagement {
    @Override
    public boolean createAFolder(String path, MFileAnnotationType fileType) {
        String dir = "";
        switch (fileType) {
            case REMINDER -> dir = "reminders";
            case IMPORTANT -> dir = "importants";
            case IMAGE -> dir = "images";
            case NONE -> dir = "";
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

            return true;
        } catch (Exception e) {
            System.out.println(" ERROR AO CRIAR DIRETORIO ");
        }
        return false;
    }

    @Override
    public boolean removeAFolder(String path) {
        File myDirectory = new File(path);
        try{
            if (myDirectory.exists()){
                File files[] = myDirectory.listFiles();
                if (files.length == 0){
                    myDirectory.delete();
                } else {
                    System.out.println("Directory will not be removed because isn't empty!\n");
                    return false;
                }
                return true;
            } else {
                System.out.printf("O diretório %s não existe!%n", path);
            }
        }
        catch (Exception e){
            System.out.println(" ERROR AO EXCLUIR DIRETORIO ");
        }
        return false;
    }

    @Override
    public void listAllFoldersCreated() {
        System.out.println("TODO: FolderOrchestrator.listAllFoldersCreated");
        //TODO: não implementado

    }
}
