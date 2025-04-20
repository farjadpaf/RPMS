# Remote Patient Monitoring System (RPMS)

A Java-based hospital management system that enables remote patient monitoring, appointment scheduling, and emergency alerts.

## 🔍 How the System Works

### 🏥 Core Functionality
The RPMS has **4 main user roles**, each with specific capabilities:

1. **Patient Portal**
   - Add/view medical history
   - Monitor vital signs (heart rate, oxygen levels, etc.)
   - Schedule appointments
   - View prescriptions
   - Emergency panic button
   - Start video/chat consultations

2. **Doctor Portal**  
   - Monitor patient vitals
   - Create prescriptions
   - Provide feedback
   - View medical history
   - Initiate consultations

3. **Appointment Manager**  
   - View all appointments
   - Update appointment statuses

4. **Administrator**  
   - Manage patient-doctor assignments
   - View system records

### ⚙️ Key Technical Components
 **Notification System**
   - Email alerts for:
     - Critical vital signs (automatic detection)
     - Panic button activation
     - Appointment reminders
   - Uses JavaMail API with SMTP
