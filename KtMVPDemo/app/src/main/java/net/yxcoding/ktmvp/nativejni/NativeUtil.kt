package net.yxcoding.ktmvp.nativejni

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24
 * @Time 14:25
 */
class NativeUtil {

    companion object {
        init {
            System.loadLibrary("NativeUtil")
        }

        external fun stringFromJNI(): String

        external fun add(a: Int, b: Int): Int

        external fun contactStr(str: String): String
    }
}