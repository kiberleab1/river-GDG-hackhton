package com.rrp.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rrp.web.domain.Comment;
import com.rrp.web.repositorries.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired 
	private CommentRepository commentRepository;
	@Override
	public Page<Comment> findByOnWhat(Pageable pageable, long OnWhat) {
		// TODO Auto-generated method stub
		
		return this.commentRepository.findByOnWhat(pageable, OnWhat);
	}

	@Override
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
		this.commentRepository.save(comment);
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		this.commentRepository.deleteById(id);
		
	}

}
