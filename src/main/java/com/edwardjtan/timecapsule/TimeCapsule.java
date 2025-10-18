package com.edwardjtan.timecapsule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.springframework.cglib.core.Local;

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

    @Column(name = "sent_at")
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

    public LocalDateTime getScheduledSendDate() {
        return this.scheduledSendDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setScheduledSendDate(LocalDateTime scheduledSendDate) {
        this.scheduledSendDate = scheduledSendDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getSentAt() {
        return this.sentAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
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
