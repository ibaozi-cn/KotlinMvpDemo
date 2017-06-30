package com.feinno.marketingdemo.data.bean

import java.io.Serializable


/**
 * @project: KotlinMvpDemo
 * @description:
 * @author zzy05 zhangzhanyong@feinno.com
 * @date 2017/6/27 b:54
 * @updateUser zzy05
 * @update 2017/6/27 b:54
 * @version V1.0
 */
/**
 * //活动专区列表查询
 */
class ResultActivityList : BaseResult<List<ActivityBean>>()

/**
 * 活动业务查询
 */
data class ResultBusiness(val bogetbus: List<Bogetbus>, val activList: List<ActivityBean>) : BaseResult<Any>(), Serializable

/**
 *   aid:int               //活动id,
 * acname:String           //活动名称,
 * summary:String          //活动摘要,
 * h5url :String           //活动详情url,
 * thumbsurl:String        //缩略图,
 * icon :String            //图标,
 * acstate:String          //活动状态, 活动状态 0 未发布;  1未开始; 2进行中; 3已结束; 4已暂停
 * atype:int              //活动类型, 活动类型 1签到类; 2赠送类; 3折扣类; 4团购类; 5抽奖类;  6秒杀类
 * atitle:String           //活动标题,
 * pnum:int           //可参与次数,
 * hnum:int           //已参与次数
 */
data class ActivityBean(var aid: Int = 0,
                        var acname: String = "",
                        var summary: String = "",
                        var icon: String = "",
                        var h5url: String = "",
                        var thumbsurl: String = "",
                        var acstate: Int = 0,
                        var atype: Int = 0,
                        var atitle: String = "",
                        var pnum: Int = 0,
                        var hnum: Int = 0,
                        var startime: String = "2017-06-28",
                        var endtime: String = "2017-06-28",
                        var userId: String = "0",
                        var banurl: String = "http://pic2.nipic.com/20090413/60867_180642018_2.jpg") : Serializable

data class Bogetbus(
        var id: Int = 0,
        var bcode: String = "010001",
        var bname: String = "用户注册") : Serializable

