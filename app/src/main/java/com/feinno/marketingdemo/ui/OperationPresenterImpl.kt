package com.feinno.marketingdemo.ui

import com.feinno.marketingdemo.data.bean.BeanOperationQuery
import com.feinno.marketingdemo.delegate.ViewSet

/**
 * @project: MarketingDemo
 * @description: //运营为Presenter实现类
 * @author zzy05
 * @date 2017/6/22 15:17
 * @updateUser zzy05
 * @update 2017/6/22 15:17
 * @version V1.0
 */
class OperationPresenterImpl : OperationPresenter {

    //将view的set方法委托给ViewSet 添加setPresenter函数调用
    var view: OperationView by ViewSet<OperationView>(this)

    override fun query(bean: BeanOperationQuery) {
        view.toast("查询完毕")
    }

    override fun start() {
    }

}