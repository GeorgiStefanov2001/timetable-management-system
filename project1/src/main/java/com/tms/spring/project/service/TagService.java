package com.tms.spring.project.service;

import com.tms.spring.project.model.Tag;
import com.tms.spring.project.model.Task;
import com.tms.spring.project.model.User;
import com.tms.spring.project.repository.TagRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

@Service
public class TagService implements ITagService 
{
	@Autowired
	private TagRepository tagRepository;

	@Override
	public boolean CreateTag( Tag tag,  User loggedInUser )
	{
        long userId = loggedInUser.getId();
		return tagRepository.CreateTag( tag, userId );
	}

    @Override
    public List<Tag> GetAllTags()
    {
        return tagRepository.GetAllTags();
    }

    @Override
    public List<Tag> GetTagsForTask( Task task )
    {
        long taskId = task.getId();
        return tagRepository.GetTagsForTask(taskId);
    }

    @Override
    public List<Tag> GetTagsForUser( User user )
    {
        long userId = user.getId();
        return tagRepository.GetTagsForUser(userId);
    }
}
