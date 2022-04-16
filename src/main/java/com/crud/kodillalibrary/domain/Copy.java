package com.crud.kodillalibrary.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COPIES")
public class Copy {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COPY_ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(targetEntity = Borrow.class, mappedBy = "copy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Borrow> borrows;

    public Copy(Title title, String status) {
        this.title = title;
        this.status = status;
        this.borrows = new ArrayList<Borrow>();
    }

    public Copy(Long id, Title title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.borrows = new ArrayList<Borrow>();
    }
}
