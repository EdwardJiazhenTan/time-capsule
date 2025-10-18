package com.edwardjtan.timecapsule;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeCapsuleRepository
    extends JpaRepository<TimeCapsule, Long> {
    List<TimeCapsule> findByStatusAndScheduledSendDateLessThanEqual(
        String status,
        LocalDateTime now
    );
}
