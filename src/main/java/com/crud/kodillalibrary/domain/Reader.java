package com.crud.kodillalibrary.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "READERS")
public class Reader {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "READER_ID", unique = true)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ACCOUNT_CREATION_DATE")
    private LocalDate accountCreationDate;

    @OneToMany(targetEntity = Borrow.class, mappedBy = "reader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Borrow> borrows;

    public Reader(String firstName, String lastName, LocalDate accountCreationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreationDate = accountCreationDate;
        this.borrows = new ArrayList<Borrow>();
    }

    public Reader(Long id, String firstName, String lastName, LocalDate accountCreationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreationDate = accountCreationDate;
        this.borrows = new ArrayList<Borrow>();
    }
}
