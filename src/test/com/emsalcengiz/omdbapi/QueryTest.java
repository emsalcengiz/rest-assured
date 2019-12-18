package com.emsalcengiz.omdbapi;
import com.junit.Test;
import java.util.Map;
import static com.junit.Assert.*;

public class QueryTest {

    private final String title = "Harry Potter";
    private final String imdbID = "tt0241527";
    private final String type = "movie";
    private final String year = "2001";
    private final String page = "1";

    @Test
    public void QueryTitleTest() throws Exception {
        Query query = new Query.Builder(title).build();
        Map<String, String> queryMap = query.getQueryMap();

        assertEquals(title, queryMap.get("t"));
        assertEquals("", queryMap.get("i"));
        assertEquals("", queryMap.get("type"));
        assertEquals("", queryMap.get("y"));
        assertEquals("", queryMap.get("page"));
    }

    @Test
    public void QueryIDTest() throws Exception {
        Query query = new Query.Builder(imdbID).build();
        Map<String, String> queryMap = query.getQueryMap();

        assertEquals("", queryMap.get("t"));
        assertEquals(imdbID, queryMap.get("i"));
        assertEquals("", queryMap.get("type"));
        assertEquals("", queryMap.get("y"));
        assertEquals("", queryMap.get("page"));
    }

    @Test
    public void QueryAllTest() throws Exception {
        Query query = new Query.Builder(title)
                .title(title)
                .imdbID(imdbID)
                .type(type)
                .year(year)
                .page(page)
                .build();

        Map<String, String> queryMap = query.getQueryMap();

        assertEquals(title, queryMap.get("t"));
        assertEquals(imdbID, queryMap.get("i"));
        assertEquals(type, queryMap.get("type"));
        assertEquals(year, queryMap.get("y"));
        assertEquals(page, queryMap.get("page"));
    }
}