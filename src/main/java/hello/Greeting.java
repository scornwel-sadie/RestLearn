package hello;

import dblearn.MySqlLearn;

public class Greeting {

    private final long id;
    private final String content;



    public Greeting(long id, String content, MySqlLearn theDb) {
        this.id = id;
        this.content = content;

    }

    public long getId() {

        return id;
    }

    public String getContent() {
        return content;
    }
}
