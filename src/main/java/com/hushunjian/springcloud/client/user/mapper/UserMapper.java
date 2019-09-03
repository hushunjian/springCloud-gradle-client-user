package com.hushunjian.springcloud.client.user.mapper;

import com.hushunjian.springcloud.client.user.domain.User;
import com.hushunjian.springcloud.client.user.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    @Delete({
        "delete from hsj_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    @Insert({
        "insert into hsj_user (id, user_name, ",
        "login_name, passward, ",
        "mobile_phone, telephone_number, ",
        "address)",
        "values (#{id,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{loginName,jdbcType=VARCHAR}, #{passward,jdbcType=VARCHAR}, ",
        "#{mobilePhone,jdbcType=VARCHAR}, #{telephoneNumber,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    @Select({
        "select",
        "id, user_name, login_name, passward, mobile_phone, telephone_number, address",
        "from hsj_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.hushunjian.springcloud.client.user.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_user
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    @Update({
        "update hsj_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "login_name = #{loginName,jdbcType=VARCHAR},",
          "passward = #{passward,jdbcType=VARCHAR},",
          "mobile_phone = #{mobilePhone,jdbcType=VARCHAR},",
          "telephone_number = #{telephoneNumber,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}