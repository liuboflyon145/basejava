package com.watcher.strategy1;

import java.util.Comparator;

public class SortByName implements Comparator {

  private int sortType = 0 ;   // 定义标记位,默认是采用升序排列
  
  @Override
  public int compare(Object arg0, Object arg1) {
        
    Person p0 = (Person)arg0 ;
    Person p1 = (Person)arg1 ;
    
    String name0 = p0.name ;
    String name1 = p1.name ;
    
    int id0 = p0.id ;
    int id1 = p1.id ;
    
    if(name0.endsWith(name1)){
      
          return id0 - id1 ;
    }
    
    if(this.sortType != 0 ){
      return name1.compareTo(name0);
    }else{
        return name0.compareTo(name1);
    }
    
  }
  
  // 设置排序类型
  public void setSortType(int sign)
  {
    this.sortType = sign ;
  }

}