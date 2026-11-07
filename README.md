# Number Detective — Android project

A native Kotlin + Jetpack Compose number-guessing game.

## Features
- Easy (1–100, 70 seconds), Medium (1–1,000, 100 seconds), Hard (1–100,000, 130 seconds)
- Secret number stays hidden until the round ends
- GREATER THAN / LESS THAN hints
- Three one-use clues: even/odd, range bucket, last digit
- Profile: wins, games played, best score, best overall time, per-level best times
- Local on-device statistics using SharedPreferences
- Dark neon UI, timer bar, guess history

## Build an installable APK
1. Install Android Studio on a computer.
2. Open this project folder in Android Studio.
3. Install Android SDK Platform 36 when prompted.
4. Wait for Gradle sync to finish.
5. Select **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
6. The debug APK will be in `app/build/outputs/apk/debug/app-debug.apk`.
7. Copy that APK to your Android phone and open it to install. You may need to allow installation from that source.

For a Play Store release, create a signed Android App Bundle using **Build > Generate Signed Bundle / APK** and use a Play Console account.

## Package details
- Application ID: `com.numberdetective.game`
- Version: 1.0
- Minimum Android: 6.0 (API 23)
- Target Android: API 36

This source project is not itself a compiled APK. It must be built with Android Studio before installation.
