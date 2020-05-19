package team.alex.Grupp1.controller;

public class ResponseObject {
    private String response;

    public ResponseObject(String response) {
        setResponse(response);
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return this.response;
    }
}
