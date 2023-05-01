package com.tms.spring.project.service;

import com.tms.spring.project.model.User;
import com.tms.spring.project.model.Timetable;
import com.tms.spring.project.model.Tag;
import java.util.List;

public interface ITimetableService
{
	Timetable GetTimetable( String weekAsDate, User ownerOfTasksToShow );

	Timetable GetFilteredTimetable( Timetable timetable, Tag tag);
}