import java.util.*

/**
 * Kotlin函数
 * 类里面的函数叫方法，没有调用者（receiver）的函数叫函数
 */
fun main() {
//    //函数使用
//    val result = double(2)
//    print(result)
//
//    /**
//     * 对于 JVM 平台：在调用 Java 函数时不能使用具名参数语法，因为 Java 字节码并不总是保留函数参数的名称。
//     */
//
//    //如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该函数来使用
//    foo(baz = 1)
//
//    //如果在默认参数之后的最后一个参数是 lambda 表达式，那么它既可以作为具名参数在括号内传入，也可以在括号外传入
//    foo(1) { println("Hello") }// 使用默认值 baz = 1
//    foo(qux = { println("Hello") })//使用两个默认值 bar = 0 与 baz = 1
//    foo { println("Hello") }// 使用两个默认值 bar = 0 与 baz = 1
//
//    //使用具名参数我们可以使代码更具有可读性
//    reformat("", normalizeCase = true, upperCaseFirstLetter = true, divideByCamelHumps = false, wordSeparator = '_')
//
//    //可以通过使用星号操作符将可变数量参数（vararg） 以具名形式传入
//    foo(strings = *arrayOf("a", "b", "c"))
//
//    //允许将可变数量的参数传递给函数
//    val l = asList(1, 2, 3)
//
//    //当我们调用 vararg-函数时，我们可以一个接一个地传参，例如 asList(1, 2, 3)，或者，
//    //如果我们已经有一个数组并希望将其内容传给该函数，我们使用伸展（spread）操作符（在数组前面加 *）
//    val a = arrayOf(1, 2, 3)
//    val list = asList(-1, 0, *a, 4)
//
//    //用中缀表示法调用该函数
//    1 shiftLeft 1
//    //等同于这样
//    1.shiftLeft(2)
//
//    //闭包
//    val fibo: () -> Long = fibonacci()
//    println(fibo())
//    println(fibo())
//    println(fibo())
//    println(fibo())
//    println(fibo())

    runBlock {
        List(1000) {
            println("Hello World")
        }
    }

    //顶级函数引用 （参数..)->返回值 = ::函数名
    val funRef: (Int, Int) -> Unit = ::powerOf

    //类函数引用 写法一 (类名，参数..)->返回值 = 类名::函数名
    val funRef1: (A, Int) -> Unit = A::foo
    //类函数引用 写法二 类名.(参数..)->返回值 = 类名::函数名
    val funRef2: A.(Int) -> Unit = A::foo
    //类函数引用 写法三 FunctionN(类名，参数..，返回值) = 类名::函数名
    val funRef3: Function2<A, Int, Unit> = A::foo

    //类实例函数引用 (参数..)->返回值 = 类实例::函数名
    val b: B = B()
    val funRef4: (String, Int) -> Any = b::action
}

/**
 * 函数声明
 * @see main
 */
fun double(x: Int): Int {
    return x * 2
}

/**
 * 函数参数声明
 */
fun powerOf(number: Int, exponent: Int) {

}

/** 函数默认参数声明
 * 函数参数可以有默认值，当省略相应的参数时使用默认值。与其他语言相比，这可以减少重载数量
 */
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {

}

/**
 * 覆盖方法总是使用与基类型方法相同的默认参数值。 当覆盖一个带有默认参数值的方法时，必须从签名中省略默认参数值
 */
open class A {
    open fun foo(i: Int = 100) {

    }
}

class B : A() {
    override fun foo(i: Int) {

    }

    fun action(s: String, i: Int): Any {
        return 1
    }
}

/**
 * 如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该函数来使用
 * @see main
 */
fun foo(bar: Int = 0, baz: Int) {

}

/**
 * 如果在默认参数之后的最后一个参数是 lambda 表达式，那么它既可以作为具名参数在括号内传入，也可以在括号外传入
 * @see main
 */
fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {

}

/**
 * 具名参数
 * 可以在调用函数时使用具名的函数参数。当一个函数有大量的参数或默认参数时这会非常方便
 * @see main
 */
fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' '
) {

}

/**
 * 可以通过使用星号操作符将可变数量参数（vararg） 以具名形式传入
 * @see main
 */
fun foo(vararg strings: String) {

}

/**
 * 如果一个函数不返回任何有用的值，它的返回类型是 Unit。Unit 是一种只有一个值——Unit 的类型。这个值不需要显式返回
 */
fun printHello(name: String?): Unit {
    if (name != null) {
        println("Hello$name")
    } else {
        println("Hi there!")
    }
    // `return Unit` 或者 `return` 是可选的
    return Unit
}

/**
 * 当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可
 */
fun doubleExpression(x: Int): Int = x * 2

/**
 * 可变数量的参数（Varargs）
 * 函数的参数（通常是最后一个）可以用 vararg 修饰符标记
 * @see main
 */
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}

/**
 * 中缀表示法
 * 标有 infix 关键字的函数也可以使用中缀表示法（忽略该调用的点与圆括号）调用。中缀函数必须满足以下要求：
 * 它们必须是成员函数或扩展函数
 * 它们必须只有一个参数
 * 其参数不得接受可变数量的参数且不能有默认值
 * @see main
 */
infix fun Int.shiftLeft(x: Int): Int {
    return 0
}

/**
 * 斐波那契数列
 * 局部函数可以访问外部函数（即闭包）的局部变量
 * @see main
 */
fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return fun(): Long {//返回返回值为Long类型的函数(闭包)
        val result = second
        second += first
        first = second - first
        return result
    }
}

val eps = 1E-10
/**
 * Kotlin 支持一种称为尾递归的函数式编程风格。
 * 这允许一些通常用循环写的算法改用递归函数来写，而无堆栈溢出的风险。
 * 当一个函数用 tailrec 修饰符标记并满足所需的形式时，编译器会优化该递归，留下一个快速而高效的基于循环的版本
 * 要符合 tailrec 修饰符的条件的话，函数必须将其自身调用作为它执行的最后一个操作
 */
tailrec fun findFixPoint(x: Double = 1.0): Double =
    if (Math.abs(x - Math.cos(x)) < eps) {
        x
    } else {
        findFixPoint(Math.cos(x))
    }

fun <T, R> Collection<T>.fold(initial: R, combine: (acc: R, nextElement: T) -> R): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

/**
 * 函数类型
 * (Int) -> Int
 * 1. 所有函数类型都有一个圆括号括起来的参数类型列表以及一个返回类型：
 * (A, B) -> C 表示接受类型分别为 A 与 B 两个参数并返回一个 C 类型值的函数类型。
 * 参数类型列表可以为空，如 () -> A。Unit 返回类型不可省略
 * 2.
 */
fun functionType(): (Int) -> Int {
    return fun(x: Int): Int {
        return x
    }
}

fun runBlock(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)
}

/**
 * 通过使用类型别名给函数类型起一个别称
 */
typealias alias = (Int, Int) -> Unit

