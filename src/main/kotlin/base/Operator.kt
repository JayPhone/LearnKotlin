package base

/**
 * 运算符重载
 */
fun main(args: Array<String>) {
    var complex: Complex = Complex(1.0, 2.0)
    complex += 1.0
    println("${complex.real},${complex.image}")

    //中缀表达式
    val pair: Pair<Int, Int> = 2 to 3
}

class Complex(var real: Double, var image: Double)

//运算符重载
operator fun Complex.plus(real: Double): Complex {
    return Complex(this.real + real, this.image)
}

//中缀表达式，只有一个参数
infix fun <A, B> A.to(that: B): Pair<A, B> {
    return Pair(this, that)
}
