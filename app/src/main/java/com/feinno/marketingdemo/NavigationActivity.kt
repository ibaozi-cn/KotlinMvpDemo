package com.feinno.marketingdemo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import com.feinno.marketingdemo.base.BaseBackExitActivity
import com.feinno.marketingdemo.ui.BusinessFragment
import com.feinno.marketingdemo.ui.MarketingListFragment
import com.feinno.marketingdemo.ui.OperationFragment
import com.feinno.marketingdemo.ui.OperationPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @project: MarketingDemo
 * @description: 主页
 * @author zzy05
 * @date 2017/6/21 12:04
 * @updateUser zzy05
 * @update 2017/6/21 12:04
 * @version V1.0
 */
class NavigationActivity : BaseBackExitActivity(), OperationFragment.OnFragmentInteractionListener {

    private val fragment = OperationFragment.newInstance()
    private val fragment2 = BusinessFragment.newInstance()
    private val fragment3 = MarketingListFragment.newInstance()

    override fun initParams(arguments: Bundle?) {
    }

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView(rootView: View) {
    }

    override fun setListener() {
        navigation!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun doBusiness() {
        //添加默认fragment
        val presenter = OperationPresenterImpl()
        presenter.view = fragment
        addFragmentToActivity(supportFragmentManager, fragment, R.id.frameLayout)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                addFragmentToActivity(supportFragmentManager, fragment, R.id.frameLayout)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                addFragmentToActivity(supportFragmentManager, fragment2, R.id.frameLayout)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                addFragmentToActivity(supportFragmentManager, fragment3, R.id.frameLayout)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    /**
     * 实现Fragment接口回掉
     */
    override fun onFragmentInteraction() {
    }
}
