package NetworkDelayTime;

class Edge implements Comparable<Edge> {
    public int node;
    public int cost;

    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return Integer.compare(this.cost, o.cost);
    }

}