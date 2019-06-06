package com.mydesq.performanceTestReport;

import javax.xml.bind.annotation.XmlRootElement;

public class ResultObjects {

    private int statusCode;
    private int serverExecutionTime;
    private int totalRequestTime;
    private int timeTakenOnMachine;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getServerExecutionTime() {
        return serverExecutionTime;
    }

    public void setServerExecutionTime(int serverExecutionTime) {
        this.serverExecutionTime = serverExecutionTime;
    }

    public int getTotalRequestTime() {
        return totalRequestTime;
    }

    public void setTotalRequestTime(int totalRequestTime) {
        this.totalRequestTime = totalRequestTime;
    }

    public int getTimeTakenOnMachine() {
        return timeTakenOnMachine;
    }

    public void setTimeTakenOnMachine(int timeTakenOnMachine) {
        this.timeTakenOnMachine = timeTakenOnMachine;
    }
}
