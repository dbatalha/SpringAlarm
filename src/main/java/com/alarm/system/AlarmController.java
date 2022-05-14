package com.alarm.system;

import java.util.concurrent.atomic.AtomicLong;

import com.alarm.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@RestController
public class AlarmController {

    private static final String ALARM_TEMPLATE = "Loud bang, %s!";
    private static final String LIST_TEMPLATE = "List of available alarms.";
    private static final String TRACK_LIST = "[ List of tracks. ]";
    private final AtomicLong counter = new AtomicLong();

    /**
     * URL Mapping for raise new alarm
     * @param trackName unique name for the alarm
     * @return json response
     */
    @PostMapping("/alarm/{trackName}")
    public RaiseAlarm raiseAlarm(@PathVariable String trackName) {
        return new RaiseAlarm(counter.incrementAndGet(), trackName, String.format(ALARM_TEMPLATE, trackName));
    }

    /**
     * URL Mapping for get a alarm status by trackname
     * @param trackName trackname to fetch alarm status
     * @return json response
     */
    @GetMapping("/alarm/{trackName}")
    public GetAlarm getAlarmByTrackName(@PathVariable String trackName) {
        return new GetAlarm(counter.incrementAndGet(), trackName, String.format(ALARM_TEMPLATE, trackName));
    }

    /**
     * URL Mapping for get all the alarms
     * @param trackName optional value
     * @return json response that contains all the alarm in the system
     */
    @GetMapping("/alarms")
    public ListAlarms listAlarms(@RequestParam(defaultValue = TRACK_LIST) String trackName) {
        return new ListAlarms(counter.incrementAndGet(), LIST_TEMPLATE);
    }

    /**
     * URL Mapping for clear a specific alarm
     * @param trackName trackname to where the clear is done.
     * @return json response
     */
    @PutMapping("/alarm/{trackName}/clear")
    public ClearAlarm clearAlarm(@PathVariable String trackName) {
        return new ClearAlarm(counter.incrementAndGet(), trackName, String.format(ALARM_TEMPLATE, trackName));
    }

    /**
     * URL Mapping for delete the track
     * @param trackName track name to delete
     * @return json response
     */
    @DeleteMapping("/alarm/{trackName}")
    public DeleteAlarm deleteAlarm(@PathVariable String trackName) {
        return new DeleteAlarm(counter.incrementAndGet(), trackName, String.format(ALARM_TEMPLATE, trackName));
    }

}