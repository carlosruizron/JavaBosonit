package com.example.block11uploaddownloadfiles.infrastucture.controller;

import com.example.block11uploaddownloadfiles.application.FileServiceImpls;
import com.example.block11uploaddownloadfiles.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    ApplicationArguments applicationArguments;
    @Autowired
    FileServiceImpls fileServiceImpl;

    final String pathDownload = "src/main/java/com/example/block11uploaddownloadfiles/downloads/";

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public File uploadFile(@RequestPart MultipartFile multipartFile) throws IOException {
        File file = new File();
        file.addDate();
        file.setFilename(multipartFile.getOriginalFilename());
        file.setData(multipartFile.getBytes());
        file.setType(multipartFile.getContentType());
        fileServiceImpl.createFile(file);
        return file;
    }

    @GetMapping("/{id}")
    public File getById(@PathVariable("id") Integer fileId) {

        return fileServiceImpl.getById(fileId);
    }

    @GetMapping("/downloadById/{id}")
    public String downloadFileById(@PathVariable("id") Integer fileId) throws IOException {

        File file = fileServiceImpl.getById(fileId);
        Path path = Paths.get(pathDownload + file.getFilename());
        Files.write(path, file.getData());
        return "Se ha descargado correctamente";
    }

    @GetMapping("/downloadByName/{name}")
    public String downloadByName(@PathVariable("name") String name) throws IOException {

        List<File> file = new ArrayList<>();
        file = fileServiceImpl.getByName(name);
        Path path = Paths.get(pathDownload + file.get(0).getFilename());
        Files.write(path, file.get(0).getData());
        return "Se ha descargado correctamente";
    }

    @GetMapping("/download/path/{name}")
    public String downloadByName(@PathVariable("name") String name, @RequestParam(name="setPath", defaultValue = pathDownload) String url) throws IOException {

        List<File> file = new ArrayList<>();
        file = fileServiceImpl.getByName(name);
        Path path = Paths.get(("src/main/java/com/example/block11uploaddownloadfiles/" + url + "/") + file.get(0).getFilename());
        if (Files.notExists(path)) {
            Files.createDirectories(Paths.get("src/main/java/com/example/block11uploaddownloadfiles/" + url + "/"));
            Files.write(path, file.get(0).getData());
            return "Se ha descargado correctamente";
        }else {
            Files.write(path, file.get(0).getData());
            return "Se ha descargado correctamente";
        }

    }

    @GetMapping
    public List<File> readAll(){

        List<File> listFile = fileServiceImpl.readAll();
        return listFile;
    }

    @GetMapping("/readByType")
    public List<File> readByType(@RequestParam(name="type", defaultValue = "") String type) {

        List<File> file = fileServiceImpl.getFileByType(type);
        return file;
    }
}
