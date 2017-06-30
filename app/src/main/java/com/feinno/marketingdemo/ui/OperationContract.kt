package com.feinno.marketingdemo.ui

import com.feinno.marketingdemo.base.BasePresenter
import com.feinno.marketingdemo.base.BaseView
import com.feinno.marketingdemo.data.bean.ParamOperationQuery

/**
 * @project: MarketingDemo
 * @description: //TODO(用一句话描述该文件做什么)
 * @author zzy05
 * @date 2017/6/22 15:02
 * @updateUser zzy05
 * @update 2017/6/22 15:02
 * @version V1.0
 */
interface OperationView :BaseView<OperationPresenter> {
    fun toast(content: String)
}

interface OperationPresenter : BasePresenter {
    fun query(bean: ParamOperationQuery)
}