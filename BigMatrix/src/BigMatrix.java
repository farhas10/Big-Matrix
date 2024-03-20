/**
 * Name: Farzad Hasan
 * Period: 1
 * Project: Big Matrix
 * Date last updated: 3/20/2024
 * Project Description: Creates a matrix which stores non-zero values 
 * using hashMaps.
 */

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

public class BigMatrix 
{
	//Creating the individual HashMaps for columns and rows.
	private HashMap<Integer, HashMap<Integer, Integer>> columns;
	private HashMap<Integer, HashMap<Integer, Integer>> rows;
	
	
	public BigMatrix()
	{
		//Sets value of columns and rows.
		columns = new HashMap<Integer, HashMap<Integer, Integer>>();
		rows = new HashMap<Integer, HashMap<Integer, Integer>>();
	}
	
	//This is the method used to put in a new value at the specificed location.
	public void setValue(int row, int col, int value)
	{
		//Checks if the location is empty.
		if(getValue(row, col) == 0 && value == 0) {
			return;
		}
		
		//Checks the column HashMap for if the value already exists.
		if(!columns.containsKey(col)) 
		{
			HashMap<Integer, Integer> currentColumn = new HashMap<Integer, Integer>();
			currentColumn.put(row, value);
			columns.put(col, currentColumn);
		} 
		else 
		{
			if (value == 0) 
			{
				columns.get(col).remove(row);
				if (columns.get(col).isEmpty()) columns.remove(col); 
			} 
			else columns.get(col).put(row, value);
		}
		
		//Checks the row HashMap for if the value already exists.
		if (!rows.containsKey(row)) {
			HashMap<Integer, Integer> currentRow = new HashMap<Integer, Integer>();
			currentRow.put(col, value);
			rows.put(row, currentRow);
		}
		
		else {
			if(value == 0) {
				rows.get(row).remove(col);
				if (rows.get(row).isEmpty()) rows.remove(row);
			}
			else rows.get(row).put(col, value);
		}
		
		
			
	}
	
	//Retrieves the value from any point in the matrix.
	public int getValue(int row, int col)
	{
		if (rows.containsKey(row) && rows.get(row).containsKey(col)) 
		{
			return rows.get(row).get(col);
		}	
		
		return 0;
	}
	
	public List<Integer> getNonEmptyRows()
	{
		//Returns the key of every row that isn't empty.
		return new ArrayList<Integer>(rows.keySet());
	}
	
	public List<Integer> getNonEmptyRowsInColumn(int col)
	{
		//Returns the key of every column that isn't empty.
		return new ArrayList<Integer>(columns.keySet());
	}
	
	public List<Integer> getNonEmptyCols()
	{
		throw new UnsupportedOperationException();
	}
	
	public List<Integer> getNonEmptyColsInRow(int row)
	{
		throw new UnsupportedOperationException();
	}
	
	public int getRowSum(int row)
	{
		throw new UnsupportedOperationException();
	}
	
	public int getColSum(int col)
	{
		throw new UnsupportedOperationException();
	}
	
	public int getTotalSum()
	{
		throw new UnsupportedOperationException();
	}
	
	public BigMatrix multiplyByConstant(int constant)
	{
		throw new UnsupportedOperationException();
	}
	
	public BigMatrix addMatrix(BigMatrix other)
	{
		throw new UnsupportedOperationException();
	}
}
