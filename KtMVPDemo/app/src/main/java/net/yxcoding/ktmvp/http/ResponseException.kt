package net.yxcoding.ktmvp.http

import cz.msebera.android.httpclient.client.HttpResponseException
import org.apache.http.conn.ConnectTimeoutException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24
 * @Time 11:09
 */

class ResponseException {

    private var errorCode: Int = 0
    private var msg: String = ""
    private var error: Throwable? = null

    constructor(errorCode: Int, msg: String) {
        this.errorCode = errorCode
        this.msg = msg
    }

    constructor(errorCode: Int, e: Throwable) {
        this.errorCode = errorCode
        this.error = e
    }

    fun errorMsg(): String {
        if (error == null) {
            return this.msg
        }

        if (error is HttpResponseException) {
            return "服务器连接超时，请稍后再试"
        } else if (error is ConnectTimeoutException || error is SocketTimeoutException) {
            return "服务器连接超时，请稍后再试"
        } else if (error is UnknownHostException
                || error is ConnectException || error is IOException) {
            return "网络异常，请检查网络设置"
        } else if (error is SocketException) {
            return "网络异常，读取数据超时"
        } else {
            return "您的网络不给力"
        }
    }

    companion object {
        val DATA_ERROR_CODE = 0
    }
}
