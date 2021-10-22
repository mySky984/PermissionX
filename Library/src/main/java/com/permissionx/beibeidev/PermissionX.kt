package com.permissionx.beibeidev

import androidx.fragment.app.FragmentActivity

/**
 * @Author lifq
 * 创建时间： 2021/10/21 17:00
 * 包名： com.permissionx.beibeidev
 * 功能描述：
 **/
object PermissionX {
    
    private const val TAG = "InvisibleFragment"
    
    fun request(activity: FragmentActivity,vararg permissions:String,
                callBack : PermissionsCallBack){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callBack,*permissions)
    }
}