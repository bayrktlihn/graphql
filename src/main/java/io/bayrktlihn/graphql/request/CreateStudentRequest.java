package io.bayrktlihn.graphql.request;

import io.bayrktlihn.graphql.entity.City;
import io.bayrktlihn.graphql.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private Gender gender;
    private City birthPlace;
    private List<LessonRequest> lessons;
}
