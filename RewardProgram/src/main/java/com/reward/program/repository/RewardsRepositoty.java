package com.reward.program.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reward.program.entity.Rewards;
import com.reward.program.entity.RewardsSummary;

@Repository("rewardsRepositoty")
public interface RewardsRepositoty extends JpaRepository<Rewards, Long> {

	@Query("select rewardMonth  as month,customerId as customerId,sum(rewardsPont)  as totalRewards  from Rewards group by rewardMonth, customerId")
	public List<RewardsSummary> getRewardSummary();
}
