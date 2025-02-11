# **CheckMyTrip - Consumer API**

CheckMyTrip is a **Spring Boot-based consumer application** that interacts with the **IRCTC Provider API** to enable users to **book, view, and download train tickets**. This application acts as a client that communicates with the IRCTC API for ticket-related operations.

## **Features** 🚀

✅ **Book Tickets** – Users can enter their journey details and book a ticket.\
✅ **View Booked Tickets** – Fetch and display all booked tickets from the provider API.\
✅ **Download Ticket by PNR** – Retrieve ticket details using a PNR number.\
✅ **User-Friendly UI** – Built with Thymeleaf and Bootstrap for a smooth experience.

## **Technology Stack** 🛠

- **Backend**: Spring Boot (Spring MVC, RestTemplate)
- **Frontend**: Thymeleaf, HTML, CSS, Bootstrap
- **Data Handling**: Java DTOs & Models
- **API Communication**: REST API (Interacts with IRCTC Provider API)

## **How It Works?** ⚙️

1️⃣ User books a ticket via a form submission.\
2️⃣ The request is sent to the **IRCTC Provider API**.\
3️⃣ If successful, a PNR is generated and displayed.\
4️⃣ Users can **view all booked tickets** and **download a ticket using PNR**.

## **Endpoints**

| **Endpoint**       | **Description**                 | **Method** |
| ------------------ | ------------------------------- | ---------- |
| `/`                | Load booking form               | `GET`      |
| `/book-ticket`     | Book a new ticket               | `POST`     |
| `/view`            | View all booked tickets         | `GET`      |
| `/download`        | Load PNR input form             | `GET`      |
| `/download-ticket` | Fetch ticket by PNR and display | `POST`     |

## **Setup & Run Locally** 🖥

### **Prerequisites:**

✔ Java 17+\
✔ Maven\
✔ [IRCTC Provider API](https://github.com/ChaitanyaKhowal/IRCTC-Provider) running on `localhost:8080`

### **Steps to Run:**

```sh
# Clone the repository
git clone https://github.com/yourusername/CheckMyTrip-Consumer.git
cd CheckMyTrip-Consumer

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

## **Screenshots** 🖼

*Add UI screenshots here (if available).*

## **Author**

👨‍💻 **Chaitanya Khowal**\
📩 [Email](mailto\:chaitanyakhowal8@gmail.com)\
🔗 [LinkedIn](https://www.linkedin.com/in/chaitanya-khowal-331b47272/)\
🐙 [GitHub](https://github.com/ChaitanyaKhowal)

