package io.bayrktlihn.graphql.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import io.bayrktlihn.graphql.response.LessonResponse;
import io.bayrktlihn.graphql.response.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public static final String ALL = "all";

    public List<LessonResponse> getLessons(StudentResponse studentResponse, String lessonName) {
        List<LessonResponse> lessons = studentResponse.getStudent().getLessons().stream().filter(lesson -> {
            String name = lesson.getName();
            return name.equalsIgnoreCase(lessonName) || lessonName.equalsIgnoreCase(ALL);
        }).map(lesson -> new LessonResponse(lesson)).collect(Collectors.toList());
        return lessons;
    }

    public String getFullName(StudentResponse studentResponse) {
        String firstName = studentResponse.getFirstName();
        String lastName = studentResponse.getLastName();
        return String.format("%s %s", firstName, lastName);
    }

}
