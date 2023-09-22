# ✈️ Airport Service App

<br />

## 🔷 Stack of used technologies
- Spring
- Maven
- Vaadin Framework
- Docker
- PostgreSQL
- Redis

<br />

## 🔷 Tasks

<br />

The developed app solves the following tasks:

1. Updated and improved ticket reservation system through the web application;
2. The possibility of authorization to the system, thanks to which the necessary functionality is provided to airport employees;
3. Possibility to return the reserved ticket through the web application;
4. The possibility of instant tracking of available flights and seats on planes;
5. Forming a document of the purchased ticket with personal data of the passenger and details of the selected flight and place;
6. Forming a report on the amount of fuel consumed for each specific flight, taking into account the time of the flight;
7. Formation of a list of flights departing from the airport in the specified period of time;
8. The ability to carry out passport control and passenger safety control, as well as to establish the result of success or problems encountered during the check of passports or passengers;
9. Monitoring of tickets sold for flights provided by the airport, together with the ability to register a boarding pass based on baggage data and ticket number, as well as the ability to track all flight boarding passes issued;
10. The ability to control the process of boarding passengers on airplanes assigned to the relevant flights, reporting success or existing problems at the stage of checking passengers' documents.

<br />

## 🔷 UML Class Diagram

<br />

The class architecture for the design object consists of the following elements:

- Data models – database entity classes (Passenger, Ticket, Flight, Aircraft, Seat, SeatPlace, BoardingPass, Luggage, LuggageType, LuggageControl, SecurityControl, BoardingControl, User).
- _Repository interfaces – inherited from ready-made interfaces for accessing database entities.
- _Service interfaces – concentrate prototypes of data access methods.
- _ServiceImpl classes – using _Repository implement methods of _Service interfaces for data access.
- _Controller classes – using _ServiceImpl are responsible for executing business logic.

<br />

<img src="https://drive.google.com/uc?export=view&id=1-yNPlYtlnokcAyHk_dhmaoZLxtl1pbbf" alt="uml-class-diagram" width="700">

<br />

## 🔷 UML Case diagram

<br />

The following users can be identified in our system:

- Passenger
- Registration agent
- Manager
- Security officer

<br />

<img src="https://drive.google.com/uc?export=view&id=1jsm3S8AsOmpOcvL9NalSyV_bW_WLMF-O" alt="uml-case-diagram" width="700">

<br />

## 🔷 Databases

<br />

The developed app uses two databases: PostgreSQL (relational) and Redis (key/value).

- Relational database gathers basic information and contains data about tickets and airport operations.
- The key/value database contains data about employee roles and passwords.

<br />

<img src="https://drive.google.com/uc?export=view&id=13Cft9zPZFXBWJiuYDlmyhP3JxkLH5FZd" alt="er-diagram" width="700">

The logical schema of the database contains the following relationships between entities:

• ONE-TO-MANY:

- One passenger can have many tickets, but a separate ticket can belong to only one passenger;
- One flight can belong to many tickets, but a separate ticket can contain only one flight;
- One aircraft can perform many flights, but a separate flight is performed by a specific aircraft.
- One aircraft has many seats, but a certain seat belongs to the scheme of a certain aircraft model.
- One type of luggage (luggage_type) can belong to many pieces of luggage (luggage), but individual luggage can belong to only one type
  
• ONE-TO-ONE:

- One ticket (ticket) belongs to a certain place in the plane (seat_place)
- A separate boarding pass (boarding_pass) is formed on the basis of the corresponding ticket (ticket)
- A separate boarding pass (boarding_pass) contains one piece of luggage
- A certain boarding pass (boarding_pass) and/or a separate passenger (passenger) is contained in one record of passing controls (security_check, luggage_check, boarding_check)
  
• MANY-TO-MANY:

- Each flight contains a list of seats available for reservation, at the same time, each seat can be found in different flights.

It is worth noting that an additional table (seat_place) has been created to represent this relationship, which ensures the achievement of various combinations, and its is_reserved attribute provides the ability for an individual flight to mark seats as available or selected.

<br />

## 🔷 User interface

<br />

Web app interface:
- implements all necessary functionality;
- is convenient to use and intuitive for both the potential passenger and the employee (Fig. 4.3.1);
- contains the necessary notifications, for example, a message about errors in case of incorrectly entered data (Fig. 4.3.2);
- able to cope with unpredictable usage scenarios.

<br />

<img src="https://drive.google.com/uc?export=view&id=1deqR4tHoZ-jSUNCGqQoxhXWOmbiTO8ai" alt="interface-1" width="700">
<img src="https://drive.google.com/uc?export=view&id=1H1yUanRBbehTFRwPGevLNM3m_2jtZFnm" alt="interface-2" width="700">


