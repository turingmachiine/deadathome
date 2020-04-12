package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageServiceImpl implements MessageService {

    public void sendMessage(String number, String name, String confirmCode) {
        RestTemplate restTemplate = new RestTemplate();
        String messageServiceUrl = "https://gate.smsaero.ru/v2/sms/send";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("strvtxv@gmail.com", "uhV0mVV2Ipmwx4gewE5ZICFolUZi");
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("sign", "SMS Aero");
        map.add("channel", "DIRECT");
        map.add("number", number);
        map.add("text", name + ", please, confirm your account. Here is your confirm code. To verify your account, paste this on site: "
                + "confirm/" + confirmCode);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        restTemplate.postForEntity(messageServiceUrl, request , String.class);
    }
}
