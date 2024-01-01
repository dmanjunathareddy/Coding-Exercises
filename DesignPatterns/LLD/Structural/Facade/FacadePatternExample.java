package com.softgroup.structural.designpatterns.facade;

public class FacadePatternExample {
    public static void main(String[] args) {
        MultimediaFacade multimediaFacade = new MultimediaFacade();

        // Client interacts with the simplified facade
        multimediaFacade.playMedia("audio", "song.mp3");
        multimediaFacade.playMedia("video", "movie.mp4");
        multimediaFacade.playMedia("image", "photo.jpg");
    }
}