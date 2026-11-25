# GETIS Android APK

This Android wrapper loads the current Cloudflare Worker URL:
https://getis-family-portal.levantusgetis.workers.dev/

## Build
GitHub Actions builds a debug APK automatically on relevant pushes. You can also run it manually from Actions → Build GETIS Android APK → Run workflow.

## Download
Open the repository's Actions tab, select the successful "Build GETIS Android APK" run, then download the "GETIS-Android-APK" artifact. Extract the ZIP to get app-debug.apk and install it on Android.

## Current scope
This is an installable Android WebView shell. It does not itself complete the migration of the original 2.1 backend or add email/AI integrations. Those remain separate follow-up work.
