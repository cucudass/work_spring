package com.lgy.spring_14_1;

import lombok.extern.slf4j.Slf4j;

//@Log4j 보안이슈
@Slf4j //로그 처리
public class Test {
	public static void main(String[] args) {
		System.out.println("test01");
		log.info("test02 info");
		log.debug("test03 debug");
	}
}