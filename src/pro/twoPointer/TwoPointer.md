# Two Pointer

1. 시작점과 끝점이 첫 번째 원소의 인덱스(0)를 가리키게 설정
2. 현재 부분 합 = M → count++ && start++
3. 현재 부분 합 <= M → end++
4. 현재 부분 합 > M || end > N-1 → start++
5. 2-4 반복
