package socialmedia;

import java.util.ArrayList;
import java.io.Serializable;

public class Account implements Serializable{
    int accountID;
    String handle;
    String description;
    int postCount;
    int endorseCount;
    ArrayList<Post> posts;
    static int nextID = 0;

    /**
     * issue the next available ID
     */
    static int issueNextID(){
        return nextID++;
    }


    /**
     * Constructor
     */
    public Account(String handle, String description){
        setID(issueNextID());
        setHandle(handle);
        setDescription(description);
        posts = new ArrayList<Post>();
    }
    public Account(String handle){
        this(handle, "");
    }

    public void updateHandle(String handle){
        setHandle(handle);
    }

    public void updateDescription(String description){
        setDescription(description);
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public ArrayList<Post> getPosts(){
        return posts;
    }

    public void increaseEndorsements(){
        endorseCount++;
    }

    public String showAccount(){
        return "" +
        "ID: " + accountID + "\n" +
        "Handle: "+ handle + "\n" + 
        "Description: " + description + "\n" +
        "Post count: " + postCount + "\n" +
        "Endorse count: " + endorseCount + "\n";
    }

    //getters and setters

    public int getID(){
        return accountID;
    }
    private void setID(int id){
        this.accountID = id;
    }

    public String getHandle(){
        return handle;
    }
    private void setHandle(String handle){
        this.handle = handle;
    }

    public String getDescription(){
        return description;
    }
    private void setDescription(String description){
        this.description = description;
    }

    public int getEndorseCount() {
        int numEndorsements = 0;
        for (Post p : posts){
            if(p instanceof Original || p instanceof Comment){
                numEndorsements += p.getNumEndorsements();
            }
        }
        return endorseCount;
    }

    public int getPostCount(){
        return posts.size();
    }

    public void removePost(Post p){
        posts.remove(p);
    }
}
