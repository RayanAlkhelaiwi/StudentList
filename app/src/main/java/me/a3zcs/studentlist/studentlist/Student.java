package me.a3zcs.studentlist.studentlist;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by root on 09/08/17.
 */

public class Student implements Parcelable {
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
    String name;
    String course;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    protected Student(Parcel in) {
        name = in.readString();
        course = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(course);
    }
}
