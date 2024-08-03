package ru.gb.recover;

import lombok.Data;
import org.slf4j.event.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("application.recover")
public class RecoverProperties {

    private Level level = Level.WARN;

    private boolean enabled = true;

    private boolean logException = false;
}
