
public abstract class Shape 
{
    public abstract double area( );
    public abstract double perimeter( );
 
    public double semiperimeter( )
    {
        return perimeter( ) / 2; 
    }
    
//    public static void stretchAll(WhatType[] arr, factor) {
//    	for(WhatType s: arr) {
//    		s.stretch(factor);
//    	}
//    }
}
