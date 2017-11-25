package com.zbb.slidingmenudemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置菜单区域
        setBehindContentView(R.layout.slidingmenu_menu);
        //分割线(样式,宽度)
        SlidingMenu slidingMenu = getSlidingMenu();
        //根据资源文件ID来设置滑动菜单的阴影效果
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        //菜单的位置(模式)(左侧,右侧,左右)
        slidingMenu.setMode(SlidingMenu.LEFT);
        //菜单打开宽度
        slidingMenu.setBehindWidthRes(R.dimen.slidingmenu_width);
        //菜单触摸打开方式(边缘 margin,全屏FULLSCREEN,不可打开 none)
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置渐入渐出效果的值
        slidingMenu.setFadeDegree(0.35f);
        //切换fragment
        replacefragment(new ContentFragment());
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu, new MenuFragment()).commit();


        /**
         * 侧滑菜单被打开
         */
        slidingMenu.setOnOpenListener(new SlidingMenu.OnOpenListener() {
            @Override
            public void onOpen() {

            }
        });
        /**
         * 侧滑菜单被关闭
         */
        slidingMenu.setOnCloseListener(new SlidingMenu.OnCloseListener() {
            @Override
            public void onClose() {

            }
        });
        /**
         * 侧滑菜单被打开过之后调用
         */
        slidingMenu.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {
            @Override
            public void onOpened() {

            }
        });
        /**
         * 侧滑菜单被关闭过之后调用
         */
        slidingMenu.setOnClosedListener(new SlidingMenu.OnClosedListener() {
            @Override
            public void onClosed() {

            }
        });
    }

    public void replacefragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, fragment).commit();
    }
}
