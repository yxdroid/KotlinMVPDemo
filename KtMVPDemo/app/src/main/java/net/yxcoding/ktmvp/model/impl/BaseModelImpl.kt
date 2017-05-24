package net.yxcoding.ktmvp.model.impl

import android.content.Context
import android.util.Log
import com.alibaba.fastjson.TypeReference
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import net.yxcoding.ktmvp.http.JsonAndObject
import net.yxcoding.ktmvp.http.ResponseCallBack
import net.yxcoding.ktmvp.http.ResponseException
import net.yxcoding.ktmvp.http.YxcodingHttp
import net.yxcoding.ktmvp.model.entity.Result
import java.net.HttpURLConnection.HTTP_OK

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24
 * @Time 11:11
 */
open abstract class BaseModelImpl {

    protected fun <T, P> get(context: Context, url: String, params: RequestParams?,
                             callback: ResponseCallBack<T>?, t: TypeReference<P>) {

        val url = getAbsoluteUrl(context, url)

        addHeaders()

        YxcodingHttp.getInstance()[context, url, params, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?,
                                   responseBody: ByteArray?)
                    = handleResponse(context, statusCode, responseBody, callback, t)

            override fun onStart() {
                callback?.onStart()
            }

            override fun onFinish() {
                callback?.onFinish()
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?,
                                   responseBody: ByteArray?, error: Throwable?) {
                callback?.onFailure(ResponseException(statusCode, error as Throwable))
            }

        }]
    }

    protected fun <T, P> post(context: Context, url: String, params: RequestParams?,
                              callback: ResponseCallBack<T>?, t: TypeReference<P>) {
        val url = getAbsoluteUrl(context, url)

        addHeaders()
        Log.d("Yxcoding HTTP : ", url)
        YxcodingHttp.getInstance().post(context, url, params, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?,
                                   responseBody: ByteArray?) = handleResponse(context, statusCode, responseBody, callback, t)

            override fun onStart() {
                callback?.onStart()
            }

            override fun onFinish() {
                callback?.onFinish()
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                Log.d("Yxcoding onFailure : ", error?.message)
                callback?.onFailure(ResponseException(statusCode, error as Throwable))
            }

        })
    }

    fun <T, P> handleResponse(context: Context, statusCode: Int, responseBody: ByteArray?,
                              callback: ResponseCallBack<T>?, t: TypeReference<P>) {

        Log.d("Yxcoding HTTP : ", String(responseBody as ByteArray))

        if (callback == null) {
            return
        }

        if (statusCode == HTTP_OK) {
            var result: Result<T>
            try {
                result = JsonAndObject.json2Object(String(responseBody as ByteArray), t) as Result<T>
                if (Result.OK_CODE == result.code) {
                    callback.onSuccess(result.data as T)
                } else {
                    callback.onFailure(ResponseException(statusCode, result.msg as String))
                }
            } catch(e: Exception) {
                callback.onFailure(ResponseException(statusCode, "数据解析异常"))
            }
        } else {
            callback.onFailure(ResponseException(statusCode, "数据解析异常"))
        }
    }

    private fun getAbsoluteUrl(context: Context, relativeUrl: String) = "" + relativeUrl

    private fun addHeaders() {
        YxcodingHttp.getInstance().addHeader("os", "Android")
    }
}