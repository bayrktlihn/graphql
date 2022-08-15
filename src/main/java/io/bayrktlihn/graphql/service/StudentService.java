package io.bayrktlihn.graphql.service;

import io.bayrktlihn.graphql.entity.Lesson;
import io.bayrktlihn.graphql.entity.Student;
import io.bayrktlihn.graphql.repository.LessonRepository;
import io.bayrktlihn.graphql.repository.StudentRepository;
import io.bayrktlihn.graphql.repository.TeacherRepository;
import io.bayrktlihn.graphql.request.CreateStudentRequest;
import io.bayrktlihn.graphql.request.LessonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    private final TeacherRepository teacherRepository;

    public Student createStudent(CreateStudentRequest createStudentRequest) {

        Student student = new Student();
        student.setGender(createStudentRequest.getGender());
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setBirthPlace(createStudentRequest.getBirthPlace());

        student = studentRepository.save(student);
        student.setLessons(new HashSet<>());

        List<LessonRequest> lessons = createStudentRequest.getLessons();

        for (LessonRequest tmpLesson : lessons) {

            Long lessonId = tmpLesson.getLessonId();
            Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() -> new RuntimeException("Not found lesson"));

            lesson.getStudents().add(student);

            student.getLessons().add(lesson);
        }


        return student;
    }

}
