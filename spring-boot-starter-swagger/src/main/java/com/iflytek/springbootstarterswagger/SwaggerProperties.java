package com.iflytek.springbootstarterswagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author llchen12
 * @date 2018/5/2
 */
@Data
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    public static final String PREFIX="swagger";

    /**
     * api组的名字，会在swagger-ui的api下拉列表中显示
     */
    private String groupName;
    /**
     * api组的标题，会在swagger-ui的标题处描述
     */
    private String title;
    /**
     * api组的描述，会在swagger-ui的描述中显示
     */
    private String description;
    /**
     * 接口所在包控制器的扫描范围，多个用逗号分割，可以用前缀匹配和正则匹配
     */
    private String basePackage;
    /**
     * 匹配到本组的api接口，匹配uri，可以用正则表达式匹配
     */
    private String pathRegex;
    /**
     * 匹配到的url在swagger中测试请求时加的url前缀
     */
    private String pathMapping;
    /**
     * api的版本号
     */
    private String version;
    /**
     * api服务条款的地址
     */
    private String termsOfServiceUrl;
    /**
     * 授权的协议
     */
    private String license;
    /**
     * 授权的协议的url
     */
    private String licenseUrl;

}
