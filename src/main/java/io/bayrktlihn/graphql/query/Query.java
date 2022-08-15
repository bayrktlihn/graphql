package io.bayrktlihn.graphql.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import io.bayrktlihn.graphql.entity.Student;
import io.bayrktlihn.graphql.repository.StudentRepository;
import io.bayrktlihn.graphql.request.SampleRequest;
import io.bayrktlihn.graphql.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final StudentRepository studentRepository;

    public String firstQuery() {
        return "First Query";
    }

    public String secondQuery() {
        return "Second Query";
    }

    public String fullName(SampleRequest sampleRequest) {
        String firstName = sampleRequest.getFirstName();
        String lastName = sampleRequest.getLastName();
        return String.format("%s %s", firstName, lastName);
    }

    public StudentResponse student(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return new StudentResponse(student);
    }

}
