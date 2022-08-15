package io.bayrktlihn.graphql.repository;

import io.bayrktlihn.graphql.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
