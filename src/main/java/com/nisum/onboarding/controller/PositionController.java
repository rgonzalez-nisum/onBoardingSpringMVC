package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.dto.OptionDto;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;

@Controller
@RequestMapping("/positions")
public class PositionController {
	
	@RequestMapping(value = "/getAllPositionsAsOptions", method = RequestMethod.POST)
	@ResponseBody
	public JTableOptionListResponseImpl getAllPositionsAsOptions() {
		List<OptionDto> positions = findAllPositionsAsOptions();
		
		return new JTableOptionListResponseImpl("OK", positions);
	}
	
	private List<OptionDto> findAllPositionsAsOptions() {
		List<OptionDto> positions = new ArrayList<OptionDto>();
		positions.add(new OptionDto("Intership"));
		positions.add(new OptionDto("Developer Trainee"));
		positions.add(new OptionDto("Developer Junior"));
		positions.add(new OptionDto("Developer Senior"));
		positions.add(new OptionDto("QA Trainee"));
		positions.add(new OptionDto("QA Junior"));
		positions.add(new OptionDto("QA Senior"));

		return positions;
	}

}
