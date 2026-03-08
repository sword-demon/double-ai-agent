package top.wjstar.common.domain.vo;

import lombok.Data;

/**
 * @author wxvirus
 * 项目统一返回结果实体定义
 */
@Data
public class R<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 泛型 数据
     */
    private T data;

    private R() {
    }

    private R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> success() {
        return new R<>(200, "success", null);
    }

    public static <T> R<T> success(T data) {
        return new R<>(200, "success", data);
    }

    public static <T> R<T> success(String msg, T data) {
        return new R<>(200, msg, data);
    }

    public static <T> R<T> error(Integer code, String msg) {
        return new R<>(code, msg, null);
    }

    public static <T> R<T> fail() {
        return new R<>(500, "fail", null);
    }

    public static <T> R<T> fail(T data) {
        return new R<>(500, "fail", data);
    }

    public static <T> R<T> fail(Integer code, T data) {
        return new R<>(code, "fail", data);
    }

    public static <T> R<T> fail(Integer code, String msg, T data) {
        return new R<>(code, msg, data);
    }

    public static <T> R<T> fail(Integer code) {
        return new R<>(code, "fail", null);
    }
}
