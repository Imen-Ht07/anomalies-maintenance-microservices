# Système de gestion des anomalies & maintenance prédictive

**Stack**: Spring Boot 3.1.x (Java 17), Spring Cloud 2022.0.x, Kafka, PostgreSQL, Eureka, API Gateway, Config Server, Docker, (Kubernetes templates inclus).

## Microservices (5)
- `eureka-server` — Registre de services (Eureka)
- `config-server` — Configuration centralisée (Git file URI)
- `api-gateway` — Entrée unique & routage (Spring Cloud Gateway)
- `surveillance-service` — Métier #1 (Alertes & Mesures) — Producer Kafka
- `maintenance-service` — Métier #2 (Techniciens & Interventions) — Consumer Kafka & Feign vers Surveillance

> Architecture alignée avec votre sujet : communication **synchrone** (Feign REST) et **asynchrone** (Kafka), **configuration centralisée**, **gateway** et **eureka**. 

---

## Démarrage rapide (Docker)

> Prérequis: Docker Desktop/Engine, ports libres: 8761, 8888, 8080, 8081, 8082, 5432-5433, 9092.

1. Construire & lancer l'infrastructure (Kafka, Zookeeper, Postgres) :
   ```bash
   docker compose -f docker-compose.infra.yml up -d
   ```
2. Lancer les microservices (Eureka, Config, Gateway, Surveillance, Maintenance) :
   ```bash
   docker compose -f docker-compose.services.yml up -d --build
   ```
3. Vérifications:
   - Eureka: http://localhost:8761 (les 4 clients doivent apparaître UP)
   - Config Server: http://localhost:8888/surveillance-service/default
   - Gateway: http://localhost:8080

4. Test fonctionnel (création d'alerte → intervention auto):
   ```bash
   curl -X POST http://localhost:8080/surveillance/api/alertes \
        -H 'Content-Type: application/json' \
        -d '{"type":"TEMPERATURE","message":"Température élevée","niveauGravite":"CRITIQUE","dateDetection":"2026-01-14T12:00:00"}'
   # Puis lister les interventions créées côté maintenance :
   curl http://localhost:8080/maintenance/api/interventions
   ```

> Astuce: Créez au préalable 1 technicien dispo:
```bash
curl -X POST http://localhost:8080/maintenance/api/techniciens \
     -H 'Content-Type: application/json' \
     -d '{"nom":"Ali","specialite":"Electro","disponibilite":true}'
```

---

## Développement local (sans Docker)
1. Démarrer **PostgreSQL** (2 instances) et **Kafka** (voir `docker-compose.infra.yml` comme référence des ports).
2. Lancer **Eureka**, **Config Server**, **Gateway**, **Surveillance**, puis **Maintenance** (ordre conseillé).
3. Les services clients lisent la config depuis le Config Server via `spring.config.import`.

---

## Kubernetes (bonus)
Des manifestes simples sont fournis dans `k8s/` pour déployer les 5 microservices (avec Services ClusterIP). Adaptez l'ingress et les Secrets (DB, Kafka) selon votre cluster.

---

## Structure
```
./
├─ docker-compose.infra.yml
├─ docker-compose.services.yml
├─ config-repo/ (monté dans le config-server)
├─ eureka-server/
├─ config-server/
├─ api-gateway/
├─ surveillance-service/
├─ maintenance-service/
└─ k8s/
```

## Licence
Projet de démonstration pédagogique.
