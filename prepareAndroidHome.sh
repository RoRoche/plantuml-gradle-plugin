#!/bin/sh

if [ ! -d $ANDROID_HOME ]; then
  mkdir -p $ANDROID_HOME
  echo "sdk.dir=$ANDROID_HOME" > local.properties

  mkdir $ANDROID_HOME/licenses
  echo "24333f8a63b6825ea9c5514f83c2829b004d1fee" > $ANDROID_HOME/licenses/android-sdk-license
fi
