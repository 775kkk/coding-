package VYZ.ErmakovJava.kyrs2sem1.bloka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class phoneSpravka {

    // имя -> телефон
    private final HashMap<String, String> nameToPhone = new HashMap<>();
    // телефон -> имя для containsPhone за O(1)
    private final HashMap<String, String> phoneToName = new HashMap<>();

    public phoneSpravka() {
    }

    //  пара телефон+имя
    //  имя есть - заменяем мобильник возвращаем старый замененный
    //  имени не было - добавляем возвращаем null
    //  телефон привязан т та пара удаляется
    public String put(String phone, String name) {
        requireNonNull(phone, "phone");
        requireNonNull(name, "name");

        String oldPhoneForName = nameToPhone.get(name);
        String oldNameForPhone = phoneToName.get(phone);

        // если телефон был у другого имени -> удаляем то имя (чтобы не ломать 1-1)
        if (oldNameForPhone != null && !oldNameForPhone.equals(name)) {
            nameToPhone.remove(oldNameForPhone);
            // phoneToName для этого телефона перезапишется ниже
        }

        // если имя уже было и у него был другой телефон -> освобождаем старый телефон
        if (oldPhoneForName != null && !oldPhoneForName.equals(phone)) {
            phoneToName.remove(oldPhoneForName);
        }

        // пишем новую связку
        nameToPhone.put(name, phone);
        phoneToName.put(phone, name);

        return oldPhoneForName;
    }

    // удаление по имени
    public boolean removeByName(String name) {
        requireNonNull(name, "name");

        String phone = nameToPhone.remove(name);
        if (phone == null) return false;

        phoneToName.remove(phone);
        return true;
    }

    // тел по имени
    public String getPhoneByName(String name) {
        requireNonNull(name, "name");
        return nameToPhone.get(name);
    }

    // имя
    public boolean containsName(String name) {
        requireNonNull(name, "name");
        return nameToPhone.containsKey(name);
    }

    // тел
    public boolean containsPhone(String phone) {
        requireNonNull(phone, "phone");
        return phoneToName.containsKey(phone);
    }

    public int size() {
        return nameToPhone.size();
    }

    // представление пар
    public String[] toPairsArray() {
        String[] res = new String[nameToPhone.size()];
        int i = 0;
        for (Map.Entry<String, String> e : nameToPhone.entrySet()) {
            String name = e.getKey();
            String phone = e.getValue();
            res[i++] = phone + " - " + name;
        }
        return res;
    }

    // мобильники
    public String[] toPhonesArray() {
        return phoneToName.keySet().toArray(new String[0]);
    }

    // неймы
    public String[] toNamesArray() {
        return nameToPhone.keySet().toArray(new String[0]);
    }

    //
    public String[] findNamesByPrefix(String prefix) {
        requireNonNull(prefix, "prefix");

        ArrayList<String> out = new ArrayList<>();
        for (String name : nameToPhone.keySet()) {
            if (name.startsWith(prefix)) out.add(name);
        }
        return out.toArray(new String[0]);
    }

    @Override
    public String toString() {
        return Arrays.toString(toPairsArray());
    }

    private void requireNonNull(String v, String arg) {
        if (v == null) throw new IllegalArgumentException(arg + " == null");
    }
}
