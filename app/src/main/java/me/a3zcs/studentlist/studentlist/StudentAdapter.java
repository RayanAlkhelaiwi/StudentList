package me.a3zcs.studentlist.studentlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 09/08/17.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context context;
    List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.student_row, parent, false);
        StudentViewHolder viewHolder = new StudentViewHolder(row);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.name.setText(student.getName());
        holder.course.setText(student.getCourse());
        holder.s = student;

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, course;
        Student s;

        public StudentViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.student_name);
            course = itemView.findViewById(R.id.student_course);
            itemView.setOnClickListener(this);
            //TODO MAKE YOUR ITEM CLICKABLE, DELETE CLICKED ITEM, AND UPDATE YOUR LIST

        }

        @Override
        public void onClick(View view) {
            students.remove(s);
            notifyDataSetChanged();
            students.add(s);
            Log.e("onClick", "Student Adapter");
        }
    }
}