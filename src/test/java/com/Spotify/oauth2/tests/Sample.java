package com.Spotify.oauth2.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

public class Sample
{
    @Test
    public void test()
    {
        ObjectMapper object = new ObjectMapper();
        ObjectNode map1 = object.createObjectNode();
        map1.put("id","001");
        map1.put("name","Nikhil");

        ObjectNode map2 = object.createObjectNode();
        map2.put("id","002");
        map2.put("name","Shweta");

        ArrayNode list = object.createArrayNode();
        list.add(map1);
        list.add(map2);

        System.out.println(list);

    }
}
