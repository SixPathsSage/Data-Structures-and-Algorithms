import java.util.Scanner;

/**
 * Created by Siddharth on 2/17/2018.
 */

public class Bishop {
    int[][] board = new int[8][8];
    public boolean IsValidBishopMove(Position currentPosition, Position newPosition)
    {
        if(IsSamePosition(currentPosition, newPosition))
        {
            return false;
        }
        // ++
        for(int i = currentPosition.row, j = currentPosition.file; i <= newPosition.row && j <= newPosition.file; i ++, j ++)
        {
            if(i == newPosition.row && j == newPosition.file)
            {
                return true;
            }
        }
        // --
        for(int i = currentPosition.row, j = currentPosition.file; i >= newPosition.row && j >= newPosition.file; i --, j --)
        {
            if(i == newPosition.row && j == newPosition.file)
            {
                return true;
            }
        }
        // -+
        for(int i = currentPosition.row, j = currentPosition.file; i >= newPosition.row && j <= newPosition.file; i --, j ++)
        {
            if(i == newPosition.row && j == newPosition.file)
            {
                return true;
            }
        }
        // +-
        for(int i = currentPosition.row, j = currentPosition.file; i <= newPosition.row && j >= newPosition.file; i ++, j --)
        {
            if(i == newPosition.row && j == newPosition.file)
            {
                return true;
            }
        }
        return false;
    }

    public void PrintBoard(Position currentPosition)
    {
        for(int i = 0; i < 8; i ++)
        {
            for(int j = 0; j < 8; j ++)
            {
                if(i == currentPosition.row && j == currentPosition.file)
                {
                    System.out.print("|  B   |");
                }
                else
                {
                    System.out.print("| "+ i + ", " + j + " |");
                }
            }
            System.out.println();
        }
    }

    boolean IsSamePosition(Position currentPosition, Position newPosition)
    {
        return  (newPosition.row < 8 && newPosition.row > -1 && newPosition.row < 8 && newPosition.row > -1) &&
                (currentPosition.row == newPosition.row && currentPosition.file == newPosition.file);
    }

    public static void main(String[] args) {
        Bishop b = new Bishop();
        Position currentPosition = new Position(2, 1);
        b.PrintBoard(currentPosition);
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter New Position( Row File)");
            Position newPosition = new Position(scanner.nextInt(), scanner.nextInt());
            if(b.IsValidBishopMove(currentPosition, newPosition))
            {
                currentPosition = newPosition;
                System.out.println("Valid Move");
            }
            else
            {
                System.out.println("Invalid Move");
            }
            b.PrintBoard(currentPosition);
        }
    }
}


class Position
{
    int row;
    int file;

    Position(int row, int file)
    {
        this.row = row;
        this.file = file;
    }
}