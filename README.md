# Time Capsule

A Spring Boot application that allows users to send messages to their future selves via email.

## Tech Stack
- **Backend**: Spring Boot 3.5.6
- **Java**: 21
- **Database**: PostgreSQL
- **Email**: JavaMailSender
- **Scheduling**: Spring @Scheduled
- **Deployment**: AWS (planned)

## Prerequisites

- **Java**: 21
- **Spring Boot**: 3.5.6
- **PostgreSQL**: 14+ (running locally)
- **Maven**: 3.6+ (wrapper included)

## How to Run

### 1. Set up PostgreSQL database

```bash
# Create the database
psql postgres -c "CREATE DATABASE timecapsule_db;"
```

### 2. Set environment variables

```bash
export DB_USERNAME=your_postgres_username
export DB_PASSWORD=your_postgres_password  # leave empty if no password
```

### 3. Run the application

```bash
# Clean build and run
./mvnw clean spring-boot:run

# Or just run
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

### 4. Verify database setup

```bash
# Check if table was created
psql -U your_username -d timecapsule_db -c "\dt"
```

## Development Roadmap

- [x] **Phase 1a: Database Setup** - PostgreSQL schema and connection
- [ ] **Phase 1b: MVP** - Core time capsule functionality (no auth)
  - Create capsule (email + message + send date)
  - Store in PostgreSQL
  - Scheduled email delivery
- [ ] **Phase 2: Authentication** - User login/registration (Spring Security)
- [ ] **Phase 3: Management** - View, edit, and cancel pending capsules
- [ ] **Phase 4: History** - View sent capsules
- [ ] **Phase 5: Frontend** - Simple web UI
- [ ] **Phase 6: Deployment** - Host on AWS

## Current Phase
Phase 1b: Building core time capsule functionality
