package com.example.clair.welp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clair.welp.Firebase.NoteFirestore;
import com.example.clair.welp.Objects.Note;
import com.example.clair.welp.Objects.Notebook;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NotebookActivity extends AppCompatActivity {
    @BindView(R.id.rvNote)
    RecyclerView noteList;
    RecyclerView.LayoutManager mLayoutManager;
    NoteAdapter mAdapter;
    private FirebaseFirestore db;
    private FirestoreRecyclerAdapter adapter;
    String passedName, passedEmail, passedFrom, passedUsername;
    ArrayList<String> passedList;
    NoteFirestore f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);
        ButterKnife.bind(this);

        //getExtras
        passedName = getIntent().getExtras().getString("NotebookName");
        passedEmail = getIntent().getExtras().getString("Email");
        passedFrom = getIntent().getExtras().getString("From");
        passedUsername = getIntent().getExtras().getString("Username");

        //Title and backbutton
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(passedName);


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        noteList.setLayoutManager(mLayoutManager);
        noteList.setItemAnimator(new DefaultItemAnimator());

        mAdapter=new NoteAdapter(this);
        noteList.setAdapter(mAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        NotebookActivity r=this;
        passedList = getIntent().getExtras().getStringArrayList("NotebookNotes");
        f=new NoteFirestore(r, passedList);
    }

    public void UpdateList(List<Note> n){
        mAdapter.deleteEverything();
        mAdapter.addAllItems(n);
    }

    //UP BUTTON (BACK)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //GOTO : Profile Activity with Notebook Tab Selected
        if(id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }

    //BACK BUTTON (BOTTOM)
    @Override
    public void onBackPressed() {
        this.finish();
    }
}
