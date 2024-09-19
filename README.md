![image](https://github.com/user-attachments/assets/a92d3ea9-9bbe-46c6-8eec-a40c89b7f50a)
# Weather App

Welcome to the Weather App! This Android application provides users with an intuitive interface to search for weather details in their desired cities and view a five-day weather forecast.

![image](https://github.com/user-attachments/assets/6d02c515-0c6e-44d7-b1cc-aa18e28c44af)

## Features

- **City Search**: Easily search for any city to get the current weather details.
- **Today's Weather Details**: View today's weather, including:
  - Temperature
  - Weather Conditions
  - Wind Speed
  - Humidity
- **Five-Day Forecast**: Access a detailed forecast for the next five days, showing:
  - Date
  - Weather Conditions
  - High and Low Temperatures

## Architecture

This project follows the **Clean Architecture** principles, ensuring a well-structured and maintainable codebase. The app utilizes the **MVVM (Model-View-ViewModel)** pattern to separate UI and business logic, making it easy to manage and test.

![image](https://github.com/user-attachments/assets/81e50b9e-8f22-4118-a1a8-e945a83e8d1c)

### Multi-Module Structure

The project is organized into multiple modules to promote separation of concerns and enhance code reusability. Each module is responsible for specific features or functionalities, making it easier to maintain and scale the application.

![image](https://github.com/user-attachments/assets/bb1fce89-1864-477b-9124-1b1d1203da6f)

### Data Binding

The app employs **Data Binding** to create a more dynamic and responsive UI. This allows for binding UI components directly to data sources, minimizing boilerplate code and enhancing readability.

## Technologies Used

- **Retrofit**: For making network requests to retrieve weather data.
- **Caching Framework**: To store weather data locally for quick access.

![image](https://github.com/user-attachments/assets/7eead61b-3151-46a9-a3fc-4ca2f3fb545b)

- **Navigation Component**: For seamless navigation between the app's screens.

![image](https://github.com/user-attachments/assets/d485a296-ce1c-49ba-9338-304d20f899ef) 

- **Hilt**: For dependency injection, making the code cleaner and easier to manage.
- **Glide**: To efficiently load and display weather-related images.

## Screens

1. **Search Screen**: Enter a city name to fetch its weather details.
2. **Today's Weather Screen**: Displays current weather metrics and to navigate to the five-day forecast.
3. **Five-Day Forecast Screen**: Lists the weather details for the next five days.

## Prerequisites

Make sure you have the following installed:

- [Android Studio](https://developer.android.com/studio)
- [Java Development Kit (JDK) 17]
- Android SDK (set up via Android Studio)
- [Gradle](https://gradle.org/install/) (if you want to use the command line)

## Installation
To run this project locally, follow these steps:
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/mayanksharmaexperiments/Weather-App.git
2. Open the project in Android Studio.
3. Build the project and run it on your Android device or emulator.

## License
   ```bash
Copyright (C) 2024

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
