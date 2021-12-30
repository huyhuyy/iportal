package com.smartoscfintech.iportal.component.impl;

import com.smartoscfintech.iportal.component.MessageTranslator;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Locale;

@Component
@AllArgsConstructor
public class MessageTranslatorImpl implements MessageTranslator {
    private final MessageSource messageSource;

    @Override
    public String getMessage(String key) {
        String message = "";
        if (StringUtils.isEmpty(key)) {
            return message;
        }

        Locale locale = LocaleContextHolder.getLocale();
        try {
            message = messageSource.getMessage(key, null, locale);
        } catch (Exception ex) {
            message = key;
        }
        return message;
    }
}
