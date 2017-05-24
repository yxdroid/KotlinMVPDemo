package net.yxcoding.ktmvp.ui.view

import net.yxcoding.ktmvp.http.ResponseException
import net.yxcoding.ktmvp.model.entity.User

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24 0024
 * @Time 9:35
 */
interface ILoginView : IBaseView {

    fun getAccount(): String?

    fun getPwd(): String?

    fun onLoginSuccess(user: User)

    fun onLoginFailure(e: ResponseException)
}