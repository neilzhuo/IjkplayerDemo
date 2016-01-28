# IjkplayerDemo on Android

Android ijkplayer demo based on [ijkplayer](https://github.com/Bilibili/ijkplayer)

### Build Environment
- ijkplayer ffmpeg libs and aar libs compile
 - Linux CentOS6.2
 - android sdk
 - android ndk r10d
 - ijkplayer k0.4.4.1
- Android compile
 - win10
 - Android Studio 1.5
 - Gradle 2.8

### Build ijkplayer ffmpeg libs and aar libs
- Follow instructions [ijkplayer](https://github.com/Bilibili/ijkplayer) to build on Linux. 
- Just need to change "git checkout -B latest K0.4.4.1" to "git checkout -b ...". Need to modify this in file "init-android.sh" too.


### Build Android ijkplayer project
- After build ijkplayer ffmpeg libs, copy folder "ijkplayer-android" from Linux to win10 (e.g. F:\ijkplayer-android).
- Open Android Studio, select "Open an existing Android Studio project", open "F:\ijkplayer-android\android\ijkplayer".
- Select "Build->Make Project", build whole ijkplayer project, include:
- ijkplayer-exo: using android ExoPlayer.
- ijkplayer-java: using ffplay.
- ijkplayer-sample: A ijkplayer demo (APK).

Install apk to mobile to check whether everything is OK before going next.

### Build ijkplayer-sample as library (aar)
In order to use ijkplayer-sample codes directly in our demo project, need to build ijkplayer-sample as aar library.

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
- aar file would be generated in "F:\ijkplayer-android\android\ijkplayer\ijkplayer-sample\build\outputs\aar".

### Build IjkplayerDemo
Copy lib files (include aar and .so) into "IjkplayerDemo\app\libs" (.aar) and "IjkplayerDemo\app\libs\armeabi-v7a" (.so).
