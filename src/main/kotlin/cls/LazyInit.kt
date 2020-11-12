package cls

/**
 * 类属性的延迟
 * 由于kotlin的空安全特性，类属性必须在定义时初始化
 */
class LazyInit {
    //方法一
    private var mContent: String? = null
    //方法二
    private lateinit var mContent2: String
    //方法三
    private val mContent3: String by lazy {
        "456"
    }

    fun onCreate() {
        mContent = "text"

        mContent2 = "123"
    }
}