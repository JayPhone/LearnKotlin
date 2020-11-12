package sample

fun main(args: Array<String>) {
    val value = "HelloWorld1World"
    println(value - "World")
    println(value * 3)
    println(value / "ld")
}

operator fun String.minus(right: Any?): String {
    return this.replaceFirst(right.toString(), "")
}

operator fun String.times(right: Int): String {
    return (1..right).joinToString("") { this }
}

//region 折叠 ctrl -
operator fun String.div(right: Any?): Int {
    val right = right.toString()
    return this.windowed(right.length, 1) {
        it == right
    }.count { it }
}
//endregion