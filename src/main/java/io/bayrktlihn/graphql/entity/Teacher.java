package io.bayrktlihn.graphql.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
public class Teacher extends Person {


    @OneToMany(mappedBy = "teacher")
    private Set<Lesson> lessons;

    public Teacher(String firstName, String lastName, Gender gender, City birthPlace) {
        super(firstName, lastName, gender, birthPlace);
    }
}
