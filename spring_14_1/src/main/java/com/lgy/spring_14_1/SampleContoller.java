package com.lgy.spring_14_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgy.spring_14_1.domain.MemberVO;
import com.lgy.spring_14_1.domain.SampleVO;
import com.lgy.spring_14_1.domain.TicketVO;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@RestController //pom.xml 설정되어야 사용 가능
@RequestMapping("/sample")
@Slf4j
public class SampleContoller {
	//@RestController가 추가되어야 사용 가능
	//produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE} xml이나 json 데이터 잘 안나올때 추가
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping(value = "/getList")
	public List<SampleVO> getList(){
		//스트림, 람다식은 프로젝트 설정에서 java compiler version 확인
		return IntStream.range(1, 10).mapToObj(i->new SampleVO(i, i+"First", i+"Second")).collect(Collectors.toList());
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		return map;
	}
	
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(double height, double weight) {
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		ResponseEntity<SampleVO> result = null;
		if(height < 150) {
			//HttpStatus.BAD_GATEWAY : http 오류 상태
			//http://localhost:8282/spring_14_1/sample/check?height=150&weight=60 502 에러
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			//HttpStatus.OK : http 정상 상태
			//http://localhost:8282/spring_14_1/sample/check?height=150&weight=60 정상
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@GetMapping(value = "/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") int pid) {
		return new String[] {"category : "+cat, "product id : "+pid};
	}
	
	@PostMapping(value = "/ticket")
	//@RequestBody : 전송된 json 데이터를 TicketVO 객체에 맞게 변환
	public TicketVO convert(@RequestBody TicketVO ticketVO) {
		log.info("@# ticketVO 1 =>"+ticketVO);
		System.out.println("@# ticketVO 2 =>"+ticketVO);
		
		return ticketVO;
	}
	
	@PostMapping(value = "/info")
	public MemberVO convert(@RequestBody MemberVO memberVO) {
		log.info("@# memberVO=>"+memberVO);
		
		return memberVO;
	}
}
