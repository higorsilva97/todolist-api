package br.com.higorsilva97.todolist.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    public static String[] getNullPropertyNames(Object source){
        final BeanWrapper src = new BeanWrapperImpl(source);

        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emplyNames = new HashSet<>();

        for(PropertyDescriptor pd: pds){
            Object srcValue =  src.getPropertyValue(pd.getName());
            if(srcValue == null){
                emplyNames.add(pd.getName());
            }
        }

        String[] result =  new String[emplyNames.size()];
        return emplyNames.toArray(result);
    }
}
