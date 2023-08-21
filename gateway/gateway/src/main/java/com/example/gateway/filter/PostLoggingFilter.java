package com.example.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Slf4j
@Component
public class PostLoggingFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain
    ) {
        // 사용자에게 응답이 돌아가고 난 뒤에 실행하는 필터
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    ServerHttpRequest httpRequest = exchange.getRequest();
                    String requestId = httpRequest.getHeaders()
                            .getFirst("x-gateway-request-id");
                    String requestTimeString = httpRequest.getHeaders()
                            .getFirst("x-gateway-request-time");
                    // 현재 시각
                    long timeEnd = Instant.now().toEpochMilli();
                    // PreLoggingFilter에서 기록한 시각
                    Long timeStart = Long.parseLong(requestTimeString);
                    // 기록한다.
                    log.info("Execution Time id: {}, timediff(ms): {}",
                            requestId, timeEnd - timeStart);
                }));
    }
}
