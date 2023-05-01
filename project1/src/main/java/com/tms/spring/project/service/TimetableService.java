package com.tms.spring.project.service;

import com.tms.spring.project.model.Task;
import com.tms.spring.project.model.User;
import com.tms.spring.project.model.Tag;
import com.tms.spring.project.model.Timetable;
import com.tms.spring.project.model.DayOfWeek;
import com.tms.spring.project.repository.TimetableRepository;
import com.tms.spring.project.repository.TagRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

@Service
public class TimetableService implements ITimetableService 
{
	@Autowired
	private TimetableRepository timetableRepository;

	@Autowired
	private TagRepository tagRepository;

	@Override
	public Timetable GetTimetable( String weekAsDate, User ownerOfTasksToShow )
	{
		long userId = ownerOfTasksToShow.getId();
		Timetable timetable = timetableRepository.GetTimetable( weekAsDate, userId );
		
		return timetable;
	}

	@Override
	public Timetable GetFilteredTimetable( Timetable timetable, Tag tag)
	{
		Timetable resultTimetable = new Timetable();
		for(DayOfWeek dayOfWeek : timetable.getDaysOfWeek()){
			DayOfWeek tmpDayOfWeek = new DayOfWeek();
			for(Task task : dayOfWeek.getTasks()){
				List<Tag> tagsForTasks = tagRepository.GetTagsForTask(task.getId());
				if(tagsForTasks.contains(tag)){
					tmpDayOfWeek.AddTask(task);
				}
			}
			resultTimetable.AddDayOfWeek(tmpDayOfWeek);
		}

		return resultTimetable;
	}
}