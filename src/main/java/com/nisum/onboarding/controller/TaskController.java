package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.jtable.bean.JTableOptionBean;
import com.nisum.onboarding.jtable.bean.JTableTaskBean;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;
import com.nisum.onboarding.jtable.response.impl.JTableTaskListResponse;
import com.nisum.onboarding.jtable.response.impl.JTableTaskResponse;
import com.nisum.onboarding.model.TaskStatus;
import com.nisum.onboarding.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	private static final Logger LOG = Logger.getLogger(TaskController.class);
	
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/getTasks", method = RequestMethod.POST)
	@ResponseBody
	public JTableTaskListResponse getAllTasks(String jtSorting) {
		JTableTaskListResponse response;

		try {
			List<JTableTaskBean> taskBeans = taskService.findAll();
			
			response = new JTableTaskListResponse("OK", taskBeans, taskBeans.size());
		} catch (Exception e) {
			LOG.error("Exception while finding all tasks", e);
			response = new JTableTaskListResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}
	
	@RequestMapping(value = "/getTaskById", method = RequestMethod.POST)
	@ResponseBody
	public JTableTaskResponse getTaskById(@RequestParam Long id) {
		JTableTaskResponse response;

		try {
			JTableTaskBean taskBean = taskService.findById(id);
			
			response = new JTableTaskResponse("OK", taskBean);
		} catch (Exception e) {
			LOG.error("Exception while finding tasks by ID", e);
			response = new JTableTaskResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}
	
	@RequestMapping(value = "/getTaskByProgramId", method = RequestMethod.POST)
	@ResponseBody
	public JTableTaskListResponse getTaskByProgramId(@RequestParam Long programId) {
		JTableTaskListResponse response;

		try {
			List<JTableTaskBean> taskBeans = taskService.findByProgramId(programId);
			
			response = new JTableTaskListResponse("OK", taskBeans, taskBeans.size());
		} catch (Exception e) {
			LOG.error("Exception while finding tasks by program ID", e);
			response = new JTableTaskListResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}

	@RequestMapping(value = "/statuses", method = RequestMethod.POST)
	public @ResponseBody JTableOptionListResponseImpl getPositions() {
		List<JTableOptionBean> statuses = allStatuses();
		return new JTableOptionListResponseImpl("OK", statuses);
	}
	
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	@ResponseBody
	public JTableTaskResponse addTask(@ModelAttribute JTableTaskBean taskBean, BindingResult result) {
		if (result.hasErrors()) {
			LOG.error(result.getAllErrors());
			return new JTableTaskResponse("ERROR", "Form invalid");
		}

		JTableTaskResponse jsonJtableResponse;
		
		try {
			taskService.save(taskBean);
			
			jsonJtableResponse = new JTableTaskResponse("OK", taskBean);
		} catch (Exception e) {
			LOG.error("Exception while adding task", e);
			jsonJtableResponse = new JTableTaskResponse("ERROR", "Could not complete the operation.");
		}

		return jsonJtableResponse;
	}

	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	@ResponseBody
	public JTableTaskResponse updateTask(@ModelAttribute JTableTaskBean taskBean, BindingResult result) {
		if (result.hasErrors()) {
			LOG.error(result.getAllErrors());
			return new JTableTaskResponse("ERROR", "Form invalid");
		}

		JTableTaskResponse jsonJtableResponse;

		try {
			taskService.update(taskBean);
			jsonJtableResponse = new JTableTaskResponse("OK", taskBean);
		} catch (Exception e) {
			LOG.error("Exception while updating task", e);
			jsonJtableResponse = new JTableTaskResponse("ERROR", "Could not complete the operation.");
		}
		
		return jsonJtableResponse;
	}

	@RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
	@ResponseBody
	public JTableTaskResponse deleteTask(@RequestParam Long id) {
		JTableTaskResponse jsonJtableResponse;
		
		try {
			taskService.deleteById(id);
			jsonJtableResponse = new JTableTaskResponse("OK");
		} catch (Exception e) {
			LOG.error("Exception while deleting task", e);
			jsonJtableResponse = new JTableTaskResponse("ERROR", "Could not complete the operation.");
		}
		
		return jsonJtableResponse;
	}
	
	private List<JTableOptionBean> allStatuses() {
		List<JTableOptionBean> positions = new ArrayList<JTableOptionBean>();
		
		for (TaskStatus status : TaskStatus.values()) {
			positions.add(new JTableOptionBean(status.toString()));
		}

		return positions;
	}
	
}
