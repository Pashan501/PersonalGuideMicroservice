package com.personalguide.imp.localization;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractResourceBasedMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Data
@NoArgsConstructor
public class Messagei18n {

    private AbstractResourceBasedMessageSource messageSource;

    @Autowired
    public Messagei18n(AbstractResourceBasedMessageSource messageSource){
        this.messageSource = messageSource;
    }

    public String getMessage(String key, Locale locale){
        return messageSource.getMessage(key,null,"No message found",locale);
    }
}
