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
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    ApplicationArguments applicationArguments;
    @Autowired
    FileServiceImpls fileServiceImpl;

    String pathDownload = "src/main/java/com/example/block11uploaddownloadfiles/downloads/";

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
    public File downloadFile(@PathVariable("id") int fileId) {

        return fileServiceImpl.readById(fileId);
    }

    @GetMapping("/downloadById/{id}")
    public String downloadFileById(@PathVariable("id") int fileId) throws IOException {

        File recoveredFile = fileServiceImpl.readById(fileId);
        Path path = Paths.get(pathDownload + recoveredFile.getFilename());
        Files.write(path, recoveredFile.getData());
        return "Se ha descargado correctamente";
    }

    @GetMapping("/downloadByName/{name}")
    public String downloadByName(@PathVariable("name") String name) throws IOException {

        File recoveredFile = fileServiceImpl.readByName(name);
        Path path = Paths.get(pathDownload + recoveredFile.getFilename());
        Files.write(path, recoveredFile.getData());
        return "Se ha descargado correctamente";
    }

    @GetMapping("/download/path/{name}")
    public String downloadByName(@PathVariable("name") String name, @RequestParam(name="setPath", defaultValue = "src/main/java/com/example/block11uploaddownloadfiles/downloads/") String url) throws IOException {

        File recoveredFile = fileServiceImpl.readByName(name);
        Path path = Paths.get(("src/main/java/com/example/block11uploaddownloadfiles/" + url + "/") + recoveredFile.getFilename());
        if (Files.notExists(path)) {
            Files.createDirectories(Paths.get("src/main/java/com/example/block11uploaddownloadfiles/" + url + "/"));
            Files.write(path, recoveredFile.getData());
            return "Se ha descargado correctamente";
        }else {
            Files.write(path, recoveredFile.getData());
            return "Se ha descargado correctamente";
        }

    }

    @GetMapping
    public List<File> readAll(){
        List<File> listReturn = fileServiceImpl.readAll();
        return listReturn;
    }




}
