package com.hushunjian.springcloud.client.user.mapper;

import com.hushunjian.springcloud.client.user.domain.Tree;
import com.hushunjian.springcloud.client.user.domain.TreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TreeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    long countByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    int deleteByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    @Delete({
        "delete from hsj_tree",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    @Insert({
        "insert into hsj_tree (id, name, ",
        "parent_id, parent_full_name, ",
        "parent_full_id, order_num, ",
        "path, level)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=VARCHAR}, #{parentFullName,jdbcType=VARCHAR}, ",
        "#{parentFullId,jdbcType=VARCHAR}, #{orderNum,jdbcType=INTEGER}, ",
        "#{path,jdbcType=VARCHAR}, #{level,jdbcType=INTEGER})"
    })
    int insert(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    int insertSelective(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    List<Tree> selectByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    @Select({
        "select",
        "id, name, parent_id, parent_full_name, parent_full_id, order_num, path, level",
        "from hsj_tree",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.hushunjian.springcloud.client.user.mapper.TreeMapper.BaseResultMap")
    Tree selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    int updateByExampleSelective(@Param("record") Tree record, @Param("example") TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    int updateByExample(@Param("record") Tree record, @Param("example") TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    int updateByPrimaryKeySelective(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hsj_tree
     *
     * @mbg.generated Sat Dec 14 19:27:53 CST 2019
     */
    @Update({
        "update hsj_tree",
        "set name = #{name,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=VARCHAR},",
          "parent_full_name = #{parentFullName,jdbcType=VARCHAR},",
          "parent_full_id = #{parentFullId,jdbcType=VARCHAR},",
          "order_num = #{orderNum,jdbcType=INTEGER},",
          "path = #{path,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Tree record);
}