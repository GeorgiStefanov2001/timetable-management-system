package com.tms.spring.project.service;

import com.tms.spring.project.model.Task;
import java.util.List;

public interface ITaskService
{
	boolean CreateTask( Task task, User loggedInUser );
}
