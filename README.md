# leeminyoung-tic-asd-bio
This repository contains selected contributions by Lee Minyoung from the BDSP_S project.


# 🧠 BDSP_S 프로젝트 개발 기여 (이민영)

본 저장소는 BDSP_S 프로젝트에서 본인이 직접 개발 및 유지보수한 핵심 모듈만을 정리한 이력서용 코드 아카이브입니다.  
Spring MVC 아키텍처 기반의 백엔드와 JSP 기반 프론트엔드로 구성되어 있으며, Java 백엔드 로직과 VO/DAO 계층, JSP 기반 프론트엔드로 구성되어 있습니다. 주요 구조 및 담당 기능을 아래에 정리하였습니다.

---

## 📁 프로젝트 디렉토리 구조

```
BDSP_S/
├── .settings/                     # 이클립스 환경설정
├── src/
│   └── medical/
│       ├── analysis/             # 분석 기능
│       │   ├── service/
│       │   │   ├── impl/
│       │   │   │   └── AnalysisDAO.java, *.Mapper.java, ServiceImpl.java
│       │   │   ├── *.java        # 분석 관련 VO 및 Service
│       │   └── web/
│       │       └── AnalysisController.java
│       ├── clinician/            # 임상 데이터 처리
│       │   ├── service/
│       │   │   ├── impl/
│       │   │   │   └── ClinicianDAO.java, *.Mapper.java, ClinicianServiceImpl.java
│       │   │   ├── *.java        # Clinician VO 및 인터페이스
│       │   └── web/
│       │       └── clinicianController.java
│       ├── common/               # 공통 설정
│       │   ├── config/           # 프로퍼티, XML 설정
│       │   ├── sqlmap/           # MyBatis 매퍼
│       │   └── service/AbstractService.java
│       └── dataintegrationAsd/   # ASD 데이터 통합
│           ├── service/impl/
│           │   └── DataIntegrationServiceImpl.java
│           └── web/
│               └── DataIntegrationController.java
├── webapp/
│   ├── js/                        # JS 스크립트
│   │   └── dashboard.js, dashboardAsd.js
│   ├── WEB-INF/views/
│   │   └── dashboard/
│   │       └── dashboard.jsp, dashboardAsd.jsp
└── pom.xml or build.gradle       # 빌드 설정
```

---

## 🔧 기술 스택

- **Back-End**: Java 11, Spring MVC, MyBatis
- **Front-End**: JSP, jQuery, JavaScript
- **DBMS**: Oracle / MySQL
- **Build**: Maven / Gradle
- **IDE**: Eclipse
- **Versioning**: SVN (필터: author = `my.lee`)

---

## 📌 주요 기능 및 소스 설명

### 📊 Dashboard (대시보드)

- `DashboardController.java`: 실시간 통계 및 시각화 대시보드 API
- `DashboardServiceImpl.java`: KPI, 사용자 활동 데이터 처리
- `dashboard.jsp`, `dashboard.js`: 차트 렌더링 및 AJAX 데이터 처리

### 🧪 Analysis (데이터 분석)

- `AnalysisServiceImpl.java`: 유전자 및 환경 요인 분석 데이터 처리
- `AnalysisEnvMattWriterMapper.java`: 환경 행렬 데이터 가공 및 저장
- `AnalysisController.java`: 분석결과 화면 처리 및 통합

### 🩺 Clinician (임상/설문 데이터)

- `ClinicianServiceImpl.java`: 자폐 스펙트럼 관련 임상 설문 처리
- `ClinicianAsdSrs01VO.java`: ASD 스케일 기반 설문 결과 모델링
- `ClinicianController.java`: 클리니션 UI 연계 API

### 🔄 Data Integration (데이터 통합)

- `DataIntegrationServiceImpl.java`: 외부 CSV/Excel 임포트 및 DB 매핑
- `DataIntegrationController.java`: 파일 업로드/변환 제어

---

## 📂 VO 클래스 구조 예시

- `AnalysisVO.java`, `AnalysisTotalVO.java`: 분석 결과 전송 구조
- `ClinicianVO.java`, `ClinicianListVO.java`: 설문 응답 및 등록 정보
- `DataIntegrationVO.java`: 통합 데이터 DTO



---

## 💼 기여 요약

- 📌 분석 및 임상 모듈 설계 및 구현 (전체 서비스 흐름 주도)
- 📁 Spring MVC 구조 하에서 Controller → Service → DAO → Mapper 흐름 주도
- 📊 MyBatis 기반 복잡한 다중 매핑 SQL 작성
- 🧪 CSV/Excel → DB 데이터 자동 매핑 기능 개발
- 📈 jQuery + AJAX 기반 대시보드 차트 UI 구현
- 🛠 개발 완료 후 테스트, 로그 설정, 성능 개선

---

## 📌 기타 정보

- 모든 코드는 SVN 로그를 기준으로 `author: my.lee`로 커밋된 것만 추출하였으며,
  `dashboard.jsp`, `dashboard.js` 등 일부 타인 커밋된 파일은 직접 개발한 파일로 수동 포함했습니다.

---

📍 이 저장소는 실무 프로젝트 기반의 기여도와 기술 역량을 이력서 및 포트폴리오 용도로 증빙하기 위해 구성하였습니다.
