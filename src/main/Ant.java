package src.main;

public class Ant {
    protected int trailSize; // kich thuoc duong di so luong thanh pho
    protected int trail[]; // luu tru hanh trinh cua kien
    protected boolean visited[]; // danh dau cac thanh pho da duoc den tham

    public Ant(int tourSize)
    {
        this.trailSize = tourSize;
        this.trail = new int[tourSize];
        this.visited = new boolean[tourSize];
    }

    protected void visitCity(int currentIndex, int city) // tham thanh pho cu the
    {
        trail[currentIndex + 1] = city; //add to trail
        visited[city] = true;           //update flag
    }

    protected boolean visited(int i) // kiem tra thanh pho i da duoc tham chua
    {
        return visited[i];
    }

    protected double trailLength(double graph[][]) // chieu dai hanh trinh
    {
        double length = graph[trail[trailSize - 1]][trail[0]];
        for (int i = 0; i < trailSize - 1; i++)
            length += graph[trail[i]][trail[i + 1]];
        return length;
    }

    protected void clear() // reset lai hanh trinh ve chua duoc tham
    {
        for (int i = 0; i < trailSize; i++)
            visited[i] = false;
    }
}
