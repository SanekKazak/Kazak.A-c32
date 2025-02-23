package org.alex.brain.by.third.task.serrvice;

import org.alex.brain.by.third.task.main.object.Student;

public class ServiceStudent {
    private Student[] studentsGroup;

    public ServiceStudent() {
        studentsGroup = new Student[0];
    }

    public void StudentAdder(Student student) {
        Student[] studentsCopyGroup = new Student[this.studentsGroup.length + 1];
        for (int i = 0; i < this.studentsGroup.length; i++) {
            studentsCopyGroup[i] = this.studentsGroup[i];
        }
        studentsCopyGroup[this.studentsGroup.length] = student;
        this.studentsGroup = new Student[studentsCopyGroup.length];
        for (int i = 0; i < this.studentsGroup.length; i++) {
            this.studentsGroup[i] = studentsCopyGroup[i];
        }
    }

    public int countGroup(String groupName) {
        int count = 0;
        for (Student student : this.studentsGroup) {
            if (student.getGroup().equals(groupName)) {
                count++;
            }
        }
        return count;
    }
}
