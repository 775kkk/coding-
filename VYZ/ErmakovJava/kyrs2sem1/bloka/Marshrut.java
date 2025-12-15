package VYZ.ErmakovJava.kyrs2sem1.bloka;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import VYZ.ErmakovJava.kyrs2sem1.pract3.City;

public final class Marshrut {

    private City start;
    private City end;

    public Marshrut(City start, City end){
        this.setStart(start);
        this.setEnd(end);
    }

    public void setStart(City start){
        if (start==null) throw new IllegalArgumentException("start == null");
        this.start = start;
    }
    public void setEnd(City end){
        if (end==null) throw new IllegalArgumentException("end == null");
        this.end = end;
    }

    public City[] toArray(){
        if (start.equals(end)) return new City[]{start};

        ArrayDeque<City> queue = new ArrayDeque<City>();
        HashSet<City> visited = new HashSet<City>();
        HashMap<City, City> prev = new HashMap<City, City>();

        visited.add(start);
        queue.add(start);

        boolean found = false;

        while (!queue.isEmpty()) {
            City cur = queue.removeFirst();

            for (City nb : cur.neighbors()) {
                if (visited.contains(nb)) continue;

                visited.add(nb);
                prev.put(nb, cur);

                if (nb.equals(end)) {
                    found = true;
                    queue.clear();
                    break;
                }
                queue.addLast(nb);
            }
        }

        if (!found) return new City[0];

        ArrayList<City> reversed = new ArrayList<City>();
        City cur = end;
        reversed.add(cur);

        while (!cur.equals(start)) {
            cur = prev.get(cur);
            if (cur == null) return new City[0];
            reversed.add(cur);
        }

        City[] path = new City[reversed.size()];
        for (int i = 0; i < reversed.size(); i++) {
            path[i] = reversed.get(reversed.size()-1-i);
        }
        return path;
    }

    @Override
    public String toString() {
        City[] path = toArray();
        if (path.length==0) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length; i++) {
            if (i>0) sb.append(" -> ");
            sb.append(path[i].getCityName());
        }
        return sb.toString();
    }
}
