package com.hushunjian.springcloud.client.user.domain;

public class Tree {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hsj_tree.id
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hsj_tree.name
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hsj_tree.parent_id
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    private String parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hsj_tree.parent_full_name
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    private String parentFullName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hsj_tree.parent_full_id
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    private String parentFullId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hsj_tree.order_num
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    private Integer orderNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hsj_tree.path
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hsj_tree.level
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    private Integer level;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hsj_tree.id
     *
     * @return the value of hsj_tree.id
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hsj_tree.id
     *
     * @param id the value for hsj_tree.id
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hsj_tree.name
     *
     * @return the value of hsj_tree.name
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hsj_tree.name
     *
     * @param name the value for hsj_tree.name
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hsj_tree.parent_id
     *
     * @return the value of hsj_tree.parent_id
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hsj_tree.parent_id
     *
     * @param parentId the value for hsj_tree.parent_id
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hsj_tree.parent_full_name
     *
     * @return the value of hsj_tree.parent_full_name
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public String getParentFullName() {
        return parentFullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hsj_tree.parent_full_name
     *
     * @param parentFullName the value for hsj_tree.parent_full_name
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public void setParentFullName(String parentFullName) {
        this.parentFullName = parentFullName == null ? null : parentFullName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hsj_tree.parent_full_id
     *
     * @return the value of hsj_tree.parent_full_id
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public String getParentFullId() {
        return parentFullId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hsj_tree.parent_full_id
     *
     * @param parentFullId the value for hsj_tree.parent_full_id
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public void setParentFullId(String parentFullId) {
        this.parentFullId = parentFullId == null ? null : parentFullId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hsj_tree.order_num
     *
     * @return the value of hsj_tree.order_num
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hsj_tree.order_num
     *
     * @param orderNum the value for hsj_tree.order_num
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hsj_tree.path
     *
     * @return the value of hsj_tree.path
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hsj_tree.path
     *
     * @param path the value for hsj_tree.path
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hsj_tree.level
     *
     * @return the value of hsj_tree.level
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hsj_tree.level
     *
     * @param level the value for hsj_tree.level
     *
     * @mbg.generated Tue Sep 03 21:35:27 CST 2019
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}