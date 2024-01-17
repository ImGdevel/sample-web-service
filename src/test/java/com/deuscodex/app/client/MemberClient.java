package com.deuscodex.app.client;

import com.deuscodex.app.dto.MemberDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class MemberClient {

    public static void main(String[] args) {
        // Member 생성을 위한 MemberDTO 객체 생성
        MemberDTO newMember = new MemberDTO();
        newMember.setName("John Doe");
        newMember.setUsername("john.doe");
        newMember.setPassword("password123");
        newMember.setEmail("john.doe@example.com");
        newMember.setPhoneNumber("123-456-7890");

        // 서버 URL 설정
        String serverUrl = "http://localhost:8080/api/members";

        // HTTP Header 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HTTP 요청을 위한 HttpEntity 생성
        HttpEntity<MemberDTO> requestEntity = new HttpEntity<>(newMember, headers);

        // Spring RestTemplate을 사용하여 POST 요청 전송
        RestTemplate restTemplate = new RestTemplate();
        MemberDTO createdMember = restTemplate.postForObject(serverUrl, requestEntity, MemberDTO.class);

        // 생성된 Member 정보 출력
        System.out.println("Created Member:");
        System.out.println(createdMember);
    }
}
