package com.example.codinghub.common.vos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    /**
     * Status code of the response.
     */
    @Schema(description = "Status code of the response", example = "200")
    private int code;

    /**
     * Message providing more details about the response.
     */
    @Schema(description = "Message providing more details about the response", example = "Success")
    private String message;

    /**
     * The actual data being returned, wrapped in this response.
     */
    @Schema(description = "The actual data being returned, wrapped in this response")
    private T data;

    /**
     * A method to quickly create a success response with data.
     *
     * @param data The data to be wrapped in the response.
     * @param <T>  The type of the data.
     * @return A CommonResponse with a success code and the provided data.
     */
    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(200, "Success", data);
    }

    /**
     * A method to quickly create an error response with a custom message.
     *
     * @param code    The error code.
     * @param message The error message.
     * @param <T>     The type of the data.
     * @return A CommonResponse with the provided error code and message.
     */
    public static <T> CommonResponse<T> error(int code, String message) {
        return new CommonResponse<>(code, message, null);
    }
}