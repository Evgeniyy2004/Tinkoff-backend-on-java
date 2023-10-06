package edu.hw1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.Set;

public class Task8
{
    public static boolean knightBoardCapture( int[]@NotNull [] chessboard)
    {
        if(chessboard.length!=8) return false;
        for(int i=0;i<chessboard.length;i++)
        {
            if(chessboard[i].length!=8) return false;
        }
        for(int j=0;j<chessboard.length;j++)
        {
            for(int k=0;k<chessboard[j].length;k++)
            {
                if(chessboard[j][k]==1)
                {
                    for(int x=-2;x<=2;x++)
                    {
                        for(int y=1;y<=2;y++)
                        {
                            if(y+j>=8 || y+j<0 || x+k>=8 || x+k<0) continue;
                            if(Math.abs(x)+Math.abs(y)!=3) continue;
                            if(chessboard[j+y][k+x]==1) return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
