package com.example.clair.welp.Firebase;

import java.util.Date;

public class MagicalNames {
    //store all names that need to use more then once
    //region Note Fiyahbase
    private String Notes_Column_Email="Email";
    private String Notes_Column_Username="Username";
    private String Notes_Column_UserIMG="UserIMG";
    private String Notes_Column_NoteTitle="NoteTitle";
    private String Notes_Column_NoteDescription="NoteDescription";
    private String Notes_Column_ResourceURL="ResourceURL";
    private String Notes_Column_DatePosted="DatePosted";
    private String Notes_Column_Deleted="Deleted";
    private String Notes_Column_Tags="Tags";
    private String Notes_Column_Upvote="Upvotes";
    private String Notes_Column_Downvote="Downvotes";
    private String Notes_Column_CommentUsername="CommentUsername";
    private String Notes_Column_Comment="Comments";
    private String Notes_Column_Notebooks="Notebooks";

    public String getNotes_Column_Email() {
        return Notes_Column_Email;
    }

    public String getNotes_Column_Username() {
        return Notes_Column_Username;
    }

    public String getNotes_Column_UserIMG() {
        return Notes_Column_UserIMG;
    }

    public String getNotes_Column_NoteTitle() {
        return Notes_Column_NoteTitle;
    }

    public String getNotes_Column_NoteDescription() {
        return Notes_Column_NoteDescription;
    }

    public String getNotes_Column_ResourceURL() {
        return Notes_Column_ResourceURL;
    }

    public String getNotes_Column_DatePosted() {
        return Notes_Column_DatePosted;
    }

    public String getNotes_Column_Deleted() {
        return Notes_Column_Deleted;
    }

    public String getNotes_Column_Tags() {
        return Notes_Column_Tags;
    }

    public String getNotes_Column_Upvote() {
        return Notes_Column_Upvote;
    }

    public String getNotes_Column_Downvote() {
        return Notes_Column_Downvote;
    }

    public String getNotes_Column_CommentUsername() {
        return Notes_Column_CommentUsername;
    }

    public String getNotes_Column_Comment() {
        return Notes_Column_Comment;
    }
    public String getNotes_Column_Notebooks() {
        return Notes_Column_Notebooks;
    }

    //endregion


    //region User
    private String Users_Column_Email="Email";
    private String Users_Column_Subjects="Subjects";
    private String Users_Column_Username="Username";
    private String Users_Column_YearOfStudy="YearOfStudy";
    private String Users_Column_ProfileDescription="ProfileDescription";
    private String Users_Column_FollowingUsers="FollowingUsers";

    public String getUsers_Column_Email() {
        return Users_Column_Email;
    }

    public String getUsers_Column_Subjects() {
        return Users_Column_Subjects;
    }

    public String getUsers_Column_Username() {
        return Users_Column_Username;
    }

    public String getUsers_Column_ProfileDescription() {
        return Users_Column_ProfileDescription;
    }

    public String getUsers_Column_YearOfStudy() {
        return Users_Column_YearOfStudy;
    }

    public String getUsers_Column_FollowingUsers() {
        return Users_Column_FollowingUsers;
    }
    //endregion

    //region Comment
    private String Comments_Column_Email="Email";
    private String Comments_Column_Username="Username";
    private String Comments_Column_Comment="Comment";
    private String Comments_Column_DatePosted="DatePosted";
    private String Comments_Column_NoteID="NoteID";

    public String getComments_Column_Email() {
        return Comments_Column_Email;
    }

    public String getComments_Column_Username() {
        return Comments_Column_Username;
    }

    public String getComments_Column_Comment() {
        return Comments_Column_Comment;
    }

    public String getComments_Column_DatePosted() {
        return Comments_Column_DatePosted;
    }

    public String getComments_Column_NoteID() {
        return Comments_Column_NoteID;
    }


    //endregion


}
