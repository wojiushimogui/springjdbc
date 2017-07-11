package com.wrh.dao;

import com.wrh.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午4:20 on 2017/6/5.
 */
@Repository
public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    /**
     * 查询表中的所有信息，返回值类型：List<Map<String, Object>>
     * */
    public List findALL() {
        String sql = "select * from student";
        return jdbcTemplate.queryForList(sql);
    }
    /**
     * 查询表中的所有信息，返回值类型：List<Student>
     * */
    public List<Student> findALLStudent() {
        List<Student> studentList = new ArrayList<Student>();;
        String sql = "select * from student";
        List list = jdbcTemplate.queryForList(sql);//List<Map<String, Object>>
        Iterator iterator = list.iterator();
        Student student = null;
        while (iterator.hasNext()) {
            Map map4student = (Map) iterator.next();
            student = new Student();
            student.setId(((Integer)map4student.get("ID")).intValue());
            student.setName((String) map4student.get("NAME"));
            student.setAge(((Integer)map4student.get("AGE")).intValue());
            studentList.add(student);
        }
        return studentList;
    }
    /**
     * 根据id来查询学生的名字
     * */
    public String findById(Integer id){
        String name = this.jdbcTemplate.queryForObject(
                "select name from student where id = ?",
                new Object[]{id}, String.class);
        return name;
    }
    /**
     * 插入一条学生信息,bywu
     * */

    public void insertOneStudent(String name,Integer age){
        this.jdbcTemplate.update(
                "insert into student (name, age) values (?, ?)",
                name, age);
    }
    /**
     * 根据指定Id来更新学生的信息
     * 练习git
     * */
    public void updateOneStudentById(Integer id,String name,Integer age){
        this.jdbcTemplate.update(
                "update student set name = ?  , age =? where id = ?",
                name, age,id);

    }

}
