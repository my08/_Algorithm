*개인 공부를 위해 정리한 문서로서 여러 블로그를 참고함.*

# 벨만포드 알고리즘(Bellman-Ford Algorithm)

## 정의
- 최단 경로를 찾는 알고리즘
- **음수 가중치가 있는 그래프**의 최단 경로
- 인접 간선을 검사하고 거리값을 갱신하는 과정을 V(정점)-1번으로 제한(그래프에서 최대 간선은 V-1개이기 때문)
    = 경로에 V번째 간선이 추가되면 사이클에 진입한것!
- 시간복잡도 : V-1번 인접한 모든 간선들을 검사하는 과정이 있기 때문에 O(VE)

## 동작 과정
1. 시작 정점 결정
2. 현재 정점의 인접 정점 탐색하며, 기존 인접정점 > 현재정점 + 인접정점거리면 거리 갱신
3. 2번 과정을 V-1번 반복, 완료 후에도 거리가 갱신된다면 음수 사이클이 존재함

<pre><code>
int[] dist;     //인접정점거리
int INF = Integer.MAX_VALUE;
static class Node{
    private int start;
    private int end;
    private int cost;

    Node(int start, int end, int cost){
        super();
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

bellmanFord(){
    dist[1] = 0; //시작점을 1로 셋팅

    for(int i=0; i<!cdata[<]>N; i++){
        for(int j=0; j<!cdata[<]>M; j++){
            if(dist[node[j].start == INF) continue;
            if(dist[node[j].end > dist[node[j].start] + node[j].cost){
                dist[node[j].end = dist[node[j].start] + node[j].cost;
            }
        }
    }

    boolean cycled = false;

    for(int j=0; j<!cdata[<]>M; j++){
        if(dist[node[j].end > dist[node[j].start] + node[j].cost){
             cycled = true;
             break;
        }
    }
    if(cycled) return false;
    return true;
}
</code></pre>