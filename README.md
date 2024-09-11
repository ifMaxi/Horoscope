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

### Light Mode
| Onboarding | Onboarding |
| ------------- | ------------ |
| <img src="https://github.com/user-attachments/assets/596d51f0-ffa2-4376-b6e9-d4a1d41983b1" width="290" height="600"> | <img src="https://github.com/user-attachments/assets/d56b54c7-4f79-4bd9-a2b6-d2bdcfbe15ed" width="290" height="600"> |

| Onboarding | Notification permission |
| ------------- | ------------ |
| <img src="https://github.com/user-attachments/assets/ea502b70-5526-4098-aba4-63b83ddea902" width="290" height="600"> | <img src="https://github.com/user-attachments/assets/9870c379-9542-4866-951f-8ce817f305b4" width="290" height="600"> |

| Main | Detail |
| ------------- | ------------ |
| <img src="https://github.com/user-attachments/assets/594a1259-278c-4e68-8aba-347f832342d3" width="290" height="600"> | <img src="https://github.com/user-attachments/assets/b0064ec5-cf75-4c42-892f-ed825892d263" width="290" height="600"> |

### Dark Mode
| Onboarding | Onboarding |
| ------------- | ------------ |
| <img src="https://github.com/user-attachments/assets/88605d65-6b57-4867-ba93-59453b4d52ad" width="290" height="600"> | <img src="https://github.com/user-attachments/assets/6fa72bd1-2953-47ac-abc9-5a8539de89cc" width="290" height="600"> |

| Onboarding | Main |
| ------------- | ------------ |
| <img src="https://github.com/user-attachments/assets/a32e1d06-1616-49e8-b535-a2571780bd86" width="290" height="600"> | <img src="https://github.com/user-attachments/assets/f6826386-38e6-442a-a887-eb9737aa39dd" width="290" height="600"> |

| Detail |
| ------------- |
| <img src="https://github.com/user-attachments/assets/6780e87f-1347-4fcf-9266-d33769f49dda" width="290" height="600"> |
