# YouTube Android Player API

[![api](https://api.bintray.com/packages/malliaridis/android/youtube-android-player-api/images/download.svg)](https://bintray.com/malliaridis/android/youtube-android-player-api/_latestVersion)

This project is an **unofficial** implementation of the [YouTube Android Player API](https://developers.google.com/youtube/android/player).
It was inspired by the [android-youtube-player](https://github.com/PierfrancescoSoffritti/android-youtube-player)
and is based on the [resources and documentation of the official YouTube API](https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/package-summary.html).

The approach was to decompile the JAR file provided, document the public interfaces after the
documentation and start renaming classes and fixing invalid code snippets.

## Why does this project exist?
The main reason this project exists is that [the official library of the YouTube Android Player API
provided by YouTube](https://developers.google.com/youtube/android/player) uses the old support
libraries which makes the library incompatible with today's applications and unusable in production.

The official library is also quite buggy and the integration of the dependency as a JAR is very
uncomfortable and problematic for versioning.

With this project it is possible to integrate YouTube in various applications in a "semi-official"
way, improve the official implementation in an unofficial way and provide a more reliable solution
for everyone.

## How legal is this?
To be honest: I don't know. And if anyone can clarify the legality of this project I would be glad
to include this here. The only thing I know for sure is that this project has only good intentions.

## Project structure
This project is split into 2 parts. The first part (`api`) is the API implementation, the second 
part (not implemented yet) provides some implementation examples.

Further details of each part can be found in the appropriate `README.md`.

## Integration
To integrate the API in your android project you can use the following dependency: 
```gradle
dependencies {
    implementation 'com.malliaridis.android:youtube-android-player-api:{current-version}'
}
```
For the `{current-version}` see the `api` tag on top of this `README.md` file.

## Compatibility and differences
This API uses the same packages for the classes that were leaked by the official API. Any further
classes were repackaged. With that in mind, existing code should be working by just switching the 
JAR with the above dependency. 

An important difference however that might crash existing code is the replacement of the support
library with the androidx library. The `YouTubePlayerSupportFragment` is marked deprecated since it
contains the exact same implementation as the `YoutubePlayerFragment`. In comparison to the official
library the `YouTubePlayerFragment` extends the `android.app.Fragment`, which was deprecated in API
level 28, and the `YouTubePlayerSupportFragment` implements the `android.support.v4.app.Fragment`.
