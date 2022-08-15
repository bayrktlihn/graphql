package io.bayrktlihn.graphql.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student extends Person {


    @ManyToMany(mappedBy = "students")
    private Set<Lesson> lessons;

    public Student(String firstName, String lastName, Gender gender, City birthPlace) {
        super(firstName, lastName, gender, birthPlace);
    }
}
