package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import Entities.main;
import dblearn.MySqlLearn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    MySqlLearn theDb = new MySqlLearn();





    @RequestMapping("/greeting")
    public List<main> greeting(@RequestParam(value="name", defaultValue="World") String name) {

        List<main> theList = null;
        Greeting theWorker = new Greeting(counter.incrementAndGet(),
                String.format(template, name),theDb);

        theList = theWorker.getContent();
        return theList;




    }
}