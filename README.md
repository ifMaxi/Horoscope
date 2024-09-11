# Horoscope

Horoscope app, created with Kotlin and Jetpack compose. 🔮
,
## Description

Simple horoscope app that shows a list of all zodiac signs and their daily, weekly and monthly horoscopes. 
Gets data from the API [Horoscope Api](https://horoscope-app-api.vercel.app/).
The app features pre-scheduled daily notifications to inform the user that a new horoscope is available, it has an onboarding screen for the welcome, this will only be visible during the first start of the app, it also does not have "Offline first" support since I did not notice that it was a necessary feature, it also has support for light/dark mode. It is written in Kotlin and Jetpack compose, while also using several jetpack android libraries and third-party libraries.

> [!NOTE]
> An Api-Key is not required to use the app.

## Architecture

The architecture used is the one recommended by Google, usually called MVVM (Model - View - ViewModel)

This is divided into:

- Model: Which represents the data and business logic
- View: Which represents the UI
- ViewModel: Which represents the bridge between the View and the Model

![Mvvm arch](https://github.com/user-attachments/assets/011add8b-cd32-4ae7-b78e-60a2ca578a59)

## Api

The API used is from [Horoscope Api](https://horoscope-app-api.vercel.app/).

## Language and libraries

- **Kotlin**
  - Serialization
  - Coroutines
  - Kps
- **Android**
  - Intents
  - Notifications
- **Jetpack Libraries**
  - Compose
  - Material 3
  - Hilt
  - ViewModel
  - Navigation
  - Preferences Data Store
  - Splash Screen
- **Other libraries**
  - Retrofit
  - OkHttp
  - Lottie

## Captures

- TODO
