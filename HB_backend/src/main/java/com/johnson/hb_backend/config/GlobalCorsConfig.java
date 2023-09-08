package com.johnson.hb_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		//允许所有域的请求
		corsConfiguration.addAllowedOrigin("https://localhost");
		corsConfiguration.addAllowedOrigin("https://127.0.0.1");
		corsConfiguration.addAllowedOrigin("https://123.249.12.92");
		corsConfiguration.addAllowedOrigin("https://www.hubeinxunited.com");
		//允许携带认证消息(cookies)
		corsConfiguration.setAllowCredentials(true);
		//允许所有请求方法
		corsConfiguration.addAllowedMethod("*");
		//允许所有请求头
		corsConfiguration.addAllowedHeader("*");
		//允许暴露所有头部信息
		corsConfiguration.addExposedHeader("*");

		//添加映射路线
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
