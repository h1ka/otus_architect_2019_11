package ru.otus.shop.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket api() {
        List<AlternateTypeRule> typeRules = getAlternateTypeRules();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.otus.shop.web.rest"))
                .build()
                .genericModelSubstitutes(Optional.class)
                .alternateTypeRules(typeRules.toArray(new AlternateTypeRule[typeRules.size()]));
    }

    private List<AlternateTypeRule> getAlternateTypeRules() {
        TypeResolver typeResolver = new TypeResolver();
        List<AlternateTypeRule> result = new ArrayList<>();

        result.add(new AlternateTypeRule(typeResolver.resolve(Character.class), typeResolver.resolve(String.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(Sort.class), typeResolver.resolve(String.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(Pageable.class), typeResolver.resolve(String.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(Page.class, WildcardType.class), typeResolver.resolve(WildcardType.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(ResponseEntity.class), typeResolver.resolve(String.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(LocalTime.class), typeResolver.resolve(String.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(File.class), typeResolver.resolve(String.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(InputStream.class), typeResolver.resolve(String.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(Resource.class), typeResolver.resolve(String.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(URI.class), typeResolver.resolve(String.class)));
        result.add(new AlternateTypeRule(typeResolver.resolve(URL.class), typeResolver.resolve(String.class)));
        return result;
    }

}

