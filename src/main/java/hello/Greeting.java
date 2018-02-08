package hello;

import Entities.main;
import dblearn.MySqlLearn;

import java.util.List;

public class Greeting {

    private final long id;
    private final String content;
    MySqlLearn localDb = null;



    public Greeting(long id, String content, MySqlLearn theDb) {
        this.id = id;
        this.content = content;
        localDb = theDb;

    }

    public long getId() {

        return id;
    }

    public List<main> getContent() {
    List<main> theData = localDb.readAll();
    return theData;
    }
}
