package trinadhkoya.github.io.myprototype;

/**
 * Created by trinadhkoya on 19/10/17.
 */


public class Request {
    private long reqId;
    private String requestTitle;
    private String status;
    private String createdDate;

    public Request(long reqId, String requestTitle, String status, String createdDate) {
        this.reqId = reqId;
        this.requestTitle = requestTitle;
        this.status = status;
        this.createdDate = createdDate;

    }

    public Request() {

    }

    public long getReqId() {
        return reqId;
    }

    public void setReqId(long reqId) {
        this.reqId = reqId;
    }

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }


    public String toString() {
        return "Req id: " + getReqId() + "\n" +
                "Name: " + getRequestTitle() + " " + getStatus() + "\n" +
                "Created Date: " + getCreatedDate();

    }


}