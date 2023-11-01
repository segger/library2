package se.johannalynn.serverapp

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : FirestoreReactiveRepository<Book>