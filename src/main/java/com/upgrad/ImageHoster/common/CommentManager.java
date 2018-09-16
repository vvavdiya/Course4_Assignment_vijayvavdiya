package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CommentManager extends SessionManager {
    /**
     * This method saves a Comment object to the database
     *
     * @param comment Comment object to be saved into the database
     * @return the saved comment object
     */
    public Comment addComment(Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
        return comment;
    }

    /**
     * This returns all the comments by image in the database
     *
     * @return List of Comment objects
     */
    public List<Comment> getAllCommentsByImageId(Integer id) {
        Session session = openSession();
        List<Comment> comments = session.createCriteria(Comment.class).add(Restrictions.eq("id", id)).list();

        commitSession(session);

        return comments;
    }
}
