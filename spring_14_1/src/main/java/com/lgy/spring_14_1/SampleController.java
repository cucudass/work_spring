package com.lgy.spring_14_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgy.spring_14_1.domain.MemberVO;
import com.lgy.spring_14_1.domain.SampleVO;
import com.lgy.spring_14_1.domain.TicketVO;

import lombok.extern.slf4j.Slf4j;

//@Controller
@RestController	//pom.xml 설정되어야 사용 가능
@RequestMapping("/sample")
@Slf4j
public class SampleController {
	//@RestController 추가되어야 사용 가능
//	@GetMapping(value = "/getSample")
//	xml 이나 json 데이터 잘 안나올때 추가
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
//		스트림, 람다식은 프로젝트 설정에서 java compiler version 확인
		return IntStream.range(1, 10).mapToObj(i->new SampleVO(i, i+"First", i+"Last"))
									 .collect(Collectors.toList());
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		return map;
	}
	
//	ResponseEntity : 데이터+http 상태코드를 전달
	@GetMapping(value = "/check", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo=new SampleVO(0, ""+height, ""+weight);
		ResponseEntity<SampleVO> result=null;
		
		if (height < 150) {
//			HttpStatus.BAD_GATEWAY : http 오류 상태
//			http://localhost:8080/spring_14_1/sample/check?height=140&weight=40 502
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
//			HttpStatus.OK : http 정상 상태
//			http://localhost:8080/spring_14_1/sample/check?height=150&weight=60 콘솔창에 비어있음
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") int pid) {
		return new String[] {"category : "+cat, "product id : "+pid};
	}
	
	@PostMapping("/ticket")
//	public TicketVO convert(TicketVO ticketVO) {
//	@RequestBody : 전송된 json 데이터를 TicketVO 타입의 객체로 변환
	public TicketVO convert(@RequestBody TicketVO ticketVO) {
		log.info("@# ticketVO 1=>"+ticketVO);
		System.out.println("@# ticketVO 2=>"+ticketVO);
		
		return ticketVO;
	}
	
	@PostMapping("/info")
	public MemberVO convert(@RequestBody MemberVO memberVO) {
		log.info("@# memberVO =>"+memberVO);
		
		return memberVO;
	}
}