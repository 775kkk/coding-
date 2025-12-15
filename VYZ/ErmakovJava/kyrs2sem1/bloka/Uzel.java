package VYZ.ErmakovJava.kyrs2sem1.bloka;

public final class Uzel {

    private Integer value; // null значение не задан
    private Uzel parent;
    private Uzel left;
    private Uzel right;

    // инициализация без аргументов
    public Uzel() {
        this.value = null;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public void add(int newValue) {
        // если значение не задано — задаем и завершаем
        if (value == null) {
            value = newValue;
            return;
        }

        // BST правило > вправо иначе <= влево
        if (newValue > value) {
            if (right == null) {
                right = new Uzel();
                right.parent = this;
            }
            right.add(newValue);
        } else {
            if (left == null) {
                left = new Uzel();
                left.parent = this;
            }
            left.add(newValue);
        }
    }

    // проверка существования
    public boolean contains(int x) {
        if (value == null) return false;

        if (x == value) return true;
        if (x > value) {
            return right != null && right.contains(x);
        } else {
            return left != null && left.contains(x);
        }
    }

    // удаление значения
    public boolean remove(int x) {
        Uzel node = findNode(x);
        if (node == null) return false;

        deleteNode(node);
        return true;
    }

    // строковое представление левосторонний обход LNR
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        appendInOrder(sb);
        sb.append("]");
        return sb.toString();
    }
    // вспомогательный метод для обхода
    private void appendInOrder(StringBuilder sb) {
        if (value == null) return;
        if (left != null) left.appendInOrder(sb);
        // аккуратное добавление разделителя
        if (sb.length() > 1) sb.append(", ");
        sb.append(value);

        if (right != null) right.appendInOrder(sb);
    }
    // поиск узла со значением x
    private Uzel findNode(int x) {
        if (value == null) return null;

        if (x == value) return this;
        if (x > value) return (right == null) ? null : right.findNode(x);
        return (left == null) ? null : left.findNode(x);
    }
    // поиск минимального узла в поддереве n
    private static Uzel minNode(Uzel n) {
        Uzel cur = n;
        while (cur.left != null && cur.left.value != null) {
            cur = cur.left;
        }
        return cur;
    }
    // удаление узла
    private void deleteNode(Uzel node) {
        // у узла 2 ребенка -> заменяем значением преемника min в правом поддереве
        if (node.left != null && node.left.value != null && node.right != null && node.right.value != null) {
            Uzel succ = minNode(node.right);
            node.value = succ.value;
            // удаляем succ у него максимум 1 ребенок
            deleteNode(succ);
            return;
        }

        // определяем единственного ребенка если есть
        Uzel child = null;
        if (node.left != null && node.left.value != null) child = node.left;
        else if (node.right != null && node.right.value != null) child = node.right;

        // узел — корень parent == null
        if (node.parent == null) {
            if (child == null) {
                // дерево становится пустым
                node.value = null;
                node.left = null;
                node.right = null;
                return;
            }

            // поднимаем child в корень копируя поля
            node.value = child.value;
            node.left = child.left;
            node.right = child.right;

            if (node.left != null) node.left.parent = node;
            if (node.right != null) node.right.parent = node;

            return;
        }

        // узел не корень
        if (child == null) {
            // лист просто отсоединяем
            if (node.parent.left == node) node.parent.left = null;
            else if (node.parent.right == node) node.parent.right = null;
            return;
        }

        // узел с одним ребенком подключаем ребенка вместо узла
        child.parent = node.parent;
        if (node.parent.left == node) node.parent.left = child;
        else if (node.parent.right == node) node.parent.right = child;
    }
}
