# Notes_Making_Application

## Project Overview
The **Notes_Making_Application** is designed to allow users to save, retrieve, and manage their notes efficiently. This application ensures secure access through user authentication and provides features like fetching recent notes, maintaining a history of notes, and adhering to specific validation rules.

---

## Use Cases
### 1. Store Notes for Different Users
- The system securely stores notes for multiple users, ensuring data segregation and privacy.

### 2. Retrieve Recent Notes
- After a successful login, the application retrieves and displays the most recent 10 notes for the user.

### 3. Hourly Cleanup of Notes
- The system automatically deletes all notes older than the last 10 recent notes every hour.

### 4. Note Deletion
- Users can delete specific notes at their discretion.

---

## Validation Rules
1. **Allowed Special Characters:**
   - Notes can include only the following special characters: `@`, `;`, `&`, `*`, `+`, `-`.
2. **Character Limit:**
   - Each note cannot exceed 500 characters.
3. **Manual Deletion:**
   - Users can delete their notes manually if required.

---

## Technologies Used
### Backend
- **Java 8**: Core language for application logic.
- **Spring Boot**: Framework for building and managing RESTful APIs.
- **JPA (Java Persistence API)**: ORM tool for database interactions.

### Frontend
- **Angular**: Framework for building the user interface.

---

## Features
1. **User Authentication:**
   - Login system to ensure secure access.
2. **Recent Notes Retrieval:**
   - Fetch the last 10 notes upon login.
3. **Hourly Cleanup:**
   - Scheduled task to delete notes older than the most recent 10 notes.
4. **Note Management:**
   - Add, view, and delete notes.
5. **Validation:**
   - Ensure notes comply with character and length restrictions.

---

## Setup and Installation
1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   ```

2. **Backend Setup:**
   - Navigate to the backend folder.
   - Build the Spring Boot application using Maven:
     ```bash
     mvn clean install
     ```
   - Run the application:
     ```bash
     mvn spring-boot:run
     ```

3. **Frontend Setup:**
   - Navigate to the Angular project folder.
   - Install dependencies:
     ```bash
     npm install
     ```
   - Start the Angular application:
     ```bash
     ng serve
     ```

4. **Access the Application:**
   - Open a browser and navigate to:
     ```
     http://localhost:<frontend-port>
     ```

---

## Future Enhancements
1. Add functionality for categorizing notes.
2. Implement search and filter options.
3. Add a dashboard for analytics on notes usage.
4. Enable multi-factor authentication for enhanced security.

---

## Contribution
Feel free to contribute by submitting issues or pull requests to enhance the application.

---

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

