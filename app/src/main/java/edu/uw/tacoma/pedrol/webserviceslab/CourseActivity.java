package edu.uw.tacoma.pedrol.webserviceslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.uw.tacoma.pedrol.webserviceslab.course.Course;

public class CourseActivity extends AppCompatActivity implements CourseFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }

    @Override
    public void onListFragmentInteraction(Course course) {

    }
}
