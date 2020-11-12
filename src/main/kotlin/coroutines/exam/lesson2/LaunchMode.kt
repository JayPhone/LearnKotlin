package coroutines.exam.lesson2

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

/**
 * 协程的4种启动模式
 */

//默认启动模式，CoroutineStart.DEFAULT，立即执行协程体
//suspend fun main() {
//    log(1)
//    //协程是在调度器里面被调用的，调度器里面包含一些线程来处理异步任务(类似线程池)
//    val job = GlobalScope.launch {
//        log(2)
//    }
//    log(3)
//    //类似Thread.json，合并任务到当前线程
//    job.join()
//    log(4)
//}

//懒汉式启动模式，CoroutineStart.LAZY，只有在需求的情况下执行协程体，不会默认执行，当调用如job.start(),job.join()时才会启动
suspend fun main() {
    log(1)
    //协程是在调度器里面被调用的，调度器里面包含一些线程来处理异步任务(类似线程池)
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        log(2)
    }
    log(3)
    //直接调用start可能不会输出2，因为主线程在输出完4之后就退出了
    job.start()
//    job.join()
    log(4)
}

//CoroutineStart.ATOMIC，只有在调度开始了之后才能被cancel(),cancel()调用的时机不同，结果也是有差异的，
//例如协程调度之前、开始调度但尚未执行、已经开始执行、执行完毕等等
//suspend fun main() {
//    log(1)
//    //协程是在调度器里面被调用的，调度器里面包含一些线程来处理异步任务(类似线程池)
//    val job = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
//        log(2)
//    }
//    job.cancel()
//    log(3)
//}

fun log(value: Int) {
    println("${Date(System.currentTimeMillis())} [${Thread.currentThread().name}] $value")
}