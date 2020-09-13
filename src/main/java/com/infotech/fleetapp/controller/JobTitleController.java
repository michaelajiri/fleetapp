package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.JobTitle;
import com.infotech.fleetapp.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    private final JobTitleService jobTitleService;

    @Autowired
    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @RequestMapping(value = "/jobTitles", method = RequestMethod.GET)
    public String jobTitlePage(Model model) {
        List<JobTitle> listOfJobTitles = jobTitleService.getAllJobTitles();
        model.addAttribute("listOfJobTitles", listOfJobTitles);
        return "jobTitle";
    }

    @ResponseBody
    @RequestMapping(value = "/oneJobTitle", method = RequestMethod.GET)
    public Optional<JobTitle> getJobTitleById(Integer id, Model model) {
        return jobTitleService.getJobTitleById(id);
    }

    @RequestMapping(value = "/addNewJobTitle", method = RequestMethod.POST)
    public String addNewJobTitle(JobTitle jobTitle) {
        jobTitleService.addNewJobTitle(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/editJobTitle", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateJobTitle(JobTitle jobTitle) {
        jobTitleService.updateJobTitle(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/deleteJobTitle", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteJobTitle(Integer id){
        jobTitleService.removeJobTitle(id);
        return "redirect:/jobTitles";
    }
}
