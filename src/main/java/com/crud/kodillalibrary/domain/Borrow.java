package com.crud.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BORROWS")
public class Borrow {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "BORROW_ID", unique = true)
    private Long id;

    @Column(name = "BORROW_DATE")
    private LocalDate borrowDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COPY_ID")
    private Copy copy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "READER_ID")
    private Reader reader;
}
