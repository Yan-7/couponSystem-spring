package Yan.Coupons2.exceptions;

public class CouponsException extends  RuntimeException {


    public CouponsException() {
        super();
    }

    public CouponsException(String message) {
        super(message);
    }

    public CouponsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CouponsException(Throwable cause) {
        super(cause);
    }


}