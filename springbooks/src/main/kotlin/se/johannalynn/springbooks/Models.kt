package se.johannalynn.springbooks

import com.google.cloud.firestore.annotation.DocumentId
import com.google.cloud.spring.data.firestore.Document

@Document(collectionName = "books")
data class Book(@DocumentId val id: String? = null, val title: String = "", val author: String = "", val readAt: ReadAt? = null)
data class ReadAt(val year: Int? = null, val month: Int? = null, val day: Int? = null)
