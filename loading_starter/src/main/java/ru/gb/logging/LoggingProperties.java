package ru.gb.logging;

import lombok.Data;
import org.slf4j.event.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("application.logging")
public class LoggingProperties {

    private Level level = Level.WARN;

    private boolean enabled = true;

    private boolean printArgs = false;
}
