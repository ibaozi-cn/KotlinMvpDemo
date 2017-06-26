package com.feinno.marketingdemo

import android.app.Application
import com.feinno.marketingdemo.delegate.NotNullSingleValueVar

/**
 * @project: KotlinMvpDemo
 * @description: //应用程序 application
 * @author zzy05 zhangzhanyong@feinno.com
 * @date 2017/6/23 17:44
 * @updateUser zzy05
 * @update 2017/6/23 17:44
 * @version V1.0
 */
class App : Application() {

    companion object {
        var instance: App by NotNullSingleValueVar<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}