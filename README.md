# 🏆 Quick Coach – Android Application

Quick Coach is a feature-rich Android application designed to streamline communication and performance tracking between coaches and players. The app provides structured interaction, event management, real-time updates, and secure authentication.

Built using modern Android development practices with Firebase integration.

---

## 📱 App Overview

Quick Coach helps sports coaches and players stay connected through a centralized platform. Coaches can manage players, events, and updates, while players can track performance and stay informed.

This project demonstrates role-based authentication, real-time database integration, and clean Android UI design.

---

## ✨ Key Features

### 🔐 Authentication System
- Firebase Authentication
- Role-based login (Coach / Player)
- Secure password reset functionality

### 👥 Role-Based Access
- Separate dashboards for Coaches and Players
- Controlled feature access based on user type

### 📅 Event Management
- Create and manage training sessions
- View event details
- Real-time updates using Firebase Firestore

### 💬 Communication
- Structured interaction between coaches and players

### 📊 Performance Tracking
- Player level tracking
- Profile management
- Cloud-based data storage

### 🎨 Modern UI
- XML-based responsive layouts
- Clean and intuitive design
- Custom UI components

---

## 🛠 Tech Stack

- **Language:** Kotlin  
- **UI:** XML  
- **Database:** Firebase Firestore  
- **Authentication:** Firebase Auth  
- **Cloud Storage:** Firebase  
- **Version Control:** Git & GitHub  

---

## 📂 Project Structure

```
QuickCoach/
│
├── app/
│   ├── java/com.quickcoach/
│   │   ├── activities/
│   │   ├── adapters/
│   │   ├── models/
│   │   └── utils/
│   ├── res/
│   │   ├── layout/
│   │   ├── drawable/
│   │   └── values/
│   └── AndroidManifest.xml
│
├── build.gradle
└── settings.gradle
```

---

## 🚀 How to Run the Project

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/quick-coach-android-app.git
   ```
2. Open the project in Android Studio  
3. Add your own `google-services.json` file  
4. Enable Firebase Authentication and Firestore  
5. Sync Gradle and run on emulator or physical device  

---

## 🔒 Firebase Setup Required

For security reasons, the `google-services.json` file is not included.

To run this project:
- Create a Firebase project
- Enable Email/Password authentication
- Enable Firestore Database
- Download `google-services.json`
- Place it inside the `app/` folder

---

## 📌 Future Improvements

- Push Notifications (Firebase Cloud Messaging)
- Chat module enhancement
- MVVM architecture refactor
- Unit testing integration

---

## 👨‍💻 Developer

**Mayank Bhadakan**  
Master’s in Computer Science  
Android Developer | Kotlin | Firebase  

LinkedIn: https://www.linkedin.com/in/mayank-bhadakan
