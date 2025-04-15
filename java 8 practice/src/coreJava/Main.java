package coreJava;// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main main1 = new Main();
     HashMap<Integer, String> hm = new HashMap<Integer, String>();
     hm.put(1,"aaa");     
     HashMap<Integer,String> reshm= main1.addVal(hm);
     System.out.print(hm);
     System.out.println(reshm);
  }
  public HashMap<Integer,String> addVal(  HashMap<Integer,String> hm){
     HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
     hm1.put(3,"cccc");
     hm=hm1;
     hm.put(4,"ddd");
    //  hm.put(3,"ccc");
    //  hm.put(2,"bbb");
      return hm;
  }
}