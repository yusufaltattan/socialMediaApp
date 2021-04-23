package socialmedia;

import java.util.ArrayList;
import java.io.Serializable;

public class Post implements Serializable{
    protected int postID;
    protected int posterID;
    protected String accountHandle;
    protected String content;
    static int nextID;

    /**
     * 
     * @return the next available ID number
     */
    static int getNextID(){
        return nextID ++;
    }

    /**
     * constructor
     */
    Post(Account poster, String content){
        setID();
        if (poster != null) setPosterID(poster.getID());
        if (poster != null) setAccountHandle(poster.getHandle());
        setContent(content);
    }

    public void addComment(Comment comment){

    }
    public void addEndorsements(Endorsement endorsement){

    }
    public void deleteEndorsements(){

    }
    public ArrayList<Endorsement> getEndorsements(){
        return null;
    }

    public int getNumEndorsements(){
        return -1;
    }

    public String show(int indent){
        return "";
    }

    public String showWithChildren(int indent){
        return show(indent);
    }

    public ArrayList<Comment> getComments(){
        return null;
    }

    //getters and setters

    protected void setID(){
        this.postID = getNextID();
    }
    public int getID(){
        return postID;
    }

    protected void setPosterID(int id){
        this.posterID = id;
    }
    public int getPosterID() {
        return posterID;
    }

    protected void setAccountHandle(String handle){
        this.accountHandle = handle;
    }    
    public String getAccountHandle() {
        return accountHandle;
    }

    protected void setContent(String content){
        this.content = content;
    }   
    public String getContent() {
        return content;
    }


}
