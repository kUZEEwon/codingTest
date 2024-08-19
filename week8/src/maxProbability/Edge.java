package maxProbability;

class Edge implements Comparable<Edge> {
    public int node;
    public double cost;

    public Edge(int node, double cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        // 내림차순 정렬을 위해 비교 순서를 반대로
        return Double.compare(o.cost, this.cost);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node=" + node +
                ", cost=" + cost +
                '}';
    }
}
