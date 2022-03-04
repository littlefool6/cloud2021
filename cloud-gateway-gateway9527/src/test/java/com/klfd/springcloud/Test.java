package com.klfd.springcloud;

import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;

@Slf4j
public class Test {

    @org.junit.Test
    public void test() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
