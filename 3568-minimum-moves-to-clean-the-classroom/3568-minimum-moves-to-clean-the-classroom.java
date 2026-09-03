class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int st_row = 0;
        int st_col = 0;
        int count = 0;

        int[][] arr = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if(ch == 'S') {
                    st_row = i;
                    st_col = j;
                }
                else if(ch == 'L') {
                    arr[i][j] = count;
                    count++;
                }
            }
        }

        if(count == 0) {
            return 0;
        }

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << count];

        int mask = (1 << count) - 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {
            st_row,
            st_col,
            energy,
            mask
        });

        visited[st_row][st_col][energy][mask] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int q = 0; q < size; q++) {

                int[] state = queue.poll();

                int row = state[0];
                int col = state[1];
                int currEnergy = state[2];
                int currMask = state[3];

                if(currMask == 0) {
                    return moves;
                }

                if(currEnergy == 0) {
                    continue;
                }

                for(int d = 0; d < 4; d++) {

                    int nr = row + dr[d];
                    int nc = col + dc[d];
                    if(nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    if(classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    char nextCell = classroom[nr].charAt(nc);
                    int nextEnergy;

                    if(nextCell == 'R') {
                        nextEnergy = energy;
                    } 
                    else {
                        nextEnergy = currEnergy - 1;
                    }
                    int nextMask = currMask;
                    if(nextCell == 'L') {
                        int litterIndex = arr[nr][nc];
                        nextMask = nextMask & ~(1 << litterIndex);
                    }

                    if(!visited[nr][nc][nextEnergy][nextMask]) {
                        visited[nr][nc][nextEnergy][nextMask] = true;
                        queue.offer(new int[] {
                            nr,
                            nc,
                            nextEnergy,
                            nextMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}