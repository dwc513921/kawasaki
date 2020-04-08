package com.csdj.dwc.mapper;

import com.csdj.dwc.pojo.CityArea;
import com.csdj.dwc.pojo.DriverSchool;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DriverSchoolMapper {

    @Select("SELECT * FROM cityarea")
    public List<CityArea> cityArea();

    @Select("SELECT d.id,d.`name`,c.namearea,d.address,d.phone FROM cityarea as c,driverschools as d where c.id=d.cityAreaId LIMIT #{page},#{limit}")
    @Results({
            @Result(column="namearea",property="namearea")
    })
    public List<DriverSchool> getAllInfo(@Param("page") Integer page, @Param("limit") Integer limit);

    @Select("<script>SELECT d.id,d.`name`,c.namearea,d.address,d.phone FROM cityarea as c,driverschools as d <where> c.id=d.cityAreaId <if test=\"id!='请选择'\">and c.namearea=#{id}</if></where> LIMIT #{page},#{limit}</script>")
    @Results({
            @Result(column="namearea",property="namearea")
    })
    public List<DriverSchool> getInfoById(@Param("page") Integer page, @Param("limit") Integer limit,@Param("id") String id);

    @Select("SELECT COUNT(1) FROM cityarea as c,driverschools as d WHERE c.id=d.cityAreaId")
    public int count();

    @Select("SELECT * FROM driverschools WHERE id=#{id}")
    public DriverSchool getDriverInfoById(@Param("id") int id);

    @Update("UPDATE driverschools SET name=#{name},cityAreaId=#{cityAreaId},address=#{address},phone=#{phone} WHERE id=#{id}")
    public int updDriver(DriverSchool driverSchool);

    @Insert("INSERT INTO driverschools VALUES('王龙驾校',2,'杜鹃路772号长沙大计','12312312312')")
    public int add(DriverSchool driverSchool);

    @Delete("DELETE * FROM driverschools WHERE id=1")
    public int del(int id);
}
