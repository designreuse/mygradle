package com.git.sh;

/**
 * Created by lihao on 17/10/23.
 */
public class ShBean {
    private String serverName;
    private String hostName;
    private String command;
    private String fileName;

    public ShBean(String serverName, String hostName,String fileName) {
        this.serverName = serverName;
        this.hostName = hostName;
        this.fileName = fileName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
