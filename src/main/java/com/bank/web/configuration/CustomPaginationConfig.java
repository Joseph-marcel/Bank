package com.bank.web.configuration;

import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomPaginationConfig implements PageableHandlerMethodArgumentResolverCustomizer{

	@Override
	public void customize(PageableHandlerMethodArgumentResolver pageableResolver) {
		// TODO Auto-generated method stub
		pageableResolver.setOneIndexedParameters(true);
	}

}
