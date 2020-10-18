package com.google.android.youtube.player.impl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// TODO This class returns localized youtube texts
public final class LocalizedYouTubeTexts {

    private static final String ERROR_INITIALIZING_PLAYER = "error_initializing_player";
    private static final String GET_YOUTUBE_APP_TITLE = "get_youtube_app_title";
    private static final String GET_YOUTUBE_APP_TEXT = "get_youtube_app_text";
    private static final String GET_YOUTUBE_APP_ACTION = "get_youtube_app_action";
    private static final String ENABLE_YOUTUBE_APP_TITLE = "enable_youtube_app_title";
    private static final String ENABLE_YOUTUBE_APP_TEXT = "enable_youtube_app_text";
    private static final String ENABLE_YOUTUBE_APP_ACTION = "enable_youtube_app_action";
    private static final String UPDATE_YOUTUBE_APP_TITLE = "update_youtube_app_title";
    private static final String UPDATE_YOUTUBE_APP_TEXT = "update_youtube_app_text";
    private static final String UPDATE_YOUTUBE_APP_ACTION = "update_youtube_app_action";


    public static Map<String, String> a(Locale locale) {
        HashMap<String, String> var1 = new HashMap<>();
        var1.put(ERROR_INITIALIZING_PLAYER, "An error occurred while initializing the YouTube player.");
        var1.put(GET_YOUTUBE_APP_TITLE, "Get YouTube App");
        var1.put(GET_YOUTUBE_APP_TEXT, "This app won't run without the YouTube App, which is missing from your device");
        var1.put(GET_YOUTUBE_APP_ACTION, "Get YouTube App");
        var1.put(ENABLE_YOUTUBE_APP_TITLE, "Enable YouTube App");
        var1.put(ENABLE_YOUTUBE_APP_TEXT, "This app won't work unless you enable the YouTube App.");
        var1.put(ENABLE_YOUTUBE_APP_ACTION, "Enable YouTube App");
        var1.put(UPDATE_YOUTUBE_APP_TITLE, "Update YouTube App");
        var1.put(UPDATE_YOUTUBE_APP_TEXT, "This app won't work unless you update the YouTube App.");
        var1.put(UPDATE_YOUTUBE_APP_ACTION, "Update YouTube App");
        getMessagesByCountry(var1, locale.getLanguage());
        String language = locale.getLanguage();
        String country = locale.getCountry();
        getMessagesByCountry(var1, language + "_" + country);
        return var1;
    }

