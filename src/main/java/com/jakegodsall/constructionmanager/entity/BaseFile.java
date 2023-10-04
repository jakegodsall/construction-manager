package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@MappedSuperclass
public class BaseFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] data;
    private String filename;
    @Enumerated(EnumType.STRING)
    private FileType fileType;

    public BaseFile() {
    }

    public BaseFile(Long id, byte[] data,
                    String filename) {
        this.id = id;
        this.data = data;
        this.filename = filename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseFile file = (BaseFile) o;
        return Objects.equals(id, file.id) && Arrays.equals(data, file.data) && Objects.equals(filename, file.filename) && fileType == file.fileType;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, filename, fileType);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "filename='" + filename + '\'' +
                '}';
    }
}
