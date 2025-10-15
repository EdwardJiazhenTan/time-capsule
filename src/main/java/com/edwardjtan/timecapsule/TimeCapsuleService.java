package com.edwardjtan.timecapsule;

import org.springframework.stereotype.Service;

@Service
public class TimeCapsuleService {

    private final TimeCapsuleRepository timeCapsuleRepository;

    public TimeCapsuleService(TimeCapsuleRepository timeCapsuleRepository) {
        this.timeCapsuleRepository = timeCapsuleRepository;
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
}
