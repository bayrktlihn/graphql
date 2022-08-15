package io.bayrktlihn.graphql.repository;

import io.bayrktlihn.graphql.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
