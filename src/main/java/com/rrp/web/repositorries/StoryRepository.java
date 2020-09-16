package com.rrp.web.repositorries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.rrp.web.domain.Story;

public interface StoryRepository extends CrudRepository<Story,Long>{
	Page<Story> findAll(Pageable pageRequest);
	Page<Story> findByType(Pageable pageRequest,String type);
	int countByType(String type);
}
