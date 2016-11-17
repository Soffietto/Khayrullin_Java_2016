package kpfu.itis.khayrullin;

import static kpfu.itis.khayrullin.HeadTeacher.getHeadTeacherName;
import static kpfu.itis.khayrullin.Teacher.getTeacherAndHeadTeacherName;
import static kpfu.itis.khayrullin.Teacher.getTeachersName;

public class Student {
    public static void main(String[] args) {
        System.out.println(getHeadTeacherName());
        System.out.println(getTeachersName());
        System.out.println(getTeacherAndHeadTeacherName());
    }


}
