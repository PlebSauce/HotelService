package edu.wgu.d387_sample_code.i18n;

import org.springframework.web.bind.annotation.*;
import edu.wgu.d387_sample_code.i18n.DisplayMessage;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WelcomeController {
    //private final PropertyFileService propertyFileService;

    //public WelcomeController(PropertyFileService propertyFileService) {
    //    this.propertyFileService = propertyFileService;
    //}
    String[] controllerArray = new String[2];
    @GetMapping("/welcome")
    public String[] getPropertiesAsString() {
        ExecutorService messageExecutor=newFixedThreadPool(10);
        //may need to add functionality for controllerArray to be indexed by "i"
        messageExecutor.execute(() -> {
            String[] newArrayDisplay = new DisplayMessage().getWelcomeMessage();
            System.out.println(newArrayDisplay[0]);
            controllerArray[0] = newArrayDisplay[0];
        });
        messageExecutor.execute(() -> {
            String[] newArrayDisplay = new DisplayMessage().getWelcomeMessage();
            System.out.println(newArrayDisplay[1]);
            controllerArray[1] = newArrayDisplay[1];
        });
        return controllerArray;
    }
}
