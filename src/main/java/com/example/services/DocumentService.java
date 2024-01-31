package com.example.services;

import com.example.entity.Document;
import com.example.repo.FileUpLoadRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class DocumentService {

    private FileUpLoadRepository repo;


    public String save(MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = Document.builder()
                .name(fileName)
                .content(file.getBytes())
                .fileType(file.getContentType())
                .build();

        Document fileSave = this.repo.save(document);

        return "One File Saved";
    }

    public Document findByName(String name){

        return this.repo.findByName(name);
    }

    public List<Document> findAllByName(String name){

        return this.repo.findByFileType(name);
    }
}
