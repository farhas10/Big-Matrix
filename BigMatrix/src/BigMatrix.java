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
	
	public void setValue(int row, int col, int value)
	{
		throw new UnsupportedOperationException();
	}
	
	public int getValue(int row, int col)
	{
		throw new UnsupportedOperationException();		
	}
	
	public List<Integer> getNonEmptyRows()
	{
		throw new UnsupportedOperationException();
	}
	
	public List<Integer> getNonEmptyRowsInColumn(int col)
	{
		throw new UnsupportedOperationException();
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
