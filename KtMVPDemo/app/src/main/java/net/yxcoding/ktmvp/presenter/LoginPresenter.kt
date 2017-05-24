package net.yxcoding.ktmvp.presenter

import android.content.Context
import android.text.TextUtils
import com.loopj.android.http.RequestParams
import net.yxcoding.ktmvp.http.ResponseCallBack
import net.yxcoding.ktmvp.http.ResponseException
import net.yxcoding.ktmvp.model.IUserModel
import net.yxcoding.ktmvp.model.entity.User
import net.yxcoding.ktmvp.model.impl.UserModelImpl
import net.yxcoding.ktmvp.ui.view.ILoginView

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24
 * @Time 9:35
 */
class LoginPresenter(val loginView: ILoginView) {

    private var userModel: IUserModel? = null

    init {
        userModel = UserModelImpl()
    }

    fun login(context: Context) {

        if (loginView == null) {
            return
        }

        val account = loginView?.getAccount()
        val pwd = loginView?.getPwd()

        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(pwd)) {
            loginView?.showTip("账号密码不能为空")
            return
        }

        val params = RequestParams()
        params.put("account", account)
        params.put("pwd", pwd)

        userModel?.login(context, params, object : ResponseCallBack<User>() {
            override fun onSuccess(t: User) = loginView?.onLoginSuccess(t)

            override fun onStart() = loginView?.showLoadingDialog()

            override fun onFinish() = loginView?.closeLoadingDialog()

            override fun onFailure(re: ResponseException) = loginView.onLoginFailure(re)
        })
    }

}