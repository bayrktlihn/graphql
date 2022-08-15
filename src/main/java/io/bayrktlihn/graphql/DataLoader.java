package io.bayrktlihn.graphql;

import io.bayrktlihn.graphql.entity.City;
import io.bayrktlihn.graphql.entity.Gender;
import io.bayrktlihn.graphql.entity.Lesson;
import io.bayrktlihn.graphql.entity.Student;
import io.bayrktlihn.graphql.entity.Teacher;
import io.bayrktlihn.graphql.repository.LessonRepository;
import io.bayrktlihn.graphql.repository.StudentRepository;
import io.bayrktlihn.graphql.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public void run(ApplicationArguments args) {
        Student alihan = new Student("alihan", "bayraktar", Gender.MAN, City.TRABZON);
        Student merve = new Student("merve", "bayraktar", Gender.WOMAN, City.ISTANBUL);
        Student deniz = new Student("deniz", "bayraktar", Gender.WOMAN, City.BOLU);
        studentRepository.save(alihan);
        studentRepository.save(merve);
        studentRepository.save(deniz);

        Teacher mesut = new Teacher("mesut", "aygur", Gender.MAN, City.BITLIS);
        Teacher selma = new Teacher("selma", "balci", Gender.WOMAN, City.ISTANBUL);

        teacherRepository.save(mesut);
        teacherRepository.save(selma);

        Set<Student> fenTeknolojileriStudents = new HashSet<>();
        fenTeknolojileriStudents.add(alihan);
        fenTeknolojileriStudents.add(merve);
        fenTeknolojileriStudents.add(deniz);

        Set<Student> hayatBilgisiStudents = new HashSet<>();
        hayatBilgisiStudents.add(alihan);
        hayatBilgisiStudents.add(merve);


        Lesson fenTeknolojileri = new Lesson("Fen Teknolojileri", selma);
        Lesson hayatBilgisi = new Lesson("Hayat Bilgisi", mesut);
        hayatBilgisi.setStudents(hayatBilgisiStudents);
        fenTeknolojileri.setStudents(fenTeknolojileriStudents);

        lessonRepository.save(fenTeknolojileri);
        lessonRepository.save(hayatBilgisi);


    }
}
