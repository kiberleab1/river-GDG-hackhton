package com.rrp.web.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rrp.web.domain.Story;

public interface StoryService {
	Page<Story> findByPageAndType(Pageable pagable,String type);
	Page<Story> findByPage(Pageable pagable);
	void saveStory(Story story);
	void deleteStroy(Story story);
	Story likeStory(long Id);
	Story findById(long id);
}
