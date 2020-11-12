package base

/**
 * Kotlin区间
 */
fun main() {
    //离散
    val intRange: IntRange = 1..10//[1,10]
    val charRange: CharRange = 'a'..'z'//[a,z]
    val longRange: LongRange = 1L..1000L//[1,1000]

    //连续
    val floatRange = 1.0f..2.0f
    val doubleRange = 1.0..2.0

    //输出区间值
    println(intRange.joinToString())
    println(charRange.joinToString())

    //带步长的区间
    val intRangeWithStep = 1..10 step 2
    val charRangeWithStep = 'a'..'z' step 2
    println(intRangeWithStep.joinToString())
    println(charRangeWithStep.joinToString())

    //右开区间
    val intRangeExclusive = 1 until 10//[1,10)
    val charRangeExclusive = 'a' until 'z'//[a,z)
    println(intRangeExclusive.joinToString())
    println(charRangeExclusive.joinToString())

    //倒序闭区间
    val intRangeReverse = 10 downTo 1//[10..1]
    val charRangeReverse = 'z' downTo 'a'
    println(intRangeReverse.joinToString())
    println(charRangeReverse.joinToString())

    val array = intArrayOf(1, 3, 5, 7)
    for (i in 0 until array.size) {
        println(i)
    }

    for (i in array.indices) {
        println(array[i])
    }
}