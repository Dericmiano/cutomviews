package com.example.mycoursewithfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mycoursewithfragments.data.Course;

public class MainActivity extends AppCompatActivity implements CourseListFragment.callBacks {
    private boolean isTwoPage =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.detailContainer) != null){
            isTwoPage = true;

        }


//        FragmentManager fm= getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(R.id.myContainer);
//        if (fragment == null){
//            fragment = new CourseListFragment();
//            fm.beginTransaction()
//                    .add(R.id.myContainer,fragment)
//                    .commit();
//        }
    }

    @Override
    public void onItemSelected(Course course,int position) {
        if (isTwoPage) {
            Bundle bundle = new Bundle();
            bundle.putInt("course_id", position);
            FragmentManager fm = getSupportFragmentManager();
            CourseDetailFragment courseDetailFragment = new CourseDetailFragment();
            courseDetailFragment.setArguments(bundle);

            fm.beginTransaction()
                    .replace(R.id.myContainer, courseDetailFragment)
                    .commit();


        } else {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, CourseDetailActivity.class);
            intent.putExtra("course_id", position);
            startActivity(intent);
        }
    }
}