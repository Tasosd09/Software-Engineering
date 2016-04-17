package main;

import java.util.List;
import javax.swing.JTextArea;


public class UnitTesting {
    
    private int unitTestingMethod;
    private String className;
    private Classes testingClass;
    private List<Method> methodList;
    private int size;
    private javax.swing.JTextArea textArea;

    
    /* testCases[i][j] is the #i value for #j parameter */
    private Float[][] testCases;
    
    public UnitTesting( Classes A, int choise, JTextArea x){
        
        methodList = A.getMethodList();
        testingClass = A;
        unitTestingMethod = choise;
        className = A.getClassName();
        textArea = x;
    }
    
    public void run( ){
        textArea.append("class Driver{\n\n\t" + className + " Test = new " + className + "();\n\n");
        /* Run the tests for each method of the class*/
        for( int i=0; i<methodList.size();i++){
            testMethod( methodList.get(i) );
            textArea.append("\n");
            
        }
          textArea.append("\n}\n");
    }
    
    public void testMethod( Method M){
        
        List<Parameter> tempParList;
        tempParList = M.getParameterList();
        
        if( unitTestingMethod == 1)
            size = 5;
        else
            size = 7;
        
        testCases = new Float[tempParList.size()][size];
        
        /*Calculate test values for each parameter of the method */
        for( int i=0; i< tempParList.size(); i++){
            calculateTestCases( tempParList.get(i), i );
        }
        
        /* Run #variables*5 tests for each method */
        for( int i=0; i<tempParList.size()*size; i++){
            runMethodTest(M,i, tempParList.size());
        }
        
    }

    public void runMethodTest( Method M, int iter, int parameterCount){
        
        /*Matrix to store the parameter values of the current test*/
        Float parameterValues[] = new Float[parameterCount];
        
        for( int i=0; i<parameterCount; i++){
            /* Set the parameter values properly */
            
            if( i == iter/size ) {
                parameterValues[i] = testCases[i][iter%size];
            }
            else {
                parameterValues[i] = testCases[i][size/2];
            }
        }
        
        
        textArea.append("\tTest." + M.getMethodName() + "(");
        if( parameterCount > 0) {
            textArea.append(Float.toString(parameterValues[0]));
        }
        
        for(int i=1; i<parameterCount;i++){
            textArea.append(", " + parameterValues[i]);
        }
          textArea.append(");\n");
          
        
    }
    
    public void calculateTestCases( Parameter P, int i ){
        Float theta = P.getTheta();
        
        if( unitTestingMethod == 1){
            testCases[i][0] = P.getParameterMin();
            testCases[i][1] = P.getParameterMin() + theta;
            testCases[i][2] = (P.getParameterMax() + P.getParameterMin())/2;
            testCases[i][3] = P.getParameterMax() - theta;
            testCases[i][4] = P.getParameterMax();
        }
        else if( unitTestingMethod == 2){
            testCases[i][0] = P.getParameterMin() - theta;
            testCases[i][1] = P.getParameterMin();
            testCases[i][2] = P.getParameterMin() + theta;
            testCases[i][3] = (P.getParameterMax() + P.getParameterMin())/2;
            testCases[i][4] = P.getParameterMax() - theta;
            testCases[i][5] = P.getParameterMax();
            testCases[i][6] = P.getParameterMax() + theta;
        }
       
        
        
    }
    
}
