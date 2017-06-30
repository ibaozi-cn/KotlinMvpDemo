package com.feinno.marketingdemo.ui


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.feinno.marketingdemo.R
import com.feinno.marketingdemo.adapter.BaseAdapter
import com.feinno.marketingdemo.data.bean.ActivityBean
import com.feinno.marketingdemo.data.bean.Authinfo
import com.feinno.marketingdemo.data.bean.ParamActivityList
import com.feinno.marketingdemo.data.repository.ActivitySource
import com.feinno.marketingdemo.extend.loadImageFromUrl
import com.feinno.marketingdemo.extend.showSnackBar
import kotlinx.android.synthetic.main.fragment_marketing_list.*

/**
 * @project: MarketingDemo
 * @description: 活动列表
 * @author zzy05
 * @date 2017/6/21 12:04
 * @updateUser zzy05
 * @update 2017/6/21 12:04
 * @version V1.0
 */
class MarketingListFragment private constructor() : Fragment() {

    private val list: ArrayList<ActivityBean> by lazy {
        ArrayList<ActivityBean>()
    }

    private var adapter: BaseAdapter<ActivityBean>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_marketing_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BaseAdapter(layoutResourceId = R.layout.item_activity_list, items = list, init = { view, bean ->

            val textView = view.findViewById(R.id.imageName) as TextView

            textView.text = bean.atitle

            val imageView = view.findViewById(R.id.imageView) as ImageView

            imageView.loadImageFromUrl(bean.banurl)

        })

        val layoutManager = LinearLayoutManager(context)

        activityListView.layoutManager = layoutManager

        activityListView.adapter = adapter

        val paramActivityList = ParamActivityList(Authinfo(), 1001, 1, 1)

        ActivitySource.getActivityList(paramActivityList, success = {
            it, retry ->
            if (it?.code != 10000) {
                showSnackBar(view!!, it?.desc ?: "", "点我重试", View.OnClickListener {
                    retry()
                }, Snackbar.LENGTH_INDEFINITE)
            }
            it?.data?.map { list.add(it) }
            adapter?.notifyDataSetChanged()
        }, fail = {
            error, retry ->
            showSnackBar(view!!, error.toString(), "点我重试", View.OnClickListener {
                retry()
            }, Snackbar.LENGTH_INDEFINITE)
        })
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

