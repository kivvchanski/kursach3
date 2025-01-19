

<p>Это приложение предназначено для организации фриланс-проектов. В нем вы можете:</p>

<ul>
    <li>Создавать аккаунты</li>
    <li>Управлять аккаунтами с помощью пользователей с ролью "ADMIN"</li>
    <li>Создавать заказы от лица любого пользователя</li>
    <li>Брать заказы, выложенные другими пользователями</li>
    <li>Управлять заказами: отказываться от уже взятых заказов, удалять созданные вами заказы</li>
    <li>Просматривать актуальные заказы</li>
    <li>Просматривать профили работодателей</li>
</ul>

<h2>Функционал для разработчиков</h2>

<p>Для разработчиков предоставлен функционал для работы с API приложения:</p>

<ul>
    <li>Получение списка пользователей с помощью <code>GET</code> запроса <code>/api/v1/users</code></li>
    <li>Получение списка всех заданий с помощью <code>GET</code> запроса <code>/api/v1/tasks</code></li>
    <li>Получение пользователей и задач по ID</li>
    <li>Создание и удаление пользователей и задач по ID</li>
    <li>"Взятие" задачи по ID для текущего пользователя</li>
    <li>Получение информации о текущем пользователе</li>
</ul>

<h2>Настройка приложения</h2>

<p>Для запуска приложения вам понадобится создать базу данных и подключить ее. Для примера можете использовать <code>pgAdmin</code>. Указать название и порт базы данных требуется в <code>application.yaml</code>.</p>

<h2>Навигация для пользователей</h2>

<ul>
    <li><code>/userplace/register</code></li>
    <li><code>/userplace/login</code></li>
    <li><code>/userplace/profile</code></li>
    <li><code>/userplace/tasks</code></li>
    <li><code>/userplace/available-tasks</code></li>
    <li><code>/userplace/view-profile/{id}</code> (например, <code>/userplace/view-profile/123</code>)</li>
    <li><code>/userplace/adminPlace</code></li>
</ul>

<h2>API Маршруты</h2>

<h3>Задачи</h3>

<ul>
    <li>
        <strong>Получить задачу по ID</strong><br>
        Адрес: <code>/api/v1/tasks/{id}</code><br>
        Тип запроса: <code>GET</code><br>
        Назначение: Возвращает задачу с указанным ID.
    </li>
    <li>
        <strong>Получить список всех задач</strong><br>
        Адрес: <code>/api/v1/tasks</code><br>
        Тип запроса: <code>GET</code><br>
        Назначение: Возвращает список всех задач.
    </li>
    <li>
        <strong>Получить задачи текущего пользователя</strong><br>
        Адрес: <code>/api/v1/tasks/userTasks</code><br>
        Тип запроса: <code>GET</code><br>
        Назначение: Возвращает задачи, связанные с текущим пользователем (владелец или исполнитель).
    </li>
    <li>
        <strong>Добавить новую задачу</strong><br>
        Адрес: <code>/api/v1/tasks</code><br>
        Тип запроса: <code>POST</code><br>
        Назначение: Добавляет новую задачу.
    </li>
    <li>
        <strong>Обновить задачу по ID</strong><br>
        Адрес: <code>/api/v1/tasks/{id}</code><br>
        Тип запроса: <code>PUT</code><br>
        Назначение: Обновляет задачу с указанным ID.
    </li>
    <li>
        <strong>Удалить задачу по ID</strong><br>
        Адрес: <code>/api/v1/tasks/{id}</code><br>
        Тип запроса: <code>DELETE</code><br>
        Назначение: Удаляет задачу с указанным ID.
    </li>
    <li>
        <strong>Получить доступные задачи</strong><br>
        Адрес: <code>/api/v1/tasks/available</code><br>
        Тип запроса: <code>GET</code><br>
        Назначение: Возвращает список доступных задач, которые еще не назначены исполнителю.
    </li>
    <li>
        <strong>Взять задачу в работу</strong><br>
        Адрес: <code>/api/v1/tasks/take/{id}</code><br>
        Тип запроса: <code>PUT</code><br>
        Назначение: Позволяет текущему пользователю взять задачу с указанным ID в работу.
    </li>
    <li>
        <strong>Отказаться от выполнения задачи</strong><br>
        Адрес: <code>/api/v1/tasks/discard/{id}</code><br>
        Тип запроса: <code>PUT</code><br>
        Назначение: Позволяет текущему пользователю отказаться от выполнения задачи с указанным ID.
    </li>
</ul>

<h3>Пользователи</h3>

<ul>
    <li>
        <strong>Сохранить пользователя</strong><br>
        Адрес: <code>/api/v1/users/save_user</code><br>
        Тип запроса: <code>POST</code><br>
        Назначение: Сохраняет нового пользователя.
    </li>
    <li>
        <strong>Получить список всех пользователей</strong><br>
        Адрес: <code>/api/v1/users</code><br>
        Тип запроса: <code>GET</code><br>
        Назначение: Возвращает список всех пользователей, заполняя отсутствующие данные (например, дату рождения).
    </li>
    <li>
        <strong>Авторизация пользователя</strong><br>
        Адрес: <code>/api/v1/users/login</code><br>
        Тип запроса: <code>POST</code><br>
        Параметры: <code>username</code> (имя пользователя), <code>role</code> (роль пользователя).<br>
        Назначение: Создает сессию для пользователя с указанными именем и ролью.
    </li>
    <li>
        <strong>Получить профиль текущего пользователя</strong><br>
        Адрес: <code>/api/v1/users/profile</code><br>
        Тип запроса: <code>GET</code><br>
        Назначение: Возвращает данные профиля текущего пользователя из активной сессии.
    </li>
    <li>
        <strong>Просмотреть профиль пользователя по ID</strong><br>
        Адрес: <code>/api/v1/users/viewProfile/{id}</code><br>
        Тип запроса: <code>GET</code><br>
        Назначение: Возвращает данные профиля пользователя по указанному ID.
    </li>
    <li>
        <strong>Получить ID пользователя по email</strong><br>
        Адрес: <code>/api/v1/users/viewEProfile/{email}</code><br>
        Тип запроса: <code>GET</code><br>
        Назначение: Возвращает ID пользователя по указанному email.
    </li>
    <li>
        <strong>Выход из системы</strong><br>
        Адрес: <code>/api/v1/users/logout</code><br>
        Тип запроса: <code>POST</code><br>
        Назначение: Завершает текущую сессию пользователя.
    </li>
    <li>
        <strong>Elfktybt пользователя</strong><br>
        Адрес: <code>/api/v1/users/delete/{id}</code><br>
        Тип запроса: <code>DELETE</code><br>
        Назначение: Удаляет пользователя по указанному id.
    </li>
