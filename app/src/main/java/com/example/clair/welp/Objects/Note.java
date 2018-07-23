package com.example.clair.welp.Objects;


import java.util.List;
import java.util.Map;

public class Note {
    private String Email,Username,UserIMG,NoteTitle,NoteDescription,ResourceURL,DatePosted,Deleted  ;
    private List<String> Tags;
    private int Upvote,Downvote;
    private String[][] Comments;
    private Map<String, Boolean> Notebooks;

    public Note(){}

    public Note(String email, String username, String userIMG, String noteTitle, String noteDescription, String resourceURL,String  datePosted, String deleted, List<String> tags, int upvote, int downvote, String[][] comments) {
        Email = email;
        Username = username;
        UserIMG = userIMG;
        NoteTitle = noteTitle;
        NoteDescription = noteDescription;
        ResourceURL = resourceURL;
        DatePosted = datePosted;
        Deleted = deleted;
        Tags = tags;
        Upvote = upvote;
        Downvote = downvote;
        Comments = comments;
       // Notebooks = notebooks;
    }

//region properties

    public String getUserIMG() {
        return UserIMG;
    }

    public void setUserIMG(String userIMG) {
        UserIMG = userIMG;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getNoteTitle() {
        return NoteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        NoteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return NoteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        NoteDescription = noteDescription;
    }

    public String getResourceURL() {
        return ResourceURL;
    }

    public void setResourceURL(String resourceURL) {
        ResourceURL = resourceURL;
    }

    public String getDatePosted() {
        return DatePosted;
    }

    public void setDatePosted(String datePosted) {
        DatePosted = datePosted;
    }

    public String getDeleted() {
        return Deleted;
    }

    public void setDeleted(String deleted) {
        Deleted = deleted;
    }

    public List<String> getTags() {
        return Tags;
    }

    public void setTags(List<String> tags) {
        Tags = tags;
    }

    public String[][] getComments() {
        return Comments;
    }

    public void setComments(String[][] comments) {
        Comments = comments;
    }

    public int getUpvote() {
        return Upvote;
    }

    public void setUpvote(int upvote) {
        Upvote = upvote;
    }

    public int getDownvote() {
        return Downvote;
    }

    public void setDownvote(int downvote) {
        Downvote = downvote;
    }

    public Map<String, Boolean> getNotebooks() {
        return Notebooks;
    }

    public void setNotebooks(Map<String, Boolean> notebooks) {
        Notebooks = notebooks;
    }

    //endregion


}
