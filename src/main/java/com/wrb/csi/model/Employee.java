package com.wrb.csi.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.deptid
     *
     * @mbggenerated
     */
    private Integer deptid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.jobid
     *
     * @mbggenerated
     */
    private Integer jobid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.cardid
     *
     * @mbggenerated
     */
    private String cardid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.postcode
     *
     * @mbggenerated
     */
    private String postcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.tel
     *
     * @mbggenerated
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.qqnum
     *
     * @mbggenerated
     */
    private String qqnum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.sex
     *
     * @mbggenerated
     */
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.party
     *
     * @mbggenerated
     */
    private String party;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.birthday
     *
     * @mbggenerated
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.race
     *
     * @mbggenerated
     */
    private String race;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.education
     *
     * @mbggenerated
     */
    private String education;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.speciality
     *
     * @mbggenerated
     */
    private String speciality;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.hobby
     *
     * @mbggenerated
     */
    private String hobby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.pemark
     *
     * @mbggenerated
     */
    private String pemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_inf.createdate
     *
     * @mbggenerated
     */
    private Date createdate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.id
     *
     * @return the value of employee_inf.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.id
     *
     * @param id the value for employee_inf.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.deptid
     *
     * @return the value of employee_inf.deptid
     *
     * @mbggenerated
     */
    public Integer getDeptid() {
        return deptid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.deptid
     *
     * @param deptid the value for employee_inf.deptid
     *
     * @mbggenerated
     */
    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.jobid
     *
     * @return the value of employee_inf.jobid
     *
     * @mbggenerated
     */
    public Integer getJobid() {
        return jobid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.jobid
     *
     * @param jobid the value for employee_inf.jobid
     *
     * @mbggenerated
     */
    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.name
     *
     * @return the value of employee_inf.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.name
     *
     * @param name the value for employee_inf.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.cardid
     *
     * @return the value of employee_inf.cardid
     *
     * @mbggenerated
     */
    public String getCardid() {
        return cardid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.cardid
     *
     * @param cardid the value for employee_inf.cardid
     *
     * @mbggenerated
     */
    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.address
     *
     * @return the value of employee_inf.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.address
     *
     * @param address the value for employee_inf.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.postcode
     *
     * @return the value of employee_inf.postcode
     *
     * @mbggenerated
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.postcode
     *
     * @param postcode the value for employee_inf.postcode
     *
     * @mbggenerated
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.tel
     *
     * @return the value of employee_inf.tel
     *
     * @mbggenerated
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.tel
     *
     * @param tel the value for employee_inf.tel
     *
     * @mbggenerated
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.phone
     *
     * @return the value of employee_inf.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.phone
     *
     * @param phone the value for employee_inf.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.qqnum
     *
     * @return the value of employee_inf.qqnum
     *
     * @mbggenerated
     */
    public String getQqnum() {
        return qqnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.qqnum
     *
     * @param qqnum the value for employee_inf.qqnum
     *
     * @mbggenerated
     */
    public void setQqnum(String qqnum) {
        this.qqnum = qqnum == null ? null : qqnum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.email
     *
     * @return the value of employee_inf.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.email
     *
     * @param email the value for employee_inf.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.sex
     *
     * @return the value of employee_inf.sex
     *
     * @mbggenerated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.sex
     *
     * @param sex the value for employee_inf.sex
     *
     * @mbggenerated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.party
     *
     * @return the value of employee_inf.party
     *
     * @mbggenerated
     */
    public String getParty() {
        return party;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.party
     *
     * @param party the value for employee_inf.party
     *
     * @mbggenerated
     */
    public void setParty(String party) {
        this.party = party == null ? null : party.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.birthday
     *
     * @return the value of employee_inf.birthday
     *
     * @mbggenerated
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.birthday
     *
     * @param birthday the value for employee_inf.birthday
     *
     * @mbggenerated
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.race
     *
     * @return the value of employee_inf.race
     *
     * @mbggenerated
     */
    public String getRace() {
        return race;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.race
     *
     * @param race the value for employee_inf.race
     *
     * @mbggenerated
     */
    public void setRace(String race) {
        this.race = race == null ? null : race.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.education
     *
     * @return the value of employee_inf.education
     *
     * @mbggenerated
     */
    public String getEducation() {
        return education;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.education
     *
     * @param education the value for employee_inf.education
     *
     * @mbggenerated
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.speciality
     *
     * @return the value of employee_inf.speciality
     *
     * @mbggenerated
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.speciality
     *
     * @param speciality the value for employee_inf.speciality
     *
     * @mbggenerated
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.hobby
     *
     * @return the value of employee_inf.hobby
     *
     * @mbggenerated
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.hobby
     *
     * @param hobby the value for employee_inf.hobby
     *
     * @mbggenerated
     */
    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.pemark
     *
     * @return the value of employee_inf.pemark
     *
     * @mbggenerated
     */
    public String getPemark() {
        return pemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.pemark
     *
     * @param pemark the value for employee_inf.pemark
     *
     * @mbggenerated
     */
    public void setPemark(String pemark) {
        this.pemark = pemark == null ? null : pemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_inf.createdate
     *
     * @return the value of employee_inf.createdate
     *
     * @mbggenerated
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_inf.createdate
     *
     * @param createdate the value for employee_inf.createdate
     *
     * @mbggenerated
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}