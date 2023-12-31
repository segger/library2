package se.johannalynn.springbooks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BooksController(@Autowired val bookService: BookService) {

    @GetMapping("/count")
    fun count() = bookService.count()

    @PostMapping("","/")
    fun store(@RequestBody books: List<Book>) {
        bookService.load(books)
    }

    @DeleteMapping("", "/")
    fun clear() = bookService.clear()

    @GetMapping("", "/")
    fun retrieve() = bookService.retrieveAll()

}