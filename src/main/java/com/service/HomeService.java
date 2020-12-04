package com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/3/2020
 */

@Service
@Slf4j
public class HomeService {

    public String getDate(Locale locale){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        return dateFormat.format(date);
    }
}
