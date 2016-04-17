package main;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextArea;


public class IntegrationTesting {
    private JTextArea textArea;
    private List<Classes> accessedList;
    private List<Classes> activeList;
    private List<Classes> classesList;
    private int IntegrationMethod;
    private int depArray [][];
    
    public IntegrationTesting( List<Classes> classList, int method, JTextArea ta){
        int depCount = 0;
        classesList = classList;
        IntegrationMethod = method;
        depArray = new int[classesList.size()][classesList.size()];
        textArea = ta;
        
        /* Construct a table that represents the dependency tree */
        for(int i=0; i<classesList.size();i++){
            Classes temp = classesList.get(i);
            for(int j=0; j<temp.getDependencyList().size();j++){
                String temp2 = temp.getDependencyList().get(j);
                depArray[i][stringToIndex(temp2)] = 1;
                depCount++;
            }
        }
        
    }
    
    /* Function that converts the name of a class to it's index in the main class list */
    private int stringToIndex(String s){
        for(int i=0; i<classesList.size();i++){
            Classes temp = classesList.get(i);
            if( temp.getClassName().equals(s)){
                return i;
            }
        }
        return -1;
    }
       
     
    /* Top Down Testing */
    private void TT(){
        int sum = 0;
        Classes root = null;
        List<Classes> currList = new LinkedList<Classes>();
            
        /* Compute that sum of each row of the dependency table */
        for(int i=0;i<classesList.size(); i++){
            for(int j=0;j<classesList.size(); j++){
                sum += depArray[j][i];
            }
            
            /* If the sum is 0, we found the root */
            if( sum == 0){
                root = classesList.get(i);
                textArea.append("Step 1: check " + root.getClassName() + " - required emulators for: ");
                break;
            }
            sum = 0;
        }
        
        int updated = 1;
        int level = 1;
        currList.add(root);
        
        /* While there are no children left, keep going down the tree */
        while( updated == 1){
            updated = 0;
             
            for(int i=0; i<level; i++){
                int times = currList.size();
                for(int j=0; j < times;j++){
                    
                    for(int k=0; k< currList.get(j).getDependencyList().size() ;k++){
                        
                        if( !currList.contains( classesList.get(stringToIndex(currList.get(j).getDependencyList().get(k)))) ){
                        
                            currList.add( classesList.get(stringToIndex(currList.get(j).getDependencyList().get(k) )));
                            updated = 1;
                            textArea.append(currList.get(j).getDependencyList().get(k) + " ");
                            
                            
                        }
                    
                    }
                }
            }
            textArea.append(" and a driver for " + root.getClassName() + "\n");
            if( updated == 1){
                textArea.append("Step " + (level+1) + ": check ");
                for( int k=0; k < currList.size(); k++) {
                    textArea.append( currList.get(k).getClassName() + " ");
                }
                textArea.append(" - required emulators for: ");
            }
            level++;
        }
        
    }
    
    /* Bottom Up Testing */
    private void BT(){
        int lineSum[] = new int[classesList.size()];
        List<Classes> rootList = new LinkedList<Classes>();
            
        /* Similar to TT, exept the leaves have line sum 0 */
        for(int i=0;i<classesList.size(); i++){
            for(int j=0;j<classesList.size(); j++){
                lineSum[i] += depArray[i][j];
            }
        }
        for(int i=0;i<classesList.size(); i++){
            if( lineSum[i] == 0){
                rootList.add(classesList.get(i));
            }
        }
        
        /*Calculate a table that represents the level of dependencies each class has */
        int cTab[][] = new int[rootList.size()][classesList.size()];
                
        for(int i=0; i<rootList.size(); i++){
            for(int j=0;j<classesList.size(); j++){
                if( depArray[j][ classesList.indexOf(rootList.get(i)) ] == 1){
                    cTab[i][j] = 1;
                }
            }
        }
        
        int updated = 1;
        int current = 1;
        int max = 0;
        
        /* Adjust the cTab table accordingly */
        while( updated != 0){
            updated = 0;
            for(int i=0; i<classesList.size();i++){
                for(int j=0; j<classesList.size();j++){
                    for(int k=0; k<rootList.size(); k++){
                        if( depArray[i][j] == 1 && cTab[k][j] == current){
                            cTab[k][i] = current+1;
                            max = current+1;
                            updated = 1;
                        }
                            
                    }
                }
            }
            current++;
        }
        
        
        List<Classes> driven = new LinkedList<Classes>();
        
        /* Untill we reach to tree root, print out each step properly */
        int level=0;
        while( level <= max){
            textArea.append("Step "+ (level+1) +": check ");
            for(int i=0; i<rootList.size();i++){
                textArea.append(rootList.get(i).getClassName()+" ");
                for(int j=0; j<classesList.size();j++){
                    if( cTab[i][j] <= level && cTab[i][j] > 0){
                        textArea.append(classesList.get(j).getClassName() + " ");
                    }
                }
                if( i < rootList.size() - 1) {
                    textArea.append(" and ");
                }
                else {
                    textArea.append(" - required drivers for: ");
                }
            }
            for(int i=0; i<rootList.size();i++){
                if( level == 0 ){
                    textArea.append(rootList.get(i).getClassName() + " ");
                        continue;
                }
                for(int j=0; j<classesList.size();j++){
                    
                    if(cTab[i][j] == level && cTab[i][j] > 0) {
                        if( !driven.contains(classesList.get(j))){
                            textArea.append(classesList.get(j).getClassName() + " ");
                            driven.add(classesList.get(j));
                        }
                    }
                }
            }

            textArea.append("\n");
            level++;
        }
        
      
    }
    
    /* Pair Wise Testing */
    private void PT(){
    
        int step = 1;
        
        /* Check each pair, and if there are any children that need drivers */
        for( int i=0; i < classesList.size(); i++){
            for( int j=0; j < classesList.get(i).getDependencyList().size(); j++){
                textArea.append( "Step " + step + ": check " + classesList.get(i).getClassName() + " ");
                textArea.append(classesList.get(i).getDependencyList().get(j) + " and required a driver for " + classesList.get(i).getClassName());
                Classes temp = classesList.get(stringToIndex(classesList.get(i).getDependencyList().get(j) ));
                if( temp.getDependencyList().size() > 0 ){
                    textArea.append( " and drivers for: ");
                    for( int k=0; k < temp.getDependencyList().size(); k++) {
                        textArea.append( temp.getDependencyList().get(k) + " ");
                    }
                }
                textArea.append("\n");
                step++;
            }
        }

    }
    private void NT(){
    
    }
    
    public void run( ){
        if( IntegrationMethod == 1){
            BT();
        }
        else if( IntegrationMethod == 2){
            TT();
        }
        else if( IntegrationMethod == 3){
            PT();
        }
        else{
            NT();
        }
       
    }
    
}