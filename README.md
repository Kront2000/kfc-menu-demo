# 🍔 Gyrmania — Сервис доставки еды

# !!!!СТАРЫЙ ПРОЕКТ!!!!

**Gyrmania** — pet-проект, имитирующий онлайн-сервис для доставки еды.  
Реализован полноценный стек: **Spring Boot + PostgreSQL + Docker + Cloudinary** с адаптивным фронтендом на чистом HTML/CSS/JS.

---

## ✨ Возможности
- 📂 Категории и блюда
   - Создание, редактирование и удаление категорий/блюд
   - Загрузка изображений (Cloudinary или локально)
   - Группировка блюд по категориям
- 🔍 Публичное меню
   - Доступно всем пользователям
   - Красивый адаптивный интерфейс (мобильные/планшеты/ПК)
- 🔐 Админка
   - Защищена через **Spring Security**
   - Добавление и редактирование блюд/категорий
   - Авторизация через логин/пароль
- ⚡ Кэширование
   - `@Cacheable` и `@CacheEvict` для быстрого доступа к меню
- 🐳 Docker
   - `docker-compose.yml` для запуска вместе с PostgreSQL
   - `Dockerfile` для упаковки приложения
- ✅ Тесты
   - Unit и интеграционные тесты (Mockito, JUnit, Spring Boot Test)
- ⚡ CI/CD
   - В проекте настроен GitHub Actions workflow
---

## 🛠️ Технологии
- **Backend**: Spring Boot (Web, Data JPA, Validation, Security, Cache)
- **Database**: PostgreSQL, H2 (тесты)
- **Frontend**: HTML, CSS, JavaScript (fetch API)
- **DevOps**: Docker, Docker Compose
- **Cloud**: Cloudinary (хранение изображений)
- **Testing**: JUnit 5, Mockito
- **Build Tool**: Maven
-  **CI/CD**: GitHub Actions 

---

## 🚀 Запуск проекта

### 1. Клонируем репозиторий

git clone https://github.com/username/gyrmania.git
cd gyrmania
2. Запускаем через Docker Compose
docker-compose -f docker-compose-dev.yml up --build
Приложение будет доступно по адресу:
👉 http://localhost:8080

3. Тестовый пользователь
Логин: admin
Пароль: 1q2w3e4r

🖼️ Скриншоты
![img_1.png](img_1.png)

👨‍💻 Автор
Проект разработал Андрей Янич в качестве pet-проекта для изучения Spring Boot и создания реального портфолио.

