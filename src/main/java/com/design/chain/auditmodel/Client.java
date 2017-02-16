package com.design.chain.auditmodel;

public class Client {

    public static void main(String[] args) {
        //先要组装责任链
        Handler general = new GeneralManager();
        Handler dept = new DeptManager();
        Handler project = new ProjectManager();
        project.setSuccessor(dept);
        dept.setSuccessor(general);
        
        //开始测试
        String test1 = project.handleFeeRequest("张三", 300);
        System.out.println("test1 = " + test1);
        String test2 = project.handleFeeRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("---------------------------------------");
        
        String test3 = project.handleFeeRequest("张三", 700);
        System.out.println("test3 = " + test3);
        String test4 = project.handleFeeRequest("李四", 700);
        System.out.println("test4 = " + test4);
        System.out.println("---------------------------------------");
        
        String test5 = project.handleFeeRequest("张三", 1500);
        System.out.println("test5 = " + test5);
        String test6 = project.handleFeeRequest("李四", 1500);
        System.out.println("test6 = " + test6);
    }

}