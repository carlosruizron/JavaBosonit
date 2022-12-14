package com.example.block11uploaddownloadfiles.application;

import com.example.block11uploaddownloadfiles.domain.File;
import com.example.block11uploaddownloadfiles.infrastucture.repository.FileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
    public File updateFile(File file) {

        fileRepository.save(file);
        return file;
    }

    @Override
    public File getById(Integer id_file) {

        return fileRepository.findById(id_file).orElseThrow(() -> new EntityNotFoundException() );
    }

    @Override
    public List<File> getByName(String name) {

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

    @Override
    public List<File> getFileByType(String type) {

        List<File> foundType = new ArrayList<>();
        fileRepository.readFileByType(type).forEach(file -> {
            foundType.add(file);
        });
        return foundType;
    }
}
