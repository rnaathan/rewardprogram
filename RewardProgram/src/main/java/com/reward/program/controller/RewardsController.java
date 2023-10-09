package com.reward.program.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reward.program.entity.RewardsSummary;
import com.reward.program.service.RewardsService;
import com.reward.program.service.exception.RewardException;


@RestController
public class RewardsController {

	@Autowired
	private RewardsService rewardsService;

	 Logger logger = LoggerFactory.getLogger(RewardsController.class);
	 
	@GetMapping("/rewardsummary")
	private ResponseEntity<List<RewardsSummary>> getRewardsSummary() {
		logger.info("Starting RewardsService.getRewardsSummary");
		return new ResponseEntity(rewardsService.getRewardSummary(), HttpStatus.OK);
	}

	@GetMapping("/addrewards")
	public ResponseEntity<String> addRewards(@PathParam("spentamt") double spentamt, @PathParam("month") String month,
			@PathParam("customerid") Integer customerid) throws RewardException {
		logger.info("Start  RewardsService.AddReward");
		String response = rewardsService.addRewards(spentamt, month, customerid);

		return new ResponseEntity(response, HttpStatus.OK);
	}

}
