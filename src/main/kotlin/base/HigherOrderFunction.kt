package base

import model.Person
import java.io.File

//内联属性
var pocket: Double = 0.0
var money: Double
    inline get() = pocket
    inline set(value) {
        pocket = value
    }

fun main() {
    //内联函数，相当于把函数内部的调用放到调用处，可通过Show Kotlin ByteCode反编译查看区别
    /**等价于
     * val start = System.currentTimeMillis()
     * println("Hello")
     * println(System.currentTimeMillis() - start)
     */
    cost { println("Hello") }

    //高阶函数返回
    returnFunction()

    //内联non-local return
//    nonLocalReturn { return }
    /**等价于
     * return
     */
//    println("Fuck")//不能输出

    runnable {
        //因为crossinline，所以不允许return
//        return
    }

    //几个有用的函数
    val person: Person = Person("JayPhone", 25)
    //不带receiver,返回值
    val a = person.let {
        it.name
    }
    //带receiver
    val b = person.run {
        name
    }
    //不带receiver
    val c = person.also {
        it.name
    }
    //带receiver
    val d = person.apply {
        name
    }

    File("build.gradle")
        .inputStream()
        .reader()
        .buffered()
        .use {
            println(it.readLines())
        }
}

fun String.toString(): String {
    return "123"
}

/**
 * 内联函数
 */
inline fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)
}

/**
 * 函数的返回
 */
fun returnFunction() {
    val ints = intArrayOf(1, 2, 3, 4)
    ints.forEach {
        //local return
        if (it == 3) return@forEach//返回到foreach，不加@forEach，直接返回到函数
        println("Hello $it")
    }
}

/**
 * 内联 non-local return
 */
inline fun nonLocalReturn(block: () -> Unit) {
    block()
}

/**
 * 禁止non-local return出现
 */
inline fun runnable(crossinline block: () -> Unit): Runnable {
    return object : Runnable {
        override fun run() {
            //有可能存在不合法的non-local return,因为block的调用处与定义处不在同一个调用上下文，可加上crossinline
            block()
        }
    }
}



