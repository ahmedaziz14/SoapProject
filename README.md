# 🧩 ArticleMongo - SOAP & RESTful Project with MongoDB

## 📖 Description
Ce projet est développé en Java avec Eclipse et implémente des services **SOAP** et **RESTful** connectés à une base de données **MongoDB**.  
Il permet d’effectuer les opérations CRUD suivantes :
- ➕ **Add** : Ajouter un article dans la base de données  
- 🔍 **Search** : Rechercher un article par ID ou titre  
- 🗑️ **Delete** : Supprimer un article  
- ✏️ **Update** : Modifier les informations d’un article  

Chaque modification effectuée via les services web est directement synchronisée avec **MongoDB** en temps réel.

## ⚙️ Technologies utilisées
- ☕ Java EE / JAX-WS / JAX-RS  
- 🗄️ MongoDB  
- 🧰 Eclipse IDE (SOA / Red Hat Tools)  
- 🌐 RESTEasy / Jersey  

## 🚀 Exécution
1. Lancer MongoDB localement  
2. Déployer le projet sur un serveur (Tomcat, WildFly ou JBoss)  
3. Accéder aux services via :
   - REST : `http://localhost:8080/ArticleMongo/rest/...`
   - SOAP : via le WSDL exposé dans le projet

## 👨‍💻 Auteur
Projet réalisé par **Ahmed Aziz Brahim**  
Étudiant en cycle ingénieur – Spécialité Informatique, École Polytechnique de Sousse
