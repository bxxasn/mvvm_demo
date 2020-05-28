package com.demo.home
import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.demo.home.databinding.ActivityMainBinding
import com.demo.library.base.BaseActivity
import com.demo.library.services.IMineService
import com.demo.library.widget.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*


//@Route(path = RouterActivityPath.Main.MAIN)
public class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun layoutId(): Int = R.layout.activity_main

    @JvmField
    @Autowired(name="/testAAA/single")
    var testService: IMineService?= null

    override fun initView(savedInstanceState: Bundle?) {


        ARouter.getInstance().inject(this)

        btn_openMine.setOnClickListener {
            ARouter.getInstance().build("/activity/mine").navigation()
        }

        btn_callMine.setOnClickListener {
            ToastUtil.show(this,testService?.getNewsName())
            testService?.sayHello("张三.....")
//            ToastUtil.show(this,"AAAAAAAAAAAAA")
//            viewModel.test("张三")
        }

        btn_goFragment.setOnClickListener {
            startActivity(Intent(this,TestFragmentActivity::class.java))
        }
    }

    override fun initData() {
    }
}
