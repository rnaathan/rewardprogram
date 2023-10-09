package com.reward.program.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.program.entity.Rewards;
import com.reward.program.entity.RewardsSummary;
import com.reward.program.repository.RewardsRepositoty;
import com.reward.program.service.exception.RewardException;



@Service("rewardsService")
public class RewardsService {
	
	@Autowired
	private RewardsRepositoty rewardsRepositoty;
	
	public String addRewards(Double spentamt,String month,Integer customerId) throws RewardException
	{
		try {
			Rewards reward  =new Rewards();
			int points = (int) ((spentamt -50) +(spentamt-100));
			reward.setRewardsPont(points);
			reward.setRewardMonth(month);
			reward.setCustomerId(customerId);
			
		rewardsRepositoty.save(reward);
		}catch(Exception e) {
			throw new RewardException("Exception occured when save rewards");
		}
		
		return "Successfully saved";
	}
	

	public  List getAllRewards()
	{   	
		List list =(List) rewardsRepositoty.findAll();
		return list;
	}
	
	public List<RewardsSummary> getRewardSummary()
	{
		return rewardsRepositoty.getRewardSummary();
	}
}
