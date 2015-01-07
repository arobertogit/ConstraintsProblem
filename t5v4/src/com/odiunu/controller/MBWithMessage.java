package com.odiunu.controller;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
public interface MBWithMessage {
    default String getMessage() {
        return "Default message";
    }
}
