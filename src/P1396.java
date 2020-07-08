import java.util.*;

public class P1396 {
    class UndergroundSystem {


        Map<Integer, Check> edges = new HashMap<>();
        Map<String, List<Integer>> nameMap = new HashMap<>();

        class Check {
            int id;
            String start;
            String end;
            int ts1;
            int ts2;

            public Check setId(int id) {
                this.id = id;
                return this;
            }

            public Check setStart(String start) {
                this.start = start;
                return this;
            }

            public Check setEnd(String end) {
                this.end = end;
                return this;
            }

            public Check setTs1(int ts1) {
                this.ts1 = ts1;
                return this;
            }

            public Check setTs2(int ts2) {
                this.ts2 = ts2;
                return this;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Check check = (Check) o;
                return id == check.id;
            }

            @Override
            public int hashCode() {
                return Objects.hash(id);
            }
        }

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            edges.put(id, new Check().setId(id).setStart(stationName).setTs1(t));
            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(id);
            nameMap.merge(stationName, ids, (x, y) -> {
                x.addAll(y);
                return x;
            });
        }

        public void checkOut(int id, String stationName, int t) {
            Check check = edges.get(id);//not null
            check.setEnd(stationName).setTs2(t);
        }

        public double getAverageTime(String startStation, String endStation) {
            double sum = 0.0D;
            int n = 0;
            for (Integer id : nameMap.get(startStation)) {
                Check check = edges.get(id);
                String end = check.end;
                if (endStation.equals(end)) {
                    sum += check.ts2 - check.ts1;
                    ++n;
                }
            }
            return sum / n;
        }
    }
}
