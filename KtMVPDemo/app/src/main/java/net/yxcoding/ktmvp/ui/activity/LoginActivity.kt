package net.yxcoding.ktmvp.ui.activity

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import net.yxcoding.ktmvp.R
import net.yxcoding.ktmvp.http.ResponseException
import net.yxcoding.ktmvp.model.entity.User
import net.yxcoding.ktmvp.nativejni.NativeUtil
import net.yxcoding.ktmvp.presenter.LoginPresenter
import net.yxcoding.ktmvp.ui.view.ILoginView

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24
 * @Time 9:29
 */
class LoginActivity : BaseActivity(), ILoginView {

    private var edtAccount: EditText? = null
    private var edtPwd: EditText? = null

    private var loginPresenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_login)

        edtAccount = findViewById(R.id.edt_account) as EditText?
        edtPwd = findViewById(R.id.edt_pwd) as EditText?

        loginPresenter = LoginPresenter(this)
        findViewById(R.id.btn_login).setOnClickListener({
            loginPresenter?.login(this)
        })

        var tvNative = findViewById(R.id.tv_native) as TextView
        var str = NativeUtil.add(3, 8).toString() + " " + NativeUtil.contactStr("hello")
        tvNative.text = str
    }

    override fun getAccount(): String? {
        return edtAccount?.text.toString().trim()
    }

    override fun getPwd(): String? {
        return edtPwd?.text.toString().trim()
    }

    override fun onLoginSuccess(user: User) {
    }

    override fun onLoginFailure(e: ResponseException) {
    }
}