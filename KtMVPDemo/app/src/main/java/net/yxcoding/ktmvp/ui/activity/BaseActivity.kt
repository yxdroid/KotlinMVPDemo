package net.yxcoding.ktmvp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import net.yxcoding.ktmvp.ui.view.IBaseView

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24 0024
 * @Time 14:08
 */
open abstract class BaseActivity : AppCompatActivity(), IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showLoadingDialog() {
        //TODO("not implemented")
    }

    override fun closeLoadingDialog() {
        //TODO("not implemented")
    }

    override fun showTip(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}