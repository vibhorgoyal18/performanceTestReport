package com.mydesq.performanceTestReport;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

    private HashMap<String, ResultObjects> resultObjects;

    public HashMap<String, ResultObjects> getResultObjects() {
        return resultObjects;
    }

    public ReadJson() {

        resultObjects = new HashMap<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("MydesqAPIPerformance.postman_test_run_jump_06062019.json")) {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            JSONArray results = (JSONArray) obj.get("results");

            results.forEach(result -> {
                JSONObject resultObject = (JSONObject) result;
                String endPointUrl = ((JSONObject) result).get("url").toString();
                int statusCode = Integer.parseInt(((JSONObject) ((JSONObject) result).get("responseCode")).get("code").toString());
                int totalTime = Integer.parseInt(((JSONObject) result).get("time").toString());
                int serverExecutionTime = Integer.parseInt(((JSONObject) result).get("tests").toString()
                        .split("executionTime ")[1].split(" Milliseconds")[0]);
                resultObjects.put(endPointUrl, new ResultObjects());
                resultObjects.get(endPointUrl).setStatusCode(statusCode);
                resultObjects.get(endPointUrl).setTotalRequestTime(totalTime);
                resultObjects.get(endPointUrl).setServerExecutionTime(serverExecutionTime);
                resultObjects.get(endPointUrl).setTimeTakenOnMachine(totalTime - serverExecutionTime);
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] a) {
        new ReadJson();
    }
}
