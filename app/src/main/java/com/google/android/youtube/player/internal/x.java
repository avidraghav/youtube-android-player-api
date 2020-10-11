package com.google.android.youtube.player.internal;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class x {
    public static Map<String, String> a(Locale locale) {
        HashMap<String, String> var1;
        HashMap<String, String> var2;
        (var2 = var1 = new HashMap<>()).put("error_initializing_player", "An error occurred while initializing the YouTube player.");
        var2.put("get_youtube_app_title", "Get YouTube App");
        var2.put("get_youtube_app_text", "This app won't run without the YouTube App, which is missing from your device");
        var2.put("get_youtube_app_action", "Get YouTube App");
        var2.put("enable_youtube_app_title", "Enable YouTube App");
        var2.put("enable_youtube_app_text", "This app won't work unless you enable the YouTube App.");
        var2.put("enable_youtube_app_action", "Enable YouTube App");
        var2.put("update_youtube_app_title", "Update YouTube App");
        var2.put("update_youtube_app_text", "This app won't work unless you update the YouTube App.");
        var2.put("update_youtube_app_action", "Update YouTube App");
        a(var1, locale.getLanguage());
        String var4 = locale.getLanguage();
        String var3 = locale.getCountry();
        a(var1, (new StringBuilder(1 + var4.length() + var3.length())).append(var4).append("_").append(var3).toString());
        return var1;
    }

    private static void a(Map<String, String> var0, String countryCode) {
        if ("af".equals(countryCode)) {
            var0.put("error_initializing_player", "Kon nie die YouTube-speler inisialiseer nie.");
            var0.put("get_youtube_app_title", "Kry YouTube-program");
            var0.put("get_youtube_app_text", "Hierdie program sal nie loop sonder die YouTube-program, wat ontbreek van jou toestel, nie");
            var0.put("get_youtube_app_action", "Kry YouTube-program");
            var0.put("enable_youtube_app_title", "Aktiveer YouTube-program");
            var0.put("enable_youtube_app_text", "Hierdie program sal nie werk tensy jy die YouTube-program aktiveer nie.");
            var0.put("enable_youtube_app_action", "Aktiveer YouTube-program");
            var0.put("update_youtube_app_title", "Dateer YouTube-program op");
            var0.put("update_youtube_app_text", "Hierdie program sal nie werk tensy jy die YouTube-program opdateer nie.");
            var0.put("update_youtube_app_action", "Dateer YouTube-program op");
        } else if ("am".equals(countryCode)) {
            var0.put("error_initializing_player", "የYouTube አጫዋቹን በማስጀመር ላይ ሳለ አንድ ስህተት ተከስቷል።");
            var0.put("get_youtube_app_title", "የYouTube መተግበሪያውን ያግኙ");
            var0.put("get_youtube_app_text", "ይህ መተግበሪያ ያለ YouTube መተግበሪያው አይሂድም፣ እሱ ደግሞ በመሣሪያዎ ላይ የለም።");
            var0.put("get_youtube_app_action", "የYouTube መተግበሪያውን ያግኙ");
            var0.put("enable_youtube_app_title", "የYouTube መተግበሪያውን ያንቁ");
            var0.put("enable_youtube_app_text", "የYouTube መተግበሪያውን እስካላነቁ ድረስ ይህ መተግበሪያ አይሰራም።");
            var0.put("enable_youtube_app_action", "የYouTube መተግበሪያውን ያንቁ");
            var0.put("update_youtube_app_title", "የYouTube መተግበሪያውን ያዘምኑ");
            var0.put("update_youtube_app_text", "የYouTube መተግበሪያውን እስካላዘመኑት ድረስ ይህ መተግበሪያ አይሰራም።");
            var0.put("update_youtube_app_action", "የYouTube መተግበሪያውን ያዘምኑ");
        } else if ("ar".equals(countryCode)) {
            var0.put("error_initializing_player", "حدث خطأ أثناء تهيئة مشغل YouTube.");
            var0.put("get_youtube_app_title", "الحصول على تطبيق YouTube");
            var0.put("get_youtube_app_text", "لن يعمل هذا التطبيق بدون تطبيق YouTube الذي لا يتوفر على جهازك");
            var0.put("get_youtube_app_action", "الحصول على تطبيق YouTube");
            var0.put("enable_youtube_app_title", "تمكين تطبيق YouTube");
            var0.put("enable_youtube_app_text", "لن يعمل هذا التطبيق ما لم يتم تمكين تطبيق YouTube.");
            var0.put("enable_youtube_app_action", "تمكين تطبيق YouTube");
            var0.put("update_youtube_app_title", "تحديث تطبيق YouTube");
            var0.put("update_youtube_app_text", "لن يعمل هذا التطبيق ما لم يتم تحديث تطبيق YouTube.");
            var0.put("update_youtube_app_action", "تحديث تطبيق YouTube");
        } else if ("be".equals(countryCode)) {
            var0.put("error_initializing_player", "Памылка падчас ініцыялізацыі прайгравальнiка YouTube.");
            var0.put("get_youtube_app_title", "Спампаваць прыкладанне YouTube");
            var0.put("get_youtube_app_text", "Гэта прыкладанне не будзе працаваць без прыкладання YouTube, якое адсутнічае на прыладзе");
            var0.put("get_youtube_app_action", "Спампаваць прыкладанне YouTube");
            var0.put("enable_youtube_app_title", "Уключыць прыкладанне YouTube");
            var0.put("enable_youtube_app_text", "Гэта прыкладанне не будзе працаваць, пакуль вы не ўключыце прыкладанне YouTube.");
            var0.put("enable_youtube_app_action", "Уключыць прыкладанне YouTube");
            var0.put("update_youtube_app_title", "Абнавiць прыкладанне YouTube");
            var0.put("update_youtube_app_text", "Гэта прыкладанне не будзе працаваць, пакуль вы не абнавiце прыкладанне YouTube.");
            var0.put("update_youtube_app_action", "Абнавiць прыкладанне YouTube");
        } else if ("bg".equals(countryCode)) {
            var0.put("error_initializing_player", "При подготвянето на плейъра на YouTube за работа възникна грешка.");
            var0.put("get_youtube_app_title", "Изтегл. на прил. YouTube");
            var0.put("get_youtube_app_text", "Това приложение няма да работи без приложението YouTube, което липсва на устройството ви");
            var0.put("get_youtube_app_action", "Изтегл. на прил. YouTube");
            var0.put("enable_youtube_app_title", "Акт. на прил. YouTube");
            var0.put("enable_youtube_app_text", "Това приложение няма да работи, освен ако не активирате приложението YouTube.");
            var0.put("enable_youtube_app_action", "Акт. на прил. YouTube");
            var0.put("update_youtube_app_title", "Актул. на прил. YouTube");
            var0.put("update_youtube_app_text", "Това приложение няма да работи, освен ако не актуализирате приложението YouTube.");
            var0.put("update_youtube_app_action", "Актул. на прил. YouTube");
        } else if ("ca".equals(countryCode)) {
            var0.put("error_initializing_player", "S'ha produït un error en iniciar el reproductor de YouTube.");
            var0.put("get_youtube_app_title", "Obtenció aplicac. YouTube");
            var0.put("get_youtube_app_text", "Aquesta aplicació no funcionarà sense l'aplicació de YouTube, que encara no és al dispositiu.");
            var0.put("get_youtube_app_action", "Obtén l'aplic. de YouTube");
            var0.put("enable_youtube_app_title", "Activació aplic. YouTube");
            var0.put("enable_youtube_app_text", "Aquesta aplicació no funcionarà fins que no activis l'aplicació de YouTube.");
            var0.put("enable_youtube_app_action", "Activa aplicació YouTube");
            var0.put("update_youtube_app_title", "Actualitz. aplic. YouTube");
            var0.put("update_youtube_app_text", "Aquesta aplicació no funcionarà fins que no actualitzis l'aplicació de YouTube.");
            var0.put("update_youtube_app_action", "Actualitza aplic. YouTube");
        } else if ("cs".equals(countryCode)) {
            var0.put("error_initializing_player", "Při inicializaci přehrávače YouTube došlo k chybě.");
            var0.put("get_youtube_app_title", "Stáhněte aplikaci YouTube");
            var0.put("get_youtube_app_text", "Tuto aplikaci nelze spustit bez aplikace YouTube, kterou v zařízení nemáte nainstalovanou");
            var0.put("get_youtube_app_action", "Stáhnout aplikaci YouTube");
            var0.put("enable_youtube_app_title", "Aktivujte aplik. YouTube");
            var0.put("enable_youtube_app_text", "Ke spuštění této aplikace je třeba aktivovat aplikaci YouTube.");
            var0.put("enable_youtube_app_action", "Zapnout aplikaci YouTube");
            var0.put("update_youtube_app_title", "Aktualizujte apl. YouTube");
            var0.put("update_youtube_app_text", "Ke spuštění této aplikace je třeba aktualizovat aplikaci YouTube.");
            var0.put("update_youtube_app_action", "Aktualizovat apl. YouTube");
        } else if ("da".equals(countryCode)) {
            var0.put("error_initializing_player", "Der opstod en fejl under initialisering af YouTube-afspilleren.");
            var0.put("get_youtube_app_title", "Få YouTube-appen");
            var0.put("get_youtube_app_text", "Denne app kan ikke køre uden YouTube-appen, som ikke findes på din enhed");
            var0.put("get_youtube_app_action", "Få YouTube-appen");
            var0.put("enable_youtube_app_title", "Aktivér YouTube-appen");
            var0.put("enable_youtube_app_text", "Denne app fungerer ikke, medmindre du aktiverer YouTube-appen.");
            var0.put("enable_youtube_app_action", "Aktivér YouTube-appen");
            var0.put("update_youtube_app_title", "Opdater YouTube-appen");
            var0.put("update_youtube_app_text", "Denne app fungerer ikke, hvis du ikke opdaterer YouTube-appen.");
            var0.put("update_youtube_app_action", "Opdater YouTube-appen");
        } else if ("de".equals(countryCode)) {
            var0.put("error_initializing_player", "Bei der Initialisierung des YouTube-Players ist ein Fehler aufgetreten.");
            var0.put("get_youtube_app_title", "YouTube App herunterladen");
            var0.put("get_youtube_app_text", "Diese App kann nur ausgeführt werden, wenn die YouTube App bereitgestellt ist. Diese ist auf deinem Gerät nicht vorhanden.");
            var0.put("get_youtube_app_action", "YouTube App herunterladen");
            var0.put("enable_youtube_app_title", "YouTube App aktivieren");
            var0.put("enable_youtube_app_text", "Diese App funktioniert nur, wenn die YouTube App aktiviert wird.");
            var0.put("enable_youtube_app_action", "YouTube App aktivieren");
            var0.put("update_youtube_app_title", "YouTube App aktualisieren");
            var0.put("update_youtube_app_text", "Diese App funktioniert nur, wenn die YouTube App aktualisiert wird.");
            var0.put("update_youtube_app_action", "YouTube App aktualisieren");
        } else if ("el".equals(countryCode)) {
            var0.put("error_initializing_player", "Παρουσιάστηκε σφάλμα κατά την προετοιμασία του προγράμματος αναπαραγωγής του YouTube.");
            var0.put("get_youtube_app_title", "Λήψη YouTube");
            var0.put("get_youtube_app_text", "Δεν είναι δυνατή η εκτέλεση αυτής της εφαρμογής χωρίς την εφαρμογή YouTube, η οποία απουσιάζει από τη συσκευή σας");
            var0.put("get_youtube_app_action", "Λήψη YouTube");
            var0.put("enable_youtube_app_title", "Ενεργοποίηση YouTube");
            var0.put("enable_youtube_app_text", "Δεν είναι δυνατή η λειτουργία αυτής της εφαρμογής εάν δεν ενεργοποιήσετε την εφαρμογή YouTube.");
            var0.put("enable_youtube_app_action", "Ενεργοποίηση YouTube");
            var0.put("update_youtube_app_title", "Ενημέρωση YouTube");
            var0.put("update_youtube_app_text", "Δεν είναι δυνατή η λειτουργία αυτής της εφαρμογής εάν δεν ενημερώσετε την εφαρμογή YouTube.");
            var0.put("update_youtube_app_action", "Ενημέρωση YouTube");
        } else if ("en_GB".equals(countryCode)) {
            var0.put("error_initializing_player", "An error occurred while initialising the YouTube player.");
            var0.put("get_youtube_app_title", "Get YouTube App");
            var0.put("get_youtube_app_text", "This app won't run without the YouTube App, which is missing from your device");
            var0.put("get_youtube_app_action", "Get YouTube App");
            var0.put("enable_youtube_app_title", "Enable YouTube App");
            var0.put("enable_youtube_app_text", "This app won't work unless you enable the YouTube App.");
            var0.put("enable_youtube_app_action", "Enable YouTube App");
            var0.put("update_youtube_app_title", "Update YouTube App");
            var0.put("update_youtube_app_text", "This app won't work unless you update the YouTube App.");
            var0.put("update_youtube_app_action", "Update YouTube App");
        } else if ("es_US".equals(countryCode)) {
            var0.put("error_initializing_player", "Se produjo un error al iniciar el reproductor de YouTube.");
            var0.put("get_youtube_app_title", "Obtener YouTube");
            var0.put("get_youtube_app_text", "Esta aplicación no se ejecutará sin la aplicación YouTube, la cual no se instaló en tu dispositivo.");
            var0.put("get_youtube_app_action", "Obtener YouTube");
            var0.put("enable_youtube_app_title", "Activar YouTube");
            var0.put("enable_youtube_app_text", "Esta aplicación no funcionará a menos que actives la aplicación YouTube.");
            var0.put("enable_youtube_app_action", "Activar YouTube");
            var0.put("update_youtube_app_title", "Actualizar YouTube");
            var0.put("update_youtube_app_text", "Esta aplicación no funcionará a menos que actualices la aplicación YouTube.");
            var0.put("update_youtube_app_action", "Actualizar YouTube");
        } else if ("es".equals(countryCode)) {
            var0.put("error_initializing_player", "Se ha producido un error al iniciar el reproductor de YouTube.");
            var0.put("get_youtube_app_title", "Descarga YouTube");
            var0.put("get_youtube_app_text", "Esta aplicación no funcionará sin la aplicación YouTube, que no está instalada en el dispositivo.");
            var0.put("get_youtube_app_action", "Descargar YouTube");
            var0.put("enable_youtube_app_title", "Habilita la aplicación YouTube");
            var0.put("enable_youtube_app_text", "Esta aplicación no funcionará si no habilitas la aplicación YouTube.");
            var0.put("enable_youtube_app_action", "Habilitar YouTube");
            var0.put("update_youtube_app_title", "Actualiza YouTube");
            var0.put("update_youtube_app_text", "Esta aplicación no funcionará si no actualizas la aplicación YouTube.");
            var0.put("update_youtube_app_action", "Actualizar YouTube");
        } else if ("et".equals(countryCode)) {
            var0.put("error_initializing_player", "YouTube'i mängija lähtestamisel tekkis viga.");
            var0.put("get_youtube_app_title", "YouTube'i rak. hankimine");
            var0.put("get_youtube_app_text", "Rakendus ei käivitu ilma YouTube'i rakenduseta ja teie seadmes see praegu puudub");
            var0.put("get_youtube_app_action", "Hangi YouTube'i rakendus");
            var0.put("enable_youtube_app_title", "YouTube'i rakenduse lubamine");
            var0.put("enable_youtube_app_text", "Rakendus ei toimi, kui te ei luba kasutada YouTube'i rakendust.");
            var0.put("enable_youtube_app_action", "Luba YouTube'i rakendus");
            var0.put("update_youtube_app_title", "Värskenda YouTube");
            var0.put("update_youtube_app_text", "Rakendus ei toimi enne, kui olete YouTube'i rakendust värskendanud.");
            var0.put("update_youtube_app_action", "Värsk. YouTube'i rakend.");
        } else if ("fa".equals(countryCode)) {
            var0.put("error_initializing_player", "هنگام مقداردهی اولیه پخش\u200cکننده YouTube، خطایی روی داد.");
            var0.put("get_youtube_app_title", "دریافت برنامه YouTube");
            var0.put("get_youtube_app_text", "این برنامه بدون برنامه YouTube که در دستگاه شما موجود نیست، اجرا نمی\u200cشود");
            var0.put("get_youtube_app_action", "دریافت برنامه YouTube");
            var0.put("enable_youtube_app_title", "فعال کردن برنامه YouTube");
            var0.put("enable_youtube_app_text", "این برنامه تنها در صورتی کار خواهد کرد که برنامه YouTube را فعال کنید.");
            var0.put("enable_youtube_app_action", "فعال کردن برنامه YouTube");
            var0.put("update_youtube_app_title", "به\u200cروزرسانی برنامه YouTube");
            var0.put("update_youtube_app_text", "این برنامه کار نخواهد کرد مگر اینکه برنامه YouTube را به روز کنید.");
            var0.put("update_youtube_app_action", "به\u200cروزرسانی برنامه YouTube");
        } else if ("fi".equals(countryCode)) {
            var0.put("error_initializing_player", "Virhe alustettaessa YouTube-soitinta.");
            var0.put("get_youtube_app_title", "Hanki YouTube-sovellus");
            var0.put("get_youtube_app_text", "Tämä sovellus ei toimi ilman YouTube-sovellusta, joka puuttuu laitteesta.");
            var0.put("get_youtube_app_action", "Hanki YouTube-sovellus");
            var0.put("enable_youtube_app_title", "Ota YouTube-sov. käyttöön");
            var0.put("enable_youtube_app_text", "Tämä sovellus ei toimi, ellet ota YouTube-sovellusta käyttöön.");
            var0.put("enable_youtube_app_action", "Ota YouTube-sov. käyttöön");
            var0.put("update_youtube_app_title", "Päivitä YouTube-sovellus");
            var0.put("update_youtube_app_text", "Tämä sovellus ei toimi, ellet päivitä YouTube-sovellusta.");
            var0.put("update_youtube_app_action", "Päivitä YouTube-sovellus");
        } else if ("fr".equals(countryCode)) {
            var0.put("error_initializing_player", "Une erreur s'est produite lors de l'initialisation du lecteur YouTube.");
            var0.put("get_youtube_app_title", "Télécharger appli YouTube");
            var0.put("get_youtube_app_text", "Cette application ne fonctionnera pas sans l'application YouTube, qui n'est pas installée sur votre appareil.");
            var0.put("get_youtube_app_action", "Télécharger appli YouTube");
            var0.put("enable_youtube_app_title", "Activer l'appli YouTube");
            var0.put("enable_youtube_app_text", "Cette application ne fonctionnera que si vous activez l'application YouTube.");
            var0.put("enable_youtube_app_action", "Activer l'appli YouTube");
            var0.put("update_youtube_app_title", "Mise à jour appli YouTube");
            var0.put("update_youtube_app_text", "Cette application ne fonctionnera que si vous mettez à jour l'application YouTube.");
            var0.put("update_youtube_app_action", "Mise à jour appli YouTube");
        } else if ("hi".equals(countryCode)) {
            var0.put("error_initializing_player", "YouTube प्लेयर को प्रारंभ करते समय कोई त्रुटि आई.");
            var0.put("get_youtube_app_title", "YouTube एप्लि. प्राप्त करें");
            var0.put("get_youtube_app_text", "यह एप्लिकेशन YouTube एप्लिकेशन के बिना नहीं चलेगा, जो आपके उपकरण पर मौजूद नहीं है");
            var0.put("get_youtube_app_action", "YouTube एप्लि. प्राप्त करें");
            var0.put("enable_youtube_app_title", "YouTube एप्लि. सक्षम करें");
            var0.put("enable_youtube_app_text", "जब तक आप YouTube एप्लिकेशन सक्षम नहीं करते, तब तक यह एप्लिकेशन कार्य नहीं करेगा.");
            var0.put("enable_youtube_app_action", "YouTube एप्लि. सक्षम करें");
            var0.put("update_youtube_app_title", "YouTube एप्लि. अपडेट करें");
            var0.put("update_youtube_app_text", "जब तक आप YouTube एप्लिकेशन अपडेट नहीं करते, तब तक यह एप्लिकेशन कार्य नहीं करेगा.");
            var0.put("update_youtube_app_action", "YouTube एप्लि. अपडेट करें");
        } else if ("hr".equals(countryCode)) {
            var0.put("error_initializing_player", "Dogodila se pogreška tijekom pokretanja playera usluge YouTube.");
            var0.put("get_youtube_app_title", "Preuzimanje apl. YouTube");
            var0.put("get_youtube_app_text", "Ova se aplikacija ne može pokrenuti bez aplikacije YouTube, koja nije instalirana na vaš uređaj");
            var0.put("get_youtube_app_action", "Preuzmi apl. YouTube");
            var0.put("enable_youtube_app_title", "Omogućavanje apl. YouTube");
            var0.put("enable_youtube_app_text", "Ova aplikacija neće funkcionirati ako ne omogućite aplikaciju YouTube.");
            var0.put("enable_youtube_app_action", "Omogući apl. YouTube");
            var0.put("update_youtube_app_title", "Ažuriranje apl. YouTube");
            var0.put("update_youtube_app_text", "Ova aplikacija neće funkcionirati ako ne ažurirate aplikaciju YouTube.");
            var0.put("update_youtube_app_action", "Ažuriraj apl. YouTube");
        } else if ("hu".equals(countryCode)) {
            var0.put("error_initializing_player", "Hiba történt a YouTube lejátszó inicializálása során.");
            var0.put("get_youtube_app_title", "YouTube alk. letöltése");
            var0.put("get_youtube_app_text", "Ez az alkalmazás nem fut a YouTube alkalmazás nélkül, amely hiányzik az eszközéről.");
            var0.put("get_youtube_app_action", "YouTube alk. letöltése");
            var0.put("enable_youtube_app_title", "YouTube alkalmazás enged.");
            var0.put("enable_youtube_app_text", "Az alkalmazás csak akkor fog működni, ha engedélyezi a YouTube alkalmazást.");
            var0.put("enable_youtube_app_action", "YouTube alkalmazás enged.");
            var0.put("update_youtube_app_title", "YouTube alk. frissítése");
            var0.put("update_youtube_app_text", "Az alkalmazás csak akkor fog működni, ha frissíti a YouTube alkalmazást.");
            var0.put("update_youtube_app_action", "YouTube alk. frissítése");
        } else if ("in".equals(countryCode)) {
            var0.put("error_initializing_player", "Terjadi kesalahan saat memulai pemutar YouTube.");
            var0.put("get_youtube_app_title", "Dapatkan Aplikasi YouTube");
            var0.put("get_youtube_app_text", "Aplikasi ini tidak akan berjalan tanpa Aplikasi YouTube, yang hilang dari perangkat Anda");
            var0.put("get_youtube_app_action", "Dapatkan Aplikasi YouTube");
            var0.put("enable_youtube_app_title", "Aktifkan Aplikasi YouTube");
            var0.put("enable_youtube_app_text", "Aplikasi ini tidak akan bekerja kecuali Anda mengaktifkan Aplikasi YouTube.");
            var0.put("enable_youtube_app_action", "Aktifkan Aplikasi YouTube");
            var0.put("update_youtube_app_title", "Perbarui Aplikasi YouTube");
            var0.put("update_youtube_app_text", "Aplikasi ini tidak akan bekerja kecuali Anda memperbarui Aplikasi YouTube.");
            var0.put("update_youtube_app_action", "Perbarui Aplikasi YouTube");
        } else if ("it".equals(countryCode)) {
            var0.put("error_initializing_player", "Si è verificato un errore durante l'inizializzazione del player di YouTube.");
            var0.put("get_youtube_app_title", "Scarica app YouTube");
            var0.put("get_youtube_app_text", "Questa applicazione non funzionerà senza l'applicazione YouTube che non è presente sul tuo dispositivo");
            var0.put("get_youtube_app_action", "Scarica app YouTube");
            var0.put("enable_youtube_app_title", "Attiva app YouTube");
            var0.put("enable_youtube_app_text", "Questa applicazione non funzionerà se non attivi l'applicazione YouTube.");
            var0.put("enable_youtube_app_action", "Attiva app YouTube");
            var0.put("update_youtube_app_title", "Aggiorna app YouTube");
            var0.put("update_youtube_app_text", "Questa applicazione non funzionerà se non aggiorni l'applicazione YouTube.");
            var0.put("update_youtube_app_action", "Aggiorna app YouTube");
        } else if ("iw".equals(countryCode)) {
            var0.put("error_initializing_player", "אירעה שגיאה בעת אתחול נגן YouTube.");
            var0.put("get_youtube_app_title", "קבל את יישום YouTube");
            var0.put("get_youtube_app_text", "יישום זה לא יפעל ללא יישום YouTube, שאינו מותקן במכשיר שלך");
            var0.put("get_youtube_app_action", "קבל את יישום YouTube");
            var0.put("enable_youtube_app_title", "הפעל את יישום YouTube");
            var0.put("enable_youtube_app_text", "יישום זה לא יעבוד אלא אם תפעיל את יישום YouTube.");
            var0.put("enable_youtube_app_action", "הפעל את יישום YouTube");
            var0.put("update_youtube_app_title", "עדכן את יישום YouTube");
            var0.put("update_youtube_app_text", "יישום זה לא יעבוד אלא אם תעדכן את יישום YouTube.");
            var0.put("update_youtube_app_action", "עדכן את יישום YouTube");
        } else if ("ja".equals(countryCode)) {
            var0.put("error_initializing_player", "YouTubeプレーヤーの初期化中にエラーが発生しました。");
            var0.put("get_youtube_app_title", "YouTubeアプリを入手");
            var0.put("get_youtube_app_text", "このアプリの実行に必要なYouTubeアプリが端末にありません");
            var0.put("get_youtube_app_action", "YouTubeアプリを入手");
            var0.put("enable_youtube_app_title", "YouTubeアプリを有効化");
            var0.put("enable_youtube_app_text", "このアプリの実行にはYouTubeアプリの有効化が必要です。");
            var0.put("enable_youtube_app_action", "YouTubeアプリを有効化");
            var0.put("update_youtube_app_title", "YouTubeアプリを更新");
            var0.put("update_youtube_app_text", "このアプリの実行にはYouTubeアプリの更新が必要です。");
            var0.put("update_youtube_app_action", "YouTubeアプリを更新");
        } else if ("ko".equals(countryCode)) {
            var0.put("error_initializing_player", "YouTube 플레이어를 초기화하는 중에 오류가 발생했습니다.");
            var0.put("get_youtube_app_title", "YouTube 앱 다운로드");
            var0.put("get_youtube_app_text", "이 앱은 내 기기에 YouTube 앱이 없어서 실행되지 않습니다.");
            var0.put("get_youtube_app_action", "YouTube 앱 다운로드");
            var0.put("enable_youtube_app_title", "YouTube 앱 사용 설정");
            var0.put("enable_youtube_app_text", "이 앱은 YouTube 앱을 사용하도록 설정하지 않으면 작동하지 않습니다.");
            var0.put("enable_youtube_app_action", "YouTube 앱 사용");
            var0.put("update_youtube_app_title", "YouTube 앱 업데이트");
            var0.put("update_youtube_app_text", "이 앱은 YouTube 앱을 업데이트하지 않으면 작동하지 않습니다.");
            var0.put("update_youtube_app_action", "YouTube 앱 업데이트");
        } else if ("lt".equals(countryCode)) {
            var0.put("error_initializing_player", "Inicijuojant „YouTube“ grotuvą įvyko klaida.");
            var0.put("get_youtube_app_title", "Gauti „YouTube“ programą");
            var0.put("get_youtube_app_text", "Ši programa neveikia be „YouTube“ programos, o jos įrenginyje nėra.");
            var0.put("get_youtube_app_action", "Gauti „YouTube“ programą");
            var0.put("enable_youtube_app_title", "Įgalinti „YouTube“ progr.");
            var0.put("enable_youtube_app_text", "Ši programa neveiks, jei neįgalinsite „YouTube“ programos.");
            var0.put("enable_youtube_app_action", "Įgalinti „YouTube“ progr.");
            var0.put("update_youtube_app_title", "Atnauj. „YouTube“ progr.");
            var0.put("update_youtube_app_text", "Ši programa neveiks, jei neatnaujinsite „YouTube“ programos.");
            var0.put("update_youtube_app_action", "Atnauj. „YouTube“ progr.");
        } else if ("lv".equals(countryCode)) {
            var0.put("error_initializing_player", "Inicializējot YouTube atskaņotāju, radās kļūda.");
            var0.put("get_youtube_app_title", "YouTube liet. iegūšana");
            var0.put("get_youtube_app_text", "Šī lietotne nedarbosies bez YouTube lietotnes, kuras nav šajā ierīcē.");
            var0.put("get_youtube_app_action", "Iegūt YouTube lietotni");
            var0.put("enable_youtube_app_title", "YouTube liet. iespējošana");
            var0.put("enable_youtube_app_text", "Lai šī lietotne darbotos, iespējojiet YouTube lietotni.");
            var0.put("enable_youtube_app_action", "Iespējot YouTube lietotni");
            var0.put("update_youtube_app_title", "YouTube liet. atjaunin.");
            var0.put("update_youtube_app_text", "Lai šī lietotne darbotos, atjauniniet YouTube lietotni.");
            var0.put("update_youtube_app_action", "Atjaun. YouTube lietotni");
        } else if ("ms".equals(countryCode)) {
            var0.put("error_initializing_player", "Ralat berlaku semasa memulakan alat main YouTube.");
            var0.put("get_youtube_app_title", "Dapatkan Apl YouTube");
            var0.put("get_youtube_app_text", "Apl ini tidak akan berjalan tanpa Apl YouTube, yang tidak ada pada peranti anda");
            var0.put("get_youtube_app_action", "Dapatkan Apl YouTube");
            var0.put("enable_youtube_app_title", "Dayakan Apl YouTube");
            var0.put("enable_youtube_app_text", "Apl ini tidak akan berfungsi kecuali anda mendayakan Apl YouTube.");
            var0.put("enable_youtube_app_action", "Dayakan Apl YouTube");
            var0.put("update_youtube_app_title", "Kemas kini Apl YouTube");
            var0.put("update_youtube_app_text", "Apl ini tidak akan berfungsi kecuali anda mengemas kini Apl YouTube.");
            var0.put("update_youtube_app_action", "Kemas kini Apl YouTube");
        } else if ("nb".equals(countryCode)) {
            var0.put("error_initializing_player", "Det oppsto en feil da YouTube-avspilleren startet.");
            var0.put("get_youtube_app_title", "Skaff deg YouTube-appen");
            var0.put("get_youtube_app_text", "Denne appen kan ikke kjøre uten YouTube-appen, som du ikke har på enheten");
            var0.put("get_youtube_app_action", "Skaff deg YouTube-appen");
            var0.put("enable_youtube_app_title", "Aktiver YouTube-appen");
            var0.put("enable_youtube_app_text", "Denne appen fungerer ikke før du aktiverer YouTube-appen.");
            var0.put("enable_youtube_app_action", "Aktiver YouTube-appen");
            var0.put("update_youtube_app_title", "Oppdater YouTube-appen");
            var0.put("update_youtube_app_text", "Denne appen fungerer ikke før du oppdaterer YouTube-appen.");
            var0.put("update_youtube_app_action", "Oppdater YouTube-appen");
        } else if ("nl".equals(countryCode)) {
            var0.put("error_initializing_player", "Er is een fout opgetreden bij het initialiseren van de YouTube-speler.");
            var0.put("get_youtube_app_title", "YouTube-app downloaden");
            var0.put("get_youtube_app_text", "Deze app wordt niet uitgevoerd zonder de YouTube-app, die op uw apparaat ontbreekt");
            var0.put("get_youtube_app_action", "YouTube-app downloaden");
            var0.put("enable_youtube_app_title", "YouTube-app inschakelen");
            var0.put("enable_youtube_app_text", "Deze app werkt niet, tenzij u de YouTube-app inschakelt.");
            var0.put("enable_youtube_app_action", "YouTube-app inschakelen");
            var0.put("update_youtube_app_title", "YouTube-app bijwerken");
            var0.put("update_youtube_app_text", "Deze app werkt niet, tenzij u de YouTube-app bijwerkt.");
            var0.put("update_youtube_app_action", "YouTube-app bijwerken");
        } else if ("pl".equals(countryCode)) {
            var0.put("error_initializing_player", "Podczas inicjowania odtwarzacza YouTube wystąpił błąd.");
            var0.put("get_youtube_app_title", "Pobierz aplikację YouTube");
            var0.put("get_youtube_app_text", "Ta aplikacja nie będzie działać bez aplikacji YouTube, której nie ma na tym urządzeniu");
            var0.put("get_youtube_app_action", "Pobierz aplikację YouTube");
            var0.put("enable_youtube_app_title", "Włącz aplikację YouTube");
            var0.put("enable_youtube_app_text", "Ta aplikacja nie będzie działać, jeśli nie włączysz aplikacji YouTube.");
            var0.put("enable_youtube_app_action", "Włącz aplikację YouTube");
            var0.put("update_youtube_app_title", "Zaktualizuj aplikację YouTube");
            var0.put("update_youtube_app_text", "Ta aplikacja nie będzie działać, jeśli nie zaktualizujesz aplikacji YouTube.");
            var0.put("update_youtube_app_action", "Zaktualizuj aplikację YouTube");
        } else if ("pt_PT".equals(countryCode)) {
            var0.put("error_initializing_player", "Ocorreu um erro ao iniciar o leitor do YouTube.");
            var0.put("get_youtube_app_title", "Obter a Aplicação YouTube");
            var0.put("get_youtube_app_text", "Esta aplicação não será executada sem a Aplicação YouTube, que está em falta no seu dispositivo");
            var0.put("get_youtube_app_action", "Obter a Aplicação YouTube");
            var0.put("enable_youtube_app_title", "Ativar Aplicação YouTube");
            var0.put("enable_youtube_app_text", "Esta aplicação não irá funcionar enquanto não ativar a Aplicação YouTube.");
            var0.put("enable_youtube_app_action", "Ativar Aplicação YouTube");
            var0.put("update_youtube_app_title", "Atualizar Aplica. YouTube");
            var0.put("update_youtube_app_text", "Esta aplicação não irá funcionar enquanto não atualizar a Aplicação YouTube.");
            var0.put("update_youtube_app_action", "Atualizar Aplica. YouTube");
        } else if ("pt".equals(countryCode)) {
            var0.put("error_initializing_player", "Ocorreu um erro ao inicializar o player do YouTube.");
            var0.put("get_youtube_app_title", "Obter aplicativo YouTube");
            var0.put("get_youtube_app_text", "Este aplicativo só funciona com o aplicativo YouTube, que está ausente no dispositivo.");
            var0.put("get_youtube_app_action", "Obter aplicativo YouTube");
            var0.put("enable_youtube_app_title", "Ativar aplicativo YouTube");
            var0.put("enable_youtube_app_text", "Este aplicativo só funciona com o aplicativo YouTube ativado.");
            var0.put("enable_youtube_app_action", "Ativar aplicativo YouTube");
            var0.put("update_youtube_app_title", "Atualizar aplic. YouTube");
            var0.put("update_youtube_app_text", "Este aplicativo só funciona com o aplicativo YouTube atualizado.");
            var0.put("update_youtube_app_action", "Atualizar aplic. YouTube");
        } else if ("ro".equals(countryCode)) {
            var0.put("error_initializing_player", "A apărut o eroare la iniţializarea playerului YouTube.");
            var0.put("get_youtube_app_title", "Descărcaţi YouTube");
            var0.put("get_youtube_app_text", "Această aplicaţie nu va rula fără aplicaţia YouTube, care lipseşte de pe gadget");
            var0.put("get_youtube_app_action", "Descărcaţi YouTube");
            var0.put("enable_youtube_app_title", "Activaţi YouTube");
            var0.put("enable_youtube_app_text", "Această aplicaţie nu va funcţiona decât dacă activaţi aplicaţia YouTube.");
            var0.put("enable_youtube_app_action", "Activaţi YouTube");
            var0.put("update_youtube_app_title", "Actualizaţi YouTube");
            var0.put("update_youtube_app_text", "Această aplicaţie nu va funcţiona decât dacă actualizaţi aplicaţia YouTube.");
            var0.put("update_youtube_app_action", "Actualizaţi YouTube");
        } else if ("ru".equals(countryCode)) {
            var0.put("error_initializing_player", "Не удалось запустить проигрыватель YouTube.");
            var0.put("get_youtube_app_title", "Загрузите YouTube");
            var0.put("get_youtube_app_text", "Чтобы запустить эту программу, установите приложение YouTube.");
            var0.put("get_youtube_app_action", "Загрузить YouTube");
            var0.put("enable_youtube_app_title", "Активация YouTube");
            var0.put("enable_youtube_app_text", "Чтобы запустить эту программу, активируйте приложение YouTube.");
            var0.put("enable_youtube_app_action", "Активировать YouTube");
            var0.put("update_youtube_app_title", "Обновление YouTube");
            var0.put("update_youtube_app_text", "Чтобы запустить эту программу, обновите приложение YouTube.");
            var0.put("update_youtube_app_action", "Обновить YouTube");
        } else if ("sk".equals(countryCode)) {
            var0.put("error_initializing_player", "Pri inicializácii prehrávača YouTube sa vyskytla chyba.");
            var0.put("get_youtube_app_title", "Získať aplikáciu YouTube");
            var0.put("get_youtube_app_text", "Túto aplikáciu nebude možné spustiť bez aplikácie YouTube, ktorá na zariadení nie je nainštalovaná.");
            var0.put("get_youtube_app_action", "Získať aplikáciu YouTube");
            var0.put("enable_youtube_app_title", "Povoliť aplikáciu YouTube");
            var0.put("enable_youtube_app_text", "Táto aplikácia bude fungovať až po povolení aplikácie YouTube.");
            var0.put("enable_youtube_app_action", "Povoliť aplikáciu YouTube");
            var0.put("update_youtube_app_title", "Aktualizovať apl. YouTube");
            var0.put("update_youtube_app_text", "Táto aplikácia bude fungovať až po aktualizácii aplikácie YouTube.");
            var0.put("update_youtube_app_action", "Aktualizovať apl. YouTube");
        } else if ("sl".equals(countryCode)) {
            var0.put("error_initializing_player", "Napaka med inicializacijo YouTubovega predvajalnika.");
            var0.put("get_youtube_app_title", "Prenos aplikacije YouTube");
            var0.put("get_youtube_app_text", "Ta aplikacija ne bo delovala brez aplikacije YouTube, ki je ni v vaši napravi");
            var0.put("get_youtube_app_action", "Prenos aplikacije YouTube");
            var0.put("enable_youtube_app_title", "Omog. aplikacije YouTube");
            var0.put("enable_youtube_app_text", "Ta aplikacija ne bo delovala, če ne omogočite aplikacije YouTube.");
            var0.put("enable_youtube_app_action", "Omog. aplikacijo YouTube");
            var0.put("update_youtube_app_title", "Posodob. aplikacije YouTube");
            var0.put("update_youtube_app_text", "Ta aplikacija ne bo delovala, če ne posodobite aplikacije YouTube.");
            var0.put("update_youtube_app_action", "Posod. aplikacijo YouTube");
        } else if ("sr".equals(countryCode)) {
            var0.put("error_initializing_player", "Дошло је до грешке при покретању YouTube плејера.");
            var0.put("get_youtube_app_title", "Преузимање аплик. YouTube");
            var0.put("get_youtube_app_text", "Ова апликација неће функционисати без апликације YouTube, која недостаје на уређају");
            var0.put("get_youtube_app_action", "Преузми апликац. YouTube");
            var0.put("enable_youtube_app_title", "Омогућавање апл. YouTube");
            var0.put("enable_youtube_app_text", "Ова апликације неће функционисати ако не омогућите апликацију YouTube.");
            var0.put("enable_youtube_app_action", "Омогући апликац. YouTube");
            var0.put("update_youtube_app_title", "Ажурирање аплик. YouTube");
            var0.put("update_youtube_app_text", "Ова апликације неће функционисати ако не ажурирате апликацију YouTube.");
            var0.put("update_youtube_app_action", "Ажурирај апликац. YouTube");
        } else if ("sv".equals(countryCode)) {
            var0.put("error_initializing_player", "Ett fel uppstod när YouTube-spelaren skulle startas.");
            var0.put("get_youtube_app_title", "Hämta YouTube-appen");
            var0.put("get_youtube_app_text", "YouTube-appen krävs för att den här appen ska kunna köras. Du har inte YouTube-appen på din enhet.");
            var0.put("get_youtube_app_action", "Hämta YouTube-appen");
            var0.put("enable_youtube_app_title", "Aktivera YouTube-appen");
            var0.put("enable_youtube_app_text", "Du måste aktivera YouTube-appen för att den här appen ska fungera.");
            var0.put("enable_youtube_app_action", "Aktivera YouTube-appen");
            var0.put("update_youtube_app_title", "Uppdatera YouTube-appen");
            var0.put("update_youtube_app_text", "Du måste uppdatera YouTube-appen för att den här appen ska fungera.");
            var0.put("update_youtube_app_action", "Uppdatera YouTube-appen");
        } else if ("sw".equals(countryCode)) {
            var0.put("error_initializing_player", "Hitilafu ilitokea wakati wa kuanzisha kichezeshi cha YouTube.");
            var0.put("get_youtube_app_title", "Pata Programu ya YouTube");
            var0.put("get_youtube_app_text", "Programu hii haitaendeshwa bila Programu ya YouTube, ambayo inakosekana kwenye kifaa chako.");
            var0.put("get_youtube_app_action", "Pata Programu ya YouTube");
            var0.put("enable_youtube_app_title", "Wezesha Programu ya YouTube");
            var0.put("enable_youtube_app_text", "Programu hii haitafanya kazi isipokuwa uwezeshe Programu ya YouTube.");
            var0.put("enable_youtube_app_action", "Wezesha Programu ya YouTube");
            var0.put("update_youtube_app_title", "Sasisha Programu ya YouTube");
            var0.put("update_youtube_app_text", "Programu hii haitafanya kazi mpaka usasishe Programu ya YouTube.");
            var0.put("update_youtube_app_action", "Sasisha Programu ya YouTube");
        } else if ("th".equals(countryCode)) {
            var0.put("error_initializing_player", "เกิดข้อผิดพลาดในขณะเริ่มต้นโปรแกรมเล่น YouTube");
            var0.put("get_youtube_app_title", "รับแอปพลิเคชัน YouTube");
            var0.put("get_youtube_app_text", "แอปพลิเคชันนี้จะไม่ทำงานหากไม่มีแอปพลิเคชัน YouTube ซึ่งไม่มีในอุปกรณ์ของคุณ");
            var0.put("get_youtube_app_action", "รับแอปพลิเคชัน YouTube");
            var0.put("enable_youtube_app_title", "เปิดใช้งานแอป YouTube");
            var0.put("enable_youtube_app_text", "แอปพลิเคชันนี้จะไม่ทำงานจนกว่าคุณจะเปิดใช้งานแอปพลิเคชัน YouTube");
            var0.put("enable_youtube_app_action", "เปิดใช้งานแอป YouTube");
            var0.put("update_youtube_app_title", "อัปเดตแอปพลิเคชัน YouTube");
            var0.put("update_youtube_app_text", "แอปพลิเคชันนี้จะไม่ทำงานจนกว่าคุณจะอัปเดตแอปพลิเคชัน YouTube");
            var0.put("update_youtube_app_action", "อัปเดตแอปพลิเคชัน YouTube");
        } else if ("tl".equals(countryCode)) {
            var0.put("error_initializing_player", "May naganap na error habang sinisimulan ang player ng YouTube.");
            var0.put("get_youtube_app_title", "Kunin ang YouTube App");
            var0.put("get_youtube_app_text", "Hindi gagana ang app na ito nang wala ang YouTube App, na nawawala sa iyong device");
            var0.put("get_youtube_app_action", "Kunin ang YouTube App");
            var0.put("enable_youtube_app_title", "Paganahin ang YouTube App");
            var0.put("enable_youtube_app_text", "Hindi gagana ang app na ito maliban kung paganahin mo ang YouTube App.");
            var0.put("enable_youtube_app_action", "Paganahin ang YouTube App");
            var0.put("update_youtube_app_title", "I-update ang YouTube App");
            var0.put("update_youtube_app_text", "Hindi gagana ang app na ito maliban kung i-update mo ang YouTube App.");
            var0.put("update_youtube_app_action", "I-update ang YouTube App");
        } else if ("tr".equals(countryCode)) {
            var0.put("error_initializing_player", "YouTube oynatıcısı başlatılırken bir hata oluştu.");
            var0.put("get_youtube_app_title", "YouTube Uygulamasını edinin");
            var0.put("get_youtube_app_text", "Cihazınızda bulunmayan YouTube Uygulaması olmadan bu uygulama çalışmaz");
            var0.put("get_youtube_app_action", "YouTube Uygulamasını edinin");
            var0.put("enable_youtube_app_title", "YouTube Uygulamasını etkinleştirin");
            var0.put("enable_youtube_app_text", "YouTube Uygulamasını etkinleştirmediğiniz sürece bu uygulama çalışmaz.");
            var0.put("enable_youtube_app_action", "YouTube Uygulamasını etkinleştirin");
            var0.put("update_youtube_app_title", "YouTube Uygulamasını güncelleyin");
            var0.put("update_youtube_app_text", "YouTube Uygulaması güncellenmedikçe bu uygulama çalışmaz.");
            var0.put("update_youtube_app_action", "YouTube Uygulamasını güncelle");
        } else if ("uk".equals(countryCode)) {
            var0.put("error_initializing_player", "Під час ініціалізації програвача YouTube сталася помилка.");
            var0.put("get_youtube_app_title", "Отримати програму YouTube");
            var0.put("get_youtube_app_text", "Ця програма не запуститься без програми YouTube, яку не встановлено на вашому пристрої");
            var0.put("get_youtube_app_action", "Отримати програму YouTube");
            var0.put("enable_youtube_app_title", "Увімк. програму YouTube");
            var0.put("enable_youtube_app_text", "Ця програма не працюватиме, поки ви не ввімкнете програму YouTube.");
            var0.put("enable_youtube_app_action", "Увімк. програму YouTube");
            var0.put("update_youtube_app_title", "Оновити програму YouTube");
            var0.put("update_youtube_app_text", "Ця програма не працюватиме, поки ви не оновите програму YouTube.");
            var0.put("update_youtube_app_action", "Оновити програму YouTube");
        } else if ("vi".equals(countryCode)) {
            var0.put("error_initializing_player", "Đã xảy ra lỗi trong khi khởi chạy trình phát YouTube.");
            var0.put("get_youtube_app_title", "Tải ứng dụng YouTube");
            var0.put("get_youtube_app_text", "Ứng dụng này sẽ không chạy nếu không có ứng dụng YouTube, ứng dụng này bị thiếu trong thiết bị của bạn");
            var0.put("get_youtube_app_action", "Tải ứng dụng YouTube");
            var0.put("enable_youtube_app_title", "Bật ứng dụng YouTube");
            var0.put("enable_youtube_app_text", "Ứng dụng này sẽ không hoạt động trừ khi bạn bật ứng dụng YouTube.");
            var0.put("enable_youtube_app_action", "Bật ứng dụng YouTube");
            var0.put("update_youtube_app_title", "Cập nhật ứng dụng YouTube");
            var0.put("update_youtube_app_text", "Ứng dụng này sẽ không hoạt động trừ khi bạn cập nhật ứng dụng YouTube.");
            var0.put("update_youtube_app_action", "Cập nhật ứng dụng YouTube");
        } else if ("zh_CN".equals(countryCode)) {
            var0.put("error_initializing_player", "初始化 YouTube 播放器时出现错误。");
            var0.put("get_youtube_app_title", "获取 YouTube 应用");
            var0.put("get_youtube_app_text", "您的设备中没有 YouTube 应用，您必须先安装 YouTube 应用才能运行此应用。");
            var0.put("get_youtube_app_action", "获取 YouTube 应用");
            var0.put("enable_youtube_app_title", "启用 YouTube 应用");
            var0.put("enable_youtube_app_text", "您需要启用 YouTube 应用才能运行该应用。");
            var0.put("enable_youtube_app_action", "启用 YouTube 应用");
            var0.put("update_youtube_app_title", "更新 YouTube 应用");
            var0.put("update_youtube_app_text", "您必须更新 YouTube 应用才能运行此应用。");
            var0.put("update_youtube_app_action", "更新 YouTube 应用");
        } else if ("zh_TW".equals(countryCode)) {
            var0.put("error_initializing_player", "初始化 YouTube 播放器時發生錯誤。");
            var0.put("get_youtube_app_title", "取得 YouTube 應用程式");
            var0.put("get_youtube_app_text", "您必須啟用 YouTube 應用程式，這個應用程式才能運作，但系統在裝置中找不到 YouTube 應用程式。");
            var0.put("get_youtube_app_action", "取得 YouTube 應用程式");
            var0.put("enable_youtube_app_title", "啟用 YouTube 應用程式");
            var0.put("enable_youtube_app_text", "您必須啟用 YouTube 應用程式，這個應用程式才能運作。");
            var0.put("enable_youtube_app_action", "啟用 YouTube 應用程式");
            var0.put("update_youtube_app_title", "更新 YouTube 應用程式");
            var0.put("update_youtube_app_text", "您必須更新 YouTube 應用程式，這個應用程式才能運作。");
            var0.put("update_youtube_app_action", "更新 YouTube 應用程式");
        } else {
            if ("zu".equals(countryCode)) {
                var0.put("error_initializing_player", "Kuvele iphutha ngenkathi kuqaliswa isidlali se-YouTube");
                var0.put("get_youtube_app_title", "Thola uhlelo lokusebenza lwe-YouTube");
                var0.put("get_youtube_app_text", "Lolu hlelo kusebenza angeke lusebenze ngaphandle kohlelo lokusebenza lwe-YouTube, olungekho kudivayisi yakho");
                var0.put("get_youtube_app_action", "Thola uhelo lokusebenza lwe-YouTube");
                var0.put("enable_youtube_app_title", "Nika amandla uhlelo lokusebenza lwe-YouTube");
                var0.put("enable_youtube_app_text", "Lolu hlelo lokusebenza angeke lusebenze uma unganikanga amandla uhlelo lokusebenza lwe-YouTube.");
                var0.put("enable_youtube_app_action", "Nika amandla uhlelo lokusebenza lwe-YouTube");
                var0.put("update_youtube_app_title", "Buyekeza uhlelo lokusebenza lwe-YouTube");
                var0.put("update_youtube_app_text", "Lolu hlelo lokusebenza angeke lusebenze uma ungabuyekezanga uhlelo lokusebenza lwe-YouTube.");
                var0.put("update_youtube_app_action", "Buyekeza uhlelo lokusebenza lwe-YouTube");
            }

        }
    }
}
