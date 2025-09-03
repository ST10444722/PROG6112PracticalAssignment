/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import prog6112assignment.Series;
import prog6112assignment.SeriesModel;
/**
 *
 * @author lab_services_student
 */
/*
 * Reference List:
 * IIE. (2016). Login and Registration System using Java - Part 4 [YouTube Video].
 * Available at: https://www.youtube.com/watch?v=1Pa15vDWG-8 [Accessed 01 September. 2025].
*simplyianm 2012, JUnit 4 Tutorial - Your first Java Unit Test, YouTube video,[Online]. https://www.youtube.com/watch?v=lYnMyi81hrs [Accessed: 01 September 2025]
* OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]. https://chat.openai.com/chat [Accessed 01 September. 2025]
 */

public class SeriesTest {

    private Series series;

    @Before 
    public void setUp() {
        series = new Series();
        series.seriesCollection.add(new SeriesModel("S1", "Breaking Bad", 16, 62));
        series.seriesCollection.add(new SeriesModel("S2", "Stranger Things", 14, 34));
    }

    // TestSearchSeries()
    @Test
    public void TestSearchSeries() {
        SeriesModel result = series.findSeriesById("S1");
        assertNotNull(result);
        assertEquals("Breaking Bad", result.getSeriesName());
    }

    // TestSearchSeries_SeriesNotFound()
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel result = series.findSeriesById("X1");
        assertNull(result);
    }

    // TestUpdateSeries()
    @Test
    public void TestUpdateSeries() {
        SeriesModel s = series.findSeriesById("S1");
        assertNotNull(s);

        s.setSeriesName("Better Call Saul");
        s.setSeriesAge(15);
        s.setSeriesNumberOfEpisodes(50);

        SeriesModel updated = series.findSeriesById("S1");
        assertEquals("Better Call Saul", updated.getSeriesName());
        assertEquals(15, updated.getSeriesAge());
        assertEquals(50, updated.getSeriesNumberOfEpisodes());
    }

    // TestDeleteSeries()
    @Test
    public void TestDeleteSeries() {
        boolean deleted = series.deleteSeriesById("S2");
        assertTrue(deleted);
        assertEquals(1, series.getSeriesCount());
    }

    //TestDeleteSeries_SeriesNotFound()
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = series.deleteSeriesById("X2");
        assertFalse(deleted);
        assertEquals(2, series.getSeriesCount());
    }

    //TestSeriesAgeRestriction_AgeValid()
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(series.isAgeValid(2));
        assertTrue(series.isAgeValid(10));
        assertTrue(series.isAgeValid(18));
    }

    //TestSeriesAgeRestriction_SeriesAgeInValid()
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(series.isAgeValid(1));
        assertFalse(series.isAgeValid(19));
        assertFalse(series.isAgeValid(100));
    }
}
