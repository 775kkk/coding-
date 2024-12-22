# C:\Users\admin\AppData\Roaming\Code\User\settings.json
import os
import json

folder_path = r'Q:/'
image_extensions = ['.png', '.jpg', '.jpeg', '.gif', '.bmp']

images = [f'file:///{os.path.join(folder_path, file)}' 
          for file in os.listdir(folder_path) 
          if os.path.splitext(file)[1].lower() in image_extensions]

json_file_path = '.json'  # Укажите путь к вашему JSON файлу

try:
    with open(json_file_path, 'r', encoding='utf-8') as json_file:
        data = json.load(json_file)
except json.JSONDecodeError as e:
    print(f"Ошибка при загрузке JSON файла: {e}")
    exit(1)

data["images"].extend(images)

with open(json_file_path, 'w', encoding='utf-8') as json_file:
    json.dump(data, json_file, ensure_ascii=False, indent=4)

print("Изображения успешно добавлены в JSON файл! 🎉")
