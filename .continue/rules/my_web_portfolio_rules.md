---
name: My web portfolio rules
---

## Rules

- Respond ALWAYS and ONLY in Italian, regardless of the language of the question. This is mandatory.
- When asked always give professional comments to the metods.

## Project Overview

Applicazione web di gestione del portafoglio finanziario personale (entrate/uscite).
Monorepo full-stack con tre servizi orchestrati via Docker Compose.

## Tech Stack

| Layer | Tecnologia | Versione |
|---|---|---|
| Backend | Java + Spring Boot | 3.5.7 |
| Frontend | Angular + TypeScript | 20.3.x |
| Database | MySQL | 8.0 |
| Build tool backend | Maven | - |
| Styling frontend | Bootstrap | 5.3.3 |
| Containerizzazione | Docker Compose | - |

## Porte e Servizi

- **MySQL** → porta `3306`, database: `my_web_portafoglio`
- **Backend** (Spring Boot) → porta `8081`
- **Frontend** (Angular, servito da Nginx) → porta `80`

## Architettura

[Browser] → porta 80 → [Frontend Angular / Nginx]
↓ HTTP REST
porta 8081 → [Backend Spring Boot]
↓ JDBC
porta 3306 → [MySQL 8.0]

## Struttura del Repository

Il repository è organizzato in tre cartelle principali:
- `backend/` — applicazione Spring Boot
- `frontend-my-web-portafoglio/` — applicazione Angular
- File di root: `docker-compose.yml`, `MyQueries.sql`

La struttura interna di ciascun modulo può evolvere nel tempo.
Fai sempre riferimento ai file presenti nel contesto della conversazione
per conoscere la struttura aggiornata.

## Convenzioni Backend (Spring Boot)

- Package base: `com.example.backend_my_web_portafoglio`
- Architettura a layer: `Controller → Service → Repository → Entity`
- I **Controller** (`@RestController`) espongono gli endpoint REST
- I **Service** (`@Service`) contengono la business logic
- I **Repository** estendono `JpaRepository`
- I **Mapper** convertono manualmente Entity ↔ DTO (MapStruct è commentato nel `pom.xml` — non usarlo)
- Usare **Lombok** per ridurre il boilerplate (`@Getter`, `@Setter`, `@Builder`, ecc.)
- Usare `@Valid` sui DTO in ingresso nei Controller
- Il CORS è configurato globalmente in una classe dedicata in `config/`

## Convenzioni Frontend (Angular)

- Angular **standalone components** (Angular 20, no NgModules)
- Un service per dominio, collocato in `src/app/service/`
- I componenti sono in `src/app/components/`, ciascuno con i propri file `.ts`, `.html`, `.css`, `.spec.ts`
- Usare `HttpClient` con `Observable` e `rxjs` per le chiamate HTTP al backend
- L'URL base del backend è `http://localhost:8081` in sviluppo
- Stile UI con **Bootstrap 5.3**
- Formattare il codice con **Prettier** (`singleQuote: true`, `printWidth: 100`)