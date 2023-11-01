package se.johannalynn.springbooks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService(@Autowired val bookRepository: BookRepository) {

    fun count() = bookRepository.count()
    fun clear() = bookRepository.deleteAll()

    fun retrieveAll() = bookRepository.findAll()

    fun save(book: Book) = bookRepository.save(book).subscribe()
}