package com.edwardjtan.timecapsule;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final TimeCapsuleService timeCapsuleService;
    private final EmailService emailService;

    public TimeCapsuleController(
        TimeCapsuleService timeCapsuleService,
        EmailService emailService
    ) {
        this.timeCapsuleService = timeCapsuleService;
        this.emailService = emailService;
    }

    /**
     * create a new time Capsule
     * @param capsuleRequest inclues the Post request
     * @return return received datas
     */
    @PostMapping
    public TimeCapsule createCapsule(
        @RequestBody CapsuleRequest capsuleRequest
    ) {
        return timeCapsuleService.createCapsule(capsuleRequest);
    }

    @GetMapping("/test-email")
    public String testEmail() {
        String testRecipient = "edwardjiazhentan@gmail.com";
        emailService.sendEmail(
            testRecipient,
            "Tiem Capsule Test Email",
            "this is a test email.. what up"
        );
        return "Email test endpoint called, yoyo";
    }
}
