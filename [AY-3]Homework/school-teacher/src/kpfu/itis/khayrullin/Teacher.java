package kpfu.itis.khayrullin;

import static kpfu.itis.khayrullin.HeadTeacher.getHeadTeacherName;

public class Teacher {
    static final String NAME = "Arslanov Marat";

    public static String getTeachersName() {
        return NAME;
    }

    public static String getTeacherAndHeadTeacherName() {
        return getHeadTeacherName() + " and "  + NAME;
    }
}
