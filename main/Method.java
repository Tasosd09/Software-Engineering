package main;

import java.util.LinkedList;
import java.util.List;


public class Method {
    private String methodName;
    private String parentClassName;
    private List<Parameter> parameterList;
    
    public Method( String methName, String parentName){
        methodName = methName;
        parameterList = new LinkedList<Parameter>();
        parentClassName = parentName;
    }
    
    public String getMethodName(){
        return methodName;
    }
    
    public String getParentClassName(){
        return parentClassName;
    }
    
    public void addParameter( String parName, float min, float max, String type){
      
        parameterList.add( new Parameter(parName,min,max,type) );
    }
    
    public List<Parameter> getParameterList(){
        return parameterList;
    }

    
}
