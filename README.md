# 음식점 찾기 모듈 Find Restaurant Module

음식점 찾기 기능을 제공하는 모듈
기능이 복잡하여 여러 모듈로 나눠 개발

# 음식점 찾기 지원 모듈

- 필터 모듈
음식점 종류, 평점, 거리, 지역 등을 선택 하는 기능

- 음식점 카드 모듈
음식점 정보를 카드 UI 제공

- 맵 모듈
지도, 음식점 마커, 마지막 위치 저장 등 지도 관련 기능 제공

- 음식점 리스트 bottom sheet 모듈
음식점 리스트를 bottom sheet 리스트로 제공


```
git submodule add https://github.com/sarang628/repository.git
git submodule add https://github.com/sarang628/finding_di.git
git submodule add https://github.com/sarang628/image.git
git submodule add https://github.com/sarang628/pinchzoom.git
git submodule add https://github.com/sarang628/filter_di.git
git submodule add https://github.com/sarang628/map_di.git
git submodule add https://github.com/sarang628/cardinfo_di.git
git submodule add https://github.com/sarang628/TorangToml
```


# Tech Stack
- JetpackCompose
- Android App Architecture
  - UILayer
  - DomainLayer