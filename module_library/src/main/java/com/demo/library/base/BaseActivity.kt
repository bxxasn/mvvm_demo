package com.demo.library.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {
    lateinit var viewModel: VM
    lateinit var bindg: DB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewDataBinding()
        initView(savedInstanceState)
        initData()
        getLifecycleObserver()?.apply { lifecycle.addObserver(getLifecycleObserver()!!) }
    }

    @LayoutRes
    abstract fun layoutId(): Int
    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData()

    fun getLifecycleObserver(): LifecycleObserver? {
        return null
    }

    /**
     * DataBinding
     */
    private fun initViewDataBinding() {
        val cls =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<*>
        if (ViewDataBinding::class.java != cls && ViewDataBinding::class.java.isAssignableFrom(cls)) {
            bindg = DataBindingUtil.setContentView(this, layoutId())
            bindg.lifecycleOwner = this
        } else setContentView(layoutId())
        createViewModel()
    }

    /**
     * 创建 ViewModel
     */
    @Suppress("UNCHECKED_CAST")
    private fun createViewModel() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val tp = type.actualTypeArguments[0]
            val tClass = tp as? Class<VM> ?: BaseViewModel::class.java
            viewModel = ViewModelProvider(this, ViewModelFactory()).get(tClass) as VM

            Log.e("A","AAA")
        }
    }
}


class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        /* val type = modelClass.constructors[0].parameterTypes
         if (type.isNotEmpty()) {
             val tClass = type[0]
             if (HomeRepository::class.java.isAssignableFrom(tClass)) {
                 return modelClass.getConstructor(tClass).newInstance(Injection.HomeRepository())
             } else if (XXXRepository::class.java.isAssignableFrom(tClass)) {
                 return modelClass.getConstructor(tClass).newInstance(Injection.XXXRepository())
             }
         }*/
        return modelClass.newInstance()
    }
}
//
class BaseViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return creator() as T
    }

}