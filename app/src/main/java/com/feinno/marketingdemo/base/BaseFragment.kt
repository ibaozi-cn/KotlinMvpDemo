package com.feinno.marketingdemo.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feinno.marketingdemo.api.INotify
import com.feinno.marketingdemo.api.IViewSpecification


/**
 * @project: MarketingDemo
 * @description: //TODO(用一句话描述该文件做什么)
 * @author zzy05
 * @date 2017/6/22 14:30
 * @updateUser zzy05
 * @update 2017/6/22 14:30
 * @version V1.0
 */
abstract class BaseFragment<T : BasePresenter> : Fragment(), INotify, IViewSpecification {

    var presenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initParams(arguments)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(bindLayout(), container, false)
        initView(rootView)
        setListener()
        doBusiness()
        return rootView
    }

}