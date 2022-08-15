package io.bayrktlihn.graphql.response;

import io.bayrktlihn.graphql.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String birthPlace;
    private String gender;
    private List<LessonResponse> lessons;

    private Student student;

    private String fullName;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.birthPlace = student.getBirthPlace().toString();
        this.gender = student.getGender().toString();
        this.student = student;

    }
}
