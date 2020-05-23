package com.demo.library.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType


//class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(BR.mainViewModel, MainViewModel::class.java) {
//    ...
//    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) {
//        //初始化界面元素和成员变量
//        ...
//    }
//
//    override fun getLayoutId(): Int {
//        return R.layout.fragment_main //返回对应的layoutId
//    }
//
//    ...
//}

abstract class BaseFragment<VM:BaseViewModel,DB:ViewDataBinding>():Fragment(){
//    (private val brId: Int, viewModeClass: Class<VM>) :Fragment(){
//    val viewModel by lazy { ViewModelProviders.of(this).get(viewModeClass) }

    lateinit var bindg:DB
    lateinit var viewModel:VM

    private var viewHolder: View? = null

    @LayoutRes
    abstract fun layoutId(): Int
    abstract fun initView( inflater: LayoutInflater,
                           container: ViewGroup?,
                           savedInstanceState: Bundle?)
    abstract fun initData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    /**
     * 返回事件处理
     *
     *
     */
    open fun onBackPressed():Boolean{
        return false;
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (viewHolder == null) {
            bindg = DataBindingUtil.inflate(inflater,layoutId(),container,false)
            initView(inflater,container,savedInstanceState)
//            bindg.setVariable(brId,viewModel)
            bindg.lifecycleOwner = viewLifecycleOwner
        }
        return bindg.root
    }

    /**
     * 是否和 Activity 共享 ViewModel,默认不共享
     * Fragment 要和宿主 Activity 的泛型是同一个 ViewModel
     */
    open fun isShareVM(): Boolean = false

    /**
     * 创建 ViewModel
     */
    @Suppress("UNCHECKED_CAST")
    private fun createViewModel() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val tp = type.actualTypeArguments[0]
            val tClass = tp as? Class<VM> ?: BaseViewModel::class.java
            val viewModelStore = if (isShareVM()) activity!!.viewModelStore else this.viewModelStore
            viewModel = ViewModelProvider(viewModelStore, ViewModelFactory()).get(tClass) as VM
        }
    }
}

