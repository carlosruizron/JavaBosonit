package com.example.block11uploaddownloadfiles.application;

import com.example.block11uploaddownloadfiles.domain.File;
import com.example.block11uploaddownloadfiles.infrastucture.repository.FileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpls implements FileService{

    @Autowired
    FileRepository fileRepository;

    @Override
    public String createFile(File file) {

        fileRepository.save(file);
        return "El archivo: " + file.getFilename() + " ha sido guardado";
    }

    @Override
    public String updateFile(File file) {
        fileRepository.save(file);
        return "El archivo: " + file.getId_file() + " ha sido actualizado";
    }

    @Override
    public File readById(Integer id_file) {
        return fileRepository.findById(id_file).orElseThrow(() -> new EntityNotFoundException() );
    }

    @Override
    public File readByName(String name) {
        return fileRepository.findByFilename(name);
    }

    @Override
    public List<File> readAll() {
        List<File> fileList = fileRepository.findAll();
        return fileList;
    }

    @Override
    public void deleteFile(Integer id_file) {
        fileRepository.deleteById(id_file);
    }
}
