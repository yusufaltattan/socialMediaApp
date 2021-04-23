package socialmedia;

import java.util.ArrayList;

public class EmptyPost extends Post{

    ArrayList<Comment> comments;

    EmptyPost(Post oldPost){
        super(null ,"The original content was removed from the system and is no longer available.");
        comments = oldPost.getComments();
        setID(oldPost.getID());
    }

    protected void setID(int id) {
        postID = id;
    }

    @Override
    public String show(int indent){
        return content;
    }

    @Override
    public String showWithChildren(int indent){
        String returnString = show(indent) + "\n";

        for (Comment c : comments){

            for (int i = 0; i< indent; i++){
                returnString += " ";
            }
            returnString += "|\n";
            for (int i = 0; i< indent; i++){
                returnString += " ";
            }
            returnString += "|";

            returnString += c.showWithChildren(++indent);
        }

        return returnString;
    }
}
