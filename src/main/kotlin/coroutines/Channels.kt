package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 延期的值提供了一种便捷的方法使单个值在多个协程之间进行相互传输。 通道提供了一种在流中传输值的方法。
 */

/**
 * 通道基础
 */
//fun main() = runBlocking {
//    val channel = Channel<Int>()
//    launch {
//        // 这里可能是消耗大量 CPU 运算的异步逻辑，我们将仅仅做 5 次整数的平方并发送
//        for (x in 1..5) channel.send(x * x)
//    }
//    // 这里我们打印了 5 次被接收的整数：
//    repeat(5) { println(channel.receive()) }
//    println("Done!")
//}

/**
 * 关闭与迭代通道
 */
//fun main() = runBlocking {
//    val channel = Channel<Int>()
//    launch {
//        for (x in 1..5) channel.send(x * x)
//        channel.close() // 我们结束发送
//    }
//    // 这里我们使用 `for` 循环来打印所有被接收到的元素（直到通道被关闭）
//    for (y in channel) println(y)
//    println("Done!")
//}

/**
 * 构建通道生产者
 */
//fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
//    for (x in 1..5) send(x * x)
//}
//
//fun main() = runBlocking {
//    val squares = produceSquares()
//    squares.consumeEach { println(it) }
//    println("Done!")
//}

/**
 * 管道
 * 管道是一种一个协程在流中开始生产可能无穷多个元素的模式
 */
//fun main() = runBlocking {
//    val numbers = produceNumbers() // 从 1 开始生成整数
//    val squares = square(numbers) // 整数求平方
//    repeat(5) {
//        println(squares.receive())// 输出前五个
//    }
//    println("Done!") // 至此已完成
//    coroutineContext.cancelChildren()// 取消子协程
//}
//
//fun CoroutineScope.produceNumbers() = produce {
//    var x = 1
//    while (true) {
//        send(x++)// 在流中开始从 1 生产无穷多个整数
//    }
//}
//
//fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
//    for (x in numbers) {
//        send(x * x)
//    }
//}

/**
 * 使用管道的素数
 */

fun main() = runBlocking {
    var cur = numbersFrom(2)
    repeat(10) {
        val prime = cur.receive()
        println(prime)
        cur = filter(cur, prime)
    }
    coroutineContext.cancelChildren() // 取消所有的子协程来让主协程结束
}

fun CoroutineScope.numbersFrom(start: Int) = produce<Int> {
    var x = start
    while (true) {
        send(x++)//从 start 开始过滤整数流
    }
}

fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int) = produce<Int> {
    for (x in numbers) if (x % prime != 0) send(x)
}
