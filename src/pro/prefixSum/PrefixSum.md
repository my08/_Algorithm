# Prefix Sum

1. Prefix Sum을 계산하여 배열 P에 저장
2. 매 M개의 쿼리 정보를 확인할 때, 구간 합 = P[R] - P[L-1]
10 | 20 | 30 | 40 | 50 
---------------------
P
0 10 30 60 100 150
if( L = 0, R = 2)
P[3] - P[0] = 60;


그리디 알고리즘
탐색 : 완전탐색, dfs, bfs
동적 프로그래밍
문자열

