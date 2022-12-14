package com.example.block11uploaddownloadfiles.infrastucture.repository;

import com.example.block11uploaddownloadfiles.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

    List<File> findByFilename(String name);
    List<File> readFileByType(String type);
}
