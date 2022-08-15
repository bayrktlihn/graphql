package io.bayrktlihn.graphql.mutations;

import graphql.kickstart.tools.GraphQLMutationResolver;
import io.bayrktlihn.graphql.entity.Student;
import io.bayrktlihn.graphql.request.CreateStudentRequest;
import io.bayrktlihn.graphql.response.StudentResponse;
import io.bayrktlihn.graphql.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final StudentService studentService;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Student student = studentService.createStudent(createStudentRequest);
        return new StudentResponse(student);
    }
}
