# Time Capsule

A Spring Boot application that allows users to send messages to their future selves via email.

## Tech Stack
- **Backend**: Spring Boot (Java)
- **Database**: PostgreSQL
- **Email**: JavaMailSender
- **Scheduling**: Spring @Scheduled
- **Deployment**: AWS (planned)

## Development Roadmap

- [ ] **Phase 1: MVP** - Core time capsule functionality (no auth)
  - Create capsule (email + message + send date)
  - Store in PostgreSQL
  - Scheduled email delivery
- [ ] **Phase 2: Authentication** - User login/registration (Spring Security)
- [ ] **Phase 3: Management** - View, edit, and cancel pending capsules
- [ ] **Phase 4: History** - View sent capsules
- [ ] **Phase 5: Frontend** - Simple web UI
- [ ] **Phase 6: Deployment** - Host on AWS
