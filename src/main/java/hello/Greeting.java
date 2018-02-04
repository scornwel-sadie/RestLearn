package hello;

import dblearn.MySqlLearn;

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

    public String getContent() {
    String smity = localDb.readAll();
    return smity;
    }
}
