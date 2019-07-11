package com.njupt.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wall
 * @date 2019/7/11  10:45
 * @description
 */
public class CompositeClass {
    private List<Component> childList = new ArrayList<>();
    public void addChild(Component component){
        childList.add(component);
    }
    public void getChild(){
        childList.forEach(System.out::println);
    }
    public void removeChild(Component component){}
}
