package com.feinno.marketingdemo.api

import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

/**
 * @project: MarketingDemo
 * @description: //通知接口
 * @author zzy05
 * @date 2017/6/22 16:20
 * @updateUser zzy05
 * @update 2017/6/22 16:20
 * @version V1.0
 */
interface INotify {

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showSnackBar(view: View, content: String) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show()
    }

    fun showSnackBarByCallBack(view: View, content: String, action: String, onClickListener: View.OnClickListener) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).setAction(action, onClickListener).show()
    }

    fun showSnackBarAllExist(view: View, content: String, action: String, onClickListener: View.OnClickListener) {
        Snackbar.make(view, content, Snackbar.LENGTH_INDEFINITE).setAction(action, onClickListener).show()
    }
}