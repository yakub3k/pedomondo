package pl.yakub.book.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private Long id;

    @Column(unique = true)
    private String name;

    public Author(String name) {
        this.name = name;
    }
}