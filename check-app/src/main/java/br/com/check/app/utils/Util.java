package br.com.check.app.utils;

import lombok.experimental.UtilityClass;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@UtilityClass
public class Util {

  public static String translate(final MessageSource messageSource, final String text,
                                 final Object... objects) {
    try {
      return messageSource.getMessage(text, objects, LocaleContextHolder.getLocale());
    } catch (final Exception ex) {
      return text;
    }
  }
}
