package com.example.demo.APIs;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicValidators {
	  boolean mobileNoValidators(String number) throws IOException{
	        Pattern pattern = Pattern.compile("[789]{1}\\d{9}");
	        if(pattern.matcher(number).find()){
	            return true;
	        }else{
	         throw new IOException("Invalid Mobile Number");
	        }
	    }

	    // boolean strongPasswordvalidators(String password) throws IOException{
	    //     Pattern pattern = Pattern.compile("[a-z]+.[A-Z].+[0-9].[^a-zA-Z0-9]+");
	    //     Matcher matcher = pattern.matcher(password);
	    //     if(pattern.matcher(password).find()){
	    //         return true;
	    //     }else{
	    //      throw new IOException("Password must have at lease one special symbol,Uppercase letter,Lowwercase letter and number");
	    //     }
	    // }
	    boolean PasswordMatcher(String password,String cfmPassword) throws IOException{
	        if(password.equals(cfmPassword)){
	            return true;
	        }else{
	             throw new IOException("Passwords Mismatch");
	        }
	    }
	    boolean verifyEmail(String str){
	        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_]+@[A-Za-z0-9+_]+.[A-Za-z]+$");
	        if(pattern.matcher(str).find()){
	            return true;
	        }else{
	          return false;
	        }
	    }

	    boolean idValidator(int in) throws IOException{
	        if(in>=1 && in<=100000)
	        {
	            return true;
	        }
	        else{
	             throw new IOException("For Data '"+in+"' ID Excced the limit, Please Enter Valid Limit");
	        }
	    }

	    boolean yearValidator(int in) throws IOException{
	        if(in>=1000 && in<=9999)
	        {
	            return true;
	        }
	        else{
	             throw new IOException("Year cannot be less than 1000 OR grtether than 9999");
	        }
	    }

	     boolean numberLessThan(int in,int min) throws IOException{
	        if(in<min)
	        {
	            return true;
	        }
	        else{
	             throw new IOException("For Data '"+in+"' value must grether than limit i.e. "+min);
	        }
	    }

	    boolean numberGretherThan(int in,int max) throws IOException{
	        if(in>max)
	        {
	            return true;
	        }
	        else{
	             throw new IOException("For Data '"+in+"' value must less than limit i.e. "+max);
	        }
	    }

        boolean numberLimits(int in, int min,int max) throws IOException{
             if(in>max && in<min)
	        {
	            return true;
	        }
	        else{
	             throw new IOException("For Data '"+in+"' value must be grether than "+min+" and less than "+max);
	        }
        }

	    boolean alaphabetsOnly(String str) throws IOException{
	        Pattern pattern = Pattern.compile("^[A-Za-z || [\\s]]+$");
	        if(pattern.matcher(str).find()){
	            return true;
	        }else{
	         throw new IOException("For Data "+str+" value Cannot contain numbers or Symbols");
	        }
	    }

	    boolean checkEmpty(String str) throws IOException{
	         if(!str.isEmpty()){
	              return true;
	         }else{
	             throw new IOException("Required data Fields Cannot be empty or NULL");
	         }
	    }

	    boolean maxLength(String str, int length) throws IOException{
	        if(str.length()<length){
	            return true;
	        }else{
	            throw new IOException("For Data '"+str+"' Length must less than limit i.e. "+length);
	        }
	    }

   }