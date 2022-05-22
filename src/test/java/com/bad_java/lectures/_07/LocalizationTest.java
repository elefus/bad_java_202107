package com.bad_java.lectures._07;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizationTest {

    @Test
    void locales() {
        // i18n = internationalization
        // l10n = localization

        Locale us = Locale.US;
        Locale ru = new Locale("ru", "RU", "win");

        NumberFormat usIntegers = NumberFormat.getIntegerInstance(us);
        NumberFormat ruIntegers = NumberFormat.getIntegerInstance(ru);

        int intValue = -1_000_000;
        assertThat(usIntegers.format(intValue)).isEqualTo("-1,000,000");
        assertThat(ruIntegers.format(intValue)).isEqualTo("-1 000 000");

        NumberFormat usPercents = NumberFormat.getPercentInstance(us);
        NumberFormat ruPercents = NumberFormat.getPercentInstance(ru);
        assertThat(usPercents.format(0.1)).isEqualTo("10%");
        assertThat(ruPercents.format(0.1)).isEqualTo("10 %");

        NumberFormat usCurrency = NumberFormat.getCurrencyInstance(us);
        NumberFormat ruCurrency = NumberFormat.getCurrencyInstance(ru);
        assertThat(usCurrency.format(-intValue)).isEqualTo("$1,000,000.00");
        assertThat(ruCurrency.format(-intValue)).isEqualTo("1 000 000,00 ₽");
    }

    @Test
    void dateFormatters() {
        Locale ru = new Locale("ru", "RU", "win");

        DateFormat ruDateTime = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, Locale.CANADA);
        String format = ruDateTime.format(new Date());
        System.out.println(format);
    }

    @Test
    void internationalizationAndLocalization() {
        Locale ru = new Locale("ru", "RU");
        Locale us = Locale.US;

        String inputUsernameKey = "input_username";

        ResourceBundle ruBundle = ResourceBundle.getBundle("com.bad_java.lectures._07.messages", ru);
        ResourceBundle usBundle = ResourceBundle.getBundle("com.bad_java.lectures._07.messages", us);

        System.out.println(ruBundle.getString(inputUsernameKey));
        System.out.println(usBundle.getString(inputUsernameKey));
    }
}
