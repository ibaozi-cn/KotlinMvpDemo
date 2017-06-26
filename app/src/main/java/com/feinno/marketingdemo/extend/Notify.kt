package com.feinno.marketingdemo.extend

import android.app.Activity
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast

/**
 * @project: MarketingDemo
 * @description: //Activity Fragment通知扩展
 * @author zzy05
 * @date 2017/6/22 16:20
 * @updateUser zzy05
 * @update 2017/6/22 16:20
 * @version V1.0
 */

fun Activity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.showSnackBar(view: View, content: String) {
    Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show()
}

fun Activity.showSnackBarByCallBack(view: View, content: String, action: String, onClickListener: View.OnClickListener) {
    Snackbar.make(view, content, Snackbar.LENGTH_SHORT).setAction(action, onClickListener).show()
}

fun Activity.showSnackBarAllExist(view: View, content: String, action: String, onClickListener: View.OnClickListener) {
    Snackbar.make(view, content, Snackbar.LENGTH_INDEFINITE).setAction(action, onClickListener).show()
}

fun Fragment.showToast(msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.showSnackBar(view: View, content: String) {
    Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show()
}

fun Fragment.showSnackBarByCallBack(view: View, content: String, action: String, onClickListener: View.OnClickListener) {
    Snackbar.make(view, content, Snackbar.LENGTH_SHORT).setAction(action, onClickListener).show()
}

fun Fragment.showSnackBarAllExist(view: View, content: String, action: String, onClickListener: View.OnClickListener) {
    Snackbar.make(view, content, Snackbar.LENGTH_INDEFINITE).setAction(action, onClickListener).show()
}