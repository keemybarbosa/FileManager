package br.com.keemy.filemanager.models;

import br.com.keemy.filemanager.enums.MFileAnnotationType;

public class MFile {
    private String content;

    private String path;
    private String fileName;

    MFileAnnotationType type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MFileAnnotationType getType() {
        return type;
    }

    public void setType(MFileAnnotationType type) {
        this.type = type;
    }
}
