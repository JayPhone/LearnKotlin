package sam

/**
 * SAM single abstract function
 */
fun main(args: Array<String>) {
    { println("Fuck World") }()

    //匿名内部类写法1
    val thread1: Thread = Thread(object : Runnable {
        override fun run() {
            println("Hello")
        }
    })
    thread1.start()

    //匿名内部类写法2
    val thread2: Thread = Thread(Runnable {
        println("Kotlin")
    })
    thread2.start()


    Runnable {

    }
    //等价于编译器自动生成以下代码
    fun Runnable(block: () -> Unit): Runnable {
        return object : Runnable {
            override fun run() {
                block()
            }
        }
    }

    submit(object : Invokable {
        override fun invoke() {
        }
    })

    //kotlin的接口类型不支持SAM转换，不能转换成lambda表达式
//    submit{
//
//    }

    //从kotlin1.3 添加编译参数可支持传递java类型的接口转换成lambda
//    submitRunnable{
//
//    }

    //无需定义接口，直接传递lambda
    submit {

    }

    //SAM转换的坑
    val eventManager = EventManager()
    eventManager.addOnEventListeners {
        println("onEvent $it")
    }
    //等价于
    eventManager.addOnEventListeners(object : EventManager.OnEventListener {
        override fun onEvent(event: Int) {
            println("onEvent $event")
        }
    })

    //不能移除
    eventManager.removeOnEventListeners(object : EventManager.OnEventListener {
        override fun onEvent(event: Int) {
            println("onEvent $event")
        }
    })
    println(eventManager.listeners)

    //正确移除
    val onEvent = EventManager.OnEventListener { event -> println("onEvent $event") }
    eventManager.addOnEventListeners(onEvent)
    eventManager.removeOnEventListeners(onEvent)
    println(eventManager.listeners)
}

fun submitRunnable(runnable: Runnable) {
    runnable.run()
}

fun submit(invokable: Invokable) {
    invokable.invoke()
}

//类型别名
typealias FunctionX = () -> Unit

fun submit(invokable: FunctionX) {
    invokable()
}

interface Invokable {
    fun invoke()
}