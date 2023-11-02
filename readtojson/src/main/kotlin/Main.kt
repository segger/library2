import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File
import kotlin.system.exitProcess

data class Book(val title: String, val author: String, val readAt: ReadAt)
data class ReadAt(val year: Int, val month: Int? = null, val day: Int? = null)

val months = mapOf(
    "januari" to 1,
    "februari" to 2,
    "mars" to 3,
    "april" to 4,
    "maj" to 5,
    "juni" to 6,
    "juli" to 7,
    "augusti" to 8,
    "september" to 9,
    "oktober" to 10,
    "november" to 11,
    "december" to 12
)

var printFile = true

val books = mutableListOf<Book>()
fun main(args: Array<String>) {
    val year = args[0]

    val inputFile = args[1]
    println("readtojson from $inputFile")

    var month: Int? = null
    var day: Int? = null
    File(inputFile).readLines().forEach {
        val line = it.trim()
        if (line.isNotEmpty()) {
            val startsWith = line[0]
            if (startsWith == '=') {
                if (!line.startsWith("==")) {
                    val lineMonth = line.replace(Regex("[^A-Za-z]"),"").trim().lowercase()
                    month = months[lineMonth]
                }
            } else if (startsWith.isDigit()) {
                day = line.takeLast(2).toInt()
            } else {
                val row = line.split("-")
                if (row.count() != 2) {
                    exitProcess(1)
                } else {
                    val title = row[0].trim().replace("+","-")
                    val author = row[1].trim().replace("+","-")
                    // println("$title by $author")
                    val readAt = ReadAt(year.toInt(), month, day)
                    books.add(Book(title, author, readAt))
                }
            }
        }
    }

    if (printFile) {
        val jsonFile = "books_$year.json"
        val mapper = jacksonObjectMapper()
        val out = File(jsonFile)
        out.writeText(mapper.writeValueAsString(books))
        println("json to $jsonFile")
    }
}