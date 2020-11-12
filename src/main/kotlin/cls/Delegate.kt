package cls

/**
 * 代理
 */
class Delegate(val inf: Inf) : Inf by inf {
    override fun method() {
        println("before")
        inf.method()
        println("after")
    }
}

class Imp : Inf {
    override fun method1() {
        println("method1")
    }

    override fun method() {
        println("method")
    }
}

interface Inf {
    fun method()

    fun method1()
}

fun main() {
    val imp: Imp = Imp()
    val delegate: Delegate = Delegate(imp)
    delegate.method()
}