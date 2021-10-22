package com.permissionx.beibeidev

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

typealias PermissionsCallBack = (Boolean,List<String>) -> Unit
    
/**
 * @Author lifq
 * 创建时间： 2021/10/21 16:04
 * 包名： com.permissionx.beibeidev
 * 功能描述：
 **/
class InvisibleFragment : Fragment() {
    
    private var callback:(PermissionsCallBack)? = null
    
    fun requestNow(cb : PermissionsCallBack,vararg permissions: String){
        callback = cb
        requestPermissions(permissions,1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 1){
            val deniedList = ArrayList<String>()
            for((index,result) in grantResults.withIndex()){
                if(result != PackageManager.PERMISSION_GRANTED){
                    deniedList.add(permissions[index])
                }
            }
            val allGranted = deniedList.isEmpty()
            callback?.let { it(allGranted,deniedList) }
        }
    }
    
}