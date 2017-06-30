package com.feinno.marketingdemo.ui


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import com.feinno.marketingdemo.BusinessActivity
import com.feinno.marketingdemo.R
import com.feinno.marketingdemo.data.bean.*
import com.feinno.marketingdemo.data.repository.ActivitySource
import com.feinno.marketingdemo.extend.showToast
import kotlinx.android.synthetic.main.fragment_business.*


/**
 * @project: MarketingDemo
 * @description: 业务查询页面
 * @author zzy05
 * @date 2017/6/21 12:04
 * @updateUser zzy05
 * @update 2017/6/21 12:04
 * @version V1.0
 */
class BusinessFragment private constructor() : Fragment() {

    private var bcode = "010001"

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_business, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonBusinessResponse.setOnClickListener {
            if (businessValue.text.isEmpty()) {
                businessValue.error = "不能为空"
                businessValue.hint = "不能为空"
                businessValue.requestFocus()
                businessValue.setSelection(0)
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)

            } else {
                val paramBusinessRespond = ParamBusinessRespond(Authinfo(), bcode = bcode, bvalue = businessValue.text.toString())
                ActivitySource.getBusinessRes(paramBusinessRespond, {
                    if (it != null) {
                        if (it.code == 10000) {
                            val data = it.data as List<ActivityBean>
                            val result = ResultBusiness(emptyList(), data)
                            BusinessActivity.startActivity(result, context)
                        } else {
                            showToast(it.desc)
                        }
                    }
                }, {
                    showToast(it.toString())
                })
            }
        }
        buttonBusinessSearch.setOnClickListener {
            val paramBusiness = ParamBusiness(Authinfo(), btyid = 1, bcode = bcode, bname = "")
            ActivitySource.getBusiness(paramBusiness, {
                BusinessActivity.startActivity(it, context)
            }, {
                showToast(it.toString())
            })
        }
        businessCodeSpinner.onItemSelectedListener = OnItemSelect()
    }

    inner class OnItemSelect : OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {
        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            bcode = p0?.adapter?.getItem(p2).toString()
            showToast(bcode)
        }
    }

    companion object {
        fun newInstance(): BusinessFragment {
            return BusinessFragment()
        }
    }
}


