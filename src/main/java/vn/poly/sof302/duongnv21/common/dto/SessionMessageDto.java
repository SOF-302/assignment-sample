package vn.poly.sof302.duongnv21.common.dto;

/**
 * @author duongnguyen
 *
 */
public class SessionMessageDto {

    private String messageCode;

    private Object [] messageArgs;

    /**
     * @return the messageCode
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * @param messageCode the messageCode to set
     */
    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    /**
     * @return the messageArgs
     */
    public Object[] getMessageArgs() {
        return messageArgs;
    }

    /**
     * @param messageArgs the messageArgs to set
     */
    public void setMessageArgs(Object... args) {
        this.messageArgs = args;
    }
}
