package com.crud.kodillalibrary.domain;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "TITLES")
public class Title {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "TITLE_ID", unique = true)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLICATION_YEAR")
    private int publicationYear;

    @OneToMany(targetEntity = Copy.class, mappedBy = "title", cascade = CascadeType.ALL)
    private List<Copy> copies;

    public Title(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.copies = new ArrayList<Copy>();
    }

    public Title(Long id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.copies = new ArrayList<Copy>();
    }
}
