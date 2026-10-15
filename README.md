# Omroep Oostwold Car Radio

Android-app voor Android-autoradio's. Start de stream automatisch en toont de huidige songtitel.

Stream: https://omroep-oostwold.nl:5995/stream?user=twinky

## APK bouwen zonder Android Studio

1. Maak op GitHub een nieuwe repository, bijvoorbeeld `omroep-oostwold-car-radio`.
2. Upload de **inhoud van deze ZIP** naar de hoofdmap van de repository, inclusief de verborgen map `.github/workflows/`.
3. Open het tabblad **Actions**.
4. Kies **Build Android APK** en klik **Run workflow** (of wacht op de automatische build na upload).
5. Open de geslaagde build en download onder **Artifacts**: `Omroep-Oostwold-Car-Radio-APK`.
6. Pak die download uit. Het bestand `app-debug.apk` is de installeerbare app.
7. Kopieer de APK naar een USB-stick en installeer hem op de Android-autoradio.

Opmerking: dit is een debug-APK, bedoeld voor eigen gebruik. De stream moet bereikbaar zijn vanaf de autoradio en een geldig HTTPS-certificaat hebben. De huidige songtitel wordt opgehaald via Icecast `status-json.xsl`.
