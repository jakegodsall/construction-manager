# Construction Manager REST API

This repository houses a backend REST API developed using Spring Boot with a MySQL database integration.
It is intended for personal use, designed to simplify the task of archiving customer information, quotations, invoices, in an easily queryable manner.

## Purpose
The motivation behind this project stems from family obligations.
After years of clumsy file system-based archiving, I decided to bite the bullet and build a basic application that facilitates simple submission of data and basic querying capabilities.

## Project Scope
Please note that this project is not intended to be a full-stack web application.
Its primary purpose is to facilitate personal bookkeeping, and it may not offer much utility beyond that specific use case.
As such, it is configured to work primarily with a local instance of MySQL.

While future development possibilities are open, including the potential addition of a web-based frontend or GUI, there are currently no concrete plans to implement these features.

## Usage Instructions
If you actually find this project useful and would like to use it, follow these simple steps:

Prerequisites
* You should have Java and Maven installed on your system.
* Ensure you have a MySQL database instance set up locally or on a remote server. Modify the `application.properties` file with your database connection details.

### Steps

Clone this repository to your local machine.
```bash
    git clone https://github.com/jakegodsall/construction-manager
```

Navigate to the project directory, build with maven and run the application.

## License
This project is licensed under the [] License - see the [LICENSE](LICENSE) file for details.
