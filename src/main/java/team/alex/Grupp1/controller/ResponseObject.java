package team.alex.Grupp1.controller;

/**
*   ResponseObject class acts as a container<br>
*   for response messages which are later converted<br>
*   to JSON format through SpringBoot
*/
public class ResponseObject {
    private String response;

    /**
    *   Constructor
    *
    *   @param response - a string to be used as response message
    */
    public ResponseObject(String response) {
        setResponse(response);
    }

    /**
    *   Sets response message.
    *
    *   @param response - a string to be used as response message
    */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
    *   @return response message
    */
    public String getResponse() {
        return this.response;
    }
}
