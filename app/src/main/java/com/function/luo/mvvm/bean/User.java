package com.function.luo.mvvm.bean;

/**
 * Created by luo on 2019/6/17.
 */

public class User {

    public String name;

    public String getName() {
        return name;
    }


    /**
     * 设置回调
     * @param name
     * @param onChangeNameLister
     */
    public void setName(String name, CommonInterface.OnChangeNameLister onChangeNameLister){
        if (onChangeNameLister!= null){
            //调用接口
            onChangeNameLister.onChangeName("你好啊："+name);
        }
    }


}
