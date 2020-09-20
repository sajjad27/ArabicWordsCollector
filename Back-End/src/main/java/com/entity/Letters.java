package com.entity;

public class Letters {
    public enum letters {
        ALF_QT3("أ"),ALF_WASEL("ا"), BA("ب"), TA("ت"), THA("ث"), JEEM("ج"), HA("ح"), KHA("خ"),
        DAL("د"), THAL("ذ"), RA2("ر"), ZA2("ز"), SEEN("س"), SHEEN("ش"), SA("ص"),
        DHA("ض"), TAA("ط"), THE("ظ"), AIN("ع"), GHAIN("غ"), FA("ف"), QAF("ق"), KAF("ك"),
        LAM("ل"), MEEM("م"), NOON("ن"), HA2("ه"), WOW("و"), YA("ي");

        private String url;

        letters(String envUrl) {
            this.url = envUrl;
        }

        public String getUrl() {
            return url;
        }
    }
}
