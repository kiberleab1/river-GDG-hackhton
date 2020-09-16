package com.rrp.web.repositorries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.rrp.web.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment,Long> {
	Page<Comment> findByOnWhat(Pageable pageble,long onWhat);
	
}
