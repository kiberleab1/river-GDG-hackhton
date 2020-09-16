package com.rrp.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rrp.web.domain.Story;
import com.rrp.web.repositorries.StoryRepository;



@Service
public class StoryServiceImple implements StoryService {

	@Autowired
	private StoryRepository storyRepository;
	@Override
	public Page<Story> findByPageAndType(Pageable pagable, String type) {
		
		return this.storyRepository.findByType(pagable,type);
	}

	@Override
	public Page<Story> findByPage(Pageable pagabl) {
		// TODO Auto-generated method stub
		return this.storyRepository.findAll(pagabl);
	}

	@Override
	public void saveStory(Story story) {
		this.storyRepository.save(story);
		
	}

	@Override
	public void deleteStroy(Story story) {
		// TODO Auto-generated method stub
		this.storyRepository.delete(story);
		
	}

	@Override
	public Story likeStory(long id) {
		Story story= this.storyRepository.findById(id).get();
		story.setNoOflikes(story.getNoOflikes());
		return story;
	}

	@Override
	public Story findById(long id) {
		return this.storyRepository.findById(id).get();
	
	}
}
