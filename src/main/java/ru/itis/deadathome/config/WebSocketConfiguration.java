package ru.itis.deadathome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.itis.deadathome.handlers.AuthHandshakeHandler;
import ru.itis.deadathome.handlers.WebSocketMessagesHandler;

import java.util.concurrent.Executors;

@Configuration
public class WebSocketConfiguration implements WebSocketConfigurer {


        @Autowired
        private WebSocketMessagesHandler handler;

        @Autowired
        private AuthHandshakeHandler handshakeHandler;

        @Override
        public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

            webSocketHandlerRegistry.addHandler(handler, "/chat").setHandshakeHandler(handshakeHandler);
        }

        @Bean
        public TaskScheduler taskScheduler() {
            return new ConcurrentTaskScheduler(Executors.newSingleThreadScheduledExecutor());
        }
}
