//package com.demo.library.widget;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.os.Handler;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//
//import com.demo.library.R;
// //@TODO  可以延迟显示的LoadingDialog ，防止在加载的时候，网络太快，瞬间打开，瞬间关闭，造成闪屏。
// //@TODO 模仿 ContentLoadingProgressBar
//public class LoadingDialog2 extends AlertDialog {
//
//    private static final int MIN_SHOW_TIME = 500;
//    private static final int MIN_DELAY = 500;
//
//    private TextView tvMessage;
//
//    private long mStartTime = -1;
//    private boolean mPostedHide = false;
//    private boolean mPostedShow = false;
//    private boolean mDismissed = false;
//
//    private Handler mHandler = new Handler();
//
//    private final Runnable mDelayedHide = new Runnable() {
//
//        @Override
//        public void run() {
//            mPostedHide = false;
//            mStartTime = -1;
//            dismiss();
//        }
//    };
//
//    private final Runnable mDelayedShow = new Runnable() {
//
//        @Override
//        public void run() {
//            mPostedShow = false;
//            if (!mDismissed) {
//                mStartTime = System.currentTimeMillis();
//                show();
//            }
//        }
//    };
//
//    public LoadingDialog(@NonNull Context context) {
//        super(context, R.style.Theme_AppCompat_Dialog);
////        View loadView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_loading, null);
////        setView(loadView);
////        tvMessage = loadView.findViewById(R.id.tv_message);
//        //@TODO 这里要自己做操作
//    }
//
//    public void showDialog(String message) {
//        tvMessage.setText(message);
//
//        mStartTime = -1;
//        mDismissed = false;
//        mHandler.removeCallbacks(mDelayedHide);
//        mPostedHide = false;
//        if (!mPostedShow) {
//            mHandler.postDelayed(mDelayedShow, MIN_DELAY);
//            mPostedShow = true;
//        }
//    }
//
//    public void hideDialog() {
//        mDismissed = true;
//        mHandler.removeCallbacks(mDelayedShow);
//        mPostedShow = false;
//        long diff = System.currentTimeMillis() - mStartTime;
//        if (diff >= MIN_SHOW_TIME || mStartTime == -1) {
//            dismiss();
//        } else {
//            if (!mPostedHide) {
//                mHandler.postDelayed(mDelayedHide, MIN_SHOW_TIME - diff);
//                mPostedHide = true;
//            }
//        }
//    }
//
//    @Override
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        mHandler.removeCallbacks(mDelayedHide);
//        mHandler.removeCallbacks(mDelayedShow);
//    }
//}