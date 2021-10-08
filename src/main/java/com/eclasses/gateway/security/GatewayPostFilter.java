package com.eclasses.gateway.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class GatewayPostFilter implements GlobalFilter, Ordered {

	private final Logger logger = LoggerFactory.getLogger(GatewayPostFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		return chain.filter(exchange).then(Mono.fromRunnable(() -> {

			logger.info("GatewayPostFilter Execurted.....");
		}));
	}

	@Override
	public int getOrder() {
		return 1;
	}

}