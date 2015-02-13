package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.dto.bean.JsonJTableOptionBean;
import com.nisum.onboarding.dto.bean.JsonJTableParticipantBean;
import com.nisum.onboarding.dto.response.JsonJTableOptionResponse;
import com.nisum.onboarding.dto.response.JsonJTableParticipantListResponse;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.service.ParticipantService;

@Controller
@RequestMapping("/participants")
public class NewParticipantController {

	@Autowired
    private ParticipantService participantService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String show(ModelMap model) {
        return "participant/all-participants";
    }

    @RequestMapping(value = "/getAllParticipants", method=RequestMethod.POST)
    @ResponseBody
    public JsonJTableParticipantListResponse getAllParticipants() {
    	JsonJTableParticipantListResponse response;
    	
        try {
            List<JsonJTableParticipantBean> participants = participantToJsonJTableParticipantBean(participantService.findAll());
            response = new JsonJTableParticipantListResponse("OK", participants, participants.size());
        } catch (Exception e) {
        	response = new JsonJTableParticipantListResponse("ERROR", e.getMessage());
        }
        
        return response;
    }

    @RequestMapping(value = "/positions", method = RequestMethod.POST)
    public @ResponseBody JsonJTableOptionResponse getPositions() {
    	List<JsonJTableOptionBean> positions = allPositions(); 
        return new JsonJTableOptionResponse("OK", positions, positions.size());
    }

//    @RequestMapping(value = "/addParticipant", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonJTableExpenseResponse insertGroup(@ModelAttribute JsonJTableParticipantBean expenseBean, BindingResult result) {
//        JsonJTableExpenseResponse jsonJtableResponse;
//        if (result.hasErrors()) {
//            jsonJtableResponse = new JsonJTableExpenseResponse("ERROR","Form invalid");
//        }
//        try {           
//            participantService.addExpense(expenseBean);
//            jsonJtableResponse = new JsonJTableExpenseResponse("OK",expenseBean);
//        } catch (Exception e) {
//            jsonJtableResponse = new JsonJTableExpenseResponse("ERROR",e.getMessage());
//        }
//        return jsonJtableResponse;
//    }
//
//    /*CRUD operation - Update the expense */
//    @RequestMapping(value = "/updateParticipant", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonJTableExpenseResponse updateRole(@ModelAttribute JsonJTableParticipantBean expenseBean, BindingResult result) {
//        JsonJTableExpenseResponse jsonJtableResponse;
//        if (result.hasErrors()) {
//            jsonJtableResponse = new JsonJTableExpenseResponse("ERROR","Form invalid");
//        }
//        try {
//            participantService.updateExpense(expenseBean);
//            jsonJtableResponse = new JsonJTableExpenseResponse("OK",expenseBean);
//        } catch (Exception e) {
//            jsonJtableResponse = new JsonJTableExpenseResponse("ERROR",e.getMessage());
//        }
//        return jsonJtableResponse;
//    }
//
//    /*CRUD operation - Delete the expense */
//    @RequestMapping(value = "/deleteParticipant", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonJTableExpenseResponse delete(@RequestParam String ExpenseId) {
//        JsonJTableExpenseResponse jsonJtableResponse;
//        try {
//            participantService.removeExpense(new Integer(ExpenseId));
//            jsonJtableResponse = new JsonJTableExpenseResponse("OK");
//        } catch (Exception e) {
//            jsonJtableResponse = new JsonJTableExpenseResponse("ERROR",e.getMessage());
//        }
//        return jsonJtableResponse;
//    }
	
    private List<JsonJTableOptionBean> allPositions() {
		List<JsonJTableOptionBean> positions = new ArrayList<JsonJTableOptionBean>();
		positions.add(new JsonJTableOptionBean("Intership"));
		positions.add(new JsonJTableOptionBean("Developer Trainee"));
		positions.add(new JsonJTableOptionBean("Developer Junior"));
		positions.add(new JsonJTableOptionBean("Developer Senior"));
		positions.add(new JsonJTableOptionBean("QA Trainee"));
		positions.add(new JsonJTableOptionBean("QA Junior"));
		positions.add(new JsonJTableOptionBean("QA Senior"));

		return positions;
	}
    
    private List<JsonJTableParticipantBean> participantToJsonJTableParticipantBean(List<Participant> participants) {
    	List<JsonJTableParticipantBean> participantsBeans = new ArrayList<JsonJTableParticipantBean>();
    	
    	for (Participant participant : participants) {
    		JsonJTableParticipantBean participantsBean = new JsonJTableParticipantBean();
    		participantsBean.setId(participant.getId());
    		participantsBean.setName(participant.getName());
    		participantsBean.setLastname(participant.getLastname());
    		participantsBean.setPosition(participant.getPosition());
    		participantsBean.setEmail(participant.getEmail());
    		
    		participantsBeans.add(participantsBean);
    	}
    	
    	return participantsBeans;
    }
    
}
