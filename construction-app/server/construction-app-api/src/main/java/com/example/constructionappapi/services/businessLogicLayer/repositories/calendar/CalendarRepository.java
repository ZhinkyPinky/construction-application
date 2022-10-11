package com.example.constructionappapi.services.businessLogicLayer.repositories.calendar;

import com.example.constructionappapi.services.dataAccessLayer.dao.CalendarDao;
import com.example.constructionappapi.services.dataAccessLayer.entities.CalendarEntity;

import java.util.List;
import java.util.Optional;

public class CalendarRepository implements ICalendarRepository {

    private CalendarDao calendarDao;

    public CalendarRepository(CalendarDao calendarDao)
    {
        this.calendarDao = calendarDao;
    }

    @Override
    public CalendarEntity createCalendar(CalendarEntity calendar) {
        return calendarDao.save(calendar);
    }

    @Override
    public CalendarEntity editCalendar(CalendarEntity calendar) {
        return calendarDao.save(calendar);
    }

    @Override
    public List<CalendarEntity> getAllCalendarEntites() {
        return calendarDao.findAll();
    }

    @Override
    public Optional<CalendarEntity> getCalendar(Long id) {
        return calendarDao.findById(id);
    }

    @Override
    public void deleteCalendar(Long id) {
        calendarDao.deleteById(id);
    }
}
