package com.demo.library.initconfig

import com.app.lib.base.BaseApplication

/**
 * 需要在Application中初始化的东西
 */
interface IModuleInit {

    /** 需要在主线程中跑的  */
    fun onInitMain(application: BaseApplication?)

    /** 可以在多线程跑的  */
    fun onInitAsyn(application: BaseApplication?)
}