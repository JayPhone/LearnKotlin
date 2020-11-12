package base

/**
 * Kotlin数组
 */
fun main() {
    //整型数组，相当于int[]
    var intArray: IntArray = IntArray(2)
    //整形装箱数组，相当于Integer[]
    var arrayInt: Array<Int> = Array<Int>(2) { it }
    //数组写
    intArray[0] = 1
    intArray[1] = 2
    //数组读
    println("${intArray[0]},${intArray[1]}")

    //数组创建方式1
    intArray = intArrayOf(1, 2, 3, 4, 5)
    //输出数组元素
    println(intArray.contentToString())
    //输出数组长度
    println(intArray.size)
    //数组创建方式2
    intArray = IntArray(3) {
        it * 3
    }
    println(intArray[1])

    //遍历数组
    intArray.forEach { print("${it * 3} ") }
    for (i in intArray) {
        print("$i ")
    }
    println()

    //判断元素是否在数组内
    if (3 in intArray) {
        println("exist!")
    }

    //字符型数组，相当于char[]
    var charArray: CharArray = CharArray(5)
    //字符装箱数组，相当于Character[]
    var arrayChar: Array<Char> = Array<Char>(2) { it.toChar() }
}