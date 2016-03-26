package com.coldridge.valley.primitiveservlet;

import java.io.IOException;

/**
 * Created by Administrator on 2016/3/26.
 */
public class StaticResourceProcesser {

    public void process(Request1 request, Response1 response) throws IOException {

        if(response != null){
            response.sendStaticResource();
        }



    }

}
