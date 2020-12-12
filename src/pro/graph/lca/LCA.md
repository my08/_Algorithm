# LCA(Lowest Common Ancestor)

- 두 노드의 공통된 조상 중에서 가장 가까운 조상을 찾는 알고리즘

1. 모든 노드에 대한 깊이를 계산(DFS)
2. 최소 공통 조상을 찾을 두 노드를 확인한다.
    1. 두 노드의 깊이가 동일하도록 거슬러 올라간다.
    2. 부모가 같아질 때 까지 반복적으로 두 노드의 부모 방향으로 거슬러 올라간다.
3. 모든 LCA(a, b) 연산에 대하여 2번 과정을 반복한다. 

- 시간복잡도 : O(NM)

//백준 11437