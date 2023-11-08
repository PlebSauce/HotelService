package edu.wgu.d387_sample_code.i18n;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TimeZoneController {
    @GetMapping("/timezone")
    public String[] getTimeZone(){

        return new TimeConversions().convertTime();
        //return ControllerTimeZones;
    }
}
