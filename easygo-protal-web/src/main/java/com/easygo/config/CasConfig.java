package com.easygo.config;

/**
 * @Author Lym
 * @Date 2020/4/23 10:48
 * @Description 作用：手动读取CAS和shiro整合的配置信息
 */
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 这个类是shiro整合cas的时候需要的一些配置
 * 申明的一些变量
 */
@SpringBootConfiguration
@ConfigurationProperties(prefix = "cas")
public class CasConfig {

    //给配置文件中的属性，赋予默认值
    private String casServerUrlPrefix = "https://server.fable.com:8443/cas";
    private String casServerLoginUrl = casServerUrlPrefix + "/login";
    private String casServerLogoutUrl = casServerUrlPrefix + "/logout";
    private String localServerUrlPrefix = "http://client1.fable.com:8081/aaaa";
    private String casFilterUrlPattern = "/shiro-cas";
    private String localServerLoginUrl = casServerLoginUrl + "?service=" + localServerUrlPrefix + casFilterUrlPattern;

    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }

    public void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    public String getCasServerLogoutUrl() {
        return casServerLogoutUrl;
    }

    public void setCasServerLogoutUrl(String casServerLogoutUrl) {
        this.casServerLogoutUrl = casServerLogoutUrl;
    }

    public String getLocalServerUrlPrefix() {
        return localServerUrlPrefix;
    }

    public void setLocalServerUrlPrefix(String localServerUrlPrefix) {
        this.localServerUrlPrefix = localServerUrlPrefix;
    }

    public String getCasFilterUrlPattern() {
        return casFilterUrlPattern;
    }

    public void setCasFilterUrlPattern(String casFilterUrlPattern) {
        this.casFilterUrlPattern = casFilterUrlPattern;
    }

    public String getLocalServerLoginUrl() {
        return localServerLoginUrl;
    }

    public void setLocalServerLoginUrl(String localServerLoginUrl) {
        this.localServerLoginUrl = localServerLoginUrl;
    }

    public String getCasService() {
        return localServerUrlPrefix + casFilterUrlPattern;
    }

}
