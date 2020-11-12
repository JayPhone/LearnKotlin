package collect

import base.to

/**
 * Kotlin集合
 */
fun main(args: Array<String>) {
    //带Mutable的集合才能添加或者移除元素

    //不可修改的List
    val list: List<Int> = listOf(1, 2, 3)
    //java相似写法
    val commonList = ArrayList<String>()
    println(list.joinToString())

    //可修改的List
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
    mutableList.add(4)
    mutableList.remove(2)
    println(mutableList.joinToString())

    //添加元素
    for (i in 1..10) {
        //等价于add()
        mutableList += i
    }
    println(mutableList.joinToString())
    //移除元素
    for (i in 1..10) {
        //等价于add()
        mutableList -= i
    }
    println(mutableList.joinToString())
    //元素的设置
    mutableList[0] = 2
    //元素的读取
    println(mutableList[0])
    println(mutableList.joinToString())

    //不可修改Map ,to为infix函数，返回Pair<Key, Value>
    //Any等价于Java中的Object
    val map: Map<String, Any> = mapOf("name" to "JayPhone", "age" to 24)
    val mutableMap: MutableMap<String, Any> = mutableMapOf("name" to "JayPhone", "age" to 24)
    //Map的读
    val name: String = mutableMap.get("name").toString()
    val name1: String = mutableMap["name"].toString()
    println("$name,$name1")

    if ("name" in map) {
        println(map["name"])
    }

    //两个元素
    val pair = "Hello" to "Kotlin"
    val pair2 = Pair("Hello", "Kotlin")
    val first = pair.first
    val second = pair.second
    println("$first,$second")
    //解构，解除结构
    val (x, y) = pair
    println("$x,$y")

    //三个元素
    val triple = Triple("x", 2, 3.0)
    val fir = triple.first
    val sec = triple.second
    val trd = triple.third
    val (a, b, c) = triple
    println("$a,$b,$c")
}