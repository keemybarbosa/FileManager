package br.com.keemy.filemanager.handlers;

import br.com.keemy.filemanager.impl.FileOrchestrator;
import br.com.keemy.filemanager.interfaces.FileDatabase;
import br.com.keemy.filemanager.interfaces.FolderManagement;
import br.com.keemy.filemanager.interfaces.ImageFileDatabase;
import br.com.keemy.filemanager.models.MFile;

public class HandlerFile  {

    ImageFileDatabase imageFileDatabase;
    FileDatabase fileDatabase;
    FolderManagement folderManagement;


    public HandlerFile(){
        imageFileDatabase = new FileOrchestrator();
        fileDatabase = new FileOrchestrator();
        folderManagement = new FileOrchestrator();
    }

    public void salvarComDiretorio(MFile file){
        fileDatabase.saveFile(file.getPath(), file.getContent(), file.getType(), file.getFileName() );
    }

    public boolean removerArquivo(MFile file){
        return fileDatabase.removeFile(file.getPath(), file.getFileName(), file.getType());
    }

    public void listarArquivos(String directory){
        if (!directory.substring(directory.length()-1).equals("\\")){
            directory += "\\";
        }
        fileDatabase.listAllFiles(directory);
    }


    public void salvarImagemComDiretorio(MFile mFile) {
        imageFileDatabase.saveImageFile(mFile.getPath(), mFile.getContent(), mFile.getFileName());
    }
}
