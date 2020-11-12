package smart_convert

import model.Kotliner
import model.Person

/**
 * Kotlin智能类型转换
 */
val tag: String? = null

fun main(args: Array<String>) {
    if (tag != null) {//不支持的智能类型转换
        println(tag.length)
    }

    val kotliner: Kotliner = Person("JayPhone", 20)
    if (kotliner is Person) {// is = instance of
        println((kotliner as Person).name)// as 类型转换
        println(kotliner.name)// 智能类型转换
    }
    println((kotliner as? Person)?.name)

    var value: String? = null
    value = "JayPhone"
    if (value != null) {//智能类型转换，作用域只在判断范围内
        println(value.length)
    }
}