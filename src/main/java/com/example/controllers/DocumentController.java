package com.example.controllers;

import com.example.entity.Document;
import com.example.services.DocumentService;
import com.example.model.FileInfo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/dox")
@AllArgsConstructor
public class DocumentController {


    private DocumentService service;


    @PostMapping
    public ResponseEntity<String> save(@RequestParam("file")  MultipartFile file) throws IOException {

        String message = this.service.save(file);

        return  ResponseEntity.status(201).body(message);

    }

    @GetMapping(path = "/image/{name}",produces = "image/png")

    public ResponseEntity<byte[]> findByName(@PathVariable("name") String name){




        return ResponseEntity.ok(this.service.findByName(name).getContent());
        }

    @GetMapping(path = "/file/{name}",produces = "text/text")

    public ResponseEntity<byte[]> findFileByName(@PathVariable("name") String name){


        return ResponseEntity.ok(this.service.findByName(name).getContent());


    }

    @GetMapping(value = "/images",produces = "application/json")

    public ResponseEntity<List<FileInfo>> getListFiles() {

        List<FileInfo> fileInfos = service.findAllByName("image/png").stream().map(document -> {

            String filename = document.getName();

            String url = MvcUriComponentsBuilder
                    .fromMethodName(DocumentController.class, "findByName",
                            document.getName()).build().toString();

            return new FileInfo(filename, url);

        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

}
