package com.demo.library.initconfig

object ModuleLifecycleReflexs {

    //@todo 这里很不优雅。后期可以用注解的方式--JavaPoet
    private val mineInit = "com.demo.mine.init.MineModuleInit"
    private val homeInit ="com.demo.home.init.HomeModuleInit"
    private val libInit = "com.demo.library.init.LibModuleInit"

     val initModuleNames by lazy {
        arrayOf(libInit,homeInit,mineInit)
    }
}