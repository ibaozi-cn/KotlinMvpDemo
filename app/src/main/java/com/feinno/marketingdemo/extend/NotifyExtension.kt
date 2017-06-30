package com.feinno.marketingdemo.extend

import android.app.Activity
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.feinno.marketingdemo.App

/**
 * @project: MarketingDemo
 * @description: //Activity Fragment通知扩展
 * @author zzy05
 * @date 2017/6/22 16:20
 * @updateUser zzy05
 * @update 2017/6/22 16:20
 * @version V1.0
 */

fun Activity.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(App.instance.applicationContext, msg, duration).show()
}

fun Activity.showSnackBar(view: View, content: String, action: String? = "", onClickListener: View.OnClickListener? = null, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(view, content, duration).setAction(action, onClickListener).show()
}

fun Fragment.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(App.instance.applicationContext, msg, duration).show()
}

fun Fragment.showSnackBar(view: View, content: String, action: String? = "", onClickListener: View.OnClickListener? = null, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(view, content, duration).setAction(action, onClickListener).show()
}
