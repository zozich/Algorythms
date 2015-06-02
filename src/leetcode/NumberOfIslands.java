package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '0', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '1', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '1', '1'};
        System.out.println(new NumberOfIslands().numIslands(grid));
      /*11000
        11000
        00100
        00011*/

        grid = new char[1][7];
        grid[0] = new char[] {'1', '0', '1', '1', '0', '1', '1'};
        System.out.println(new NumberOfIslands().numIslands(grid));
        //1111111
    }

    private Set<Point> visited = new HashSet<Point>();
    private Set<Point> toVisit = new HashSet<Point>();
    private int counter = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(new Point(i, j))) {
                    counter++;
                    addPoint(grid, new Point(i + 1, j), toVisit);
                    addPoint(grid, new Point(i, j + 1), toVisit);
                }
                visited.add(new Point(i, j));
                while (!toVisit.isEmpty()) {
                    Set<Point> toVisit2 = new HashSet<Point>();
                    for (Point point : toVisit) {
                        visited.add(point);
                        addPoint(grid, new Point(point.x - 1, point.y), toVisit2);
                        addPoint(grid, new Point(point.x, point.y - 1), toVisit2);
                        addPoint(grid, new Point(point.x + 1, point.y), toVisit2);
                        addPoint(grid, new Point(point.x, point.y + 1), toVisit2);
                    }
                    toVisit = toVisit2;
                }
            }
        }
        return counter;
    }

    private void addPoint(char[][] grid, Point point, Set<Point> set) {
        if (!visited.contains(point)) {
            if (point.x >= 0 && point.x <= grid.length - 1) {
                if (point.y >= 0 && point.y <= grid[0].length - 1) {
                    if (grid[point.x][point.y] == '1') {
                        set.add(point);
                        visited.add(point);
                    }
                }
            }
        }
    }

    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            if (x != point.x) {
                return false;
            }
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = (int) x;
            result = 31 * result + (int) y;
            return result;
        }
    }
}
