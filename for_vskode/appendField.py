import json
from pathlib import Path

# путь к JSON VS Code
json_path = r"C:\Users\adminS\AppData\Roaming\Code\User\settings.json"

# папка с картинками
images_dir = Path(r"C:\Users\adminS\Pictures")

# читаем JSON
with open(json_path, "r", encoding="utf-8") as f:
    data = json.load(f)

# забираем блок background.editor
if "background.editor" not in data:
    raise KeyError('В JSON нет ключа "background.editor"')

editor_block = data["background.editor"]

# гарантируем, что там есть images-список
if "images" not in editor_block:
    editor_block["images"] = []
elif not isinstance(editor_block["images"], list):
    raise TypeError('"background.editor.images" существует, но это не список')

editor_images = editor_block["images"]

# собираем файлы из папки
paths = []
for file in images_dir.iterdir():
    if file.is_file():
        url = file.resolve().as_uri()  # file:///C:/Users/...
        # чтобы не плодить дубликаты:
        if url not in editor_images:
            paths.append(url)

# добавляем
editor_images.extend(paths)

# сохраняем JSON
with open(json_path, "w", encoding="utf-8") as f:
    json.dump(data, f, ensure_ascii=False, indent=4)

print("Готово. Добавлено файлов:", len(paths))
