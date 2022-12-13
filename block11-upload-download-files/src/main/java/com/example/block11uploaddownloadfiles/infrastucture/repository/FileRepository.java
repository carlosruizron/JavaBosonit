package com.example.block11uploaddownloadfiles.infrastucture.repository;

import com.example.block11uploaddownloadfiles.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

    File findByFilename(String name);
}
