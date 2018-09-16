package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.common.CommentManager;
import com.upgrad.ImageHoster.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommnetServiceImpl implements CommentService {
    private CommentManager commentManager;

    public CommnetServiceImpl() {
        commentManager = new CommentManager();
    }


    @Override
    public List<Comment> getAllCommentsByImageId(Integer id) {
        return commentManager.getAllCommentsByImageId(id);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentManager.addComment(comment);
    }
}
