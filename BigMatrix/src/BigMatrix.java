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
		//Returns the key of every column that isn't empty
		return new ArrayList<Integer>(columns.get(col).keySet());
		
	}
	
	public List<Integer> getNonEmptyCols()
	{
		//Creates ArrayList for columns.
		return new ArrayList<Integer>(columns.keySet());
	}
	
	public List<Integer> getNonEmptyColsInRow(int row)
	{
		//Creates ArrayList for rows.
		return new ArrayList<Integer>(rows.get(row).keySet());
	}
	
	public int getRowSum(int row)
	{
		
		//Loop to sum all values in the row.
		int total = 0;
		if (rows.containsKey(row))
		{
			for (int current : rows.get(row).values())
			{
				total += current;
			}
		}
		return total;
	}
	
	public int getColSum(int col)
	{
		
		//Loop to sum all values in the column.
		int total = 0;
		if (columns.containsKey(col))
		{
			for (int current : columns.get(col).values())
			{
				total += current;
			}
		}
		return total;
	}
	
	public int getTotalSum()
	{
		int total = 0;
		
		//Loops through every non-empty row.
		for (int currentRow : getNonEmptyRows())
		{
			//Adds to the current total.
			total += getRowSum(currentRow);
		}
		return total;
	}
	
	public BigMatrix multiplyByConstant(int constant)
	{
		BigMatrix temp = new BigMatrix();
		HashMap<Integer, Integer> rowsMap;

		//Go through each row
		for (int row : getNonEmptyRows())
		{
			rowsMap = rows.get(row);
		
			for (int col : getNonEmptyColsInRow(row))
			{
				//Multiplies every value by appropriate constant
				temp.setValue(row, col, rowsMap.get(col) * constant);
			}
		}
		return temp;
	}
	
	public BigMatrix addMatrix(BigMatrix other)
	{
				BigMatrix temp = new BigMatrix();
				temp.columns = this.columns; 
				temp.rows = this.rows;
				
				//Find the rows available in the "other" matrix.
				for (int r : other.getNonEmptyRows())
				{
					//Find the columns in each row and add values to temp.
					for (int c : other.getNonEmptyColsInRow(r))
					{
						temp.setValue(r, c, other.getValue(r, c) + temp.getValue(r, c));
					}
				}
				return temp;
	}
}
