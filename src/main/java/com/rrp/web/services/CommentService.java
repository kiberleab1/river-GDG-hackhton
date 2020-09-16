package com.rrp.web.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rrp.web.domain.Comment;

public interface CommentService {
	Page<Comment> findByOnWhat(Pageable pageable,long OnWhat);
	void saveComment(Comment comment);
	void deleteById(long id);
}
