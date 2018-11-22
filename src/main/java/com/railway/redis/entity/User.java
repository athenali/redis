package com.railway.redis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "[sys_user]")
public class User implements  Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(length = 32)
	private String id;

	/**
	 * 用户名
	 */
    @Column(length = 50, unique = true)
	private String username;

	/**
	 * 姓名
	 */
	@Column(length = 50)
	private String realname;

	/**
	 * 类型
	 */
	@Column(length = 50)
	private String type;

	/**
	 * 性别 男1 0女
	 */
	@Column(length = 1)
	private String sex;

	@Column(length = 10)
	private String birthday;

	@Column(length = 50)
	private String wechat;

	/**
	 * 备注
	 */
	@Column(length = 255)
	private String remark;

	/**
	 * 联系电话
	 */
	@Column(length = 50)
	private String phone;

	/**
	 * 邮箱
	 */
	@Column(length = 50)
	private String email;
	/**
	 * 密码
	 */
	@JsonIgnore
	@Column(length = 100)
	private String password;

	/**
	 * 账号是否可用
	 */
	private Boolean enabled = Boolean.TRUE;

	/**
	 * 角色
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public User() {
		super();
	}

	public User(String username, String realname, Boolean enabled) {
		super();
		this.username = username;
		this.realname = realname;
		this.enabled = enabled;
	}
}
