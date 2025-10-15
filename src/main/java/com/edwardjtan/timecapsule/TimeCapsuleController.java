package com.edwardjtan.timecapsule;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

record CapsuleRequest(
    String email,
    String message,
    LocalDateTime scheduledSendDate
) {}

@RestController
@RequestMapping("/api/capsules")
public class TimeCapsuleController {

    /**
     * create a new time Capsule
     * @param capsuleRequest inclues the Post request
     * @return return received datas
     */
    @PostMapping
    public CapsuleRequest createCapsule(
        @RequestBody CapsuleRequest capsuleRequest
    ) {
        System.out.println("Received new capsule " + capsuleRequest);

        return capsuleRequest;
    }
}
