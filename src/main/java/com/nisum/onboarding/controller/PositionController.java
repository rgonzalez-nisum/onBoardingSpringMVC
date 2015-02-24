package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.bo.impl.OptionBoImpl;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;

@Controller
@RequestMapping("/positions")
public class PositionController {
	
	@RequestMapping(value = "/getAllPositionsAsOptions", method = RequestMethod.POST)
	@ResponseBody
	public JTableOptionListResponseImpl getAllPositionsAsOptions() {
		List<OptionBoImpl> positions = findAllPositionsAsOptions();
		
		return new JTableOptionListResponseImpl("OK", positions);
	}
	
	private List<OptionBoImpl> findAllPositionsAsOptions() {
		List<OptionBoImpl> positions = new ArrayList<OptionBoImpl>();
		positions.add(new OptionBoImpl("Intership"));
		positions.add(new OptionBoImpl("Developer Trainee"));
		positions.add(new OptionBoImpl("Developer Junior"));
		positions.add(new OptionBoImpl("Developer Senior"));
		positions.add(new OptionBoImpl("QA Trainee"));
		positions.add(new OptionBoImpl("QA Junior"));
		positions.add(new OptionBoImpl("QA Senior"));

		return positions;
	}

}
