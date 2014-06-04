/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app;

import miui.os.Build;


public class Application extends miui.external.Application {
    @Override
    public ApplicationDelegate onCreateApplicationDelegate() {
        return new ApplicationDelegate();
    }
}

class ApplicationDelegate extends miui.external.ApplicationDelegate {
    @Override
    public void onCreate() {
        super.onCreate();

//        if (Build.IS_XIAOMI) {
//            // do something
//        } else {
//            // do something else
//        }
    }
}
