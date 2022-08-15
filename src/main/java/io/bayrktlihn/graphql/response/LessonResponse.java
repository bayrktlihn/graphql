package io.bayrktlihn.graphql.response;

import io.bayrktlihn.graphql.entity.Lesson;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LessonResponse {
    public String name;
    public Long teacherId;

    public List<Long> studentIds;

    public LessonResponse(Lesson lesson) {
        this.name = lesson.getName();
        this.teacherId = lesson.getTeacher().getId();
        this.studentIds = lesson.getStudents().stream().map(student -> student.getId()).collect(Collectors.toList());
    }
}
