package com.example.block11uploaddownloadfiles.application;

import com.example.block11uploaddownloadfiles.domain.File;

import java.util.List;

public interface FileService {

    String createFile(File file);
    String updateFile(File file);
    File readById(Integer idFile);
    File readByName(String name);
    List<File> readAll();
    void deleteFile(Integer idFile);
}
