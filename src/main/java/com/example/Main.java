package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Country: " + Locale.ROOT.getCountry() + "Language and Display Language, Respectively: " + Locale.ROOT.getLanguage() + ", " + Locale.ROOT.getDisplayLanguage());
    }
}
