package com.feinno.marketingdemo.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.feinno.marketingdemo.api.IViewSpecification


/**
 * @project: MarketingDemo
 * @description: BaseActivity
 * @author zzy05 zhangzhanyong@feinno.com
 * @date 2017/6/21 12:04
 * @updateUser zzy05
 * @update 2017/6/21 12:04
 * @version V1.0
 */
abstract class BaseActivity : AppCompatActivity(), IViewSpecification {

    /**
     * 是否允许屏幕转动  默认不允许
     */
    var isAllowScreenRotate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!isAllowScreenRotate) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        }

        val bundle = intent.extras
        initParams(bundle)

        val viewContent = layoutInflater.inflate(bindLayout(), null)
        setContentView(viewContent)

        setStatusBar()

        initView(viewContent)
        setListener()
        doBusiness()

    }

    /**
     * 设置statusBar主题
     */
    private fun setStatusBar() {
    }

    fun startActivity(targetActivity: Class<*>) {
        startActivity(Intent(this, targetActivity))
    }

    fun startActivity(targetActivity: Class<*>, bundle: Bundle?) {
        startActivity(Intent(this, targetActivity).putExtras(bundle))
    }

    fun startActivityForResult(cls: Class<*>, bundle: Bundle?,
                               requestCode: Int) {
        val intent = Intent()
        intent.setClass(this, cls)
        intent.putExtras(bundle)
        startActivityForResult(intent, requestCode)
    }

    fun addFragmentToActivity(fragmentManager: FragmentManager,
                              fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        if (!fragment.isAdded)
            transaction.add(frameId, fragment)
        fragmentManager.fragments.filter { it.id == fragment.id }.map { transaction.hide(it) }
        transaction.show(fragment)
        transaction.commit()
    }
}