package ru.gb.timer;

import lombok.Data;
import org.slf4j.event.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("application.timer")
public class TimerProperties {

    private Level level = Level.WARN;

    private boolean enabled = true;
}
