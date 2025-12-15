package VYZ.ErmakovJava.kyrs2sem1.bloka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public final class spisokKontactov {

    // имя -> контакт
    private final HashMap<String, Contact> nameToContact = new HashMap<>();
    // телефон -> имя уникальность телефона + containsPhone O(1)
    private final HashMap<String, String> phoneToName = new HashMap<>();

    public spisokKontactov() {
    }


    // телефон-имя
    // имя есть - новый делается основным старый основной возвращается и сохраняется как доп.
    // имени нет - создаём возвращаем null
    // телефон уже был перепривязываем старому убираем
    public String put(String phone, String name) {
        requireNonNull(phone, "phone");
        requireNonNull(name, "name");

        // телефон уже был перепривязываем старому убираем
        String oldOwner = phoneToName.get(phone);
        if (oldOwner != null && !oldOwner.equals(name)) {
            Contact oldContact = nameToContact.get(oldOwner);
            if (oldContact != null) {
                oldContact.removePhone(phone);
                // у старого телефонов не осталось del
                if (oldContact.totalPhones() == 0) {
                    nameToContact.remove(oldOwner);
                }
            }
        }

        // добавляем обновляем для нового вл
        Contact c = nameToContact.get(name);
        if (c == null) {
            c = new Contact(name, phone);
            nameToContact.put(name, c);
            phoneToName.put(phone, name);
            return null;
        }

        // если этот телефон уже принадлежит
        if (c.hasPhone(phone)) {
            phoneToName.put(phone, name); // на всякий если был oldOwner==name
            return null;
        }

        // имя есть телефон новый -> делаем его основным старый основной сохраняем как доп
        String oldMain = c.mainPhone;
        c.promoteToMain(phone);

        // обновляем глобальную карту телефонов
        // новый телефон принадлежит name
        phoneToName.put(phone, name);
        // старый основной всё ещё принадлежит name н как дополнительный
        if (oldMain != null) {
            phoneToName.put(oldMain, name);
        }

        return oldMain; // из 1.7
    }

    // удаление по имени
    public boolean removeByName(String name) {
        requireNonNull(name, "name");

        Contact c = nameToContact.remove(name);
        if (c == null) return false;

        for (String p : c.getAllPhones()) {
            phoneToName.remove(p);
        }
        return true;
    }

    // основной тел по имени
    public String getPhoneByName(String name) {
        requireNonNull(name, "name");

        Contact c = nameToContact.get(name);
        return (c == null) ? null : c.mainPhone;
    }

    // все телефоны по имени
    public String[] getPhonesByName(String name) {
        requireNonNull(name, "name");

        Contact c = nameToContact.get(name);
        return (c == null) ? new String[0] : c.getAllPhones();
    }

    public boolean containsName(String name) {
        requireNonNull(name, "name");
        return nameToContact.containsKey(name);
    }

    public boolean containsPhone(String phone) {
        requireNonNull(phone, "phone");
        return phoneToName.containsKey(phone);
    }

    // колво контактов уникальных имён — предположение
    public int size() {
        return nameToContact.size();
    }

    // пары телефон - имя ключая доп. телефоны
    public String[] toPairsArray() {
        ArrayList<String> out = new ArrayList<>();
        for (Contact c : nameToContact.values()) {
            for (String p : c.getAllPhones()) {
                out.add(p + " - " + c.name);
            }
        }
        return out.toArray(new String[0]);
    }

    public String[] toPhonesArray() {
        return phoneToName.keySet().toArray(new String[0]);
    }

    public String[] toNamesArray() {
        return nameToContact.keySet().toArray(new String[0]);
    }
    
    // найти имена по префиксу
    public String[] findNamesByPrefix(String prefix) {
        requireNonNull(prefix, "prefix");

        ArrayList<String> out = new ArrayList<>();
        for (String name : nameToContact.keySet()) {
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

    private static final class Contact {
        private final String name;
        private String mainPhone;     // основной телефон
        private String[] otherPhones; // дополнительные телефоныуникальные
        private int otherSize;

        Contact(String name, String mainPhone) {
            this.name = name;
            this.mainPhone = mainPhone;
            this.otherPhones = new String[4];
            this.otherSize = 0;
        }

        int totalPhones() {
            return (mainPhone == null ? 0 : 1) + otherSize;
        }

        boolean hasPhone(String phone) {
            if (mainPhone != null && mainPhone.equals(phone)) return true;
            for (int i = 0; i < otherSize; i++) {
                if (otherPhones[i].equals(phone)) return true;
            }
            return false;
        }

        void promoteToMain(String newMain) {
            if (mainPhone == null) {
                mainPhone = newMain;
                return;
            }
            // переносим старый основной в доп, если его там ещё нет
            if (!containsInOthers(mainPhone)) {
                addOther(mainPhone);
            }
            // если новый был в доп — удалим его оттуда
            removeFromOthersIfExists(newMain);

            mainPhone = newMain;
        }

        void removePhone(String phone) {
            if (mainPhone != null && mainPhone.equals(phone)) {
                // удаляем основной если есть доп — поднимаем один в основной
                if (otherSize > 0) {
                    mainPhone = popOther();
                } else {
                    mainPhone = null;
                }
                return;
            }
            removeFromOthersIfExists(phone);
        }

        String[] getAllPhones() {
            int total = totalPhones();
            String[] res = new String[total];
            int i = 0;
            if (mainPhone != null) res[i++] = mainPhone;
            for (int j = 0; j < otherSize; j++) res[i++] = otherPhones[j];
            return res;
        }

        private boolean containsInOthers(String phone) {
            for (int i = 0; i < otherSize; i++) {
                if (otherPhones[i].equals(phone)) return true;
            }
            return false;
        }

        private void addOther(String phone) {
            ensureOtherCapacity(otherSize + 1);
            otherPhones[otherSize++] = phone;
        }

        private String popOther() {
            String v = otherPhones[otherSize - 1];
            otherPhones[otherSize - 1] = null;
            otherSize--;
            return v;
        }

        private void removeFromOthersIfExists(String phone) {
            for (int i = 0; i < otherSize; i++) {
                if (otherPhones[i].equals(phone)) {
                    otherPhones[i] = otherPhones[otherSize - 1];
                    otherPhones[otherSize - 1] = null;
                    otherSize--;
                    return;
                }
            }
        }

        private void ensureOtherCapacity(int minCap) {
            if (minCap <= otherPhones.length) return;
            int newCap = otherPhones.length + (otherPhones.length + 1) / 2; // ~1.5x
            if (newCap < minCap) newCap = minCap;
            otherPhones = Arrays.copyOf(otherPhones, newCap);
        }
    }
}
