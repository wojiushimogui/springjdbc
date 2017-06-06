package com.wrh;

import com.wrh.bean.Student;
import com.wrh.dao.StudentDao;
import com.wrh.util.SpringUtil;

import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class StudentMain
{
    public static void main( String[] args )
    {
        StudentDao dao = (StudentDao) SpringUtil.getBean("studentDao");

        List<Student> studentList = dao.findALLStudent();
        for(Student student:studentList){
            System.out.println(student.getId()+","+student.getName()+","+student.getAge());
        }
        System.out.println("---------------------------------");

        List list = dao.findALL();
        for(Iterator it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        System.out.println("--------------根据ID来查询一个学生的信息-------------------");
        Integer id = 13;
        String name = dao.findById(id);
        System.out.println("id=13所对应的学生名字为："+name);

        System.out.println("-----------插入一个学生信息----------------------");

        dao.insertOneStudent("spring jdbc",18);
        System.out.println("-----------根据ID来更新一个学生信息----------------------");

        dao.updateOneStudentById(13,"updateName",10);

    }
}
