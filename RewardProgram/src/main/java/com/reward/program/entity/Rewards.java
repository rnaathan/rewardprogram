package com.reward.program.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REWARDS")
public class Rewards {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="REWARD_ID")
	private Long id;
	
	@Column(name="REWARD_MONTH")
	private String rewardMonth;
	
	@Column(name="REWARD_POINTS")
	private Integer rewardsPont;
	
	@Column(name="CUSTOMER_ID")
	private Integer customerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRewardMonth() {
		return rewardMonth;
	}

	public void setRewardMonth(String rewardMonth) {
		this.rewardMonth = rewardMonth;
	}

	public Integer getRewardsPont() {
		return rewardsPont;
	}

	public void setRewardsPont(Integer rewardsPont) {
		this.rewardsPont = rewardsPont;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


}
