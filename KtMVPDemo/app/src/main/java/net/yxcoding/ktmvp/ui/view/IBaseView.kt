package net.yxcoding.ktmvp.ui.view

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24 0024
 * @Time 14:07
 */
interface IBaseView {

    fun showLoadingDialog()

    fun closeLoadingDialog()

    fun showTip(msg: String)
}