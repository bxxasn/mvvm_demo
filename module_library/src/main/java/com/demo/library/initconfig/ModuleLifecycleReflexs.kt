package com.demo.library.initconfig

object ModuleLifecycleReflexs {
//    /** 基础库  */
//    private val BaseInit = "com.drz.common.CommonModuleInit"
//
//    /** main组件库  */
//    private val MainInit = "com.drz.main.application.MainModuleInit"
//
//    /**用户组件初始化 */
//    private val UserInit = "com.drz.user.UserModuleInit"

    //@todo 这里很不优雅。后期可以用注解的方式--JavaPoet
    private val investInit = "com.demo.mine.init.MineModuleInit"

    public val initModuleNames by lazy {
        arrayOf(investInit)
    }
}