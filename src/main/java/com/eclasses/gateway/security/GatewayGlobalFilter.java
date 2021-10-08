package com.eclasses.gateway.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;

@Configuration
public class GatewayGlobalFilter {

	private final Logger logger = LoggerFactory.getLogger(GatewayGlobalFilter.class);

	@Order(1)
	@Bean
	public GlobalFilter secondPreFiltor() {

		return (exchange, chain) -> {

			logger.info("Gateway Global Second Pre Filter Executed .....");

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {

				logger.info("Gateway Global Second Post Filter Executed .....");

			}));

		};

	}
	
	@Order(2)
	@Bean
	public GlobalFilter thirdPreFiltor() {

		return (exchange, chain) -> {

			logger.info("Gateway Global Third Pre Filter Executed .....");

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {

				logger.info("Gateway Global third Post Filter Executed .....");

			}));

		};

	}
	
	@Order(3)
	@Bean
	public GlobalFilter fourthPreFiltor() {

		return (exchange, chain) -> {

			logger.info("Gateway Global Fourth Pre Filter Executed .....");

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {

				logger.info("Gateway Global Fourth Post Filter Executed .....");

			}));

		};

	}

}
