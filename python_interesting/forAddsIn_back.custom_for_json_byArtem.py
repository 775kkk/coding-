import os
import json
folder_path = r""
json_path = r".json"

with open(json_path, 'r', encoding='utf-8') as file:
    data = json.load(file)

data["background.customImages"] = []# тут вставляем че куда нам надо вставить

for file_name in os.listdir(folder_path):
    if os.path.isfile(os.path.join(folder_path, file_name)):
        file_path = f"file://{os.path.join(folder_path, file_name)}"
        data["background.customImages"].append(file_path)


with open(json_path, 'w', encoding='utf-8') as file:
    json.dump(data, file, indent=4, ensure_ascii=False)