package net.yxcoding.ktmvp.model.entity

/**
 * User: yxfang
 * Date: 2016-07-29
 * Time: 20:56
 * ------------- Description -------------
 * HTTP请求统一返回数据结构
 * ---------------------------------------
 */
class Result<out T> {

    val code: Int = 0
    val msg: String? = null
    val data: T? = null

    companion object {
        val OK_CODE = 200
    }
}
