package entities;

/**
 * @author amir
 * @since 11/9/19
 */
public enum HttpStatusCode {

    OK(200),
    CREATE(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    PAYMENT_REQUIRED(402),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    NOT_ACCEPTABLE(406),
    CONFLICT(409),
    METHOD_FAILURE(420),
    UNPROCESSABLE_ENTITY(422),
    TOO_MANY(429),
    INTERNAL_SERVER_ERROR(500),
    BAD_GATEWAY(502);

    private int code;

    public int getCode() {
        return this.code;
    }

    HttpStatusCode(int code) {
        this.code = code;
    }
}
