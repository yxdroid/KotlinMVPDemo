package net.yxcoding.ktmvp.http


import android.content.Context

import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24
 * @Time 11:09
 */
class YxcodingHttp private constructor() {

    private var asyncHttpClient: AsyncHttpClient? = null

    companion object {
        @Synchronized fun getInstance(): YxcodingHttp {
            var instance: YxcodingHttp? = null
            if (instance == null) {
                synchronized(YxcodingHttp::class.java) {
                    instance = YxcodingHttp()
                }
            }
            return instance!!
        }
    }

    init {
        asyncHttpClient = AsyncHttpClient()
    }

    /**
     * Perform a HTTP GET request without any parameters and track the Android Context which
     * initiated the request.

     * @param context         the Android Context which initiated the request.
     * *
     * @param url             the URL to send the request to.
     * *
     * @param params          additional GET parameters to send with the request.
     * *
     * @param responseHandler the response handler instance that should handle the response.
     */
    operator fun get(context: Context, url: String, params: RequestParams?,
            responseHandler: AsyncHttpResponseHandler) {
        asyncHttpClient?.get(context, url, params, responseHandler)
    }

    /**
     * Perform a HTTP GET request without any parameters and track the Android Context which
     * initiated the request.

     * @param context         the Android Context which initiated the request.
     * *
     * @param url             the URL to send the request to.
     * *
     * @param responseHandler the response handler instance that should handle the response.
     */
    fun get(context: Context, url: String, responseHandler: AsyncHttpResponseHandler) {
        get(context, url, null, responseHandler)
    }

    /**
     * Perform a HTTP POST request without any parameters and track the Android Context which
     * initiated the request.

     * @param context         the Android Context which initiated the request.
     * *
     * @param url             the URL to send the request to.
     * *
     * @param params          additional POST parameters to send with the request.
     * *
     * @param responseHandler the response handler instance that should handle the response.
     */
    fun post(context: Context, url: String, params: RequestParams?,
             responseHandler: AsyncHttpResponseHandler) {
        asyncHttpClient?.post(context, url, params, responseHandler)
    }

    /**
     * add Header

     * @param key
     * *
     * @param value
     */
    fun addHeader(key: String, value: String) {
        asyncHttpClient?.addHeader(key, value)
    }

    /**
     * cancel http request

     * @param context
     */
    fun cancelHttpRequest(context: Context) {
        asyncHttpClient?.cancelRequests(context, true)
    }

}
