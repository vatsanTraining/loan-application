package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "loan_dox_feb_24")

public class Document {

    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    private String id;
    private String name;
    @Column(name = "file_type")
    private String fileType;

    @Column(columnDefinition = "BLOB")
    private byte[] content;
}
