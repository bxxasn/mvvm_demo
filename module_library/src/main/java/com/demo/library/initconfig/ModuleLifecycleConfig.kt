package com.demo.library.initconfig
import com.app.lib.base.BaseApplication
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ModuleLifecycleConfig private constructor() {

    companion object {
        val instance: ModuleLifecycleConfig by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { ModuleLifecycleConfig() }
    }

    public fun initModule(application: BaseApplication){
        ModuleLifecycleReflexs.initModuleNames.forEach {
            try {
                val clazz = Class.forName(it)
                val init = clazz.newInstance() as IModuleInit
                // 初始化操作
                init.onInitMain(application)

                //异步初始化操作
                GlobalScope.launch {
                    init.onInitAsyn(application)
                }
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }




}