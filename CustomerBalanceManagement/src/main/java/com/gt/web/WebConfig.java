package com.gt.web;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Configuration class for web-related settings.
 *
 * Configures locale resolver and message source for internationalization.
 *
 * Provides an interceptor for changing the locale based on request parameters.
 *
 * This class implements WebMvcConfigurer to customize Spring MVC configuration.
 *
 * Defines beans for handling locale resolution and message sources.
 *
 * @author [Your Name]
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Bean definition for locale resolver.
     *
     * @return A LocaleResolver instance.
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        localeResolver.setLocaleAttributeName("session.current.locale");
        localeResolver.setTimeZoneAttributeName("session.current.timezone");
        return localeResolver;
    }

    /**
     * Bean definition for locale change interceptor.
     *
     * @return A LocaleChangeInterceptor instance.
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("lang");
        return localeInterceptor;
    }

    /**
     * Adds interceptors for locale change to the registry.
     *
     * @param registry The InterceptorRegistry to register interceptors.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * Bean definition for message source.
     *
     * @return A MessageSource instance.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
        msgSource.setBasename("messages");
        msgSource.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        return msgSource;
    }
}
