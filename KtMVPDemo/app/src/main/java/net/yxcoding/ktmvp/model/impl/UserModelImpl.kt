package net.yxcoding.ktmvp.model.impl

import android.content.Context
import com.alibaba.fastjson.TypeReference
import com.loopj.android.http.RequestParams
import net.yxcoding.ktmvp.http.ResponseCallBack
import net.yxcoding.ktmvp.model.IUserModel
import net.yxcoding.ktmvp.model.entity.Result
import net.yxcoding.ktmvp.model.entity.User

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24
 * @Time 11:09
 */

class UserModelImpl : BaseModelImpl(), IUserModel {

    override fun login(context: Context, params: RequestParams?, callback: ResponseCallBack<User>?)
            = post(context, "http://www.huohao.com", params, callback,
            object : TypeReference<Result<User>>() {})

}