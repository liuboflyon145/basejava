package com.watcher.strategy1;

import java.util.Comparator;

public class Environment {

  private Comparator comparator ;   // 私有的抽象策略角色的引用
  
  public Environment(Comparator comp)
  {
    this.comparator = comp ;
  }
  
  public void setComparator(Comparator comp){
    this.comparator = comp ;
  }
  
  public Comparator getComparator(){
    return this.comparator;
  }
  
}