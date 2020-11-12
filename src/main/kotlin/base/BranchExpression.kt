package base

/**
 * Kotlin分支表达式
 */
fun main(args: Array<String>) {
    val a = 1
    //if..else表达式
    var c: Int = if (a == 3) 4 else 5

    //when表达式,相当于switch，:换成->
    when (a) {
        0 -> c = 5
        1 -> c = 1
        else -> c = 20
    }

    var x: Any = 1
    var b = when {
        x is String -> x.length
        x == 1 -> c = 100
        else -> c = 200
    }

    var d = when (val input = readLine()) {
        null -> 0
        else -> input.length
    }

    //try..catch表达式
    var e = try {
        1 / 2
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }
}