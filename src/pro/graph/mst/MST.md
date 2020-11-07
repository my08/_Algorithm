*개인 공부를 위해 정리한 문서로서 여러 블로그를 참고함.
#최소신장트리, MST(Minimun Spanning Tree)

##신장트리(Spanning Tree)
- 그래프 내 모든 정점이 간선으로 연결되어 있지만, 사이클은 없는 그래프
- 정점이 총 5개, 서로 연결해야 되지만 사이클은 없으므로 간선은 총 4개
- **정점의 수 = 간선의 수 + 1**

##최소신장트리
- 최소의 비용으로 연결된 신장트리
- 각 정점을 모두 연결하면서 가장 낮은 비용으로 연결된 신장트리

## 프림 알고리즘(Prim)
1. 정점 중 아무 시작점 설정
2. 해당 정점에 연결된 모든 간선 중 최소 비용을 가진 간선 선택
3. 지금까지 연결된 정점의 간선 중 최소의 비용 간선을 선택하여 연결
4. 2-3번 반복

## 크루스칼 알고리즘(Kruskal)
- Disjoint-set 자료구조 사용 필요
    - Union Find개념
모든 간선 중 최소 비용 간선 선택
    - 선택 시 사이클이 생기는지 확인 필요
    - 사이클 발생여부 확인 알고리즘 : Union-Find

##Union-Find
- 서로소 집합 알고리즘
    - 두 노드가 연결되어 있는지 확인하는 알고리즘
    - 모든 정점들의 부모 정점 배열 필요(make-set)

* Union
    - 두 정점을 합치는 작업
    - 두 장점의 parent Node 중 작은 값을 parent로 설정  
    ex) 1번 부모는 1, 3번 정점은 3일 경우 3번의 부모 노드는 1이 된다.
    - 시간복잡도 : O(N)
* Find
    - 두 정점의 연결 여부
    - 두 정점의 부모 노드가 일치할 경우 연결되어있음
    - 시간복잡도 : O(1)


<pre>
<code>
int MAX_SIZE = N;
int root[MAX_SIZE];
int rank[MAX_SIZE];
for(int i=0; i<<![cdata[<]]>MAX_SIZE; i++){
    root[i] = i;
    rank[i] = 0;
}

int find(int x){
    if(root[x] == x) return x;
    return root[x] = find(root[x]);
}

void union(int x, int y){
    x = find(x);
    y = find(y);
    
    if(x == y) return;
    
    //트리의 높이에 따라 낮은 트리를 높은 트리 밑에 넣는다.
    if(rank[x] < rank[y]){
        root[x] = y;
    }else{
        root[y] = x;
    }
    
    if(rank[x] == rank[y]){
        rank[x]++;      //높이가 같은 경우 합치고 height+1;
    }
}
</code>
</pre>