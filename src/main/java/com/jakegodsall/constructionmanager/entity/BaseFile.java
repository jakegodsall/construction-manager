package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.Objects;

@MappedSuperclass
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @EqualsAndHashCode @ToString
public class BaseFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] data;
    private String filename;
    @Enumerated(EnumType.STRING)
    private FileType fileType;
}
