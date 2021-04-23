package socialmedia;

import java.util.ArrayList;

public class Comment extends Post{
    ArrayList<Comment> comments;
    ArrayList<Endorsement> endorsements;
    Post originalPost;

    Comment(Account commenter, String content ,Post OriginalPost){
        super(commenter, content);
        setOriginalPost(originalPost);
        comments = new ArrayList<Comment>();
        endorsements = new ArrayList<Endorsement>();
    }

    public void setOriginalPost(Post originalPost) {
        this.originalPost = originalPost;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    @Override
    public void addEndorsements(Endorsement endorsement){
        endorsements.add(endorsement);
    }

    @Override
    public void deleteEndorsements(){
        endorsements.removeAll(endorsements);
    }

    @Override
    public String show(int indent){
        String outString = "";
        
        outString += "ID: " + postID + "\n";
        for (int i = 0; i < indent; i++){
            outString += "    ";
        }
        outString += "Account: " + accountHandle + "\n";
        for (int i = 0; i < indent; i++){
            outString += "    ";
        }
        outString += "No. Endorsements: " + endorsements.size() + " | No. Comments: " + comments.size() + "\n";
        for (int i = 0; i < indent; i++){
            outString += "    ";
        }
        outString += content;

        return outString;
    }

    @Override
    public int getNumEndorsements(){
        return endorsements.size();
    }

    @Override
    public String showWithChildren(int indent){
        String returnString = show(indent) + "\n";

        for (Comment c : comments){
            
            for (int i = 0; i< indent; i++){
                returnString += "    ";
            }
            returnString += "|\n";
            for (int i = 0; i< indent; i++){
                returnString += "    ";
            }
            returnString += "|";

            returnString += c.showWithChildren(indent++);
        }

        return returnString;
    }

    @Override
    public ArrayList<Comment> getComments() {
        // TODO Auto-generated method stub
        return comments;
    }

    @Override
    public ArrayList<Endorsement> getEndorsements(){
        return endorsements;
    }
}
