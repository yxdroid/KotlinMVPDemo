package net.yxcoding.ktmvp.http

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24
 * @Time 11:09
 */
abstract class ResponseCallBack<in T> {

    /**
     * 数据返回成功

     * @param t
     */
    @Throws(Exception::class)
    abstract fun onSuccess(t: T)

    /**
     * HTTP请求失败
     * 数据返回非正常状态

     * @param re
     */
    abstract fun onFailure(re: ResponseException)

    /**
     * 请求开始时回调
     * 执行在主线程
     */
    open fun onStart() {

    }

    /**
     * 请求结束时回调
     * 执行在主线程
     */
    open fun onFinish() {

    }

}
