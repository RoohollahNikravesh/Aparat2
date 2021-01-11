package com.example.aparat2.webservice;

public interface IMessageListener<T> {
    public void onSuccess(T ResponseMessage );
    public void onFailure(String errorResponseMessage);
}
