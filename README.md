# IjkplayerDemo on Android

Android ijkplayer demo based on [ijkplayer](https://github.com/Bilibili/ijkplayer).
This project setup steps are described as below:

### Build Environment
- ijkplayer ffmpeg libs and aar libs compile
 - Linux CentOS release 6.3 (Final): Linux version 2.6.32-279.22.1.el6.i686
 - android sdk: android-sdk_r24.3.4-linux.tgz
 - android ndk: android-ndk-r10d-linux-x86.bin
 - ijkplayer k0.4.4.1
- Android compile
 - win10
 - Android Studio 1.5
 - Gradle 2.8

### Build ijkplayer ffmpeg libs and aar (ijkplayer-java and ijkplayer-exo) libs
- Follow instructions [ijkplayer](https://github.com/Bilibili/ijkplayer) to build on Linux. Don't waste time to do that in windows.
- Just need to change "git checkout -B latest K0.4.4.1" to "git checkout -b ...". Need to modify this in file "init-android.sh" too.
- ijkplayer-java based on ffplay.
- ijkplayer-Exo based on android exoplayer.

### Build Android ijkplayer project
- After build ijkplayer libs successfully, copy folder "ijkplayer-android" from Linux to win10 (e.g. F:\ijkplayer-android).
- Open Android Studio, select "Open an existing Android Studio project", open "F:\ijkplayer-android\android\ijkplayer".
- Modify file "F:\ijkplayer-android\android\ijkplayer\build.gradle":
```
#change buildToolsVersion to "23.0.01"
ext {
    compileSdkVersion = 23
    buildToolsVersion = "23.0.01"

    targetSdkVersion = 23
    ......
}
```
- Select "Build->Make Project", build whole ijkplayer project, include:
- ijkplayer-exo: using android ExoPlayer.
- ijkplayer-java: based on ffplay.
- ijkplayer-sample: A ijkplayer demo (APK).

Install apk to mobile to check whether everything is OK before going next.

### Build ijkplayer-sample as library (aar)
In order to use ijkplayer-sample codes directly in my demo project, need to build ijkplayer-sample as aar library.

- Modify file "F:\ijkplayer-android\android\ijkplayer\ijkplayer-sample\build.gradle".
```
1)change:
apply plugin: 'com.android.application'

to:
apply plugin: 'com.android.library'

2)change:
applicationId "tv.danmaku.ijk.media.sample"

to:
//applicationId "tv.danmaku.ijk.media.sample"
```

- Modify file "F:\ijkplayer-android\android\ijkplayer\ijkplayer-sample\src\main\AndroidManifest.xml".
```
change:
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

to:
            <!--<intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>-->
```

- Select "Build->Make Module 'ijkplayer-sample'".
- aar file would be generated in folder "F:\ijkplayer-android\android\ijkplayer\ijkplayer-sample\build\outputs\aar\".

### Build IjkplayerDemo
New an android project, copy lib files (include aar and .so) into "IjkplayerDemo\app\libs" (.aar) and "IjkplayerDemo\app\libs\armeabi-v7a" (.so).