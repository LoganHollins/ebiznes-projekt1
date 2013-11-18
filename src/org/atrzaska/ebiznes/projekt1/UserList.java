package org.atrzaska.ebiznes.projekt1;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.atrzaska.ebiznes.util.FileUtils;

public class UserList {

    protected List<User> userList;
    protected Map<Integer, User> userMap;

    public UserList(String path) {
       loadUsers(path);
    }

    public void loadUsers(String path) {
        String fileString = FileUtils.readFileAsString(path);

        // compile pattern for matching lines
        Pattern pattern = Pattern.compile("(\\d+)[ ]*,(\\d+),[ ]*(\\d+)");
        Matcher matcher = pattern.matcher(fileString);

        // find matches
        while (matcher.find()) {
            // parse line
            int id = Integer.parseInt(matcher.group(1));
            String name = matcher.group(2);

            // set value
            User user = new User(id);
        }
    }

    public User getUser(int id) {
        return userMap.get(id);
    }
}
