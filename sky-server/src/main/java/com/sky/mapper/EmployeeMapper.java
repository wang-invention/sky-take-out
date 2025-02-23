package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     *
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /*
     * 插入员工数据
     *
     * */
    @AutoFill(value = OperationType.INSERT)
    @Insert("insert into employee(name,username,password,phone,sex,id_number,create_time,update_time,create_user,update_user)" +
            "values" + "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Employee employee);

    /*
    *
    * 分页查询
    *
    * */

    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用和禁用员工状态
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Employee build);


    /**
     * 根据id查询员工数据
     * @param id
     * @return
     */
    @Select("select * from employee where id =#{id}")
    Employee getByid(Long id);
}
