package cls

fun main(args: Array<String>) {
    val simpleClass = SimpleClass(1, "123")
    val propertyReceiverRef = simpleClass::simplePropertyVar
    propertyReceiverRef.set(2)
    propertyReceiverRef.get()

    println(simpleClass.x)
    simpleClass.y()

    //属性引用
    val propertyValRef = SimpleClass::simplePropertyVal
    propertyValRef.get(simpleClass)

    val propertyVarRef = SimpleClass::simplePropertyVar
    propertyVarRef.set(simpleClass, 1)
    propertyVarRef.get(simpleClass)
}

//主构造器，可以省略constructor
open class SimpleClass(var x: Int, val y: String) : AbsClass(1),
    SimpleInf {
    //实现只读属性的get()方法
    override val simplePropertyVal: Int
        get() = 2

    //实现读写属性的get()和set()方法
    override var simplePropertyVar: Int
        get() = 2
        set(value) {}

    //实现抽象方法
    override fun absMethod() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //实现接口方法
    override fun simpleMethod() {
        TODO("not implemented")
    }

    //重写父类方法
    override fun overridable() {
        super.overridable()
    }

    //加上final后，子类不能重写
    final override fun finalOverridable() {
        super.finalOverridable()
    }

    //成员必须初始化
//    var x: Int = x

    //副构造器
//    constructor(x: Int) {
//        this.x = x
//    }

    fun y() {}
}

class SimpleClass2 : SimpleClass(1, "123") {
    override val simplePropertyVal: Int
        get() = 3

    override var simplePropertyVar: Int
        get() = 3
        set(value) {}

    override fun overridable() {
        super.overridable()
    }
}

//抽象类
abstract class AbsClass(i: Int) {
    var property: Int = i
        get() {
            return field
        }
        set(value) {
            println("$value")
        }

    abstract fun absMethod()

    open fun overridable() {

    }

    open fun finalOverridable() {

    }

    fun nonOverridable() {

    }
}

//接口
//Kotlin属性等于field+getter+setter,
//java只等于field
interface SimpleInf {
    //接口可以定义属性，只读属性默认生成get()
    val simplePropertyVal: Int//property
    //接口可以定义属性，读写属性默认生成get()和set()
    var simplePropertyVar: Int

    fun simpleMethod()
}