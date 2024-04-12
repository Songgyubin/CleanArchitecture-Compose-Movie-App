# CleanArchitecture-Compose-Movie-App
🚧 현재 진행중인 프로젝트입니다.

[TMDB API]
CleanArchitecture와 Compose를 사용한 영화 정보 앱

클린아키텍처 기반의 멀티 모듈 구조의 앱입니다.

# 화면
![KakaoTalk_Photo_2024-04-16-11-18-37](https://github.com/Songgyubin/CleanArchitecture-Compose-Movie-App/assets/37494776/ac9d928a-7082-4c52-9046-7b8efcfc7d58)


# 모듈화 구조
<img width="1197" alt="image" src="https://github.com/Songgyubin/CleanArchitecture-Compose-Movie-App/assets/37494776/fb36964d-bd23-4845-b794-bf370e17b8b8">


# 아키텍처 및 주요 의존 관계
<img width="1761" alt="image" src="https://github.com/Songgyubin/CleanArchitecture-Compose-Movie-App/assets/37494776/09727847-efa2-42fb-a782-4f2c656e8992">
관심사 분리 및 체계적인 계층 구조를 위해 **CleanArchitecture를** 도입하였습니다.

Domain Layer와 Data Layer 간 **의존성 역전을 위한 Repository 패턴을** 적용함으로써,


기술 인프라 변경, 확장에 대해 비즈니스 로직을 담당하는 **Domain Layer에 가는 영향을 최소화** 시키려 했습니다.

### 기본 구조
**CleanArchitecture** 기반의 멀티 모듈 구조로 기본적으로 **app, data, domain** 모듈이 나뉘어져 있습니다.

### Core 모듈
`data`, `domain`, `network`, `common` 모듈을 포함하는 모듈입니다.

처음 생각했던 모듈 구조는 `app` 모듈에서 `core` 모듈을 직접 의존하는 것이 아닌,

`feature` 모듈을 두어 `app` -> `feature:섹션, feature:찜 ...` -> `core` 식의 구조를 가져가려 했지만,

시간 상 `app` -> `core` 모듈 의존 구조로 구현했습니다.

### Common 모듈
**유틸 함수 및 헬퍼를** 관리할 수 있는 모듈입니다.

### Network 모듈
**네트워크 통신 및 응답 모델을** 담당하는 모듈입니다.

현재는 Retrofit만을 사용하기에 '굳이'라는 생각이 들 수도 있지만,

확장성을 고려하여 프로젝트를 진행한다면 Network 모듈을 두어 네트워크 통신에 관한 설정을 이 모듈에서 관리하려고 했습니다.

### Design 모듈
**UI 컴포넌트 및 디자인 시스템 관리**를 담당하는 모듈입니다.

# 사용 스킬

### 언어 및 아키텍처

- Kotlin
- Clean Architecture
- MVVM

### UI 및 상태 관리

- ViewModel
- Compose

### 네트워크 통신

- Retrofit
- OkHttp

### 비동기 처리 및 반응형 프로그래밍

- Coroutine
- Flow

### 의존성 주입

- Hilt

### 이미지 로드

- Coil

