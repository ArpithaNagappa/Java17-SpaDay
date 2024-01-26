package org.launchcode.data;

import org.launchcode.models.User;

import java.util.ArrayList;

public class UserData {
    private ArrayList<User> users = new ArrayList<User>();

    public void add(User user){
        users.add(user);
        return;
    }
    public ArrayList<User> getAll(){
        return this.users;
    }
    public User getById(int id){
        return users.get(id);

    }
}
