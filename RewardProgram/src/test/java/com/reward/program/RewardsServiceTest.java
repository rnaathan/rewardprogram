package com.reward.program;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.reward.program.entity.Rewards;
import com.reward.program.repository.RewardsRepositoty;
import com.reward.program.service.RewardsService;
import com.reward.program.service.exception.RewardException;

@SpringBootTest
public class RewardsServiceTest {
	
	@Mock
	private RewardsRepositoty rewardsRepositoty; 
	
	@InjectMocks
	private RewardsService rewardsService; 
	
	private Rewards rewards;
	
	@BeforeEach
	void setMock()
	{
		rewards  = new Rewards();
		rewards.setCustomerId(1212);
		rewards.setRewardMonth("January");
		rewards.setRewardsPont(100);
		when(rewardsRepositoty.save(rewards)).thenReturn(rewards);
	}

	@Test
	public void TestAddRewards() throws RewardException
	{
		String response = rewardsService.addRewards(120.0,"January", 1212);
		assertEquals("Successfully saved",response);
		
	}
}
