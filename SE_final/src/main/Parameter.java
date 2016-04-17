
package main;

public class Parameter {
    
    private String parameterName;
    private Float minValue, maxValue;
    private String type;
    private Float theta;
    

    public String getType(){
        return type;
    }
    
    public Parameter(String parName, Float min, Float max, String tp){
        parameterName = parName;
        minValue = min;
        maxValue = max;
        type = tp;
    }
    
    public void setTheta(Float t){
        theta = t;
    }
    
    public Float getTheta(){
        return theta;
        
    }
    
    public String getParameterName(){
        return parameterName;
    }
    
    public Float getParameterMax(){
        return maxValue;
    }
     
    public Float getParameterMin(){
        return minValue;
    }
}