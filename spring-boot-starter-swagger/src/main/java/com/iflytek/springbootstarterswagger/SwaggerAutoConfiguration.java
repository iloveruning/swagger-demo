package com.iflytek.springbootstarterswagger;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author llchen12
 * @date 2018/5/2
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties({SwaggerProperties.class})
public class SwaggerAutoConfiguration {

    private final SwaggerProperties properties;

    public SwaggerAutoConfiguration(SwaggerProperties properties) {
        this.properties = properties;
    }

    @Bean
    //@ConditionalOnMissingBean
    public Docket getSwagger2Docket() {
        final String[] basePackages = this.splitBasePackages(properties.getBasePackage());

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        ApiInfoBuilder builder = new ApiInfoBuilder();

        if (StringUtils.hasLength(this.properties.getTitle())) {
            builder.title(this.properties.getTitle());
        }

        if (StringUtils.hasLength(this.properties.getDescription())) {
            builder.description(this.properties.getDescription());
        }

        if (StringUtils.hasLength(this.properties.getVersion())) {
            builder.version(this.properties.getVersion());
        }

        if (StringUtils.hasLength(this.properties.getLicense())) {
            builder.license(this.properties.getLicense());
        }

        if (StringUtils.hasLength(this.properties.getLicenseUrl())) {
            builder.licenseUrl(this.properties.getLicenseUrl());
        }

        if (StringUtils.hasLength(this.properties.getTermsOfServiceUrl())) {
            builder.termsOfServiceUrl(this.properties.getTermsOfServiceUrl());
        }

        docket.apiInfo(builder.build());

        if (StringUtils.hasLength(this.properties.getGroupName())) {
            docket.groupName(this.properties.getGroupName());
        }


        if (StringUtils.hasLength(this.properties.getPathMapping())) {
            docket.pathMapping(this.properties.getPathMapping());
        }

        return docket.select()
                .apis(h -> {
                    if (basePackages == null) {
                        return true;
                    }

                    String packageName = h.declaringClass().getName();
                    for (String basePackage : basePackages) {
                        if (packageName.startsWith(basePackage) || packageName.matches(basePackage + ".*")) {
                            return true;
                        }
                    }
                    return false;
                }).paths(input -> {
                    String pathRegex = this.properties.getPathRegex();
                    if (StringUtils.isEmpty(pathRegex) || input.matches(pathRegex)) {
                        return true;
                    } else {
                        return false;
                    }
                }).build();

    }

    private String[] splitBasePackages(String basePackage) {
        if (StringUtils.isEmpty(basePackage) || (basePackage = basePackage.trim()).isEmpty()) {
            return null;
        } else {
            return basePackage.split(",");
        }
    }
}
