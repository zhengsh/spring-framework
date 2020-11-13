package cn.edu.cqvie.tx.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户信息
 *
 * @author zhengsh
 * @date 2020-11-13
 */
public class Person {

	/**
	 * id
	 **/
	private Long id;

	/**
	 * 类型 1 普通, 2 vip
	 **/
	private short type;

	/**
	 * 用户名称
	 **/
	private String username;

	/**
	 * 出生日期
	 **/
	private LocalDate birthday;

	/**
	 * 创建时间
	 **/
	private LocalDateTime createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}


	public enum TypeEnum {

		/**
		 * 占位
		 */
		__,
		/**
		 * 普通
		 */
		GENERAL,
		/**
		 * VIP
		 */
		VIP;
	}

}
