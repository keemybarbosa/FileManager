package br.com.keemy.filemanager.impl;

import br.com.keemy.filemanager.enums.MFileAnnotationType;
import br.com.keemy.filemanager.interfaces.FileDatabase;
import br.com.keemy.filemanager.interfaces.ImageFileDatabase;
import br.com.keemy.filemanager.utils.FileUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDatabase, FileDatabase {
    @Override
    public void saveFile(String directory, String content, MFileAnnotationType type, String nameFile) {
        String dir;
        switch (type) {
            case REMINDER -> dir = "\\reminders";
            case IMPORTANT -> dir = "\\importants";
            case IMAGE -> dir = "\\images";
            default -> dir = "";
        }
        super.createAFolder(directory + dir, type);

        String path = directory + dir + "\\" + FileUtils.getFileNameWithExtension(nameFile,"txt");


        try (FileWriter writer = new FileWriter(path)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recoveryFile(String directory, String nameFile) {
        System.out.println("TODO: FileOrchestrator.recoveryFile");
        //TODO: não implementado
    }

    @Override
    public boolean removeFile(String directory, String nameFile, MFileAnnotationType type) {
        String dir;
        switch (type) {
            case REMINDER -> dir = "\\reminders";
            case IMPORTANT -> dir = "\\importants";
            case IMAGE -> dir = "\\images";
            default -> dir = "";
        }

        String extension = (type.equals(MFileAnnotationType.IMAGE) ? "jpg" : "txt");

        String fullName = dir + "\\" + FileUtils.getFileNameWithExtension(nameFile,extension);

        String path = directory + fullName;

        if (!(new File(path).exists())){
            System.out.printf("File %s not found\n", fullName);
            return false;
        }

        try {
            File file = new File(path);
            if(file.delete()){
                System.out.printf("File %s removed successfully!%n", fullName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void listAllFiles(String directory) {
        File file = new File(directory);

        File[] listFiles = file.listFiles();

        if (listFiles != null) {
            for (File currentFile : listFiles) {
                if (currentFile.isFile()) {
                    System.out.printf("     \t %s%n",currentFile.getName());
                } else {
                    System.out.printf("<dir>\t %s%n", currentFile.getName());
                }

            }
        } else System.out.println("No Files Found!");
    }

    @Override
    public void saveImageFile(String directory, String content, String nameFile) {
        try{
            String  dir = "images";
            BufferedImage image;

            super.createAFolder(directory + dir, MFileAnnotationType.IMAGE);

            URL url = new URL(content);
            image = ImageIO.read(url);
            String imageFile = directory + dir + "\\" + FileUtils.getFileNameWithExtension(nameFile , "jpg");

            ImageIO.write(image, "jpg", new File(imageFile));
            System.out.println("Image Saved successful");
        } catch (Exception e){
            System.out.println("Error to save imageFile");
        }
    }

    @Override
    public void recoveryImageFile(String directory, String nameFile) {

        String dir = "images";
        String fullName = directory + dir + "\\" + FileUtils.getFileNameWithExtension(nameFile,"jpg");
        File file = new File(fullName);
        if (file.exists()){
            getImageAndShow(file);
        } else {
            System.out.printf("File %s not found%n", dir + "\\" + FileUtils.getFileNameWithExtension(nameFile,"jpg"));
        }
    }

    private void getImageAndShow(File file) {
        try{
            BufferedImage bufImage = ImageIO.read(file);

            new Imageframe().showImage(bufImage);

        } catch (Exception e){
            System.out.println("Display image generic Error");
        }

    }

    @Override
    public boolean removeImageFile(String directory, String nameFile) {
        return removeFile(directory,nameFile,MFileAnnotationType.IMAGE);
    }

    @Override
    public void listAllImageFiles(String directory) {

        String fullPath = directory + "images";

        File file = new File(fullPath);

        File[] listFiles = file.listFiles();

        if (listFiles != null) {
            System.out.printf("Listing all files inside %s directory.%n", fullPath);
            for (File currentFile : listFiles) {
                if (currentFile.isFile()) {
                    System.out.printf("     \t %s%n",currentFile.getName());
                }

            }
        } else System.out.println("No Files Found!");
    }

    private class Imageframe{
        private JFrame fraMain;
        private JPanel myPanel;
        private JLabel lblTitle;
        private JLabel lblImage;

        public Imageframe() {
            fraMain = new JFrame();
            myPanel = new JPanel(new FlowLayout());
            lblTitle = new JLabel();
            lblImage = new JLabel();
        }
        public void showImage(Image image) {
            if (image != null) {

                int width = image.getWidth(null);
                int height = image.getHeight(null);

                lblTitle.setText("My Image:");
                lblImage.setIcon(new ImageIcon(image));
                lblTitle.setSize(new Dimension(300,100));

                fraMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                fraMain.setSize(width , height + lblTitle.getHeight());

                myPanel.add(lblTitle);
                myPanel.add(lblImage);
                fraMain.add(myPanel);
                fraMain.setVisible(true);
            } else {
                System.out.printf("Image not found!");
            }
        }
    }

}
