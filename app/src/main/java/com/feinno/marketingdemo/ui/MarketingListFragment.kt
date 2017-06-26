package com.feinno.marketingdemo.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.feinno.marketingdemo.R


/**
 * @project: MarketingDemo
 * @description: 活动列表
 * @author zzy05
 * @date 2017/6/21 12:04
 * @updateUser zzy05
 * @update 2017/6/21 12:04
 * @version V1.0
 */
class MarketingListFragment private constructor(): Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_marketing_list, container, false)
    }

    companion object {

        fun newInstance(): MarketingListFragment {
            val fragment = MarketingListFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}
