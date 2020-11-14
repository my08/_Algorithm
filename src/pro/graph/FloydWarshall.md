*개인 공부를 위해 정리한 문서로서 여러 블로그를 참고함.*

# 플로이드워셜 알고리즘(Floyd Warshall Algorithm)

## 정의
- 모든 정점들 사이의 최단 거리를 구하는 알고리즘
- 특정 정점을 무조건 경유한다 생각하고 진행한다. 

## 동작 과정
- 3중 for문
    - 1차(가장 바깥쪽) : 정점
    - 2차 : 출발하는 정점
    - 3차 : 도착하는 정점
요
<pre><code>
int[][] dist;     //인접정점거리, input받을 때 본인의 경우 (1,1 ~ n,n) 0, 연결간선 제외 나머지 부분은 INF로 설정필
int INF = Integer.MAX_VALUE;

floydWarshall(){
    for(int i=0; i < N; i++){ //경유정점
        for(int j=0; j < N; j++){ //출발정점
            for(int k=0; k < N; k++){ //도착정점
                if(dist[j][k] > dist[j][i] + dist[i][k]){
                    dist[j][k] = dist[j][i] + dist[i][k];
                }
            }
        }
    }
    
    for(int i=0; i < N; i++){
        for(int j=0; j < N; j++){
            System.out.print(dist[i][j] + " ");
        }
        System.out.println();
    }
}
</code></pre>