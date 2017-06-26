package com.feinno.marketingdemo.base

/**
 * @project: MarketingDemo
 * @description: //TODO(用一句话描述该文件做什么)
 * @author zzy05
 * @date 2017/6/22 16:43
 * @updateUser zzy05
 * @update 2017/6/22 16:43
 * @version V1.0
 */
interface BaseView<T : BasePresenter> {
    fun setBasePresenter(presenter: BasePresenter)
}