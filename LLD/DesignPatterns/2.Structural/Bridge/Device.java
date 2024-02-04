package com.softgroup.structural.designpatterns.bridge;

interface Device {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
}