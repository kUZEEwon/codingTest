package dijkstra;
class Entry implements Comparable<Entry> {
    public int node;
    public int distance;

    public Entry(int node, int distance) {
        this.node = node; // 현재 노드 번호
        this.distance = distance;
    }

    @Override
    public int compareTo(Entry o) {
        return this.distance - o.distance;
    }
}