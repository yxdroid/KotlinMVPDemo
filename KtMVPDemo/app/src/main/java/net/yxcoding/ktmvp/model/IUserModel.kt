package net.yxcoding.ktmvp.model

import android.content.Context
import com.loopj.android.http.RequestParams
import net.yxcoding.ktmvp.http.ResponseCallBack
import net.yxcoding.ktmvp.model.entity.User

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24 0024
 * @Time 10:22
 */
interface IUserModel {

    fun login(context: Context, params: RequestParams?, callback: ResponseCallBack<User>?)
}