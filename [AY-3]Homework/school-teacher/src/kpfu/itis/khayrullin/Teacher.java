package kpfu.itis.khayrullin;

import static kpfu.itis.khayrullin.Headteacher.getHeadTeachersName;

public class Teacher {
    static String name = "Arslanov Marat";

    public static String getTeachersName() {
        return name;
    }

    public static String getTeachersAndHeadTeachersName() {
        return getHeadTeachersName() + " and "  +name;
    }
}
