package com.feinno.marketingdemo.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.feinno.marketingdemo.R
import com.feinno.marketingdemo.base.BaseFragment
import com.feinno.marketingdemo.base.BasePresenter
import com.feinno.marketingdemo.data.bean.BeanOperationQuery
import com.feinno.marketingdemo.delegate.Preference
import com.feinno.marketingdemo.extend.showToast


/**
 * @project: MarketingDemo
 * @description: 运营位View实现
 * @author zzy05
 * @date 2017/6/21 12:04
 * @updateUser zzy05
 * @update 2017/6/21 12:04
 * @version V1.0
 */
class OperationFragment private constructor(): BaseFragment<OperationPresenter>(), OperationView {

    private var mListener: OnFragmentInteractionListener? = null
    private var buttonSearch: Button? = null

    private var userId by Preference("UserId", "csdn41526")

    override fun initParams(arguments: Bundle?) {
    }

    override fun bindLayout(): Int {
        return R.layout.fragment_operation_selection
    }

    override fun initView(rootView: View) {
        buttonSearch = rootView.findViewById(R.id.buttonSearch) as Button
    }

    override fun setListener() {
        buttonSearch?.setOnClickListener {
            presenter?.query(BeanOperationQuery())
        }
    }

    override fun doBusiness() {
    }

    fun onButtonPressed() {
        if (mListener != null) {
            mListener!!.onFragmentInteraction()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context as OnFragmentInteractionListener?
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction()
    }

    /**
     * 单例
     */
    companion object {
        fun newInstance(): OperationFragment {
            return OperationFragment()
        }
    }

    /**
     * 通知
     */
    override fun toast(content: String) {
        showToast(content + userId)
        print(content)
    }

    override fun setBasePresenter(presenter: BasePresenter) {
        this.presenter = presenter as OperationPresenter
    }

}
