package com.rrp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rrp.web.domain.Comment;
import com.rrp.web.domain.Story;
import com.rrp.web.services.CommentService;
import com.rrp.web.services.StoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/User/Story")
public class UserStroiesController {
	private CommentService commentService;
	private StoryService storyService;

	@Autowired
	public UserStroiesController(CommentService commentService, StoryService storyService) {

		this.commentService = commentService;
		this.storyService = storyService;
	}

	@GetMapping
	public String getStory(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "type", defaultValue = "none") String type) {

		PageRequest pageRequest = PageRequest.of(page, size);
		if (type.equalsIgnoreCase("none")) {
			model.addAttribute("allStories", this.storyService.findByPage(pageRequest));
		} else {
			model.addAttribute("allStories", this.storyService.findByPageAndType(pageRequest, type));
		}
		
		model.addAttribute("newStory", new Story());
		return "social";
	}

	@GetMapping("/Single")
	public String getSingleStory(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "type", defaultValue = "none") String type,
			@RequestParam(name = "storyId") int storyid) {

		PageRequest pageRequest = PageRequest.of(page, size);
		log.info("Hello World");
		model.addAttribute("Story", this.storyService.findById(storyid));
		model.addAttribute("comments", this.commentService.findByOnWhat(pageRequest, storyid));
		model.addAttribute("newComment", new Comment());
		return "Story";
	}

	@PostMapping
	public String saveStroy(@Valid @ModelAttribute("newStory") Story newStory, BindingResult bindingResult,
			 Errors errors, Model model) {
		String type="none";
		if(errors.hasErrors()){
			PageRequest pageRequest = PageRequest.of(0, 10);
			if(type.equalsIgnoreCase("none")) {
				model.addAttribute("allStories",this.storyService.findByPage(pageRequest));
			}
			else {
				model.addAttribute("allStories",this.storyService.findByPage(pageRequest));
			}
			return "Social";
		}
		this.storyService.saveStory(newStory);
		return "Social";
	}
	@PostMapping("/comment")
	public String saveComment(@Valid @ModelAttribute("newComment") Comment comment,@RequestParam(name = "storyId") int storyid,BindingResult bindingResult,
			 Errors errors, Model model) {
		String type="none";
		if(errors.hasErrors()){
			PageRequest pageRequest = PageRequest.of(0, 10);
			model.addAttribute("Story", this.storyService.findById(storyid));
			model.addAttribute("comments", this.commentService.findByOnWhat(pageRequest, storyid));
		
			return "Single";
		}
		this.commentService.saveComment(comment);
		return "Single";
	}
	@PostMapping("/deleteStory")
	public String saveComment(@RequestParam(name = "storyId") int storyid) {
		Story story=this.storyService.findById(storyid);
		this.storyService.deleteStroy(story);
		return "Story";
	}
	

}
