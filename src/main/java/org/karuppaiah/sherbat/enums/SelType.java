/**
 * 
 */
package org.karuppaiah.sherbat.enums;

/**
 * @author Karuppaiah
 *
 */
 public enum SelType{
	    //You can initialize enums using enumname(value)
	    ID(0),
	    TEXT(1),
	    CSS(2),
	    NAME(3);
	    
	    private int selType;
	    //Constructor which will initialize the enum
	    SelType(int stype)
	    {
	    	selType = stype;
	    }
	    
	    //method to return the direction set by the user which initializing the enum
	    public int GetSelType()
	    {
	      return selType;
	    }

}
