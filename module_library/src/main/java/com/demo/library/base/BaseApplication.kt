package com.app.lib.base

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.Process

open abstract class BaseApplication : Application() {

//    private var sInstance: BaseApplication? = null
//
//    private var sDebug = false
//
//    override fun onCreate() {
//        super.onCreate()
//        setApplication(this)
//    }
//
//
//
//    /** 当宿主没有继承自该Application时,可以使用set方法进行初始化baseApplication  */
//    private fun setApplication(@NonNull application: BaseApplication) {
//        sInstance = application
//        application
//            .registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
//                override fun onActivityCreated(
//                    @NonNull activity: Activity,
//                    @Nullable savedInstanceState: Bundle
//                ) {
//                    AppManager.instance.addActivity(activity)
//                }
//
//                override fun onActivityStarted(@NonNull activity: Activity) {}
//                override fun onActivityResumed(@NonNull activity: Activity) {}
//                override fun onActivityPaused(@NonNull activity: Activity) {}
//                override fun onActivityStopped(@NonNull activity: Activity) {}
//                override fun onActivitySaveInstanceState(
//                    @NonNull activity: Activity, @NonNull outState: Bundle
//                ) {
//                }
//
//                override fun onActivityDestroyed(@NonNull activity: Activity) {
//                    AppManager.instance.removeActivity(activity)
//                }
//            })
//    }
//
//    /**
//     * 获得当前app运行的Application
//     */
//    fun getInstance(): BaseApplication? {
//        if (sInstance == null) {
//            throw NullPointerException(
//                "please inherit BaseApplication or call setApplication."
//            )
//        }
//        return sInstance
//    }
//
//    fun setsDebug(isDebug: Boolean) {
//        sDebug = isDebug
//    }
//
//    fun issDebug(): Boolean {
//        return sDebug
//    }
//
//    /**
//     * 获取进程名
//     *
//     * @param context
//     * @return
//     */
//    fun getCurrentProcessName(context: Context): String? {
//        val am =
//            context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
//        val runningApps =
//            am.runningAppProcesses ?: return null
//        for (proInfo in runningApps) {
//            if (proInfo.pid == Process.myPid()) {
//                if (proInfo.processName != null) {
//                    return proInfo.processName
//                }
//            }
//        }
//        return null
//    }


}