package com.liebe;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/18.
 */
@Service
public class TesService implements TeService {
    @Override
    public  void print(){
        System.out.print("xxx");
    }
}
