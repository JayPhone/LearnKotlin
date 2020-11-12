package base

//常量，相当于java中的static final
const val d = 3

fun main() {
    //变量
    var a = 2
    a = 3

    //只读变量，局部变量可以认为是常量
    val b = 3

    //常量引用
    val c: A = A()

    //编译期和运行时常量
}

class A {
    //只读变量，值可以改变，不是常量
    val c: Int
        get() {
            return (Math.random() * 100).toInt()
        }
}