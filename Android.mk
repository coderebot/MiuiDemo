#
# Copyright (C) 2013, Xiaomi Inc. All rights reserved.
#
LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_AAPT_INCLUDES := $(call intermediates-dir-for,APPS,miui,,COMMON)/package-export.apk

LOCAL_JAVA_LIBRARIES := miuisdk
LOCAL_STATIC_JAVA_LIBRARIES := miuisdk_static
LOCAL_SRC_FILES := $(call all-java-files-under, src)

LOCAL_PACKAGE_NAME := MiuiDemo

LOCAL_PROGUARD_FLAG_FILES := proguard.flags

include $(BUILD_PACKAGE)

