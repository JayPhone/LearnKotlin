package base

/**
 * Kotlin基本数据类型
 */
fun main() {
    //变量
    var a: Int = 2
    //常量
    val b: String = "Hello Kotlin"

    //类型必须大写
//  val c = 12345678910l  Use 'L' instead of 'l'
    val c = 12345678910L

    val d = 3.0 //Double类型，3.0f为Float类型
    val float = 3.0f

    val e: Int = 10
//  val f: Long = e //不能强制转换
    val f: Long = e.toLong()

    val g: UInt = 10u //非符号整形
    val h: ULong = 100000000000000u//非符号长整形

    val i: UByte = 1u//非符号字节

    //字符串模板
    println("Range of Int:[${Int.MIN_VALUE},${Int.MAX_VALUE}]")
    println("Range of UInt:[${UInt.MIN_VALUE},${UInt.MAX_VALUE}]")

    val k = "Today is a sunny day"//常量池
    val m = String("Today is a sunny day".toCharArray())//创建字符串对象，堆
    println(k == m) //判断内容是否一致
    println(k === m) //判断对象是否一致

    //Raw String，输出带格式的字符串
    val n = """
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Hello Kotlin</title>
            </head>
            <body>
            </body>
        </html>
    """.trimIndent()
    println(n)
}