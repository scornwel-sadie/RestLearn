package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import Entities.PrimaryKey;
import Entities.main;
import dblearn.MySqlLearn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    MySqlLearn theDb = new MySqlLearn();




    @RequestMapping(path = "/list", method = RequestMethod.GET)

    public ResponseEntity<List<main>> getList(@RequestParam(value="name", defaultValue="World") String name) {

        List<main> theList = null;
        Greeting theWorker = new Greeting(counter.incrementAndGet(),
                String.format(template, name),theDb);

        theList = theWorker.getContent();
        return new ResponseEntity<List<main>>(theList, HttpStatus.OK);




    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<List<PrimaryKey>>  addList(@RequestBody List<main> theList){

        List<PrimaryKey> theKeys = new  ArrayList<PrimaryKey>();
        PrimaryKey key = new PrimaryKey();
        key.setKey(45);
        key.setName("carol");
        theKeys.add(key);


        return new ResponseEntity<List<PrimaryKey>>(theKeys, HttpStatus.OK);

    }
}