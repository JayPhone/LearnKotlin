package collect

import java.lang.StringBuilder

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    //饿汉式
    list.filter {
        println("filter:$it")
        it % 2 == 0
    }.map {
        println("map:$it")
        it * 2 + 1
    }.flatMap {
        1 until it
    }.forEach {
        println("forEach:$it")
    }

    //懒汉式
    list.asSequence().filter {
        println("filter:$it")
        it % 2 == 0
    }.map {
        println("map:$it")
        it * 2 + 1
    }.flatMap {
        (1 until it).asSequence()
    }.forEach {
        println("forEach:$it")
    }

    //相加
    list.sum().let {
        println(it)
    }

    //聚合
    list.reduce { pre, next ->
        pre * next
    }.let {
        println(it)
    }

    //折叠
    list.fold(StringBuilder()) { acc, i ->
        acc.append(i)
    }
        .run {
            println(this.toString())
            this
        }.also {
            it.append(" Hello")
        }.apply {
            this.append(" Kotlin")
        }.let {
            println(it.toString())
        }

    list.zip(listOf(2, 2)).joinToString().let {
        println(it)
    }
}