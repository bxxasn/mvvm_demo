package com.demo.library.services

import com.alibaba.android.arouter.facade.template.IProvider

interface IMineService :IProvider {
    fun getNewsName(): String

    fun sayHello(msg:String):Unit
}