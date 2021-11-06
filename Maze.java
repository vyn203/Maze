import java.io.*;
import java.util.*;

public class Maze
{
	static int[][] maze;

 	public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		maze = loadMaze( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];
		String path = ""; // with each step grows to => "[2,3][3,4][3,5][4,6]" etc
		dfs( row, col, path );
	} // END MAIN

	private static int[][] loadMaze( String infileName, int[] dropInPt  ) throws Exception
	{
		Scanner infile = new Scanner( new File( infileName ) ); // OPEN UP A SCANNER USING THE INCOMING FILENAME

		int row = infile.nextInt(); // THE FIRST NUMBER ON THE FIRST LINE WILL BE THE NUMBER OF ROWS & COLS

		dropInPt[ 0 ] = infile.nextInt(); // THE SECOND & THIRD NUMBER ON 1st LINE WILL BE THE DROP IN POINT X,Y
		dropInPt[ 1 ] = infile.nextInt();

		int[][] maze = new int[ row ][ row ]; // USING ROW, COL DEFINE A 2D ARRAY OF INT

		for( int r = 0; r < row; r++ ){
			for( int c = 0; c < row; c++)
				maze[ r ][ c ] = infile.nextInt();	// READ IN THE GRID OF VALUES FROM THE INPUT FILE
		}

		infile.close();

		return maze; // RETURN THE 2D ARRAY WITH VALUES LOADED INTO IT	
	}

	static void dfs( int row, int col, String path ) // dfs = DEPTH FIRST SEARCH
	{
		String r = Integer.toString( row ), c = Integer.toString( col );
		path = path + "[" + r + "," + c + "]";

		if( row == 0 || col == 0 ||  row == ( maze.length - 1 ) || col == ( maze.length - 1 ) ){
			System.out.println( path );
			return;
		}

		if( maze[ row - 1 ][ col ] == 1 )
		{
			maze[ row ][ col ] = -1;
			dfs( row - 1, col, path );
			maze[ row ][ col ] = 1;
		}

		if( maze[ row - 1 ][ col + 1] == 1 )
		{
			maze[ row ][ col ] = -1;
			dfs( row - 1, col + 1, path );
			maze[ row ][ col ] = 1;
		}

		if( maze[ row ][ col + 1 ] == 1 )
		{
			maze[ row ][ col ] = -1;
			dfs( row, col + 1, path );
			maze[ row ][ col ] = 1;
		}

		if( maze[ row + 1 ][ col + 1 ] == 1 )
		{
			maze[ row ][ col ] = -1;
			dfs( row + 1 , col + 1 , path );
			maze[ row ][ col ] = 1;
		}

		if( maze[ row + 1 ][ col ] == 1 )
		{
			maze[ row ][ col ] = -1;
			dfs( row + 1, col, path );
			maze[ row ][ col ] = 1;
		}

		if( maze[ row + 1 ][ col - 1 ] == 1 )
		{
			maze[ row ][ col ] = -1;
			dfs( row + 1, col - 1, path );
			maze[ row ][ col ] = 1;
		}

		if( maze[ row ][ col - 1 ] == 1 )
		{
			maze[ row ][ col ] = -1;
			dfs( row, col - 1, path );
			maze[ row ][ col ] = 1;
		}

		if( maze[ row - 1 ][ col - 1 ] == 1 )
		{
			maze[ row ][ col ] = -1;
			dfs( row - 1, col - 1, path );
			maze[ row ][ col ] = 1;
		}
	}	
}