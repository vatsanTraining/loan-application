package com.example.repo;

import com.example.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileUpLoadRepository extends JpaRepository<Document,String> {

     Document findByName(String srchString);

    List<Document> findByFileType(String srchString);

}