    private static void getMessagesByCountry(Map<String, String> messageHolder, String countryCode) {
        if ("af".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Kon nie die YouTube-speler inisialiseer nie.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Kry YouTube-program");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Hierdie program sal nie loop sonder die YouTube-program, wat ontbreek van jou toestel, nie");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Kry YouTube-program");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Aktiveer YouTube-program");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Hierdie program sal nie werk tensy jy die YouTube-program aktiveer nie.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Aktiveer YouTube-program");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Dateer YouTube-program op");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Hierdie program sal nie werk tensy jy die YouTube-program opdateer nie.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Dateer YouTube-program op");
        } else if ("am".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "የYouTube አጫዋቹን በማስጀመር ላይ ሳለ አንድ ስህተት ተከስቷል።");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "የYouTube መተግበሪያውን ያግኙ");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "ይህ መተግበሪያ ያለ YouTube መተግበሪያው አይሂድም፣ እሱ ደግሞ በመሣሪያዎ ላይ የለም።");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "የYouTube መተግበሪያውን ያግኙ");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "የYouTube መተግበሪያውን ያንቁ");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "የYouTube መተግበሪያውን እስካላነቁ ድረስ ይህ መተግበሪያ አይሰራም።");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "የYouTube መተግበሪያውን ያንቁ");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "የYouTube መተግበሪያውን ያዘምኑ");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "የYouTube መተግበሪያውን እስካላዘመኑት ድረስ ይህ መተግበሪያ አይሰራም።");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "የYouTube መተግበሪያውን ያዘምኑ");
        } else if ("ar".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "حدث خطأ أثناء تهيئة مشغل YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "الحصول على تطبيق YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "لن يعمل هذا التطبيق بدون تطبيق YouTube الذي لا يتوفر على جهازك");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "الحصول على تطبيق YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "تمكين تطبيق YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "لن يعمل هذا التطبيق ما لم يتم تمكين تطبيق YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "تمكين تطبيق YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "تحديث تطبيق YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "لن يعمل هذا التطبيق ما لم يتم تحديث تطبيق YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "تحديث تطبيق YouTube");
        } else if ("be".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Памылка падчас ініцыялізацыі прайгравальнiка YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Спампаваць прыкладанне YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Гэта прыкладанне не будзе працаваць без прыкладання YouTube, якое адсутнічае на прыладзе");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Спампаваць прыкладанне YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Уключыць прыкладанне YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Гэта прыкладанне не будзе працаваць, пакуль вы не ўключыце прыкладанне YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Уключыць прыкладанне YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Абнавiць прыкладанне YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Гэта прыкладанне не будзе працаваць, пакуль вы не абнавiце прыкладанне YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Абнавiць прыкладанне YouTube");
        } else if ("bg".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "При подготвянето на плейъра на YouTube за работа възникна грешка.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Изтегл. на прил. YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Това приложение няма да работи без приложението YouTube, което липсва на устройството ви");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Изтегл. на прил. YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Акт. на прил. YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Това приложение няма да работи, освен ако не активирате приложението YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Акт. на прил. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Актул. на прил. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Това приложение няма да работи, освен ако не актуализирате приложението YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Актул. на прил. YouTube");
        } else if ("ca".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "S'ha produït un error en iniciar el reproductor de YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Obtenció aplicac. YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Aquesta aplicació no funcionarà sense l'aplicació de YouTube, que encara no és al dispositiu.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Obtén l'aplic. de YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Activació aplic. YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Aquesta aplicació no funcionarà fins que no activis l'aplicació de YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Activa aplicació YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Actualitz. aplic. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Aquesta aplicació no funcionarà fins que no actualitzis l'aplicació de YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Actualitza aplic. YouTube");
        } else if ("cs".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Při inicializaci přehrávače YouTube došlo k chybě.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Stáhněte aplikaci YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Tuto aplikaci nelze spustit bez aplikace YouTube, kterou v zařízení nemáte nainstalovanou");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Stáhnout aplikaci YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Aktivujte aplik. YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Ke spuštění této aplikace je třeba aktivovat aplikaci YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Zapnout aplikaci YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Aktualizujte apl. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Ke spuštění této aplikace je třeba aktualizovat aplikaci YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Aktualizovat apl. YouTube");
        } else if ("da".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Der opstod en fejl under initialisering af YouTube-afspilleren.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Få YouTube-appen");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Denne app kan ikke køre uden YouTube-appen, som ikke findes på din enhed");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Få YouTube-appen");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Aktivér YouTube-appen");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Denne app fungerer ikke, medmindre du aktiverer YouTube-appen.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Aktivér YouTube-appen");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Opdater YouTube-appen");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Denne app fungerer ikke, hvis du ikke opdaterer YouTube-appen.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Opdater YouTube-appen");
        } else if ("de".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Bei der Initialisierung des YouTube-Players ist ein Fehler aufgetreten.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "YouTube App herunterladen");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Diese App kann nur ausgeführt werden, wenn die YouTube App bereitgestellt ist. Diese ist auf deinem Gerät nicht vorhanden.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "YouTube App herunterladen");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "YouTube App aktivieren");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Diese App funktioniert nur, wenn die YouTube App aktiviert wird.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "YouTube App aktivieren");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "YouTube App aktualisieren");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Diese App funktioniert nur, wenn die YouTube App aktualisiert wird.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "YouTube App aktualisieren");
        } else if ("el".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Παρουσιάστηκε σφάλμα κατά την προετοιμασία του προγράμματος αναπαραγωγής του YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Λήψη YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Δεν είναι δυνατή η εκτέλεση αυτής της εφαρμογής χωρίς την εφαρμογή YouTube, η οποία απουσιάζει από τη συσκευή σας");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Λήψη YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Ενεργοποίηση YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Δεν είναι δυνατή η λειτουργία αυτής της εφαρμογής εάν δεν ενεργοποιήσετε την εφαρμογή YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Ενεργοποίηση YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Ενημέρωση YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Δεν είναι δυνατή η λειτουργία αυτής της εφαρμογής εάν δεν ενημερώσετε την εφαρμογή YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Ενημέρωση YouTube");
        } else if ("en_GB".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "An error occurred while initialising the YouTube player.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Get YouTube App");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "This app won't run without the YouTube App, which is missing from your device");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Get YouTube App");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Enable YouTube App");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "This app won't work unless you enable the YouTube App.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Enable YouTube App");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Update YouTube App");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "This app won't work unless you update the YouTube App.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Update YouTube App");
        } else if ("es_US".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Se produjo un error al iniciar el reproductor de YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Obtener YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Esta aplicación no se ejecutará sin la aplicación YouTube, la cual no se instaló en tu dispositivo.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Obtener YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Activar YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Esta aplicación no funcionará a menos que actives la aplicación YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Activar YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Actualizar YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Esta aplicación no funcionará a menos que actualices la aplicación YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Actualizar YouTube");
        } else if ("es".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Se ha producido un error al iniciar el reproductor de YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Descarga YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Esta aplicación no funcionará sin la aplicación YouTube, que no está instalada en el dispositivo.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Descargar YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Habilita la aplicación YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Esta aplicación no funcionará si no habilitas la aplicación YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Habilitar YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Actualiza YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Esta aplicación no funcionará si no actualizas la aplicación YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Actualizar YouTube");
        } else if ("et".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "YouTube'i mängija lähtestamisel tekkis viga.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "YouTube'i rak. hankimine");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Rakendus ei käivitu ilma YouTube'i rakenduseta ja teie seadmes see praegu puudub");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Hangi YouTube'i rakendus");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "YouTube'i rakenduse lubamine");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Rakendus ei toimi, kui te ei luba kasutada YouTube'i rakendust.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Luba YouTube'i rakendus");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Värskenda YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Rakendus ei toimi enne, kui olete YouTube'i rakendust värskendanud.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Värsk. YouTube'i rakend.");
        } else if ("fa".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "هنگام مقداردهی اولیه پخش\u200cکننده YouTube، خطایی روی داد.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "دریافت برنامه YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "این برنامه بدون برنامه YouTube که در دستگاه شما موجود نیست، اجرا نمی\u200cشود");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "دریافت برنامه YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "فعال کردن برنامه YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "این برنامه تنها در صورتی کار خواهد کرد که برنامه YouTube را فعال کنید.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "فعال کردن برنامه YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "به\u200cروزرسانی برنامه YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "این برنامه کار نخواهد کرد مگر اینکه برنامه YouTube را به روز کنید.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "به\u200cروزرسانی برنامه YouTube");
        } else if ("fi".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Virhe alustettaessa YouTube-soitinta.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Hanki YouTube-sovellus");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Tämä sovellus ei toimi ilman YouTube-sovellusta, joka puuttuu laitteesta.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Hanki YouTube-sovellus");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Ota YouTube-sov. käyttöön");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Tämä sovellus ei toimi, ellet ota YouTube-sovellusta käyttöön.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Ota YouTube-sov. käyttöön");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Päivitä YouTube-sovellus");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Tämä sovellus ei toimi, ellet päivitä YouTube-sovellusta.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Päivitä YouTube-sovellus");
        } else if ("fr".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Une erreur s'est produite lors de l'initialisation du lecteur YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Télécharger appli YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Cette application ne fonctionnera pas sans l'application YouTube, qui n'est pas installée sur votre appareil.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Télécharger appli YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Activer l'appli YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Cette application ne fonctionnera que si vous activez l'application YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Activer l'appli YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Mise à jour appli YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Cette application ne fonctionnera que si vous mettez à jour l'application YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Mise à jour appli YouTube");
        } else if ("hi".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "YouTube प्लेयर को प्रारंभ करते समय कोई त्रुटि आई.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "YouTube एप्लि. प्राप्त करें");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "यह एप्लिकेशन YouTube एप्लिकेशन के बिना नहीं चलेगा, जो आपके उपकरण पर मौजूद नहीं है");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "YouTube एप्लि. प्राप्त करें");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "YouTube एप्लि. सक्षम करें");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "जब तक आप YouTube एप्लिकेशन सक्षम नहीं करते, तब तक यह एप्लिकेशन कार्य नहीं करेगा.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "YouTube एप्लि. सक्षम करें");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "YouTube एप्लि. अपडेट करें");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "जब तक आप YouTube एप्लिकेशन अपडेट नहीं करते, तब तक यह एप्लिकेशन कार्य नहीं करेगा.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "YouTube एप्लि. अपडेट करें");
        } else if ("hr".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Dogodila se pogreška tijekom pokretanja playera usluge YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Preuzimanje apl. YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Ova se aplikacija ne može pokrenuti bez aplikacije YouTube, koja nije instalirana na vaš uređaj");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Preuzmi apl. YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Omogućavanje apl. YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Ova aplikacija neće funkcionirati ako ne omogućite aplikaciju YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Omogući apl. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Ažuriranje apl. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Ova aplikacija neće funkcionirati ako ne ažurirate aplikaciju YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Ažuriraj apl. YouTube");
        } else if ("hu".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Hiba történt a YouTube lejátszó inicializálása során.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "YouTube alk. letöltése");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Ez az alkalmazás nem fut a YouTube alkalmazás nélkül, amely hiányzik az eszközéről.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "YouTube alk. letöltése");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "YouTube alkalmazás enged.");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Az alkalmazás csak akkor fog működni, ha engedélyezi a YouTube alkalmazást.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "YouTube alkalmazás enged.");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "YouTube alk. frissítése");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Az alkalmazás csak akkor fog működni, ha frissíti a YouTube alkalmazást.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "YouTube alk. frissítése");
        } else if ("in".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Terjadi kesalahan saat memulai pemutar YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Dapatkan Aplikasi YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Aplikasi ini tidak akan berjalan tanpa Aplikasi YouTube, yang hilang dari perangkat Anda");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Dapatkan Aplikasi YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Aktifkan Aplikasi YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Aplikasi ini tidak akan bekerja kecuali Anda mengaktifkan Aplikasi YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Aktifkan Aplikasi YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Perbarui Aplikasi YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Aplikasi ini tidak akan bekerja kecuali Anda memperbarui Aplikasi YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Perbarui Aplikasi YouTube");
        } else if ("it".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Si è verificato un errore durante l'inizializzazione del player di YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Scarica app YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Questa applicazione non funzionerà senza l'applicazione YouTube che non è presente sul tuo dispositivo");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Scarica app YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Attiva app YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Questa applicazione non funzionerà se non attivi l'applicazione YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Attiva app YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Aggiorna app YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Questa applicazione non funzionerà se non aggiorni l'applicazione YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Aggiorna app YouTube");
        } else if ("iw".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "אירעה שגיאה בעת אתחול נגן YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "קבל את יישום YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "יישום זה לא יפעל ללא יישום YouTube, שאינו מותקן במכשיר שלך");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "קבל את יישום YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "הפעל את יישום YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "יישום זה לא יעבוד אלא אם תפעיל את יישום YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "הפעל את יישום YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "עדכן את יישום YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "יישום זה לא יעבוד אלא אם תעדכן את יישום YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "עדכן את יישום YouTube");
        } else if ("ja".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "YouTubeプレーヤーの初期化中にエラーが発生しました。");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "YouTubeアプリを入手");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "このアプリの実行に必要なYouTubeアプリが端末にありません");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "YouTubeアプリを入手");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "YouTubeアプリを有効化");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "このアプリの実行にはYouTubeアプリの有効化が必要です。");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "YouTubeアプリを有効化");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "YouTubeアプリを更新");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "このアプリの実行にはYouTubeアプリの更新が必要です。");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "YouTubeアプリを更新");
        } else if ("ko".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "YouTube 플레이어를 초기화하는 중에 오류가 발생했습니다.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "YouTube 앱 다운로드");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "이 앱은 내 기기에 YouTube 앱이 없어서 실행되지 않습니다.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "YouTube 앱 다운로드");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "YouTube 앱 사용 설정");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "이 앱은 YouTube 앱을 사용하도록 설정하지 않으면 작동하지 않습니다.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "YouTube 앱 사용");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "YouTube 앱 업데이트");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "이 앱은 YouTube 앱을 업데이트하지 않으면 작동하지 않습니다.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "YouTube 앱 업데이트");
        } else if ("lt".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Inicijuojant „YouTube“ grotuvą įvyko klaida.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Gauti „YouTube“ programą");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Ši programa neveikia be „YouTube“ programos, o jos įrenginyje nėra.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Gauti „YouTube“ programą");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Įgalinti „YouTube“ progr.");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Ši programa neveiks, jei neįgalinsite „YouTube“ programos.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Įgalinti „YouTube“ progr.");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Atnauj. „YouTube“ progr.");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Ši programa neveiks, jei neatnaujinsite „YouTube“ programos.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Atnauj. „YouTube“ progr.");
        } else if ("lv".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Inicializējot YouTube atskaņotāju, radās kļūda.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "YouTube liet. iegūšana");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Šī lietotne nedarbosies bez YouTube lietotnes, kuras nav šajā ierīcē.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Iegūt YouTube lietotni");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "YouTube liet. iespējošana");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Lai šī lietotne darbotos, iespējojiet YouTube lietotni.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Iespējot YouTube lietotni");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "YouTube liet. atjaunin.");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Lai šī lietotne darbotos, atjauniniet YouTube lietotni.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Atjaun. YouTube lietotni");
        } else if ("ms".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Ralat berlaku semasa memulakan alat main YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Dapatkan Apl YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Apl ini tidak akan berjalan tanpa Apl YouTube, yang tidak ada pada peranti anda");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Dapatkan Apl YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Dayakan Apl YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Apl ini tidak akan berfungsi kecuali anda mendayakan Apl YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Dayakan Apl YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Kemas kini Apl YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Apl ini tidak akan berfungsi kecuali anda mengemas kini Apl YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Kemas kini Apl YouTube");
        } else if ("nb".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Det oppsto en feil da YouTube-avspilleren startet.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Skaff deg YouTube-appen");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Denne appen kan ikke kjøre uten YouTube-appen, som du ikke har på enheten");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Skaff deg YouTube-appen");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Aktiver YouTube-appen");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Denne appen fungerer ikke før du aktiverer YouTube-appen.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Aktiver YouTube-appen");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Oppdater YouTube-appen");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Denne appen fungerer ikke før du oppdaterer YouTube-appen.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Oppdater YouTube-appen");
        } else if ("nl".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Er is een fout opgetreden bij het initialiseren van de YouTube-speler.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "YouTube-app downloaden");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Deze app wordt niet uitgevoerd zonder de YouTube-app, die op uw apparaat ontbreekt");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "YouTube-app downloaden");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "YouTube-app inschakelen");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Deze app werkt niet, tenzij u de YouTube-app inschakelt.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "YouTube-app inschakelen");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "YouTube-app bijwerken");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Deze app werkt niet, tenzij u de YouTube-app bijwerkt.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "YouTube-app bijwerken");
        } else if ("pl".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Podczas inicjowania odtwarzacza YouTube wystąpił błąd.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Pobierz aplikację YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Ta aplikacja nie będzie działać bez aplikacji YouTube, której nie ma na tym urządzeniu");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Pobierz aplikację YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Włącz aplikację YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Ta aplikacja nie będzie działać, jeśli nie włączysz aplikacji YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Włącz aplikację YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Zaktualizuj aplikację YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Ta aplikacja nie będzie działać, jeśli nie zaktualizujesz aplikacji YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Zaktualizuj aplikację YouTube");
        } else if ("pt_PT".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Ocorreu um erro ao iniciar o leitor do YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Obter a Aplicação YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Esta aplicação não será executada sem a Aplicação YouTube, que está em falta no seu dispositivo");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Obter a Aplicação YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Ativar Aplicação YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Esta aplicação não irá funcionar enquanto não ativar a Aplicação YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Ativar Aplicação YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Atualizar Aplica. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Esta aplicação não irá funcionar enquanto não atualizar a Aplicação YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Atualizar Aplica. YouTube");
        } else if ("pt".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Ocorreu um erro ao inicializar o player do YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Obter aplicativo YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Este aplicativo só funciona com o aplicativo YouTube, que está ausente no dispositivo.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Obter aplicativo YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Ativar aplicativo YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Este aplicativo só funciona com o aplicativo YouTube ativado.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Ativar aplicativo YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Atualizar aplic. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Este aplicativo só funciona com o aplicativo YouTube atualizado.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Atualizar aplic. YouTube");
        } else if ("ro".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "A apărut o eroare la iniţializarea playerului YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Descărcaţi YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Această aplicaţie nu va rula fără aplicaţia YouTube, care lipseşte de pe gadget");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Descărcaţi YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Activaţi YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Această aplicaţie nu va funcţiona decât dacă activaţi aplicaţia YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Activaţi YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Actualizaţi YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Această aplicaţie nu va funcţiona decât dacă actualizaţi aplicaţia YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Actualizaţi YouTube");
        } else if ("ru".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Не удалось запустить проигрыватель YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Загрузите YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Чтобы запустить эту программу, установите приложение YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Загрузить YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Активация YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Чтобы запустить эту программу, активируйте приложение YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Активировать YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Обновление YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Чтобы запустить эту программу, обновите приложение YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Обновить YouTube");
        } else if ("sk".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Pri inicializácii prehrávača YouTube sa vyskytla chyba.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Získať aplikáciu YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Túto aplikáciu nebude možné spustiť bez aplikácie YouTube, ktorá na zariadení nie je nainštalovaná.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Získať aplikáciu YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Povoliť aplikáciu YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Táto aplikácia bude fungovať až po povolení aplikácie YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Povoliť aplikáciu YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Aktualizovať apl. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Táto aplikácia bude fungovať až po aktualizácii aplikácie YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Aktualizovať apl. YouTube");
        } else if ("sl".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Napaka med inicializacijo YouTubovega predvajalnika.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Prenos aplikacije YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Ta aplikacija ne bo delovala brez aplikacije YouTube, ki je ni v vaši napravi");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Prenos aplikacije YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Omog. aplikacije YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Ta aplikacija ne bo delovala, če ne omogočite aplikacije YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Omog. aplikacijo YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Posodob. aplikacije YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Ta aplikacija ne bo delovala, če ne posodobite aplikacije YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Posod. aplikacijo YouTube");
        } else if ("sr".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Дошло је до грешке при покретању YouTube плејера.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Преузимање аплик. YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Ова апликација неће функционисати без апликације YouTube, која недостаје на уређају");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Преузми апликац. YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Омогућавање апл. YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Ова апликације неће функционисати ако не омогућите апликацију YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Омогући апликац. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Ажурирање аплик. YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Ова апликације неће функционисати ако не ажурирате апликацију YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Ажурирај апликац. YouTube");
        } else if ("sv".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Ett fel uppstod när YouTube-spelaren skulle startas.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Hämta YouTube-appen");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "YouTube-appen krävs för att den här appen ska kunna köras. Du har inte YouTube-appen på din enhet.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Hämta YouTube-appen");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Aktivera YouTube-appen");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Du måste aktivera YouTube-appen för att den här appen ska fungera.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Aktivera YouTube-appen");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Uppdatera YouTube-appen");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Du måste uppdatera YouTube-appen för att den här appen ska fungera.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Uppdatera YouTube-appen");
        } else if ("sw".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Hitilafu ilitokea wakati wa kuanzisha kichezeshi cha YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Pata Programu ya YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Programu hii haitaendeshwa bila Programu ya YouTube, ambayo inakosekana kwenye kifaa chako.");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Pata Programu ya YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Wezesha Programu ya YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Programu hii haitafanya kazi isipokuwa uwezeshe Programu ya YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Wezesha Programu ya YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Sasisha Programu ya YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Programu hii haitafanya kazi mpaka usasishe Programu ya YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Sasisha Programu ya YouTube");
        } else if ("th".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "เกิดข้อผิดพลาดในขณะเริ่มต้นโปรแกรมเล่น YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "รับแอปพลิเคชัน YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "แอปพลิเคชันนี้จะไม่ทำงานหากไม่มีแอปพลิเคชัน YouTube ซึ่งไม่มีในอุปกรณ์ของคุณ");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "รับแอปพลิเคชัน YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "เปิดใช้งานแอป YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "แอปพลิเคชันนี้จะไม่ทำงานจนกว่าคุณจะเปิดใช้งานแอปพลิเคชัน YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "เปิดใช้งานแอป YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "อัปเดตแอปพลิเคชัน YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "แอปพลิเคชันนี้จะไม่ทำงานจนกว่าคุณจะอัปเดตแอปพลิเคชัน YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "อัปเดตแอปพลิเคชัน YouTube");
        } else if ("tl".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "May naganap na error habang sinisimulan ang player ng YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Kunin ang YouTube App");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Hindi gagana ang app na ito nang wala ang YouTube App, na nawawala sa iyong device");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Kunin ang YouTube App");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Paganahin ang YouTube App");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Hindi gagana ang app na ito maliban kung paganahin mo ang YouTube App.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Paganahin ang YouTube App");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "I-update ang YouTube App");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Hindi gagana ang app na ito maliban kung i-update mo ang YouTube App.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "I-update ang YouTube App");
        } else if ("tr".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "YouTube oynatıcısı başlatılırken bir hata oluştu.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "YouTube Uygulamasını edinin");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Cihazınızda bulunmayan YouTube Uygulaması olmadan bu uygulama çalışmaz");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "YouTube Uygulamasını edinin");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "YouTube Uygulamasını etkinleştirin");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "YouTube Uygulamasını etkinleştirmediğiniz sürece bu uygulama çalışmaz.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "YouTube Uygulamasını etkinleştirin");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "YouTube Uygulamasını güncelleyin");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "YouTube Uygulaması güncellenmedikçe bu uygulama çalışmaz.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "YouTube Uygulamasını güncelle");
        } else if ("uk".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Під час ініціалізації програвача YouTube сталася помилка.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Отримати програму YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Ця програма не запуститься без програми YouTube, яку не встановлено на вашому пристрої");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Отримати програму YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Увімк. програму YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Ця програма не працюватиме, поки ви не ввімкнете програму YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Увімк. програму YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Оновити програму YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Ця програма не працюватиме, поки ви не оновите програму YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Оновити програму YouTube");
        } else if ("vi".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Đã xảy ra lỗi trong khi khởi chạy trình phát YouTube.");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Tải ứng dụng YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Ứng dụng này sẽ không chạy nếu không có ứng dụng YouTube, ứng dụng này bị thiếu trong thiết bị của bạn");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Tải ứng dụng YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Bật ứng dụng YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Ứng dụng này sẽ không hoạt động trừ khi bạn bật ứng dụng YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Bật ứng dụng YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Cập nhật ứng dụng YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Ứng dụng này sẽ không hoạt động trừ khi bạn cập nhật ứng dụng YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Cập nhật ứng dụng YouTube");
        } else if ("zh_CN".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "初始化 YouTube 播放器时出现错误。");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "获取 YouTube 应用");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "您的设备中没有 YouTube 应用，您必须先安装 YouTube 应用才能运行此应用。");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "获取 YouTube 应用");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "启用 YouTube 应用");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "您需要启用 YouTube 应用才能运行该应用。");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "启用 YouTube 应用");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "更新 YouTube 应用");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "您必须更新 YouTube 应用才能运行此应用。");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "更新 YouTube 应用");
        } else if ("zh_TW".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "初始化 YouTube 播放器時發生錯誤。");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "取得 YouTube 應用程式");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "您必須啟用 YouTube 應用程式，這個應用程式才能運作，但系統在裝置中找不到 YouTube 應用程式。");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "取得 YouTube 應用程式");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "啟用 YouTube 應用程式");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "您必須啟用 YouTube 應用程式，這個應用程式才能運作。");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "啟用 YouTube 應用程式");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "更新 YouTube 應用程式");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "您必須更新 YouTube 應用程式，這個應用程式才能運作。");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "更新 YouTube 應用程式");
        } else if ("zu".equals(countryCode)) {
            messageHolder.put(ERROR_INITIALIZING_PLAYER, "Kuvele iphutha ngenkathi kuqaliswa isidlali se-YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TITLE, "Thola uhlelo lokusebenza lwe-YouTube");
            messageHolder.put(GET_YOUTUBE_APP_TEXT, "Lolu hlelo kusebenza angeke lusebenze ngaphandle kohlelo lokusebenza lwe-YouTube, olungekho kudivayisi yakho");
            messageHolder.put(GET_YOUTUBE_APP_ACTION, "Thola uhelo lokusebenza lwe-YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TITLE, "Nika amandla uhlelo lokusebenza lwe-YouTube");
            messageHolder.put(ENABLE_YOUTUBE_APP_TEXT, "Lolu hlelo lokusebenza angeke lusebenze uma unganikanga amandla uhlelo lokusebenza lwe-YouTube.");
            messageHolder.put(ENABLE_YOUTUBE_APP_ACTION, "Nika amandla uhlelo lokusebenza lwe-YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TITLE, "Buyekeza uhlelo lokusebenza lwe-YouTube");
            messageHolder.put(UPDATE_YOUTUBE_APP_TEXT, "Lolu hlelo lokusebenza angeke lusebenze uma ungabuyekezanga uhlelo lokusebenza lwe-YouTube.");
            messageHolder.put(UPDATE_YOUTUBE_APP_ACTION, "Buyekeza uhlelo lokusebenza lwe-YouTube");
        }
    }
}
