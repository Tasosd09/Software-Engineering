package main;

import java.util.LinkedList;
import java.util.List;

    
public class Classes {
    private List<Method> methodList;
    private String className;
    private List<String> dependencies;
    
    public Classes(String clName){
        className = clName;
        methodList = new LinkedList<Method>();
        dependencies = new LinkedList<String>();
    }
    
    public String getClassName( ){
        return className;
    }
    
    public void addMethod(Method m){
        methodList.add(m);
    }
    
    public Method addMethod(String methName){
        
        Method tempMethod = new Method(methName, className);
        methodList.add(tempMethod );
        return tempMethod;
    }
    
    public void addDependency( String dependingClassName){
        dependencies.add(dependingClassName);
    }
    
    public List<String> getDependencyList(){
        return dependencies;
    }
    
    public List getMethodList( ){
        List tempMethodList;
        tempMethodList = methodList;
        return tempMethodList;

    }

    
}
