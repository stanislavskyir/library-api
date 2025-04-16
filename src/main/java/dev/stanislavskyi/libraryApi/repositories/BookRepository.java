package dev.stanislavskyi.libraryApi.repositories;

import dev.stanislavskyi.libraryApi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
