# Mini-Module de Facturation

## Objectif
Développer un mini-module de facturation permettant :  

- La création et gestion des clients  
- L’émission de factures avec détails  
- Le calcul automatique des montants (HT, TVA, TTC)  
- La génération d’un export JSON des factures  
---
## Fonctionnalités
### 1. Gestion des clients
- **Lister tous les clients**  
- **Créer un client** : nom, email, SIRET, date de création  
- **Afficher le détail d’un client**  
### 2. Gestion des factures
- **Lister toutes les factures**  
- **Créer une facture** :  
  - `clientId`  
  - `date` (auto-générée)  
  - `lines` (liste des lignes)  
Chaque ligne contient :  
- `description`  
- `quantity`  
- `unitPrice` (HT)  
- `tva` (0%, 5.5%, 10%, 20%)  
Le backend calcule automatiquement :  
- **Total HT**  
- **Total TVA**  
- **Total TTC**  
---
### 3. Export JSON

- Chaque facture peut être exportée en JSON structuré, représentant :  
  - Les informations du client  
  - La liste des lignes  
  - Les totaux (HT, TVA, TTC)  

---

### 4. Règles métier
- Une facture **doit avoir au moins une ligne**  
- Aucun champ ne doit être vide  
- Le taux de TVA est limité à **0%, 5.5%, 10% ou 20%**  

---

### Bonus
- **Recherche de factures par client ou par date** via un endpoint dédié  

---

### Configuration du fichier application.properties
#### Configuration de la base de données PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5433/facturation_db
spring.datasource.username=VOTRE_USERNAME
spring.datasource.password=VOTRE_MOT_DE_PASSE
spring.datasource.driver-class-name=org.postgresql.Driver

#### Configuration JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---
### Tech Stack
- Java 17+
- Spring Boot 3.x
- Base de données PostgreSQL
- Postman pour tester les endpoints
