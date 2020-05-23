package com.demo.home.ui.mainactivity2

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.home.R
import com.demo.home.databinding.MainActivity2FragmentBinding
import com.demo.library.base.BaseFragment
import com.demo.library.widget.ToastUtil
import kotlinx.android.synthetic.main.main_activity2_fragment.*

class MainActivity2Fragment : BaseFragment<MainActivity2ViewModel,MainActivity2FragmentBinding>() {

    companion object {
        fun newInstance() = MainActivity2Fragment()
    }

//    private lateinit var viewModel: MainActivity2ViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        return inflater.inflate(R.layout.main_activity2_fragment, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainActivity2ViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun layoutId(): Int =R.layout.main_activity2_fragment

    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        bindg.btnClick.setOnClickListener {
            ToastUtil.show(activity,"测试")
        }
//            .btn_click.setOnClickListener {
//
//        }
    }

    override fun initData() {
    }

}
