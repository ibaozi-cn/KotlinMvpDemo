package com.feinno.marketingdemo.delegate

import com.feinno.marketingdemo.base.BasePresenter
import com.feinno.marketingdemo.base.BaseView
import java.lang.IllegalStateException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @project: MarketingDemo
 * @description: //委托BaseView属性的set get 在set中添加额外的配置
 * @author zzy05
 * @date 2017/6/22 17:05
 * @updateUser zzy05
 * @update 2017/6/22 17:05
 * @version V1.0
 */
class ViewSet<T : BaseView<*>>(val presenter: BasePresenter) : ReadWriteProperty<Any?, T> {

    private var view: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return view ?: throw IllegalStateException()
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.view = value
        this.view?.setBasePresenter(presenter)
    }

}