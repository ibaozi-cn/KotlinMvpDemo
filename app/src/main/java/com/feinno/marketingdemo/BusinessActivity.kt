package com.feinno.marketingdemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.feinno.marketingdemo.base.BaseActivity
import com.feinno.marketingdemo.data.bean.ResultBusiness
import com.feinno.marketingdemo.data.net.ServiceFactory
import com.feinno.marketingdemo.extend.loadImageFromUrl
import kotlinx.android.synthetic.main.activity_business.*
import kotlinx.android.synthetic.main.content_business.*

class BusinessActivity : BaseActivity() {

    private var result: ResultBusiness? = null

    companion object {
        fun startActivity(result: ResultBusiness?, context: Context) {
            val intent = Intent(context, BusinessActivity::class.java)
            intent.putExtra("result", result)
            context.startActivity(intent)

        }
    }

    override fun initParams(arguments: Bundle?) {
        result = arguments?.getSerializable("result") as? ResultBusiness
    }

    override fun bindLayout(): Int {
        return R.layout.activity_business
    }

    @SuppressLint("SetTextI18n")
    override fun initView(rootView: View) {
        setSupportActionBar(toolbar)
        result?.activList?.map {
            toolbarLayout.title = it.atitle
            activityName.text = "活动名称:  ${it.acname}"
            activityDesc.text = "活动摘要:  ${it.summary}"
            JoinNumber.text = "可参与次数:  ${it.pnum}"
            JoinedNumber.text = "已参与次数:  ${it.hnum}"
            toolbarBg.loadImageFromUrl(ServiceFactory.getBaseImageUrl() +it.thumbsurl)
            fab.loadImageFromUrl(ServiceFactory.getBaseImageUrl() + it.icon)
        }
        result?.bogetbus?.map {
            toolbarLayout.title = it.bname
        }
    }

    override fun setListener() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun doBusiness() {
    }
}
