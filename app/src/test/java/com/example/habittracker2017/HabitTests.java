package com.example.habittracker2017;

import com.example.habittracker2017.Habit;
import com.example.habittracker2017.User;

import net.bytebuddy.dynamic.ClassFileLocator;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by jmark on 2017-12-04.
 */

public class HabitTests {
    HashMap<Integer, Boolean> testSchedule;

    @Test
    public void testGetTitle(){
        String testTitle = "Title";
        Habit habit0 = new Habit(testTitle, "Reason", new Date(), testSchedule);

        assertEquals("Title gotten is different from set title", habit0.getTitle(), testTitle);
    }

    @Test
    public void testSetTitle(){
        String testTitle = "Title";
        Habit habit0 = new Habit(testTitle, "Reason", new Date(), testSchedule);

        String newTestTitle = "New Title";
        habit0.setTitle(newTestTitle);

        assertEquals("Title did not update", habit0.getTitle(), newTestTitle);
    }

    @Test
    public void testGetReason(){
        String testReason = "test reason";
        Habit habit0 = new Habit("Title", testReason, new Date(), testSchedule);

        assertEquals("Reason gotten is not the same as one given", habit0.getReason(), testReason);
    }

    @Test
    public void testSetReason(){
        String testReason = "original test reason";
        String newTestReason = "new test reason";
        Habit habit0 = new Habit("Title", testReason, new Date(), testSchedule);
        habit0.setReason(newTestReason);

        assertEquals("habit reason did not update", habit0.getReason(), newTestReason);
    }

    @Test
    public void testGetDate(){
        Date testDate = new Date();
        Habit habit0 = new Habit("Title", "Reason", testDate, testSchedule);

        assertEquals("not the same date", habit0.getStartDate(),testDate);
    }

    @Test
    public void testSetDate(){
        String originalTestDate = "11-11-2017";
        String newTestDate = "22-11-2017";
        SimpleDateFormat converter = new SimpleDateFormat("dd-MM-yyyy");
        Date originalDate = new Date();
        Date newDate = new Date();
        try {
            originalDate = converter.parse(originalTestDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            newDate = converter.parse(newTestDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Habit habit0 = new Habit("Title", "Reason", originalDate, testSchedule);
        habit0.setStartDate(newDate);

        assertEquals("Date did not update", habit0.getStartDate(), newDate);

    }

    @Test
    public void testGetSchedule(){
        HashMap<Integer, Boolean> newTestSchedule = new HashMap<>();
        newTestSchedule.put(1, true);
        Habit habit0 = new Habit("Title", "Reason", new Date(), newTestSchedule);

        assertEquals("Schedule gotten is not the same as the one given", habit0.getSchedule(), newTestSchedule);
    }

    @Test
    public void testSetSchedule(){
        Habit habit0 = new Habit("Title", "Reason", new Date(), testSchedule);
        HashMap<Integer, Boolean> newTestSchedule = new HashMap<>();
        newTestSchedule.put(1,true);
        habit0.setSchedule(newTestSchedule);

        assertEquals("Schedule did not update", habit0.getSchedule(), newTestSchedule);
    }


}