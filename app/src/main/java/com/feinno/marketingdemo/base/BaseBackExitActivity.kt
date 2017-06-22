package com.feinno.marketingdemo.base

import android.view.KeyEvent
import android.widget.Toast


/**
 * @project: MarketingDemo
 * @description: //继承该类，给当前页添加双击返回退出事件
 * @author zzy05
 * @date 2017/6/22 14:03
 * @updateUser zzy05
 * @update 2017/6/22 14:03
 * @version V1.0
 */
abstract class BaseBackExitActivity : BaseActivity() {

    private var exitTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(applicationContext, "再按一次退出程序",
                        Toast.LENGTH_SHORT).show()
                exitTime = System.currentTimeMillis()
            } else {
                finish()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}