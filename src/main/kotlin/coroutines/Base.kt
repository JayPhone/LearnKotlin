package coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.channels.ReceiveChannel
import sun.reflect.generics.scope.ConstructorScope


fun main() {
    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        delay(1000L)
        println("World!")
    }
    println("Hello,") // 主线程中的代码会立即执行
    runBlocking {
        // 但是这个表达式阻塞了主线程
        delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
    }
}

//fun main() {
//    GlobalScope.launch { // 在后台启动一个新的协程并继续
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,") // 主线程中的代码会立即执行
//    runBlocking {     // 但是这个表达式阻塞了主线程
//        delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
//    }
//}


//fun main() = runBlocking<Unit> {
//    GlobalScope.launch {// 在后台启动一个新的协程并继续
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,") // 主协程在这里会立即执行
//    delay(2000L)      // 延迟 2 秒来保证 JVM 存活
//}

//fun main() = runBlocking {
//    val job = GlobalScope.launch {
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//    job.join()
//}

//fun main() = runBlocking {
//    launch {
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//}

//fun main() = runBlocking {
//    launch {
//        delay(200L)
//        println("Task from runBlocking")
//    }
//    //runBlocking会阻塞线程，而coroutineScope只会挂起，并且都会等待协程体内的协程都处理完毕再结束
//    coroutineScope {// 创建一个协程作用域
//        launch {
//            delay(500L)
//            println("Task from nested launch")
//        }
//
//        delay(100L)
//        println("Task from coroutine scope")
//    }
//    println("Coroutine scope is over")
//}

//fun main() = runBlocking {
//    launch {
//        doWorld()
//    }
//    println("Hello,")
//}
//
//suspend fun doWorld() {
//    delay(1000L)
//    println("World!")
//}

//fun main() = runBlocking {
//    repeat(100_100) {
//        launch {
//            delay(5000L)
//            print(".")
//        }
//    }
//}








