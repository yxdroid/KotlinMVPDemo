cmake_minimum_required(VERSION 3.4.1)

find_library(  log-lib
              log )

add_library( NativeUtil
             SHARED
             src/main/cpp/native-lib.cpp
             src/main/cpp/NativeUtil.cpp)

target_link_libraries( NativeUtil ${log-lib} )