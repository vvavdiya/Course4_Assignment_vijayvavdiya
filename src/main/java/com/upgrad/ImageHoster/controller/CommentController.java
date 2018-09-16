package com.upgrad.ImageHoster.controller;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller

public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    /**
     * Create comment for img
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/image/{id}/comments/create", method = RequestMethod.POST)
    public String addComments(@PathVariable Integer id, @RequestParam("comment") String comment, HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        if (user == null) {
            return "redirect:/signup";
        }

        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setImage(imageService.getById(id));
        newComment.setUser(user);
        commentService.addComment(newComment);
        return "redirect:/images/" + id;
    }
}
