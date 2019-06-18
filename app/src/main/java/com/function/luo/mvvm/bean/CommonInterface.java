package com.function.luo.mvvm.bean;

/**
 * Created by luo on 2019/6/18.
 */

public class CommonInterface {
    /**
     * 点击 Item
     */
    public interface  OnItemListener{
         void onItemClick(int points,String msg);
    }


    /**
     * 点击Button按钮
     */

    public interface  OnButtonListener{
         void OnButtonclick(int points,String msg);
    }

    /**
     * Java 接口
     */
    public interface OnChangeNameLister{
        void onChangeName(String name);
    }

}
