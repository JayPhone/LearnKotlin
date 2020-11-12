package sample

import java.io.File

fun main(args: Array<String>) {
    File("build.gradle").readText().toCharArray()
        .filterNot (Char::isWhitespace)
        .groupBy {
            it
        }.map {
            it.key to it.value.size
        }.let {
            println(it)
        }

    //DSL
}