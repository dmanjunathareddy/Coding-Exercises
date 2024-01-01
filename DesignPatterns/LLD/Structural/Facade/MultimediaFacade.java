package com.softgroup.structural.designpatterns.facade;

public class MultimediaFacade {
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;
    private ImageLoader imageLoader;

    public MultimediaFacade() {
        this.audioPlayer = new AudioPlayer();
        this.videoPlayer = new VideoPlayer();
        this.imageLoader = new ImageLoader();
    }

    public void playMedia(String fileType, String file) {
        switch (fileType.toLowerCase()) {
            case "audio":
                audioPlayer.playAudio(file);
                break;
            case "video":
                videoPlayer.playVideo(file);
                break;
            case "image":
                imageLoader.loadImage(file);
                break;
            default:
                System.out.println("Unsupported media type");
        }
    }
}