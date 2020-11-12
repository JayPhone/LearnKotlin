package function

fun main(args: Array<String>) {
    println("Hello Kotlin".padding(5))
    println("*".times(10))

    val ref: (String, Int) -> String = String::times
    println(ref("-", 10))
    val receiverRef: (Int) -> String = "+"::times
    println(receiverRef(10))
}

//扩展方法
fun String.isEmail(): Boolean {
    return true
}

//扩展方法，给字符串填充边距
fun String.padding(count: Int, char: Char = ' '): String {
    val padding = (1..count).joinToString("") { char.toString() }
    return "$padding$this$padding"
}

//扩展方法，重复某一段字符
fun String.times(count: Int): String {
    return (1..count).joinToString("") { this }
}

class PoorGuy {
    var pocket: Double = 0.0
}

//扩展方法
fun PoorGuy.noMoney() {

}

//扩展属性
var PoorGuy.moneyLeft: Double
    //get和set也可以加inline，以下get set加inline后讲内联到pocket，跟moneyLeft无关
    inline get() {
        //无法返回field，因为不是实例.无法获取到状态，field代表状态(存的值)
        //只能读取public的属性或者方法
        return this.pocket
    }
    inline set(value) {
        this.pocket = value
    }

interface Guy {
    //接口定义的属性不能获取Field，因为接口不是实例，只能定义行为，不能定义状态(与扩展属性类似)
    var moneyLeft: Double
        get() {
            return 0.0
        }
        set(value) {

        }

    //接口中的方法可以定义函数体
    fun noMoney() {

    }
}