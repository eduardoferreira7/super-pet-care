package br.com.superpetcare.superpetcare.controller.exception;

public class ControlerNotFoundException extends RuntimeException{

    public ControlerNotFoundException(String message){
        super(message);
    }

}
