package com.edwardjtan.timecapsule;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TimeCapsuleService {

    private final TimeCapsuleRepository timeCapsuleRepository;
    private final EmailService emailService;

    public TimeCapsuleService(
        TimeCapsuleRepository timeCapsuleRepository,
        EmailService emailService
    ) {
        this.timeCapsuleRepository = timeCapsuleRepository;
        this.emailService = emailService;
    }

    /**
     * Create and save a new time CapsuleRequest
     * @param request DTO object, contain the data from Controller
     * @return the entity saved to database
     */
    public TimeCapsule createCapsule(CapsuleRequest request) {
        // convert DTO to entity
        TimeCapsule newCapsule = new TimeCapsule(
            request.email(),
            request.message(),
            request.scheduledSendDate()
        );

        System.out.println("saving new capsule to database");
        TimeCapsule savedCapsule = timeCapsuleRepository.save(newCapsule);
        System.out.println("capsule saved with id: " + savedCapsule.toString());

        return savedCapsule;
    }

    /**
     * we check for email we need to send and scheduled to send
     */
    @Scheduled(fixedRateString = "PT1M")
    public void monitorAndSendCapsules() {
        System.out.println(
            "scheduled: running regular chaeck for due capsules"
        );
        List<TimeCapsule> dueCapsules =
            timeCapsuleRepository.findByStatusAndScheduledSendDateLessThanEqual(
                "PENDING",
                LocalDateTime.now()
            );

        if (dueCapsules.isEmpty()) {
            System.out.println("no capsules currently");
            return;
        }

        System.out.println(
            "Scheduler: Found" +
                dueCapsules.size() +
                "capsules that scheduled to send now"
        );

        for (TimeCapsule capsule : dueCapsules) {
            try {
                System.out.println(
                    "Scheduler: processing capsule id" + capsule.getId()
                );

                emailService.sendEmail(
                    capsule.getEmail(),
                    "Your Time Capsule Has Arrived!",
                    capsule.getMessage()
                );

                capsule.setStatus("SENT");
                capsule.setSentAt(LocalDateTime.now());

                timeCapsuleRepository.save(capsule);
                System.out.println(
                    "successfully sent and updated capsule id= " +
                        capsule.getId()
                );
            } catch (Exception e) {
                System.err.println("Failed to process scheduler");
                capsule.setStatus("FAILED");
                timeCapsuleRepository.save(capsule);
                e.printStackTrace();
            }
        }
    }
}
