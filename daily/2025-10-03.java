class Solution {
    public int trapRainWater(int[][] heightMap) {

        int rows = heightMap.length;
        int cols = heightMap[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        
        PriorityQueue<Cell> bound = new PriorityQueue<>();

        for (int i = 0; i < rows; i++) {
            bound.offer(new Cell(heightMap[i][0], i, 0));
            visited[i][0] = true;
            bound.offer(new Cell(heightMap[i][cols - 1], i, cols - 1));
            visited[i][cols - 1] = true;
        }

        for (int i = 0; i < cols; i++) {
            bound.offer(new Cell(heightMap[0][i], 0, i));
            visited[0][i] = true;
            bound.offer(new Cell(heightMap[rows - 1][i], rows - 1, i));
            visited[rows - 1][i] = true;
        }

        int total = 0;

        while(!bound.isEmpty()) {
            Cell current = bound.poll();

            int currentRow = current.row;
            int currentCol = current.col;
            int minBoundHeight = current.height;

            int[] dRow = { 0, 0, -1, 1 };
            int[] dCol = { -1, 1, 0, 0 };

            for (int d = 0; d < 4; d++) {
                int neighborRow = currentRow + dRow[d];
                int neighborCol = currentCol + dCol[d];

                if ((neighborRow >= 0 && neighborCol >= 0 && neighborRow < rows && neighborCol < cols)
                    && !visited[neighborRow][neighborCol]) {
                    
                    int neighborHeight = heightMap[neighborRow][neighborCol];
                    if (neighborHeight < minBoundHeight) {
                        total += minBoundHeight - neighborHeight;
                    }

                    bound.offer(new Cell(Math.max(neighborHeight, minBoundHeight), neighborRow, neighborCol));
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }

        return total;

    }

    private static class Cell implements Comparable<Cell> {
        int height;
        int row;
        int col;

        public Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Cell other){
            return Integer.compare(this.height, other.height);
        }
    }
}