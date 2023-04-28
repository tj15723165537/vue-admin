package com.example.serve.utils;


import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author chenliang
 * @since 2022-10-31
 */
public class Response<T> {

    private int code = HttpStatus.OK.value();
    private String message;
    private T data;

    public static Response error(String message) {
        return error(HttpStatus.BAD_REQUEST.value(), message);
    }

    public static Response error(int code, String message) {
        Response r = new Response();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static Response ok() {
        return new Response();
    }

    public static Response okMsg(String message) {
        Response r = new Response();
        r.setMessage(message);
        return r;
    }

    public static <T> Response ok(T data) {
        Response r = new Response();
        r.setData(data);
        return r;
    }

    public static <T> Response ok(List<T> content, long total) {
        Page<T> objectPage = new Page<T>(content, total);
        return ok(objectPage);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class Page<R> {
        private List<R> content;
        private long total;

        public Page(List<R> content, long total) {
            this.content = content;
            this.total = total;
        }

        public List<R> getContent() {
            return content;
        }

        public void setContent(List<R> content) {
            this.content = content;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }
    }

}
