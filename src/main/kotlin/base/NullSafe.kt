package base

import model.Person

fun main(args: Array<String>) {
    //非空类型
    var nonNull: String = "Hello"
    //不能设置为null
    //nonNull = null

    //可空类型
    var nullable: String? = "Hello"
//    nullable = null
    //不能调用，因为可能会造成空指针
//    val length = nullable.length
    //可以调用，在不确定是否为空时,可设定默认值
    val length1 = nullable?.length ?: 0//elvis
    //可以调用,强制转换成非空类型(不建议使用)
    val length = nullable!!.length

    var x: String = "Hello"
    var y: String? = "World"
    //不能赋值，类型不匹配
//    x = y
    //可以赋值，符合里氏替换原则
    y = x

    var a: Int = 2
    var b: Number = 10.0

//    a = b
    b = a

    //Kotlin平台类型有Java，JavaScript，Native
    //在Kotlin下调用Java会返回平台类型，类型!
    val person = Person("123", 20)
    //String!为平台类型,可能为空
    val title = person.title()
    val titleLength = title?.length ?: 0
}

