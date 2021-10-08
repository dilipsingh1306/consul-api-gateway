package com.eclasses.gateway.security;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class GatewayPreFilter implements GlobalFilter, Ordered {

	private final Logger logger = LoggerFactory.getLogger(GatewayPreFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		logger.info("GatewayPreFilter Execurted.....");
		String requestedPath = exchange.getRequest().getPath().toString();
		logger.info("Request Path : " + requestedPath);

		HttpHeaders headers = exchange.getRequest().getHeaders();

		Set<String> headersName = headers.keySet();
		headersName.forEach((headerName) -> {

			String headerValue = headers.getFirst(headerName);
			logger.info("Header Value " + headerValue);

		});

		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
