package com.demo.library.services

import com.alibaba.android.arouter.facade.template.IProvider

public interface IMineService :IProvider {
    fun getNewsName(): String

    fun sayHello(msg:String):Unit
}