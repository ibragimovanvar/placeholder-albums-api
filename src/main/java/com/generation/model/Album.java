package com.generation.model;

public class Album implements Comparable<Album>{

    private int userId ;
    private int id;
    private String title ;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;


    }

    @Override
    public int compareTo(Album o) {
        if(o.getId() > this.getId()){
            return 1;
        }

        return -1;
    }
}
