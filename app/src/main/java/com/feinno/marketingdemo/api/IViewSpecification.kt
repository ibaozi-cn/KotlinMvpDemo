package com.feinno.marketingdemo.api

import android.os.Bundle
import android.view.View

/**
 * @project: MarketingDemo
 * @description: //view层 编码规范
 * @author zzy05
 * @date 2017/6/22 16:25
 * @updateUser zzy05
 * @update 2017/6/22 16:25
 * @version V1.0
 */
interface IViewSpecification {

    /**
     * 初始化Bundle参数
     */
    fun initParams(arguments: Bundle?)

    /**
     * 绑定布局
     */
    fun bindLayout(): Int

    /**
     * 初始化view
     */
    fun initView(rootView: View)

    /**
     * 设置监听
     */
    fun setListener()

    /**
     * 处理业务逻辑
     */
    fun doBusiness()
}