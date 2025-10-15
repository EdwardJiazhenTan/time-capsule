package com.edwardjtan.timecapsule;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "time_capsules")
public class TimeCapsule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String message;

    @Column(name = "scheduled_send_date")
    private LocalDateTime scheduledSendDate;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "send_at")
    private LocalDateTime sentAt;

    public TimeCapsule() {}

    public TimeCapsule(
        String email,
        String message,
        LocalDateTime scheduledSendDate
    ) {
        this.email = email;
        this.message = message;
        this.scheduledSendDate = scheduledSendDate;
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    public String getEmail() {
        return this.email;
    }

    public String getMessage() {
        return this.message;
    }

    public LocalDateTime getScheuledSendDate() {
        return this.scheduledSendDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setScheuledSendDate(LocalDateTime scheduledSendDate) {
        this.scheduledSendDate = scheduledSendDate;
    }

    @Override
    public String toString() {
        return (
            "TimeCapsule{" +
            "id=" +
            id +
            ", email='" +
            email +
            '\'' +
            ", status='" +
            status +
            '\'' +
            '}'
        );
    }
}
