*개인 공부를 위해 정리한 문서로서 여러 블로그를 참고함.*

# 다익스트라(Dijkstra) 알고리즘

## 정의
- 최단 경로를 찾는 알고리즘
- **가중치가 있는 그래프**의 최단 경로
- 방향 그래프(무방향 그래프일 경우 간선 쪼개 방향 그래프로 변환 필요)
- 0 이상의 가중치
    - 가중치 음수 불가(가중치에 대한 최소값을 보장할 수 없으므로)
    - **다익스트라는 정점을 지날수록 가중치가 증가한다는 사실을 전제로 함**
- BFS 기본
    - 시작 정점에서 가장 가까운 순서대로 진행
- Greedy Algorithm(탐욕 알고리즘)
    - 매 순간 최선의 선택을 하는 알고리즘.
    - 우선순위 큐를 이용해 매 순간 최단 거리의 정점을 선택한다.     
- 시간복잡도
    - 모든 간선 검사할 경우 : O(V)
    - 모든 간선 검사할때마다 우선순위큐에 정점 삽입/삭제 : O(VlogV)
    ==> O(V) + O(VlogV)  ==> O(VlogV)
    
## 동작 과정
1. 각 노드간의 거리를 저장하는 배열 생성
    - 첫 정점을 기준으로 배열 선언
        - 첫 정점 : 0, 나머지 : 무한대
        - PriorityQueue에 첫 정점 add
2. 첫 정점의 인접 노드 간의 거리부터 계산하여 가장 짧은 거리를 업데이트
    - PriorityQueue에서 Node poll
        - 첫 정점에서 각 노드로 가는 거리와 현재 배열에 저장된 각 정점까지의 거리 비교
        - 배열상의 거리 > 첫 정점 + 해당 노드로 가는 거리
        
            => 해당 노드의 거리 업데이트
            => PriorityQueue Add
3. 2 과정 반복

<pre>
<code>
int[][] adj;        //연결정점 및 가중치
                    //ex) 1->2, value = 4 : adj[1][2] = 4;

class Node implements Comparable<!CDATA[<]>Node<!CDATA[>]>{
    int index;
    int distance;
    Node(int index, int distance){
        this.index = index;
        this.distance = distacne;
    }
    
    public int compareTo(Node n){
        return this.distance <!CDATA[<=]> n.distance ? -1 : 1;
    }
}

void dijkstra(){
    PriorityQueue<!CDATA[<]>Node<!CDATA[>]> pq = new PriorityQueue<!CDATA[<]>Node<!CDATA[>]>();
    
    pq.add(new Node(start, 0)); //(시작점, 거리) 정보
    dist[start] = 0;            //시작점과의 거리(본인 시작이므로 0)
    
    Node n;
    while(!pq.isEmpty()){
        n = pq.poll();
        int index = n.index;
        int distance = n.distance;
        //현재 거리가 지금까지의 거리보다 클 경우 패스(최단거리가 되지 않으므로)
        if(distance > dist[index]) continue;
        
        
        for(int i=1; i<!cdata[<=]>V; i++){
        // 현재 점과 연결될 점을 합치고 이 점이 이전에 구했던 점보다 작을 경우 이는 최소 거리가 된다. 
            if(dist[i] <!cdata[>]> dist[index] + adj[index][i]){
                dist[i] = dist[index]+adj[index][i];
                pq.add(new Node(i, dist[i]))); 
            }
        }
    }
}
</code>
</pre>