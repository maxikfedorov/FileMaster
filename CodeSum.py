import os
from datetime import datetime

# Получаем имя текущей директории
current_dir = os.path.basename(os.getcwd())

# Создаем словарь с названиями месяцев на русском языке
months = {
    1: "января",
    2: "февраля",
    3: "марта",
    4: "апреля",
    5: "мая",
    6: "июня",
    7: "июля",
    8: "августа",
    9: "сентября",
    10: "октября",
    11: "ноября",
    12: "декабря"
}

# Создаем новый файл для записи кода проекта
with open(f"Код проекта {current_dir}.txt", "w", encoding="utf-8") as project_file:
    # Записываем дату сборки в начало файла
    now = datetime.now()
    month_name = months[now.month]
    project_file.write(f"Дата сборки - {now.day} {month_name} {now.strftime('%H:%M')}\n\n")
    
    # Список расширений файлов, которые нужно найти
    extensions = [".html", ".css", ".php", ".js", ".yml", ".yaml", "Dockerfile", ".sql", ".java"]
    
    # Итерируемся по всем файлам в текущей директории и ее поддиректориях
    for root, dirs, files in os.walk("."):
        # Итерируемся по всем файлам в текущей директории и ее поддиректориях
        for filename in files:
            # Проверяем, что файл имеет нужное расширение
            if any(filename.endswith(ext) for ext in extensions):
                # Определяем путь к файлу
                file_path = os.path.join(root, filename)
                # Если файл находится в подпапке, добавляем путь к файлу перед именем файла
                if root != ".":
                    file_path = os.path.join(root, filename)
                # Открываем файл и записываем его содержимое в текстовый файл
                with open(file_path, "r", encoding="utf-8") as file:
                    project_file.write(f"\n{file_path}\n")
                    project_file.write("-" * 30 + "\n")
                    project_file.write(file.read())
                    project_file.write("\n" + "-" * 30 + "\n")
                    
# Выводим сообщение об успешном выполнении скрипта
print("Документ успешно составлен.")
