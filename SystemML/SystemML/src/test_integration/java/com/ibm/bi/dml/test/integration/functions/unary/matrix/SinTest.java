/**
 * IBM Confidential
 * OCO Source Materials
 * (C) Copyright IBM Corp. 2010, 2014
 * The source code for this program is not published or otherwise divested of its trade secrets, irrespective of what has been deposited with the U.S. Copyright Office.
 */

package com.ibm.bi.dml.test.integration.functions.unary.matrix;

import org.junit.Test;

import com.ibm.bi.dml.test.integration.AutomatedTestBase;
import com.ibm.bi.dml.test.integration.TestConfiguration;



public class SinTest extends AutomatedTestBase 
{
	@SuppressWarnings("unused")
	private static final String _COPYRIGHT = "Licensed Materials - Property of IBM\n(C) Copyright IBM Corp. 2010, 2014\n" +
                                             "US Government Users Restricted Rights - Use, duplication  disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	
	private static final double EPS = 1e-14;
	
	@Override
	public void setUp() {
		baseDirectory = SCRIPT_DIR + "functions/unary/matrix/";
		availableTestConfigurations.put("PositiveTest",
				new TestConfiguration("SinTest", new String[] { "vector", "matrix" }));
		availableTestConfigurations.put("NegativeTest",
				new TestConfiguration("SinTest", new String[] { "vector", "matrix" }));
		availableTestConfigurations.put("RandomTest",
				new TestConfiguration("SinTest", new String[] { "vector", "matrix" }));
	}
	
	@Test
	public void testPositive() {
		int rows = 10;
		int cols = 10;
		
		TestConfiguration config = availableTestConfigurations.get("PositiveTest");
		config.addVariable("rows", rows);
		config.addVariable("cols", cols);
		
		loadTestConfiguration("PositiveTest");
		
		double[][] vector = getRandomMatrix(rows, 1, 0, 1, 1, -1);
		double[][] sinVector = new double[rows][1];
		for(int i = 0; i < rows; i++) {
			sinVector[i][0] = Math.sin(vector[i][0]);
		}
		writeInputMatrix("vector", vector);
		writeExpectedMatrix("vector", sinVector);
		
		double[][] matrix = getRandomMatrix(rows, cols, 0, 1, 1, -1);
		double[][] sinMatrix = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				sinMatrix[i][j] = Math.sin(matrix[i][j]);
			}
		}
		writeInputMatrix("matrix", matrix);
		writeExpectedMatrix("matrix", sinMatrix);
		
		runTest();
		
		compareResults(EPS);
	}
	
	@Test
	public void testNegative() {
		int rows = 10;
		int cols = 10;
		
		TestConfiguration config = availableTestConfigurations.get("NegativeTest");
		config.addVariable("rows", rows);
		config.addVariable("cols", cols);
		
		loadTestConfiguration("NegativeTest");
		
		double[][] vector = getRandomMatrix(rows, 1, -1, 0, 1, -1);
		double[][] sinVector = new double[rows][1];
		for(int i = 0; i < rows; i++) {
			sinVector[i][0] = Math.sin(vector[i][0]);
		}
		writeInputMatrix("vector", vector);
		writeExpectedMatrix("vector", sinVector);
		
		double[][] matrix = getRandomMatrix(rows, cols, -1, 0, 1, -1);
		double[][] sinMatrix = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				sinMatrix[i][j] = Math.sin(matrix[i][j]);
			}
		}
		writeInputMatrix("matrix", matrix);
		writeExpectedMatrix("matrix", sinMatrix);
		
		runTest();
		
		compareResults(EPS);
	}
	
	@Test
	public void testRandom() {
		int rows = 10;
		int cols = 10;
		
		TestConfiguration config = availableTestConfigurations.get("RandomTest");
		config.addVariable("rows", rows);
		config.addVariable("cols", cols);
		
		loadTestConfiguration("RandomTest");
		
		double[][] vector = getRandomMatrix(rows, 1, -1, 1, 1, -1);
		double[][] sinVector = new double[rows][1];
		for(int i = 0; i < rows; i++) {
			sinVector[i][0] = Math.sin(vector[i][0]);
		}
		writeInputMatrix("vector", vector);
		writeExpectedMatrix("vector", sinVector);
		
		double[][] matrix = getRandomMatrix(rows, cols, -1, 1, 1, -1);
		double[][] sinMatrix = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				sinMatrix[i][j] = Math.sin(matrix[i][j]);
			}
		}
		writeInputMatrix("matrix", matrix);
		writeExpectedMatrix("matrix", sinMatrix);
		
		runTest();
		
		compareResults(EPS);
	}
	
}