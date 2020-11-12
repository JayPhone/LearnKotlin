package base

/**
 * lambda表达式
 */
fun main() {
    //匿名函数
    val func = fun() {
        println("Hello")
    }

    //函数调用
    func()
    func.invoke()

    val lambda: (Int, String) -> String = { i: Int, s: String ->
        println("Lambda $i $s")
        //最后一行为函数返回值
        "Kotlin"
    }

    val result: String = lambda.invoke(1, "1")
    println(result)
}