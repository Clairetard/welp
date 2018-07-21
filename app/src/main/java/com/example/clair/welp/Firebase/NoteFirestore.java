package com.example.clair.welp.Firebase;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;

import com.example.clair.welp.FragmentCurrentUserPosts;
import com.example.clair.welp.MainActivity;
import com.example.clair.welp.Objects.Note;
import com.example.clair.welp.R;
import com.firebase.client.annotations.NotNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class NoteFirestore {
    public NoteFirestore() {
    }


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Note> notes;
    Map<String, Object> notas = new HashMap<>();
    MagicalNames magicalNames = new MagicalNames();
    CollectionReference collectionref = FirebaseFirestore.getInstance().collection("Notes");
    public NoteFirestore(MainActivity r) {
        final MainActivity reference = r;

        collectionref.orderBy("DatePosted").get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        notes = new ArrayList<>();

                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                String email = document.getString(magicalNames.getNotes_Column_Email());
                                String username = document.getString(magicalNames.getNotes_Column_Username());
                                String userIMG = document.getString(magicalNames.getNotes_Column_UserIMG());
                                String noteTitle = document.getString(magicalNames.getNotes_Column_NoteTitle());
                                String noteDescription = document.getString(magicalNames.getNotes_Column_NoteDescription());
                                String resourceURL = document.getString(magicalNames.getNotes_Column_ResourceURL());
                                Date datePosted = document.getDate(magicalNames.getNotes_Column_DatePosted());
                                Date deleted = document.getDate(magicalNames.getNotes_Column_Deleted());
                                //String[] tags = {document.getString(magicalNames.getNotes_Column_Tags())};
                                //String[][] comments = {{document.getString(magicalNames.getNotes_Column_CommentUsername())}, {document.getString(magicalNames.getNotes_Column_Comment())}};
                                int upvote = Integer.parseInt(document.getLong(magicalNames.getNotes_Column_Upvote()).toString());
                                int downvote = Integer.parseInt(document.getLong(magicalNames.getNotes_Column_Downvote()).toString());

                            Note n=new Note(email,username,userIMG,noteTitle,noteDescription,resourceURL,datePosted,deleted,null,null,upvote,downvote);
                            notes.add(n);
                            }
                            reference.UpdateList(notes);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

    }

    public NoteFirestore(FragmentCurrentUserPosts r, String email, TextView error) {
        final FragmentCurrentUserPosts reference = r;
        final TextView tvError = error;
        CollectionReference collectionrefcurrentuser = FirebaseFirestore.getInstance().collection("Notes");

        collectionrefcurrentuser.whereEqualTo("Email", email).get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        notes = new ArrayList<>();

                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                String email = document.getString(magicalNames.getNotes_Column_Email());
                                String username = document.getString(magicalNames.getNotes_Column_Username());
                                String userIMG = document.getString(magicalNames.getNotes_Column_UserIMG());
                                String noteTitle = document.getString(magicalNames.getNotes_Column_NoteTitle());
                                String noteDescription = document.getString(magicalNames.getNotes_Column_NoteDescription());
                                String resourceURL = document.getString(magicalNames.getNotes_Column_ResourceURL());
                                Date datePosted = document.getDate(magicalNames.getNotes_Column_DatePosted());
                                Date deleted = document.getDate(magicalNames.getNotes_Column_Deleted());
                                //String[] tags = {document.getString(magicalNames.getNotes_Column_Tags())};
                                //String[][] comments = {{document.getString(magicalNames.getNotes_Column_CommentUsername())}, {document.getString(magicalNames.getNotes_Column_Comment())}};
                                int upvote = Integer.parseInt(document.getLong(magicalNames.getNotes_Column_Upvote()).toString());
                                int downvote = Integer.parseInt(document.getLong(magicalNames.getNotes_Column_Downvote()).toString());

                                Note n=new Note(email,username,userIMG,noteTitle,noteDescription,resourceURL,datePosted,deleted,null,null,upvote,downvote);
                                notes.add(n);
                            }
                            reference.UpdateList(notes);
                            if(notes.size() == 0){

                                tvError.setText("You have not posted anything yet.");
                            }

                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

    }

    public void add(Note n) {
        notas.put(magicalNames.getNotes_Column_Email(),n.getEmail());
        notas.put(magicalNames.getNotes_Column_Username(),n.getUsername());
        notas.put(magicalNames.getNotes_Column_UserIMG(),n.getUserIMG());
        notas.put(magicalNames.getNotes_Column_NoteTitle(),n.getNoteTitle());
        notas.put(magicalNames.getNotes_Column_NoteDescription(),n.getNoteDescription());
        notas.put(magicalNames.getNotes_Column_ResourceURL(),n.getResourceURL());
        notas.put(magicalNames.getNotes_Column_DatePosted(),n.getDatePosted());
        notas.put(magicalNames.getNotes_Column_Deleted(),n.getDeleted());
        notas.put(magicalNames.getNotes_Column_Tags(),n.getTags());
        notas.put(magicalNames.getNotes_Column_Comment(),n.getComments());
        notas.put(magicalNames.getNotes_Column_Upvote(),n.getUpvote());
        notas.put(magicalNames.getNotes_Column_Downvote(),n.getDownvote());


        collectionref.document().set(notas).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot added with ID: " + collectionref.document().getId());
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NotNull Exception e) {
                        Log.w(TAG, "Eroor adding document", e);
                    }
                });


    }
}
